package com.confluence.test;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*")
public class ConfluenceController {
	
	
	@GetMapping(value = "/login", produces = "application/json")
	public ResponseEntity<?> newLogin() {
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@GetMapping(value = "/rest/api/audit", produces = "application/json")
	public ResponseEntity<?> getAudit(@RequestParam("email") String email) {
		final String uri = "https://wasstest.atlassian.net/wiki/rest/api/audit";
		RestTemplate restTemplate = new RestTemplate();
		
		// TODO: Change the email of the corresponding user and his API key
		String userPlusAPIToken = email + ":KRLhU1BUIBWVihV0SXCz0A63";
		
		byte[] bytesEncoded = Base64.encodeBase64(userPlusAPIToken.getBytes());
		StringBuilder auth = new StringBuilder();
		auth.append("Basic ");
		auth.append(new String(bytesEncoded));
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		headers.add("Authorization", auth.toString());
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		
		return result;
	}
	
	@GetMapping(value = "/rest/api/content", produces = "application/json")
	public ResponseEntity<?> getContent(@RequestParam("email") String email) {
		final String uri = "https://wasstest.atlassian.net/wiki/rest/api/content";
		RestTemplate restTemplate = new RestTemplate();
		
		// TODO: Change the email of the corresponding user and his API key
		String userPlusAPIToken = email + ":KRLhU1BUIBWVihV0SXCz0A63";
		
		byte[] bytesEncoded = Base64.encodeBase64(userPlusAPIToken.getBytes());
		StringBuilder auth = new StringBuilder();
		auth.append("Basic ");
		auth.append(new String(bytesEncoded));
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		headers.add("Authorization", auth.toString());
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		
		return result;
	}
	
	@GetMapping(value = "/rest/api/space", produces = "application/json")
	public ResponseEntity<?> getSpaces(@RequestParam("email") String email) {
		final String uri = "https://wasstest.atlassian.net/wiki/rest/api/space";
		RestTemplate restTemplate = new RestTemplate();
		
		// TODO: Change the email of the corresponding user and his API key
		String userPlusAPIToken = email + ":KRLhU1BUIBWVihV0SXCz0A63";
		
		byte[] bytesEncoded = Base64.encodeBase64(userPlusAPIToken.getBytes());
		StringBuilder auth = new StringBuilder();
		auth.append("Basic ");
		auth.append(new String(bytesEncoded));
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		headers.add("Authorization", auth.toString());
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		
		return result;
	}
	
	
	// Make sure you have the right permissions in confluence
	@GetMapping(value = "/rest/api/user", produces = "application/json")
	public ResponseEntity<?> getTheUser(@RequestParam("email") String email) {
		final String uri = "https://wasstest.atlassian.net/wiki/rest/api/user";
		RestTemplate restTemplate = new RestTemplate();
		
		// TODO: Change the email of the corresponding user and his API key
		String userPlusAPIToken = email + ":KRLhU1BUIBWVihV0SXCz0A63";
		
		byte[] bytesEncoded = Base64.encodeBase64(userPlusAPIToken.getBytes());
		StringBuilder auth = new StringBuilder();
		auth.append("Basic ");
		auth.append(new String(bytesEncoded));
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		headers.add("Authorization", auth.toString());
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		
		return result;
	}
	
	
	@GetMapping(value = "/rest/api/settings/lookandfeel", produces = "application/json")
	public ResponseEntity<?> getSettingsLookAndFeel(@RequestParam("email") String email) {
		final String uri = "https://wasstest.atlassian.net/wiki/rest/api/settings/lookandfeel";
		RestTemplate restTemplate = new RestTemplate();
		
		// TODO: Change the email of the corresponding user and his API key
		String userPlusAPIToken = email + ":KRLhU1BUIBWVihV0SXCz0A63";
		
		byte[] bytesEncoded = Base64.encodeBase64(userPlusAPIToken.getBytes());
		StringBuilder auth = new StringBuilder();
		auth.append("Basic ");
		auth.append(new String(bytesEncoded));
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		headers.add("Authorization", auth.toString());
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		
		return result;
	}
	
}
