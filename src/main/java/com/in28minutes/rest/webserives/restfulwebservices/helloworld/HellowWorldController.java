package com.in28minutes.rest.webserives.restfulwebservices.helloworld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowWorldController {

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
            return "Hello World";
        }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldbean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }


}