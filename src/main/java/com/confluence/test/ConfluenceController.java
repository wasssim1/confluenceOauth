package com.confluence.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ConfluenceController {

	@GetMapping(value = "/login", produces = "application/json")
	public ResponseEntity<?> newLogin() {
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@GetMapping(value = "wasstest.atlassian.net/wiki/rest/api/audit", produces = "application/json")
	public ResponseEntity<?> getAudit() {
//		accept = " application/json";
//		auth = "Basic bWgud2Fzc2ltMUBnbWFpbC5jb206S1JMaFUxQlVJQldWaWhWMFNYQ3owQTYz";
		return new ResponseEntity<?>(null, HttpStatus.OK);
	}
}
