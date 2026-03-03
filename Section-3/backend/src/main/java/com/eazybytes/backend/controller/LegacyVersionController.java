package com.eazybytes.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/legacy/versions")
public class LegacyVersionController {

    @GetMapping({"", "/", "/v1"})
    public ResponseEntity<String> defaultPathVersion(){
        return ResponseEntity.ok("Response from defaultPathVerison API 1.0.0");
    }

    @GetMapping("/v2")
    public ResponseEntity<String> pathV2Version(){
        return ResponseEntity.ok("Response from pathV2Verison API 2.0.0");
    }

    @GetMapping(params = "version=1")
    public ResponseEntity<String> defaultReqVersion(){
        return ResponseEntity.ok("Response from defaultReqVerison API 1.0.0");
    }

    @GetMapping(params = "version=2")
    public ResponseEntity<String> v2ParamVersion(){
        return ResponseEntity.ok("Response from v2ParamVerison API 2.0.0");
    }

    @GetMapping(headers = "X-API-VERSION=1")
    public ResponseEntity<String> defaultReqHeaderVersion(){
        return ResponseEntity.ok("Response from defaultReqHeaderVerison API 1.0.0");
    }

    @GetMapping(headers = "X-API-VERSION=2")
    public ResponseEntity<String> v2ReqHeaderVersion(){
        return ResponseEntity.ok("Response from v2ReqHeaderVerison API 2.0.0");
    }

    @GetMapping(produces = "application/vnd.eazyapp.v1+json")
    public ResponseEntity<String> defaultMediaTypeVersion(){
        return ResponseEntity.ok("Response from defaultMediaTypeVerison API 1.0.0");
    }

    @GetMapping(produces = "application/vnd.eazyapp.v2+json")
    public ResponseEntity<String> v2MediaTypeVersion(){
        return ResponseEntity.ok("Response from v2MediaTypeVerison API 2.0.0");
    }

}
