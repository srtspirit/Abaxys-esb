package com.abaxys.esb.route.out.erp;

import org.apache.camel.builder.RouteBuilder;

public class BusinessPartner extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("activemq:topic:ESB.OUT.ALL.BUSINESSPARTNER")
			.to("xslt://xslt/serviceToERP.xsl?saxon=true")
			.to("file://hui?fileName=hui4.xml");
	}

}
