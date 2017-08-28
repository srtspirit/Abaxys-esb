package com.abaxys.esb.route.in;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat.NamespacesPerElementMapping;
import org.apache.camel.processor.validation.SchemaValidationException;
import org.springframework.stereotype.Component;

import com.abaxys.esb.exception.ExceptionHandler;
import com.abaxys.esb.route.service.BusinesspartnerService;


@Component
public class FromCRMBusinessPartnerUpdate extends RouteBuilder {
	public final static String INCOMING_BP_QUEUE = "ESB.IN.CRM.BUSINESSPARTNER.UPDATE";

	@Override
	public void configure() throws Exception {
		//define data format for converting json -> xml
		NamespacesPerElementMapping namespace = new NamespacesPerElementMapping("businessPartner", "||http://crm|");
		List<NamespacesPerElementMapping> list = new ArrayList<>();
		list.add(namespace);
		XmlJsonDataFormat xmljson = new XmlJsonDataFormat();
		xmljson.setRootName("businessPartner");
		xmljson.setNamespaceMappings(list);
		
		onException(SchemaValidationException.class)
		.bean(ExceptionHandler.class)
		.to("activemq:queue: DLQ?connectionFactory=jmsConnectionFactory");
		
		onException(Exception.class)
		.maximumRedeliveries(3).redeliveryDelay(3000)
		.bean(ExceptionHandler.class)
		.to("activemq:queue: DLQ?connectionFactory=jmsConnectionFactory");
		
		from("activemq:queue:" + INCOMING_BP_QUEUE + "?connectionFactory=jmsConnectionFactory")
			.unmarshal(xmljson)
			.to("xslt://xslt/crm/BuisinessPartner/prepareBusinessPartner.xsl?saxon=true") // saxon - for XSLT 2.0
			.to("validator:xsd/crm/BusinessPartner.xsd")
			.to("xslt://xslt/crm/BuisinessPartner/CrmToCMBusinesPartner.xsl?saxon=true")
			.to("activemq:queue:" + BusinesspartnerService.SERVICE_BP_QUEUE + "?connectionFactory=jmsConnectionFactory");
	}
}