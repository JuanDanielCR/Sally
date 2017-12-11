package com.quicksoft.sally;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.conekta.Conekta;
import io.conekta.Customer;
import io.conekta.Error;
import io.conekta.ErrorList;
import io.conekta.Order;

public class TestCrypt {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder b =  new BCryptPasswordEncoder();
		System.out.println("cifrada"+b.encode("minimonica"));
		
		/*Conekta.setApiKey("key_ierxo5AtM39sB54smPTAXw");
		Conekta.apiVersion = "2.0.0";
		try{  
			Customer customer = Customer.create(
			new JSONObject("{"
			     + "'name': 'Juan Castillo', "
			      + "'email': 'castilloreyesjuan@gmail.com',"
			      + "'phone': '+523313979662',"
			      + "'payment_sources':[{"
			        + "'type': 'card',"
			        + "'token_id': 'tok_test_visa_4242'"
			        + "}]"
			      + "}"
				)
			);
			
			 Order order = Order.create(
					    new JSONObject("{"
					      + "'line_items': [{"
					          + "'name': 'Tacos',"
					          + "'unit_price': 1000,"
					          + "'quantity': 12"
					      + "}]," //line_items
					      + "'shipping_lines': [{"
					          + "'amount': 1500,"
					          + "'carrier': 'FEDEX'"
					      + "}]," //shipping_lines - physical goods only
					      + "'currency': 'MXN',"
					      + "'customer_info': {"
					        + "'customer_id': 'cus_2fkJPFjQKABcmiZWz'"
					      + "}," //customer_info
					      + "'shipping_contact':{"
					         + "'address': {"
					           + "'street1': 'Calle 123, int 2',"
					           + "'postal_code': '06100',"
					           + "'country': 'MX'"
					         + "}"
					       + "}," //shipping_contact - required only for physical goods 
					       +"'metadata': {'description': 'Compra de creditos: 300(MXN)' , 'reference' : '1334523452345'},"
					      + "'charges':[{"
					        + "'payment_method': {"
					          + "'type': 'default'"
					        + "}" //payment_method - use the customer's <code>default</code> - a card
					      + "}]" //charges
					    + "}" //order
					    )
					  );
			 
			 System.out.println("ID: " + order.id);
			 System.out.println("Status: " + order.payment_status);
			 System.out.println("$" + (order.amount/100) + order.currency);
			 System.out.println("Order");
			 
		}catch (ErrorList e) {
		   System.out.println(e.details.get(0).message);
		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}
