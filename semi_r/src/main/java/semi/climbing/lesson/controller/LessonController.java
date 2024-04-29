package semi.climbing.lesson.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.climbing.lesson.model.dto.LessonInsertDto;
import semi.climbing.lesson.service.LessonService;
import semi.climbing.member.model.dto.MemberDto;

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
		int lessonNo = Integer.parseInt(req.getParameter("lessonNo"));
				
		MemberDto sssLogin = (MemberDto)req.getSession().getAttribute("sssLogin");
		String memId =  sssLogin.getMemId();
		System.out.println("memId : " +memId);
		LessonInsertDto dto = new LessonInsertDto(memId, lessonNo);
		int result = service.insertOneday(dto);
		
		if(result == 1) {
			resp.sendRedirect(req.getContextPath()+"/notice?tabmenu=2");
			System.out.println("update");
			int update = service.updateLessonCapa(lessonNo);
		}
	}
}
