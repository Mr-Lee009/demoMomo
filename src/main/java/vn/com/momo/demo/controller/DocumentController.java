package vn.com.momo.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

    @RequestMapping(value = "/load",method = RequestMethod.GET)
    public String load(){
        return "document";
    }
}
