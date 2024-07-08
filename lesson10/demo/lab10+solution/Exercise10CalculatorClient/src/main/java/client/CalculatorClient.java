package client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import generated.*;

public class CalculatorClient extends WebServiceGatewaySupport {

	public int add(int x, int y) {
		AddRequest request = new AddRequest();
		request.setNumber1(x);
		request.setNumber2(x);
		
		AddResponse response = (AddResponse)
				getWebServiceTemplate().marshalSendAndReceive(request);
		return response.getResult();
	}
}


