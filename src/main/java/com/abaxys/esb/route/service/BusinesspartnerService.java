package com.abaxys.esb.route.service;

import org.apache.camel.builder.RouteBuilder;

public class BusinesspartnerService extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("activemq:queue:ESB.SERVICE.BUSINESSPARTNER")
			.to("activemq:topic:ESB.OUT.ALL.BUSINESSPARTNER");
	}

}