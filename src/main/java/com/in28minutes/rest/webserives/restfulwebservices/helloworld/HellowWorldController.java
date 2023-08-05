package com.in28minutes.rest.webserives.restfulwebservices.helloworld;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HellowWorldController {
    private MessageSource messageSource;

    public HellowWorldController(MessageSource messageSource){
        this.messageSource = messageSource;
    }
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

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);

    }

}
