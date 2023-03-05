package com.liuyang.springmvc.controller;

import com.liuyang.springmvc.pojo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestAjax {

    @RequestMapping("/RequestBody")
    public String testRequestBody(@RequestBody String requserBody) {
        System.out.println("requserBody = " + requserBody);
        return "success";

    }

    //@RequestMapping("/RequestBody/json")
    //public void testRequestBodyJson(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException {
    //
    //    System.out.println("map = " + map);
    //    response.getWriter().write("hello");
    //
    //
    //}

    @RequestMapping("/RequestBody/json")
    public void testRequestBodyJson(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println("user = " + user);
        response.getWriter().write("howAreYou?!");

    }


    //@RequestMapping("/ResponseBody")
    //@ResponseBody
    //public List<User> testTheResponseBody(){
    //    User user1 = new User("liuyang","123456");
    //    User user2 = new User("liuneng","245");
    //    User user3 = new User("liudehua","7655");
    //    User user4 = new User("liuyifei","344556");
    //    User user5 = new User("zhoasi","343445");
    //    List<User> users = Arrays.asList(user1, user2, user3, user4, user5);
    //
    //    return users;
    //}


    @RequestMapping("/ResponseBody")
    public Map<String,Object> testTheResponseBody(){
        User user1 = new User("liuyang","123456");
        User user2 = new User("liuneng","245");
        User user3 = new User("liudehua","7655");
        Map<String,Object> users = new HashMap<String, Object>();
        users.put("001",user1);
        users.put("002",user2);
        users.put("003",user3);
        return users;
    }


}
