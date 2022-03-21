package hello.core;

import hello.core.discount.DiscountPolisy;
import hello.core.discount.FixDiscountPolisy;
import hello.core.discount.RateDiscountPolisy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 어플리케이션에 대한 환경 구성을 담당한다
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolisy());
    }

    public DiscountPolisy discountPolisy() {
        return new FixDiscountPolisy();
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
