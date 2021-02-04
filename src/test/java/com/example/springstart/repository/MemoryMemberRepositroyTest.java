package com.example.springstart.repository;

import com.example.springstart.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositroyTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
         Member member = new Member();
         member.setName("hello");

         repository.save(member);
         Member member2 = new Member();
         member2.setName("spring2");
         repository.save(member2);

         Member result = repository.findByName("spring2").get();
         Assertions.assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll() {
        Member member = new Member();
        member.setName("saouk1");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("saouk2");
        repository.save(member2);

        List<Member> restult = repository.findAll();
        Assertions.assertThat(restult.size()).isEqualTo(2);

    }
}
