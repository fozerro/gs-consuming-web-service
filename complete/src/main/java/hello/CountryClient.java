
package hello;

import hello.wsdl.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import hello.wsdl.GetCountryRequest;
import hello.wsdl.GetCountryResponse;

import javax.xml.bind.JAXBElement;

public class CountryClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

	public GetCountryResponse getCountry2(String country) {

		GetCountryRequest request = new GetCountryRequest();
		request.setName(country);

		log.info("Requesting location for " + country);

		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive( request );

		return response;
	}


	public GetCountryResponse getCountryMarszal(String country) {

		GetCountryRequest request = new GetCountryRequest();
		request.setName(country);

		log.info("Requesting location for " + country);

		JAXBElement<GetCountryResponse> response = (JAXBElement<GetCountryResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

		return response.getValue();
	}

	public GetCountryResponse getCountryMarszaluRI(String country) {

		GetCountryRequest request = new GetCountryRequest();
		request.setName(country);

		log.info("Requesting location for " + country);

		JAXBElement<GetCountryResponse> response = (JAXBElement<GetCountryResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

		return response.getValue();
	}

}
