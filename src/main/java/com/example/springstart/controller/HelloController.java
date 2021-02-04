package com.example.springstart.controller;

import com.sun.tools.javac.Main;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","test");
        return "hello";
    }

    //GetMapping rails routes라고 생각 하면될듯
    //RequestParam rails params[:name] 이렇게 생각하면될듯, 받아서 String name에 넣어준다.
    //그다음 받은걸 addAtribute에 넣어준다음 name이라는 키로 뷰에 뿌려준다.
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello_template";
    }

    @GetMapping("hello-spring")
    // http통신 부분에서 바디 부분에 이 데이터를 직접 넣어주겠다.
    @ResponseBody
    public String helloSrping(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return  hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}


