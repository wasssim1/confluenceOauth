package com.confluence.test.oauth;

import static com.confluence.test.oauth.PropertiesClient.CONFLUENCE_HOME;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.google.api.client.auth.oauth.OAuthAuthorizeTemporaryTokenUrl;
import com.google.api.client.auth.oauth.OAuthCredentialsResponse;
import com.google.api.client.auth.oauth.OAuthParameters;

public class ConfluenceOAuthClient {

    public final String jiraBaseUrl;
    private final ConfluenceOAuthTokenFactory oAuthGetAccessTokenFactory;
    private final String authorizationUrl;

    public ConfluenceOAuthClient(PropertiesClient propertiesClient) throws Exception {
        jiraBaseUrl = propertiesClient.getPropertiesOrDefaults().get(CONFLUENCE_HOME);
        this.oAuthGetAccessTokenFactory = new ConfluenceOAuthTokenFactory(this.jiraBaseUrl);
        authorizationUrl = jiraBaseUrl + "/plugins/servlet/oauth/authorize";
    }

    /**
     * Gets temporary request token and creates url to authorize it
     *
     * @param consumerKey consumer key
     * @param privateKey  private key in PKCS8 format
     * @return request token value
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws IOException
     */
    public String getAndAuthorizeTemporaryToken(String consumerKey, String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        ConfluenceOAuthGetTemporaryToken temporaryToken = oAuthGetAccessTokenFactory.getTemporaryToken(consumerKey, privateKey);
        OAuthCredentialsResponse response = temporaryToken.execute();

        System.out.println("Token:\t\t\t" + response.token);
        System.out.println("Token secret:\t" + response.tokenSecret);

        OAuthAuthorizeTemporaryTokenUrl authorizationURL = new OAuthAuthorizeTemporaryTokenUrl(authorizationUrl);
        authorizationURL.temporaryToken = response.token;
        System.out.println("Retrieve request token. Go to " + authorizationURL.toString() + " to authorize it.");

        return response.token;
    }

    /**
     * Gets acces token from JIRA
     *
     * @param tmpToken    temporary request token
     * @param secret      secret (verification code provided by JIRA after request token authorization)
     * @param consumerKey consumer ey
     * @param privateKey  private key in PKCS8 format
     * @return access token value
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws IOException
     */
    public String getAccessToken(String tmpToken, String secret, String consumerKey, String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        ConfluenceOAuthGetAccessToken oAuthAccessToken = oAuthGetAccessTokenFactory.getConfluenceOAuthGetAccessToken(tmpToken, secret, consumerKey, privateKey);
        OAuthCredentialsResponse response = oAuthAccessToken.execute();

        System.out.println("Access token:\t\t\t" + response.token);
        return response.token;
    }

    /**
     * Creates OAuthParameters used to make authorized request to JIRA
     *
     * @param tmpToken
     * @param secret
     * @param consumerKey
     * @param privateKey
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public OAuthParameters getParameters(String tmpToken, String secret, String consumerKey, String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        ConfluenceOAuthGetAccessToken oAuthAccessToken = oAuthGetAccessTokenFactory.getConfluenceOAuthGetAccessToken(tmpToken, secret, consumerKey, privateKey);
        oAuthAccessToken.verifier = secret;
        return oAuthAccessToken.createParameters();
    }
}
