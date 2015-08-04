package com.asyncmessage.restapi.controller;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asyncmessage.restapi.messageservice.MessageService;
import com.asyncmessage.restapi.model.Greeting;

/**
 * @author Ravi Kant Soni
 * @since Aug/04/2015 {@link learningspringapplicationdevelopment.com}
 */
@Controller
@RequestMapping("/hello-world")
public class JmsMessageController {
	private final static Logger LOGGER = Logger
			.getLogger(JmsMessageController.class);

	@Autowired
	private MessageService mySampleService;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Greeting sayHello(
			@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name)
			throws InterruptedException {

		Future<String> result = mySampleService.call();
		while (!(result.isDone())) {
			Thread.sleep(1); // 10-millisecond pause between each check
			System.out.println("Waiting for Long Process...");
		}
		System.out.println("Done!");
		mySampleService.generateReport();
		return new Greeting(counter.incrementAndGet(), String.format(template,
				name));
	}

}
