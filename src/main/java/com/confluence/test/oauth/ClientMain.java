package com.confluence.test.oauth;

import java.util.Arrays;
import java.util.List;

public class ClientMain {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            throw new IllegalArgumentException("No command specified. Use one of " + Command.names());
        }

        PropertiesClient propertiesClient = new PropertiesClient();
        ConfluenceOAuthClient confluenceOAuthClient = new ConfluenceOAuthClient(propertiesClient);

        List<String> argumentsWithoutFirst = Arrays.asList(args).subList(1, args.length);

        new OAuthClient(propertiesClient, confluenceOAuthClient).execute(Command.fromString(args[0]), argumentsWithoutFirst);
    }
}
