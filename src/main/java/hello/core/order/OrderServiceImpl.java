package hello.core.order;

import hello.core.discount.DiscountPolisy;
import hello.core.discount.FixDiscountPolisy;
import hello.core.discount.RateDiscountPolisy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    // 추상체와 구현체 둘 다 의존하고 있기 때문에 DIP를 위반함
    // 항상 추상화에만 의존해야 한다
    private final MemberRepository memberRepository;
    private final DiscountPolisy discountPolisy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolisy discountPolisy) {
        this.memberRepository = memberRepository;
        this.discountPolisy = discountPolisy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member findMember = memberRepository.findById(memberId);
        int discountPrice = discountPolisy.discount(findMember, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
