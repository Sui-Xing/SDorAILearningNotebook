package com.tf.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tf.utils.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tf.pojo.User;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//标注下面所有方法都只会返回json字符串
@RestController
public class UserController {
    @RequestMapping(value = "/j1")
    public String json1() throws JsonProcessingException {

//        jackson,ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        User user=new User("秦将",3,"nan");

        String s = objectMapper.writeValueAsString(user);
        return s;
    }

    @RequestMapping(value = "/j2")
    public String json2() throws JsonProcessingException {

//        jackson,ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> userList = new ArrayList<User>();
        User user1=new User("秦将1",3,"nan");
        User user2=new User("秦将2",3,"nan");
        User user3=new User("秦将3",3,"nan");
        User user4=new User("秦将4",3,"nan");


        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);


        String s = objectMapper.writeValueAsString(userList);


        return s;// new ObjectMapper().writeValueAsString(userList);
    }


    @RequestMapping(value = "/j3")
    public String json3() throws JsonProcessingException {

        Date date = new Date();
        return Json.getJson(date);
    }

    @RequestMapping(value = "/j4")
    public String json4() throws JsonProcessingException {
        User user1 = new User("秦疆1号", 3, "男");
        User user2 = new User("秦疆2号", 3, "男");
        User user3 = new User("秦疆3号", 3, "男");
        User user4 = new User("秦疆4号", 3, "男");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);
        return "hello";

    }


}
