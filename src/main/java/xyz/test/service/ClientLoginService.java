package xyz.test.service;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.test.model.ClientModel;
import xyz.test.pojo.Client;

@Service
public class ClientLoginService implements ClientDetailsService {

    @Transactional
    public ClientDetails loadClientByClientId(String clientId)
	    throws OAuth2Exception {
	Client client = null;
	
	client = ClientModel.getByClientId(clientId);
	
	if (client == null) {
	    throw new NoSuchClientException("ClientId not found");
	}

	BaseClientDetails clientDetails = new BaseClientDetails(client.getClientId(),
		client.getResourceIds(), client.getScopes(),
		client.getAuthorizedGrantTypes(), client.getAuthorities()
			.toString());
	
	clientDetails.setClientSecret(client.getClientSecret());
	clientDetails.setAccessTokenValiditySeconds(client.getAccessTokenValiditySeconds());
	clientDetails.setRefreshTokenValiditySeconds(client.getRefreshTokenValiditySeconds());
	
	return clientDetails;
    }

}
