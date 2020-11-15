package Payment.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ctrl.AbstractController;
import myshop.mdl.ImageVO;
import myshop.mdl.InterProductDAO;
import myshop.mdl.ProductDAO;
import myshop.mdl.ProductVO;

public class PayMentController extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		InterProductDAO pdao = new ProductDAO();// DAO 객체 생성
		
		// HttpSession session = request.getSession();
		
		// 장바구니 테이블에서 보내준 제품번호를 받아온다.
		//request.getParameter("pdno");
		
		// 로그인된 유저의 아이디 정보를 받아온다.
		String userid = "siasia"; 
		// 유저 로그인이 완료될경우 주석문 해제
		//((MemberVO) session.getAttribute("loginuser")).getUserid();
		
		// 캐러셀 이미지 name을 받아올 DTO객체를 생성
		List<ImageVO> productList = pdao.ImageCarouselSelectAll();
		
		// 장바구니 테이블에 존재하는 row를 특정유저(로그인된 유저)의 아이디와 제품번호를 사용하여
		// select 해온뒤 List에 담는다. List를 이용하여 반복문을 사용해 선택한 제품을 화면에 출력
		List<ProductVO> cartList = pdao.getCartList(userid);
		
		request.setAttribute("imgList", productList);
		
		request.setAttribute("cartList", cartList);
		
		super.setRedirect(false);
		super.setViewPage("/WEB-INF/Payment/Payment.jsp");
		
	}

}
