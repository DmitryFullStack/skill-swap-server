package ru.kirilin.skillswap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kirilin.skillswap.UserDto;
import ru.kirilin.skillswap.entity.AccountType;
import ru.kirilin.skillswap.entity.User;
import ru.kirilin.skillswap.service.UserService;

@RestController
@RequestMapping("/v1")
public class UserController {
    @Autowired
//    private OAuth2AuthorizedClientService authorizedClientService;
    private UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String id,
                                               @RequestParam(name = "accountType", required = true) AccountType accountType){
        return ResponseEntity.ok(userService.getUserById(id, accountType));
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

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

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleNotFound(IllegalArgumentException exception){
        return ResponseEntity.notFound().build();
    }
}
