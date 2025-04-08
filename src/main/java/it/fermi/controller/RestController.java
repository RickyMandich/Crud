package it.fermi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@org.springframework.web.bind.annotation.RestController
public class RestController{

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/richiesta/{p1}")
    public String index(@PathVariable int p1, @RequestParam(required = false) int p2) {
        return p1+"+"+p2+"="+(p1+p2);
    }
}