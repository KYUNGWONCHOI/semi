package semi.climbing.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.climbing.member.model.service.MemberService;



/**
 * Servlet implementation class CheckIdController
 */
@WebServlet("/checkid")
public class CheckIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String k1 = request.getParameter("k1");
		String k2 = request.getParameter("k2");
		System.out.println(k1+","+k2);
	
		String memId = request.getParameter("cid");
		System.out.println(memId);
		//TODO DB 갔다올 예정
		int result = new MemberService().selectCheckId(memId);
		response.getWriter().append(String.valueOf(result));	
	}

}
