package com.qa.kittens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.kittens.rest.KittenController;
import com.qa.kittens.service.KittenServiceList;

@SpringBootApplication
public class SpringKittensApplication {

	public static void main(String[] args) {
		ApplicationContext beanBag = SpringApplication.run(SpringKittensApplication.class, args);
		KittenController controller = beanBag.getBean(KittenController.class);
		System.out.println(controller);

		KittenServiceList service = beanBag.getBean(KittenServiceList.class);
		System.out.println(service);
//		beanBag.getBean(Kitten.class);

		// HOW YOU'D DO IT W/O SPRING:
		KittenServiceList myService = new KittenServiceList();
		KittenController myController = new KittenController(myService);
	}

}
