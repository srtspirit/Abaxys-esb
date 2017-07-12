package com.abaxys.esb.app;

import org.apache.camel.Main;
import org.apache.camel.main.MainListenerSupport;
import org.apache.camel.main.MainSupport;

import com.abaxys.esb.route.in.FromCRMBusinessPartnerUpdate;

public class Application {

	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.addRouteBuilder(new FromCRMBusinessPartnerUpdate());
		main.addMainListener(new Events());
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
