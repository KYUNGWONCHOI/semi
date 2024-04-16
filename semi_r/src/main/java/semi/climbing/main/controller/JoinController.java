package semi.climbing.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
