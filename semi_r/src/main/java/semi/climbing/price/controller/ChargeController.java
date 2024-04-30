package semi.climbing.price.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.climbing.member.model.dto.MemberDto;
import semi.climbing.price.model.dto.PointChargeDto;
import semi.climbing.price.service.PriceService;

/**
 * Servlet implementation class ChargeController
 */
@WebServlet("/charge")
public class ChargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PriceService service = new PriceService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChargeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/semi/price/point.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDto sssLogin = (MemberDto)request.getSession().getAttribute("sssLogin");
		String memId =  sssLogin.getMemId();
		int point = Integer.parseInt(request.getParameter("charge"));
		System.out.println(memId);
		System.out.println(point);
		
		
		
		PointChargeDto dto = new PointChargeDto(memId, point);	
		int result = service.updatePoint(dto);
		
	}

}
