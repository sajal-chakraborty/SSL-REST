package securedClientRestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RestTemplateTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		RestTemplate restTemplate = context.getBean(RestTemplate.class);
		System.out.println(restTemplate);

		//postWithHeaders(restTemplate);

		//exchangeWIthJSONObject(restTemplate);
		
		//postWithRequestparmAndURLParm(restTemplate);
	}

	private static void postWithRequestparmAndURLParm(RestTemplate restTemplate) {
		String url = "https://localhost:8443/getDetails/{name}";

		// URI (URL) parameters
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("name", "Sajal");

		// Query parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
		        // Add query parameter
		        .queryParam("email", "Sajal.chakraborty@gmail.com");

		URI modifiedURL = builder.buildAndExpand(uriParams).toUri();
		System.out.println(modifiedURL);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("email", "first.last@example.com");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<String> response = restTemplate.postForEntity(modifiedURL, request, String.class);
		System.out.println("POST is successuful.. with request parm and url parm");
		System.out.println(response.getBody());
	}

	private static void exchangeWIthJSONObject(RestTemplate restTemplate) {
		// create request body
		JSONObject request = new JSONObject();
		request.put("userid", "PPPPP");

		// set headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("header1", "XXXXXX");
		headers.set("header2", "YYYYYY");
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

		// send request and parse result
		ResponseEntity<String> loginResponse = restTemplate.exchange("https://localhost:8443/getDetailsWithHeader", HttpMethod.POST, entity, String.class);
		if (loginResponse.getStatusCode() == HttpStatus.OK) {
			JSONObject userJson = new JSONObject(loginResponse.getBody());
			System.out.println(userJson);
		} else if (loginResponse.getStatusCode() == HttpStatus.UNAUTHORIZED) {
			// nono... bad credentials
		}
	}

	private static void postWithHeaders(RestTemplate restTemplate) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("email", "first.last@example.com");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<String> response = restTemplate.postForEntity("https://localhost:8443/getDetails", request, String.class);
		System.out.println("POST is successuful!!!!");
		System.out.println(response.getBody());
	}

}
