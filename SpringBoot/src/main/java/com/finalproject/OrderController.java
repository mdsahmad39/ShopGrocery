package com.finalproject;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CustomerDao;
import com.dao.OrderDetailsDao;
import com.dao.OrdersDao;
import com.dao.ProductDao;
import com.dao.StoreDao;
import com.dto.OrderDetails;
import com.dto.Orders;
import com.dto.PurchasedOrders;



@RestController
public class OrderController {

	@Autowired
	OrdersDao orderDao;
	
	@Autowired
	OrderDetailsDao  orderDetailsDao;
	
	@Autowired
	StoreDao storeDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	ProductDao productDao;
	
/*	@RequestMapping("/register_Order")
	public void register() {
		List<Store> storeList = storeDao.getAllStores();
		List<Customer> customerList =  customerDao.getAllCustomers();
		List<Product> productList = productDao.getAllProducts();
		Orders order = new Orders("will be reached never", "12/2/2021", storeList.get(0), customerList.get(0));
		orderDao.register(order);
		OrderDetails orderDetails = new OrderDetails(40, 20, 8000, order, productList.get(0));
		orderDetailsDao.register(orderDetails);
	}
*/	
	@PostMapping("/registerOrder")
	public void regiterOrder(@RequestBody PurchasedOrders order)
	{  

		Orders orderobj = new Orders();
		orderobj.setOrderStatus("Pending");
		orderobj.setOrderDate(String.valueOf(new Date()));
		orderobj.setCustomer(order.getUserId());
		orderobj.setStore(order.getStoreId());
		orderDao.register(orderobj);
		
		for(String ordlist : order.orderDetailsList)
		{
			ordlist=ordlist.replace('{',' ');
			ordlist=ordlist.replace('}',' ');
			
			String[] temp1 = ordlist.split(",");
			int purchasedQuantity = Integer.parseInt(temp1[1].split(":")[1]);
			double totalPrice = Integer.parseInt(temp1[2].split(":")[1]);
			int productId = Integer.parseInt(temp1[4].split(":")[1].replaceAll("\\s", ""));
			OrderDetails orderDet = new OrderDetails();
			orderDet.setOrder(orderobj);
			orderDet.setProductId(productId);
			orderDet.setPurchasedQuantity(purchasedQuantity);
			orderDet.setTotalPrice(totalPrice);
			System.out.println(orderDet.toString());
			orderDetailsDao.register(orderDet);
		}
	}
	
	@RequestMapping("getAllOrders")
	public List<Orders> getAllOrders() {
		return orderDao.getAllOrders();
	}
	
	@GetMapping("/getOrderById/{Id}")
	public Orders getOrderById(@PathVariable("Id") Integer userId)
	{
		return orderDao.findById(userId);
	}
	
}
