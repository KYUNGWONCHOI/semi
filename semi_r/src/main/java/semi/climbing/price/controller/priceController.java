package semi.climbing.price.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.climbing.member.model.dto.MemberDto;
import semi.climbing.price.model.dto.PointChargeDto;
import semi.climbing.price.model.dto.RegisterInfoDto;
import semi.climbing.price.service.PriceService;

@WebServlet("/price")
public class PriceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PriceService service = new PriceService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PriceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/semi/price/page_price.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDto sssLogin = (MemberDto)req.getSession().getAttribute("sssLogin");
		int priceType = Integer.parseInt(req.getParameter("priceType"));
		int price = 0;
		int useHistory = 0;
		int duration = 0;
		switch (priceType) {
		case 1:
			price = 130000;
			useHistory = 999;
			duration = 1;
			break;
		case 2:
			price = 130000;
			useHistory = 999;
			duration = 12;
			break;
		case 3:
			price = 330000;
			useHistory = 5;
			duration = 3;
			break;
		case 4:
			price = 170000;
			useHistory = 10;
			duration = 12;
			break;
		case 5:
			price = 22000;
			useHistory = 1;
			duration = 0;
			break;
		default:
			break;
		}	
		int memPoint = sssLogin.getMemPoint();
		String memLocker = req.getParameter("locker");		
		String memId =  sssLogin.getMemId();
		int cResult = 0;
		if(memPoint >= price) {
			RegisterInfoDto dto = new RegisterInfoDto(memId, priceType, memLocker, price, useHistory, duration);
			PointChargeDto pointDto = new PointChargeDto(memId, (-price));
			int result = service.insert(dto);	
			int pointresult = service.updatePoint(pointDto);
			cResult=1;
		}else {
			cResult=0;
		}
		req.setAttribute("cResult", cResult);
	}
}
