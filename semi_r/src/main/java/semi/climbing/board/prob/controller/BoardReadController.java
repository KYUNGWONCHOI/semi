package semi.climbing.board.prob.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.climbing.board.prob.service.ProblemService;

/**
 * Servlet implementation class BoardReadController
 */
@WebServlet("/board/read")
public class BoardReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProblemService service = new ProblemService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardIdStr = request.getParameter("id");
		try {
			int boardNo = Integer.parseInt(boardIdStr);
			request.setAttribute("dto", service.selectOne(boardNo));
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@"+service.selectOne(boardNo));
//			request.setAttribute("fdto", service.selectFileList(noticeNo));
			request.getRequestDispatcher("/WEB-INF/views/semi/board/board_prob_read.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			System.out.println("!!! NumberFormatException !!!!!!");
			response.sendRedirect(request.getContextPath()+"board/list");
		}
	}

}
