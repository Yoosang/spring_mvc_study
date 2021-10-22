package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello", 20);
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        //given
        Member[] members = new Member[10];
        for(int i = 0; i < 10; i++){
            members[i] = new Member("member"+i, i*10);
        }

        //when
        for(int i = 0; i < 10; i++){
            memberRepository.save(members[i]);
        }

        //then
        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(members.length);
        assertThat(result).contains(members);
    }
}
