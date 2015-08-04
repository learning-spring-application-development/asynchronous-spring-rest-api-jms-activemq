package com.asyncmessage.restapi.messageservice;

import java.util.concurrent.Future;

/**
 * @author Ravi Kant Soni
 * @since Aug/04/2015 {@link learningspringapplicationdevelopment.com}
 */
public interface MessageService {

	public Future<String> call();

	public Future<String> generateReport();

}
