package com.abaxys.esb.route.service;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class BusinesspartnerService extends RouteBuilder {
	public static final String SERVICE_BP_QUEUE = "ESB.SERVICE.BUSINESSPARTNER";
	public static final String OUT_BP_TOPIC = "ESB.OUT.ALL.BUSINESSPARTNER";

	@Override
	public void configure() throws Exception {
		from("activemq:queue:" + SERVICE_BP_QUEUE + "?connectionFactory=jmsConnectionFactory")
			.to("activemq:topic:" + OUT_BP_TOPIC + "?connectionFactory=jmsConnectionFactory");
	}

}
