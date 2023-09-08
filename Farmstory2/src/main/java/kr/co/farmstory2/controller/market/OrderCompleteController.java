package kr.co.farmstory2.controller.market;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.dto.OrderDTO;
import kr.co.farmstory2.service.OrderService;

@WebServlet("/market/orderComplete.do")
public class OrderCompleteController extends HttpServlet{

	private static final long serialVersionUID = -5379432086154831804L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private OrderService service = OrderService.INSTANCE;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String orderProduct = req.getParameter("orderProduct");
		String orderCountStr = req.getParameter("orderCount");
		String orderDelivery = req.getParameter("orderDelivery");
		String orderPriceStr = req.getParameter("orderPrice");
		String orderTotalStr = req.getParameter("orderTotal");
		String orderUser = req.getParameter("orderUser");
		String receiver = req.getParameter("receiver");
		String hp = req.getParameter("hp");
		String zip = req.getParameter("zip");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String etc = req.getParameter("etc");
		
		// 빈 문자열 또는 유효하지 않은 숫자 값을 확인하고 처리합니다.
	    int orderCount = 0;
	    double orderPrice = 0.0;
	    double orderTotal = 0.0;
	    try {
	        if (orderCountStr != null && !orderCountStr.isEmpty()) {
	            orderCount = Integer.parseInt(orderCountStr);
	        }
	        if (orderPriceStr != null && !orderPriceStr.isEmpty()) {
	            orderPrice = Double.parseDouble(orderPriceStr);
	        }
	        if (orderTotalStr != null && !orderTotalStr.isEmpty()) {
	            orderTotal = Double.parseDouble(orderTotalStr);
	        }
	    } catch (NumberFormatException e) {
	        // 예외 처리를 수행합니다. 예를 들어 오류를 기록하거나 사용자에게 오류 메시지를 표시할 수 있습니다.
	    }
		
		OrderDTO dto = new OrderDTO();
		dto.setOrderProduct(orderProduct);
		dto.setOrderCount(orderCount);
		dto.setOrderDelivery(orderDelivery);
		dto.setOrderPrice(orderPrice);
		dto.setOrderTotal(orderTotal);
		dto.setReceiver(receiver);
		dto.setHp(hp);
		dto.setZip(zip);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setOrderEtc(etc);
		dto.setOrderUser(orderUser);
		
		logger.debug(dto.toString());
		
		service.insertOrder(dto);
		
		// 리다이렉트
		resp.sendRedirect("/Farmstory2/market/list.do?success=200");
		
		
	}
}
