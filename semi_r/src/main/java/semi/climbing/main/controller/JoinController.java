package semi.climbing.main.controller;

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

import semi.climbing.common.file.FileWriteDto;
import semi.climbing.member.model.dto.MemberDto;
import semi.climbing.member.model.service.MemberService;



/**
 * Servlet implementation class JoinController
 */
@WebServlet("/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/semi/join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memId = request.getParameter("id");
		String memPwd = request.getParameter("pwd");
		String memPhoto = request.getParameter("photo");
		int memPoint = Integer.parseInt(request.getParameter("point"));
		
		String uploadPath = request.getServletContext().getRealPath("files");
		System.out.println("uploadPath:"+uploadPath);
		File uploadPathFile = new File(uploadPath);
		if(!uploadPathFile.exists()) {
			uploadPathFile.mkdirs();
		}
		int uploadFileLimit = 10 * 1024 *1024; // 10M제한
		MultipartRequest multiReq = new MultipartRequest(request,  // jsp->controll로 전달된 객체 
				uploadPath,  //  서버에 저장할 디렉토리 
				uploadFileLimit, // 업로드 파일 크기제한
				"UTF-8", // 인코딩 방법
				new DefaultFileRenamePolicy() // was 서버에 저장할 디렉토리에 동일이름이 존재할때 새로운 이름 부여방식 
				);
		
		List<FileWriteDto> fileList = new ArrayList<FileWriteDto>();
		
		Enumeration<?> fileNames = multiReq.getFileNames();
		while(fileNames.hasMoreElements()) {
			String name = (String)fileNames.nextElement();   // input type="file" name="xxx", xxx_0, xxx_1
			String fileName = multiReq.getFilesystemName(name);  // 서버에 저장된 파일이름
			String orginFileName = multiReq.getOriginalFileName(name);
			String type = multiReq.getContentType(name);  // 전송된 파일의 타입
			System.out.println(type);
//			System.out.println(type);
			File f1= multiReq.getFile(name);  // name을 이용해서 파일 객체 생성 여부 확인 작업.
			if (f1==null) {  // name을 이용해서 파일 객체 생성에 실패하면
				System.out.println("파일 업로드 실패");   // 실패 오류메시지  
			} else {
				System.out.println(f1.length());   // 그 파일의 크기 
//				System.out.println(f1.length());   // 그 파일의 크기 
			}
			System.out.println(name + "  :  "+ fileName+"  :  "+orginFileName);
//			System.out.println(name + "  :  "+ fileName+"  :  "+orginFileName);
//			uploadfiles: SQL실습과제5.jpg : SQL실습과제.jpg
//			uploadfiles_0: t7.PNG : t.PNG
//			uploadfiles_1: 캡처6.PNG : 캡처.PNG
			FileWriteDto filedto = new FileWriteDto(fileName, orginFileName);
			fileList.add(filedto);			
		}
		
		
		MemberDto dto = new MemberDto(memId, memPwd, memPhoto, memPoint); 
		int result = new MemberService().insert(dto);
		if(result < 0) {
			//오류사항 작성-회원가입 실패 시
			response.sendRedirect(request.getContextPath()+"/main");
			return;
		}
		//회원가입 성공 시
		response.sendRedirect(request.getContextPath()+"/login");
		
	}

}