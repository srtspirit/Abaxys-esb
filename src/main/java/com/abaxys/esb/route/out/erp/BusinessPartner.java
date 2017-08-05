package com.abaxys.esb.route.out.erp;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.abaxys.esb.route.service.BusinesspartnerService;

@Component
public class BusinessPartner extends RouteBuilder implements EnvironmentAware {
	@Autowired
	Environment env;

	@Override
	public void configure() throws Exception {
		//restConfiguration().component("restlet");
		
		//define data format for translating xml -> json
		XmlJsonDataFormat jsonXml = new XmlJsonDataFormat();
		jsonXml.setSkipNamespaces(true);
		
		from("activemq:topic:" + BusinesspartnerService.OUT_BP_TOPIC + "?connectionFactory=jmsConnectionFactory")
			.to("xslt://xslt/erp/businessPartner/BusinessPartnerCMToERP.xsl?saxon=true") //saxon == XSLT 2.0
			.marshal(jsonXml)
			.to("rest:post:ABerp/stdSscript/stdBridge.php?host=" + env.getProperty("abaxys.erp.restApiHost"))
			.to("file://hui?fileName=hui5.xml");
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.env = environment;
	}
}
