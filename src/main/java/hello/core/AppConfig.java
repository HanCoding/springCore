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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// 어플리케이션의 설정 정보를 담당하는 클래스
@Configuration
public class AppConfig {

    // 스프링 컨테이너에 등록
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolisy());
    }

    @Bean
    public DiscountPolisy discountPolisy() {
        return new RateDiscountPolisy();
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
