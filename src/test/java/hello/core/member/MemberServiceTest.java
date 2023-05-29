package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {


    MemberService memberService;
    @BeforeEach//테스트를 실행하기전에 무조건 실행함
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join(){
        //given : 이런저런환경이 주어졌을떄
        Member member = new Member(1L,"memberA",Grade.VIP);


        //when : 이렇게 했을떄
        memberService.join(member);
        Member findeMember = memberService.findMember(1L);


        //then : 이렇게 된다
        Assertions.assertThat(member).isEqualTo(findeMember);

    }
}
