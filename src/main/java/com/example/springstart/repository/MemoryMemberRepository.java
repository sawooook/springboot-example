package com.example.springstart.repository;

import java.util.*;
import com.example.springstart.domain.Member;
import org.springframework.stereotype.Repository;


@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {


        /// kkkkkkkkk


        member.setId(++sequence);
        System.out.printf("fdfdfdfd");
        System.out.printf("----------------");
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
     }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
