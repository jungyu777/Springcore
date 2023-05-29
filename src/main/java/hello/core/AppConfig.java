package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.ReteDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {//나의 앱플리케이션 전체를 설정하고 구성한다
    //AppConfig는 애플리케이션 의 실제 동작에 필요한 구현객체를 생성한다.
    //내가 만든 MemberServiceImpl 은 (new MemoryMemberRepository())를 사용할꺼야 하면서 주입해준다
    public MemberService memberService(){ //생성자 주입
        return  new MemberServiceImpl(memberRepository());
    }
    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
       // return new ReteDiscountPolicy();
    }

}
