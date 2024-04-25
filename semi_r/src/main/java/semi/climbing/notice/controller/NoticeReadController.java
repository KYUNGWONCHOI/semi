package semi.climbing.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.climbing.notice.service.NoticeService;

/**
 * Servlet implementation class BoardAnnReadController
 */
@WebServlet("/notice/read")
public class NoticeReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService service = new NoticeService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeIdStr = request.getParameter("id");
		System.out.println("@@@@@@@@@@@id : "+noticeIdStr);
		try {
			int noticeNo = Integer.parseInt(noticeIdStr);
			request.setAttribute("dto", service.selectOne(noticeNo));
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@"+service.selectOne(noticeNo));
//			request.setAttribute("fdto", service.selectFileList(noticeNo));
			request.getRequestDispatcher("/WEB-INF/views/semi/notice/notice_read.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			System.out.println("!!! NumberFormatException !!!!!!");
			response.sendRedirect(request.getContextPath()+"notice/list");
		}
	}
}
