package semi.climbing.board.prob.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.climbing.board.any.service.AnyService;
import semi.climbing.board.ask.service.AskService;
import semi.climbing.board.lost.service.LostService;
import semi.climbing.board.prob.service.ProblemService;

/**
 * Servlet implementation class noticeController
 */
@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProblemService serviceProb = new ProblemService();
	AnyService serviceAny = new AnyService();
	AskService serviceAsk = new AskService();
	LostService serviceLost = new LostService();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize = 5;
		int pageBlockSize = 5;
		int currentPageNum = 1;
		String pageNum = request.getParameter("page");
		if(pageNum != null && !pageNum.equals("")) {
			try {
				currentPageNum = Integer.parseInt(pageNum);
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("mapBoardProb" , serviceProb.selectPageList(pageSize, pageBlockSize, currentPageNum));
		request.setAttribute("mapBoardAny", serviceAny.selectPageList(pageSize, pageBlockSize, currentPageNum));
		request.setAttribute("mapBoardAsk", serviceAsk.selectPageList(pageSize, pageBlockSize, currentPageNum));
		request.setAttribute("mapBoardLost", serviceLost.selectPageList(pageSize, pageBlockSize, currentPageNum));
		request.getRequestDispatcher("/WEB-INF/views/semi/board/page_board.jsp").forward(request, response);
	}

}
