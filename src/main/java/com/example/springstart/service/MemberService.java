package com.example.springstart.service;

import com.example.springstart.domain.Member;
import com.example.springstart.repository.MemberRepository;
import com.example.springstart.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private  final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Long join(Member member){
        validateDulpicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDulpicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재함");
                });
    }
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
