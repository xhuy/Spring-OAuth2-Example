package xyz.test.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

    public Client() {

    }

    public Client(Integer id) {
	this.id = id;
    }

    @Id
    @GeneratedValue()
    @Column(name = "id")
    private Integer id;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "scopes")
    // Debe ser un Set
    private String scopes;

    @Column(name = "resource_ids")
    // Debe de ser un Set
    private String resourceIds;

    @Column(name = "authorized_grant_types")
    private String authorizedGrantTypes;

    @Column(name = "redirect_uri")
    // Debe de ser un Set
    private String registeredRedirectUris;

    @Column(name = "authorities")
    private String authorities;

    @Column(name = "access_token_validity")
    private Integer accessTokenValiditySeconds;

    @Column(name = "refresh_token_validity")
    private Integer refreshTokenValiditySeconds;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getClientId() {
	return clientId;
    }

    public void setClientId(String clientId) {
	this.clientId = clientId;
    }

    public String getClientSecret() {
	return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
	this.clientSecret = clientSecret;
    }

    public String getScopes() {
	return scopes;
    }

    public void setScopes(String scopes) {
	this.scopes = scopes;
    }

    public String getResourceIds() {
	return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
	this.resourceIds = resourceIds;
    }

    public String getAuthorizedGrantTypes() {
	return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
	this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getRegisteredRedirectUris() {
	return registeredRedirectUris;
    }

    public void setRegisteredRedirectUris(String registeredRedirectUris) {
	this.registeredRedirectUris = registeredRedirectUris;
    }

    public String getAuthorities() {
	return authorities;
    }

    public void setAuthorities(String authorities) {
	this.authorities = authorities;
    }

    public Integer getAccessTokenValiditySeconds() {
	return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
	this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    public Integer getRefreshTokenValiditySeconds() {
	return refreshTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(
	    Integer refreshTokenValiditySeconds) {
	this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

}
