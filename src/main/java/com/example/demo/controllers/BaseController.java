package com.example.demo.controllers;

import com.example.demo.entities.VueUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.BaseService;

import java.util.List;


@RestController
@RequestMapping("/api/vi/user")//路径
public class BaseController {

    private final BaseService baseService;
    @Autowired
    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }
    //search
    @GetMapping
    public List<VueUserEntity> getUsername(){
        return baseService.getUsername();
    }
    //add
    @PostMapping
    public void registerAddNewUser(@RequestBody VueUserEntity vueUserEntity) throws IllegalAccessException {
        baseService.addNewUser(vueUserEntity);
    }

    //delete
    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") Integer id) throws IllegalAccessException {
        baseService.deleteUser(id);
    }

    //change
    @DeleteMapping(path = "{}")
//    @ResponseBody
//    @RequestMapping("/")
//    public String root() {
//        VueUserEntity vueUserEntity = baseService.login();
//        return "<h1>hello</h1>";
//    }
}
