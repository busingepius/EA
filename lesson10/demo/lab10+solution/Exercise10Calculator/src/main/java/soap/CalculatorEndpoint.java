package soap;


import generated.AddRequest;
import generated.AddResponse;
import generated.SubtractRequest;
import generated.SubtractResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class CalculatorEndpoint {
	private static final String NAMESPACE_URI = "http://springtraining/calculator";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddRequest")
	@ResponsePayload
	public AddResponse add(@RequestPayload AddRequest request) {
		AddResponse response = new AddResponse();
		response.setResult(request.getNumber1()+request.getNumber2());
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "SubtractRequest")
	@ResponsePayload
	public SubtractResponse subtract(@RequestPayload SubtractRequest request) {
		SubtractResponse response = new SubtractResponse();
		response.setResult(request.getNumber1()-request.getNumber2());
		return response;
	}
}



