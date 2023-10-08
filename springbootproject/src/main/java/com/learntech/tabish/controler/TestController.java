package com.learntech.tabish.controler;

import com.learntech.tabish.beans.HelloworldBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class TestController {

    private MessageSource messageSource;
    public TestController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/test")
    public String firstHandler(){

        return "Just for testing 123 !!";

    }

    @GetMapping(path = "/hello_world")
    public HelloworldBean helloWorldBean(){

        return new HelloworldBean("Hello world");

    }

    @GetMapping(path = "/hello_world/path_variable/{name}")
    public HelloworldBean helloWorldPathVariable(@PathVariable String name){

        return new HelloworldBean(String.format("Hello Mr.%s", name));

    }

    @GetMapping(path = "/hello_world_internationalized")
    public String helloWorldInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);

    }


}
