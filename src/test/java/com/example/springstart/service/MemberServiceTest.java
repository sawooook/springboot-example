package com.example.springstart.service;

import com.example.springstart.domain.Member;
import com.example.springstart.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("Hello");
        Long saveId = memberService.join(member);
        //when
        Member findMember = memberService.findOne(saveId).get();
        //then

    }

    @Test
    void 중복회원가입() {
        Member member = new Member();
        member.setName("saouk");
        Member member1 = new Member();
        member1.setName("saouk");

        memberService.join(member);

//        try {
//            memberService.join(member1);
//            fail();
//        } catch ( IllegalStateException e){
//
//        }

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}