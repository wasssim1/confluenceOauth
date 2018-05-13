package com.confluence.test.oauth;

import com.google.api.client.auth.oauth.OAuthRsaSigner;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

public class ConfluenceOAuthTokenFactory {
    protected final String accessTokenUrl;
    protected final String requestTokenUrl;


    public ConfluenceOAuthTokenFactory(String confluenceBaseUrl) {
        this.accessTokenUrl = confluenceBaseUrl + "/plugins/servlet/oauth/access-token";
        ;
        requestTokenUrl = confluenceBaseUrl + "/plugins/servlet/oauth/request-token";
    }

    /**
     * Initialize ConfluenceOAuthGetAccessToken
     * by setting it to use POST method, secret, request token
     * and setting consumer and private keys.
     *
     * @param tmpToken    request token
     * @param secret      secret (verification code provided by JIRA after request token authorization)
     * @param consumerKey consumer key
     * @param privateKey  private key in PKCS8 format
     * @return ConfluenceOAuthGetAccessToken request
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public ConfluenceOAuthGetAccessToken getConfluenceOAuthGetAccessToken(String tmpToken, String secret, String consumerKey, String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        ConfluenceOAuthGetAccessToken accessToken = new ConfluenceOAuthGetAccessToken(accessTokenUrl);
        accessToken.consumerKey = consumerKey;
        accessToken.signer = getOAuthRsaSigner(privateKey);
        accessToken.transport = new ApacheHttpTransport();
        accessToken.verifier = secret;
        accessToken.temporaryToken = tmpToken;
        return accessToken;
    }


    /**
     * Initialize ConfluenceOAuthGetTemporaryToken
     * by setting it to use POST method, oob (Out of Band) callback
     * and setting consumer and private keys.
     *
     * @param consumerKey consumer key
     * @param privateKey  private key in PKCS8 format
     * @return ConfluenceOAuthGetTemporaryToken request
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public ConfluenceOAuthGetTemporaryToken getTemporaryToken(String consumerKey, String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        ConfluenceOAuthGetTemporaryToken oAuthGetTemporaryToken = new ConfluenceOAuthGetTemporaryToken(requestTokenUrl);
        oAuthGetTemporaryToken.consumerKey = consumerKey;
        oAuthGetTemporaryToken.signer = getOAuthRsaSigner(privateKey);
        oAuthGetTemporaryToken.transport = new ApacheHttpTransport();
        oAuthGetTemporaryToken.callback = "oob";
        return oAuthGetTemporaryToken;
    }

    /**
     * @param privateKey private key in PKCS8 format
     * @return OAuthRsaSigner
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private OAuthRsaSigner getOAuthRsaSigner(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        OAuthRsaSigner oAuthRsaSigner = new OAuthRsaSigner();
        oAuthRsaSigner.privateKey = getPrivateKey(privateKey);
        return oAuthRsaSigner;
    }

    /**
     * Creates PrivateKey from string
     *
     * @param privateKey private key in PKCS8 format
     * @return private key
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private PrivateKey getPrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] privateBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(keySpec);
    }
}
