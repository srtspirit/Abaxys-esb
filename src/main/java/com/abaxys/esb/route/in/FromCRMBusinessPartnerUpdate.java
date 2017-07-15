package com.abaxys.esb.route.in;

import java.util.ArrayList;
import java.util.List;


import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat.NamespacesPerElementMapping;
import org.apache.xalan.xsltc.trax.TransformerFactoryImpl;

public class FromCRMBusinessPartnerUpdate extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		NamespacesPerElementMapping namespace = new NamespacesPerElementMapping("businessPartner", "ns1", "http://crm");
		List<NamespacesPerElementMapping> list = new ArrayList<>();
		list.add(namespace);
		XmlJsonDataFormat xmljson = new XmlJsonDataFormat();
		xmljson.setRootName("businessPartner");
		xmljson.setNamespaceMappings(list);
		
	
		
		
		
		from("activemq:queue:ESB.IN.CRM.BUSINESSPARTNER.UPDATE")
			.unmarshal(xmljson)
			//.xmljson()
			.log("${body}")
			.to("file://hui?fileName=hui.xml")
			.to("xslt://xslt/1.xsl?transformerFactory=#hui")
			.to("file://hui?fileName=hui2.xml")
			.to("validator:xsd/crm/BusinessPartner.xsd");
		System.out.println("the route is created");
	}

}