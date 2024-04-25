package semi.climbing.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import semi.climbing.member.model.dto.MemberInfoDto;
import semi.climbing.notice.model.dto.FileWriteDto;
import semi.climbing.notice.model.dto.NoticeInsertDto;
import semi.climbing.notice.service.NoticeService;

@WebServlet("/notice/write")
public class NoticeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService service = new NoticeService();
   
    public NoticeWriteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prePage = (String)request.getSession().getAttribute("prePage");
		if(prePage!= null &&prePage.equals("write")) {
			request.getSession().removeAttribute("prePage");
		}
		request.getRequestDispatcher("/WEB-INF/views/semi/notice/notice_write.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/notice/write doPost()");
		
		String uploadPath = req.getServletContext().getRealPath("notice_list");
		System.out.println("uploadPath:"+uploadPath);
		File uploadPathFile = new File(uploadPath);
		if(!uploadPathFile.exists()) {
			uploadPathFile.mkdirs();
		}
		int uploadFileLimit = 10 * 1024 *1024; // 10M제한
	
		MultipartRequest multiReq = new MultipartRequest(req,  // jsp->controll로 전달된 객체 
				uploadPath,  //  서버에 저장할 디렉토리 
				uploadFileLimit, // 업로드 파일 크기제한
				"UTF-8", // 인코딩 방법
				new DefaultFileRenamePolicy() // was 서버에 저장할 디렉토리에 동일이름이 존재할때 새로운 이름 부여방식 
				);
		/// 중요!!! 이시점에 new MultipartRequest() 하면 file은 uploadPath위치에 저장완료!

		List<FileWriteDto> fileList = new ArrayList<FileWriteDto>();
		Enumeration<?> fileNames = multiReq.getFileNames();
		while(fileNames.hasMoreElements()) {
			String name = (String)fileNames.nextElement();   // input type="file" name="xxx", xxx_0, xxx_1
			String fileName = multiReq.getFilesystemName(name);  // 서버에 저장된 파일이름
			String orginFileName = multiReq.getOriginalFileName(name);
			String type = multiReq.getContentType(name);  // 전송된 파일의 타입
			File f1= multiReq.getFile(name);  // name을 이용해서 파일 객체 생성 여부 확인 작업.
			if (f1==null) {  // name을 이용해서 파일 객체 생성에 실패하면
				System.out.println("파일 업로드 실패");   // 실패 오류메시지  
			} else {
//				System.out.println(f1.length());   // 그 파일의 크기 
			}
			System.out.println(name + "  :  "+ fileName+"  :  "+orginFileName);
			FileWriteDto filedto = new FileWriteDto(fileName, orginFileName);
			fileList.add(filedto);			
		}
		
		String subject = multiReq.getParameter("subject");
		String content = multiReq.getParameter("content");
		int noticeType = Integer.parseInt(multiReq.getParameter("pos"));
		System.out.println("@@@@@@@@@@@"+noticeType);
		NoticeInsertDto dto = new NoticeInsertDto(subject, content, noticeType, fileList);
		int result = service.insert(dto);
		resp.sendRedirect(req.getContextPath()+"/notice");
	}

}
