package ru.kirilin.skillswap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.kirilin.skillswap.repository.UserRepository;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
//    private OAuth2AuthorizedClientService authorizedClientService;
    private UserRepository userRepository;

//    @GetMapping("/registration")
//    public ResponseEntity<Map> getLoginInfo(OAuth2AuthenticationToken authentication) {
//        OAuth2AuthorizedClient client = authorizedClientService
//                .loadAuthorizedClient(
//                        authentication.getAuthorizedClientRegistrationId(),
//                        authentication.getName());
//        String userInfoEndpointUri = client.getClientRegistration()
//                .getProviderDetails().getUserInfoEndpoint().getUri();
//        Map userAttributes = null;
//        if (!userInfoEndpointUri.isBlank()) {
//            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders headers = new HttpHeaders();
//            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken()
//                    .getTokenValue());
//            HttpEntity entity = new HttpEntity("", headers);
//            ResponseEntity <Map>response = restTemplate
//                    .exchange(userInfoEndpointUri, HttpMethod.GET, entity, Map.class);
//            userAttributes = response.getBody();
//        }
//        return ResponseEntity.ok(userAttributes);
//    }
}
