package semi.climbing.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.climbing.lesson.service.LessonService;
import semi.climbing.notice.service.NoticeService;

/**
 * Servlet implementation class announceController
 */
@WebServlet("/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NoticeService serviceNotice = new NoticeService();
	LessonService serviceLesson = new LessonService();
	
       
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
//		-- 한페이지당글수 5 씩
		int pageSize = 10;
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
			}
		}
		
		request.setAttribute("mapNotice" , serviceNotice.selectPageList(pageSize, pageBlockSize, currentPageNum));
		request.setAttribute("listLessonOneday", serviceLesson.selectOnedayList());
		request.setAttribute("listLessonWeekday", serviceLesson.selectDayAllList());
		request.setAttribute("listLessonWeekend", serviceLesson.selectEndAllList());
		request.getRequestDispatcher("/WEB-INF/views/semi/notice/notice.jsp").forward(request, response);
	}
}