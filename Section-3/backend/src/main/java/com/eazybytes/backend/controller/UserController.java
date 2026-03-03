package com.eazybytes.backend.controller;

import com.eazybytes.backend.dto.UserDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/dummy/users")
public class UserController {

//    @GetMapping({"/api/dummy/users/{userId}/posts/{postId}", "/api/dummy/users/{userId}"})
//    public String searchUserPostWithMultiPathVariables(@PathVariable Long userId, @PathVariable(required = false) Long postId) {
//        String response;
//        if(postId == null) {
//            response = "Fetched user with id: " + userId;
//        }
//        else{
//            response = "Fetched user with id: " + userId + " and post id: " + postId;
//        }
//        return response;
//    }

    @GetMapping({"/{userId}/orders/{orderId}"})
    public String searchUserPostWithMultiPathVariables(@PathVariable(name = "userId") Long customerId, @PathVariable Long orderId) {
        return "Fetched user with id: " + customerId + "and order id: " + orderId;
    }

    @GetMapping({"/{userId}/address/{addressId}"})
    public String searchUserPostWithMultiPathVariables(@PathVariable Map<String, String> pathVariablesMap) {
        return "Fetched user with id: " + pathVariablesMap.get("userId") + "and address id: " + pathVariablesMap.get("addressId");
    }

    @GetMapping("/search")
    public String searchUserWithQueryParams(@RequestParam(required = false, defaultValue = "Guest") String name,
                                            @RequestParam(name = "gender") String sex){
        return "Fetched user with query params: " + name + " and gender: " + sex;
    }

    @GetMapping("/search/map")
    public String searchUserWithQueryParams(@RequestParam Map<String, String> requestParams) {
        return "Fetched user with query params: " + requestParams.get("name") + " and gender: " + requestParams.get("gender");
    }

    @GetMapping("/headers")
    public String readRequestHeaders(@RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader(name = "User-Location", required = false, defaultValue = "Hyderabad") String userLocation) {
        return "Recieved: " + userAgent + " " + userLocation;
    }

    @GetMapping("/headers/map")
    public String readRequestHeadersWithMap(@RequestHeader Map<String, String> requestHeaders) {
        return "Recieved: " + requestHeaders.get("User-Agent") + " " + requestHeaders.get("User-Location");
    }

    @PostMapping
    public String createUser(@RequestBody UserDto userDto) {
        return "Created user: " + userDto.toString();
    }

    @PostMapping("/request-entity")
    public ResponseEntity<String> createUserRequestEntity(RequestEntity<UserDto> requestEntity) {
        HttpHeaders headers = requestEntity.getHeaders();
        UserDto userDto = requestEntity.getBody();
        String queryParam = requestEntity.getUrl().getQuery();
        String pathVariables = requestEntity.getUrl().getPath();
        // return "Created user with the data: " + userDto.toString();
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Custom-Header", "ExampleValue")
                .body("Created User with the data: " + userDto.toString());
    }

}
