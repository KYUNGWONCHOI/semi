package semi.climbing.lesson.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.climbing.lesson.service.LessonService;

/**
 * Servlet implementation class LessonController
 */
@WebServlet("/lesson")
public class LessonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LessonService service = new LessonService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LessonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int classNo = Integer.parseInt(req.getParameter("classNo"));
		System.out.println("get ClassNum : " + classNo);
		String memId = req.getParameter("memId");
		System.out.println("get memId : " + memId);
		
		int result = 1;
		
		
		resp.getWriter().append(String.valueOf(result));
	}

}
