package com.project.restservice.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Ansh Gupta");
    }

    @GetMapping("v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Ansh","A","Gupta"));
    }

    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter(){
        return new PersonV1("Ansh Gupta");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonReqParameter(){
        return new PersonV2(new Name("Ansh","A","Gupta"));
    }

    @GetMapping(value = "/person/header", headers = "API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader(){
        return new PersonV1("Ansh Gupta");
    }

    @GetMapping(value = "/person/header", headers = "API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonReqHeader(){
        return new PersonV2(new Name("Ansh","A","Gupta"));
    }
}
