package com.abaxys.esb.route.out.erp;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class BusinessPartner extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		//restConfiguration().component("restlet");
		
		XmlJsonDataFormat jsonXml = new XmlJsonDataFormat();
		jsonXml.setSkipNamespaces(true);
		
		from("activemq:topic:ESB.OUT.ALL.BUSINESSPARTNER")
			.to("xslt://xslt/serviceToERP.xsl?saxon=true")
			.marshal(jsonXml)
			.to("rest:post:ABerp/stdSscript/stdBridge.php?host=www.sasadept.net:3080")
			.to("file://hui?fileName=hui5.xml");
	}

}
