package com.confluence.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.confluence.test.oauth.Command;
import com.confluence.test.oauth.ConfluenceOAuthClient;
import com.confluence.test.oauth.OAuthClient;
import com.confluence.test.oauth.PropertiesClient;

@SpringBootApplication
public class ConfluenceOauthApplication {

	public static void main(String[] args) throws Exception {
		
        PropertiesClient propertiesClient = new PropertiesClient();
        ConfluenceOAuthClient confluenceOAuthClient = new ConfluenceOAuthClient(propertiesClient);
        
        
        String [] arr = {"requestToken"};
        // TODO: get the token and confirm it in your confluence space !!!!!
        // accessToken {token-from-the-above-command}
        // request {url-request}
        
        List<String> argumentsWithoutFirst = Arrays.asList(arr).subList(1, arr.length);
        
        new OAuthClient(propertiesClient, confluenceOAuthClient).execute(Command.fromString(arr[0]), argumentsWithoutFirst);
		
		
		SpringApplication.run(ConfluenceOauthApplication.class, args);
	}
}
