package semi.climbing.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.climbing.member.model.service.MemberService;
import semi.climbing.member.model.dto.MemberLoginDto;
import semi.climbing.member.model.dto.MemberDto;
import semi.climbing.member.model.dto.MemberInfoDto;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prePage = request.getParameter("prePage");
		request.getSession().setAttribute("prePage", prePage);
		request.getRequestDispatcher("/WEB-INF/views/semi/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<MemberDto> temp = service.selectAllList();
//		System.out.println(temp);
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");		
		MemberLoginDto dto = new MemberLoginDto(id, pwd);
		System.out.println("/login doPost dto: "+ dto);
//		/login doPost dto: MemberDto [memId=aaa, memPwd=bbb]

		// ajax
		// 성공 : 1
		// 실패 : 0
		int result = 0;
		// session 에 저장해 다닐 값에 따라 
		//int result = service.login(dto);
		MemberDto memdto = service.selectOne(id);
		
		if(dto != null) {
			//성공
//			request.getSession().setAttribute("sssLogin", id);
			request.getSession().setAttribute("sssLogin", memdto);
			request.setAttribute("loginInfo" , service.loginGetInfo(id));
			result = 1;

			System.out.println("@@@@@@@resultInfo : " +memdto);
			System.out.println("@@#!"+service.loginGetInfo(id));
		}
		response.getWriter().append(String.valueOf(result));
	}

}
