package com.eazybytes.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
