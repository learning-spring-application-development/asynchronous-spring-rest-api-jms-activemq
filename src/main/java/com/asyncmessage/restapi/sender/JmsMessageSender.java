package com.asyncmessage.restapi.sender;

import javax.jms.Destination;

/**
 * @author Ravi Kant Soni
 * @since Aug/04/2015 {@link learningspringapplicationdevelopment.com}
 */
public interface JmsMessageSender {

	public void send(final Object Object);

	public void sendMessage(final String text);

	public void sendText(final String text);

	public void send(final Destination dest, final String text);

}
