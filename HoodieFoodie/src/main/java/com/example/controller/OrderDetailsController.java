package com.example.controller;

import com.example.exceptions.OrderDetailsException;
import com.example.exceptions.RestaurantException;
import com.example.model.Customer;
import com.example.model.OrderDetails;
import com.example.model.Restaurant;
import com.example.service.OrderDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderDetailsController {
	@Autowired
	OrderDetailsServices ods;

	@PostMapping("/OrderDetails")
	public ResponseEntity<OrderDetails> addOrderDetailsHanler(@RequestBody OrderDetails ordeDetails) throws OrderDetailsException {
		OrderDetails od=ods.addOrder(ordeDetails);
		return new ResponseEntity<>(od, HttpStatus.ACCEPTED);
	}


	@PutMapping("OrderDetails")
	public ResponseEntity<OrderDetails> updateOrderDetailsHanler(@RequestBody OrderDetails ordeDetails) throws OrderDetailsException{
		OrderDetails od=ods.updateOrder(ordeDetails);
		return new ResponseEntity<>(od, HttpStatus.CREATED);
	}


	@DeleteMapping("OrderDetails")
	public ResponseEntity<OrderDetails> removeOrderDetailsHanler(@RequestBody OrderDetails ordeDetails) throws OrderDetailsException{
		OrderDetails od=ods.removeOrder(ordeDetails);
		return new ResponseEntity<>(od, HttpStatus.OK);
	}

	@GetMapping("viewsOrderDetails")
	public ResponseEntity<OrderDetails> viewOrderDetailsHanler(@RequestBody OrderDetails ordeDetails) throws OrderDetailsException{
		OrderDetails od=ods.viewOrder(ordeDetails);
		return new ResponseEntity<>(od, HttpStatus.ACCEPTED);
	}


	@GetMapping("ByRestraunt")
	public ResponseEntity<List<OrderDetails>> viewOrderDetailsByRestrauntHanler(@RequestBody Restaurant restaurant) throws OrderDetailsException{
		List<OrderDetails> odlist=ods.viewAllOrdersByRestaurant(restaurant);

		return new ResponseEntity<>(odlist, HttpStatus.ACCEPTED);
	}


	@GetMapping("ByCustomer")
	public ResponseEntity<List<OrderDetails>> viewOrderDetailsByCustomerHanler(@RequestBody Customer customer) throws OrderDetailsException, RestaurantException {
		List<OrderDetails> odlist=ods.viewAllOrdersByCustomer(customer);

		return new ResponseEntity<>(odlist, HttpStatus.ACCEPTED);
	}




}