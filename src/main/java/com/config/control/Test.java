package com.config.control;


import com.config.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Test {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/test/cookie")
    public String cookie(@RequestParam("sex") String sex, HttpServletRequest request, HttpSession session) {
        //测试redis
//        String redisName = redisService.getStr("name");
        //取出session中的name
        Object sessionSex = session.getAttribute("sex");
        if (sessionSex == null) {
            System.out.println("不存在session，设置sex=" + sex);
            session.setAttribute("sex", sex);
        } else {
            System.out.println("存在session，sex=" + sex.toString());
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }
        return null;
    }
}