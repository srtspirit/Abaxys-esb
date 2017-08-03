package com.abaxys.esb;

import java.util.ArrayList;
import java.util.List;

import javax.jms.ConnectionFactory;
import javax.xml.XMLConstants;
import javax.xml.transform.TransformerFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.Main;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat.NamespacesPerElementMapping;
import org.apache.camel.impl.JndiRegistry;
import org.apache.camel.impl.PropertyPlaceholderDelegateRegistry;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.main.MainListenerSupport;
import org.apache.camel.main.MainSupport;
import org.apache.camel.spi.Registry;
import org.apache.camel.spring.spi.ApplicationContextRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.abaxys.esb.route.in.FromCRMBusinessPartnerUpdate;
import com.abaxys.esb.route.out.erp.BusinessPartner;
import com.abaxys.esb.route.service.BusinesspartnerService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		CamelContext camel = ctx.getBean(CamelContext.class);
		//camel.addComponent("activemq", ActiveMQComponent);;
		
//		TransformerFactory factory = TransformerFactory.newInstance();
//		factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);
//		
//		Main main = new Main();
//		main.addRouteBuilder(new FromCRMBusinessPartnerUpdate());
//		main.addRouteBuilder(new BusinesspartnerService());
//		main.addRouteBuilder(new BusinessPartner());
//		main.addMainListener(new Events());
//		//main.getCamelContexts().get(0).getProperties().put("org.apache.camel.xmlconverter.output.indent", "yes");
//		//main.bind("hui", factory);
//		main.addRouteBuilder(new BusinesspartnerService());
//		main.run();
	}
	
	@Bean
	public XmlJsonDataFormat xmlJsonDataFormat(){
		NamespacesPerElementMapping namespace = new NamespacesPerElementMapping("businessPartner", "||http://crm|");
		List<NamespacesPerElementMapping> list = new ArrayList<>();
		list.add(namespace);
		XmlJsonDataFormat xmljson = new XmlJsonDataFormat();
		xmljson.setRootName("businessPartner");
		xmljson.setNamespaceMappings(list);
		
		return xmljson;
	}
	
	@Bean
	public static ConnectionFactory connectionFactory(){
		return new ActiveMQConnectionFactory("tcp://localhost:61615");
	}
	
//	public static class Events extends MainListenerSupport {
//		 
//        @Override
//        public void afterStart(MainSupport main) {
//            System.out.println("MainExample with Camel is now started!");
//        }
// 
//        @Override
//        public void beforeStop(MainSupport main) {
//            System.out.println("MainExample with Camel is now being stopped!");
//        }
//    }

}
