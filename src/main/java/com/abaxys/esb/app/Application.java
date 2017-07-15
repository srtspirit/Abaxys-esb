package com.abaxys.esb.app;

import javax.xml.XMLConstants;
import javax.xml.transform.TransformerFactory;

import org.apache.camel.Main;
import org.apache.camel.main.MainListenerSupport;
import org.apache.camel.main.MainSupport;

import com.abaxys.esb.route.in.FromCRMBusinessPartnerUpdate;

public class Application {

	public static void main(String[] args) throws Exception {
		
		TransformerFactory factory = TransformerFactory.newInstance();
		factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);
		
		Main main = new Main();
		main.addRouteBuilder(new FromCRMBusinessPartnerUpdate());
		main.addMainListener(new Events());
		main.bind("hui", factory);
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
