package com.harry.springboot.controller;

import com.harry.springboot.bean.Person;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {
    //  car/2/owner/zhangsan
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam( required = false) Integer age,
                                     @RequestParam Map<String,String> params){


        Map<String,Object> map = new HashMap<>();

//        map.put("id",id);
//        map.put("name",name);
//        map.put("pv",pv);
//        map.put("userAgent",userAgent);
//        map.put("headers",header);
        map.put("age",age);
        map.put("params",params);

        return map;
    }

    @GetMapping("/person/")
    @ResponseBody
    public Person getPerson(Person person){
        System.out.println(person);
        person.setUserName("harry");
        int i = 0;
//        throw new UserTooManyException("ss");
        return  person;
    }
}
