package com.confluence.test.oauth;

import com.google.api.client.auth.oauth.OAuthGetAccessToken;

public class ConfluenceOAuthGetAccessToken extends OAuthGetAccessToken {

    /**
     * @param authorizationServerUrl encoded authorization server URL
     */
    public ConfluenceOAuthGetAccessToken(String authorizationServerUrl) {
        super(authorizationServerUrl);
        this.usePost = true;
    }

}
