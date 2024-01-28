package com.gmstech.services;


import com.gmstech.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private ShippingService shippingService;
	

	public Double total(Order order) {
		double discount = (order.getDiscount() / 100.0) * order.getBasic();
	
		return order.getBasic() - discount + shippingService.shipment(order);
	}
	
}
