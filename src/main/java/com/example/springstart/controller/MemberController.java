package com.example.springstart.controller;

import com.example.springstart.domain.Member;
import com.example.springstart.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


// 스프링컨테이너에 객체를 생성해서 넣어두고 관리를함
@Controller
public class MemberController {
     private final MemberService memberService;

     @Autowired
     public MemberController(MemberService memberService) {
         this.memberService = memberService;
     }

     @GetMapping("/members/new")
     public String createForm() {
         return "members/createMemberForm";
     }

     @PostMapping("/members/new")
    public String create(MemberForm form){
         Member member = new Member();
         System.out.println(form.getTitle());
         member.setName(form.getTitle());

         System.out.printf("member:", member.getName());
         memberService.join(member);
         System.out.printf("member:", member.getName());
         return "redirect:/";
     }

     @GetMapping("/members")
    public String list(Model model) {
         List<Member> members = memberService.findMembers();
         model.addAttribute("members", members);
         return "members/memberList";
     }
}
