package semi.climbing.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.climbing.notice.service.NoticeService;

/**
 * Servlet implementation class announceController
 */
@WebServlet("/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NoticeService service = new NoticeService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int noticeSort = (int)request.getAttribute("noticeSort");
//		System.out.println("noticeSort : " +noticeSort);
//		-- 한페이지당글수 5 씩
		int pageSize = 5;
//		-- 화면하단 나타날 페이지수 5 씩
		int pageBlockSize = 5;
//		-- 현재페이지
		int currentPageNum = 1;  // 기본1
		// 페이지지정하고 들어왔다면... 현재페이지를 그값으로 설정함
		System.out.println("NoticeListController");
		String pageNum = request.getParameter("page");
		if(pageNum!= null && !pageNum.equals("")) {
			try {
				currentPageNum = Integer.parseInt(pageNum);
			}catch(NumberFormatException e) {
				System.out.println("!!!!!!!!!!!!!! NumberFormatException !!!!!!");
				//e.printStackTrace();
			}
		}
		request.setAttribute("map" , service.selectPageList(pageSize, pageBlockSize, currentPageNum));
		
		request.getRequestDispatcher("/WEB-INF/views/semi/notice/notice.jsp").forward(request, response);
//		do{
//			if (noticeSort == 1) {
//			int pageSize = 5;
//			int pageBlockSize = 5;
//			int currentPageNum = 1;
//			System.out.println("NoticeListController");
//			String pageNum = request.getParameter("page");
//			if(pageNum!= null && !pageNum.equals("")) {
//				try {
//					currentPageNum = Integer.parseInt(pageNum);
//				}catch(NumberFormatException e) {
//					System.out.println("!!!!!!!!!!!!!! NumberFormatException !!!!!!");
//					//e.printStackTrace();
//				}
//			}
//			request.setAttribute("map" , service.selectPageList(pageSize, pageBlockSize, currentPageNum));
//			request.getRequestDispatcher("/WEB-INF/views/semi/notice/notice_list.jsp").forward(request, response);
//			}
//		} while(true);
	}
}