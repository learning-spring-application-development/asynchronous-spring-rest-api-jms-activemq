package com.asyncmessage.restapi.messageservice;

import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import com.asyncmessage.restapi.receiver.JmsMessageReceiver;
import com.asyncmessage.restapi.sender.JmsMessageSender;

/**
 * @author Ravi Kant Soni
 * @since Aug/04/2015 {@link learningspringapplicationdevelopment.com}
 */
@Component
public class MessageServiceImpl implements MessageService {
	private final static Logger LOGGER = Logger
			.getLogger(MessageServiceImpl.class);

	@Autowired
	private JmsMessageSender jmsMessageSender;

	@Autowired
	private JmsMessageReceiver jmsMessageReceiver;

	@Override
	@Async
	public Future<String> call() {
		try {
			jmsMessageSender.sendMessage("Ravi Kant Soni");
			System.out.println("Sleeping now...");
			Thread.sleep(10000);
			return new AsyncResult<String>("Hey");
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Async
	public Future<String> generateReport() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String message = jmsMessageReceiver.receive().toString();
		System.out.println(message);
		return new AsyncResult<String>(message);
	}

}
