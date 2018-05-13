package com.confluence.test.oauth;

import com.google.api.client.auth.oauth.OAuthGetTemporaryToken;

public class ConfluenceOAuthGetTemporaryToken extends OAuthGetTemporaryToken {

    /**
     * @param authorizationServerUrl encoded authorization server URL
     */
    public ConfluenceOAuthGetTemporaryToken(String authorizationServerUrl) {
        super(authorizationServerUrl);
        this.usePost = true;
    }

}
