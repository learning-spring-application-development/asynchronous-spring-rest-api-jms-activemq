package com.asyncmessage.restapi.sender;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * @author Ravi Kant Soni
 * @since Aug/04/2015 {@link learningspringapplicationdevelopment.com}
 */
@Service
public class JmsMessageSenderImpl implements JmsMessageSender {
	private final static Logger LOGGER = Logger
			.getLogger(JmsMessageSenderImpl.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(final Object Object) {
		jmsTemplate.convertAndSend(Object);
	}

	/**
	 * send text to default destination
	 * 
	 * @param text
	 */
	public void sendMessage(final String text) {

		this.jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createTextMessage(text);
				// set ReplyTo header of Message, pretty much like the concept
				// of email.
				message.setJMSReplyTo(new ActiveMQQueue("Recived to Send"));
				return message;
			}
		});
	}

	/**
	 * Simplify the send by using convertAndSend
	 * 
	 * @param text
	 */
	public void sendText(final String text) {
		this.jmsTemplate.convertAndSend(text);
	}

	/**
	 * Send text message to a specified destination
	 * 
	 * @param text
	 */
	public void send(final Destination dest, final String text) {

		this.jmsTemplate.send(dest, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createTextMessage(text);
				return message;
			}
		});
	}

}
