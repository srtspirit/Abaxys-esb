package com.abaxys.esb.app;

import javax.xml.XMLConstants;
import javax.xml.transform.TransformerFactory;

import org.apache.camel.Main;
import org.apache.camel.main.MainListenerSupport;
import org.apache.camel.main.MainSupport;

import com.abaxys.esb.route.in.FromCRMBusinessPartnerUpdate;
import com.abaxys.esb.route.service.BusinesspartnerService;

public class Application {

	public static void main(String[] args) throws Exception {
		
		TransformerFactory factory = TransformerFactory.newInstance();
		factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);
		
		Main main = new Main();
		main.addRouteBuilder(new FromCRMBusinessPartnerUpdate());
		main.addMainListener(new Events());
		//main.getCamelContexts().get(0).getProperties().put("org.apache.camel.xmlconverter.output.indent", "yes");
		//main.bind("hui", factory);
		main.addRouteBuilder(new BusinesspartnerService());
		main.run();
	}
	
	public static class Events extends MainListenerSupport {
		 
        @Override
        public void afterStart(MainSupport main) {
            System.out.println("MainExample with Camel is now started!");
        }
 
        @Override
        public void beforeStop(MainSupport main) {
            System.out.println("MainExample with Camel is now being stopped!");
        }
    }

}
