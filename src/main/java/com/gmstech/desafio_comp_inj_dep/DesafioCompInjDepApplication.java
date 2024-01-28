package com.gmstech.desafio_comp_inj_dep;

import com.gmstech.entities.Order;
import com.gmstech.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.gmstech"})
public class DesafioCompInjDepApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {

		SpringApplication.run(DesafioCompInjDepApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int code = sc.nextInt();
		double basic = sc.nextDouble();
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		//Order order = new Order(1309, 95.90, 0.0);

		System.out.println("Pedido código " + order.getCode());
		System.out.println("Valor total: R$ " + String.format("%.2f",orderService.total(order)));
	}
}
