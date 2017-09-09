package com.example.securedService;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SecuredServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuredServiceApplication.class, args);
	}
}

@RestController
class SecuredController {

	@RequestMapping(value = "/hi")
	public String hi() {
		System.out.println("Inside hi()");
		return "Hi : " + new Date();
	}

	@RequestMapping(value = "/getDetails/{name}", method = RequestMethod.POST)
	// public ResponseEntity<UserSearchDetails> getDetails(@RequestBody
	// UserSearchDetails userSearchDetails) {
	public UserDetails getDetails(@PathVariable String name, @RequestParam String email, @RequestBody UserSearchDetails userSearchDetails) {
		System.out.println("Inside getDetails()");
		System.out.println("Search Details : " + userSearchDetails);
		System.out.println("Request Parms-------");
		System.out.println("email " + email);
		System.out.println("URL Parms-------");
		System.out.println("name : " + name);
		UserDetails userDetails = new UserDetails();
		userDetails.setUserSearchDetails(userSearchDetails);
		userDetails.setName("Sajal");
		userDetails.setAddress("India");
		System.out.println("Response : " + userDetails);
		// return new
		// ResponseEntity<UserSearchDetails>(userSearchDetails,HttpStatus.OK);
		return userDetails;
	}

	@RequestMapping(value = "/getDetailsWithHeader", method = RequestMethod.POST)
	// public ResponseEntity<UserSearchDetails> getDetails(@RequestBody
	// UserSearchDetails userSearchDetails) {
	public UserDetails getDetailsWIthHeader(@RequestHeader(value="header1") String header1,@RequestHeader(value="header2") String header2,@RequestBody UserSearchDetails userSearchDetails) {
		System.out.println("Inside getDetailsWIthHeader()");
		System.out.println("Search Details : " + userSearchDetails);
		System.out.println("Header Deatils ---------");
		System.out.println("Header1 : " + header1);
		System.out.println("Header2 : " + header2);
		UserDetails userDetails = new UserDetails();
		userDetails.setUserSearchDetails(userSearchDetails);
		userDetails.setName("Sajal");
		userDetails.setAddress("India");
		System.out.println("Response : " + userDetails);
		// return new
		// ResponseEntity<UserSearchDetails>(userSearchDetails,HttpStatus.OK);
		return userDetails;
	}
}
