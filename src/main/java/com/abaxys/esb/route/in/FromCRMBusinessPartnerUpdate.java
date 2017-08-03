package com.abaxys.esb.route.in;

import java.util.ArrayList;
import java.util.List;


import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat.NamespacesPerElementMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FromCRMBusinessPartnerUpdate extends RouteBuilder {
	@Autowired
	protected XmlJsonDataFormat xmljson;

	@Override
	public void configure() throws Exception {
		from("activemq:queue:ESB.IN.CRM.BUSINESSPARTNER.UPDATE")
			.unmarshal(xmljson)
			.to("xslt://xslt/crm/BuisinessPartner/prepareBusinessPartner.xsl?saxon=true")
			.to("validator:xsd/crm/BusinessPartner.xsd")
			.to("xslt://xslt/crm/BuisinessPartner/CrmToCMBusinesPartner.xsl?saxon=true")
			.to("activemq:queue:ESB.SERVICE.BUSINESSPARTNER");
	}

	public void setXmljson(XmlJsonDataFormat xmljson) {
		this.xmljson = xmljson;
	}
}