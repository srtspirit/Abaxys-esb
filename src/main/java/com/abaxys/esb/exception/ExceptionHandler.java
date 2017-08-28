package com.abaxys.esb.exception;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class ExceptionHandler {
	public void handle(Exchange exchange){
		Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class); 
		exchange.getIn().setHeader("error", cause.getMessage());
	}
}
