package hello.core.order;

import hello.core.discount.DiscoundPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscoundPolicy discoundPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscoundPolicy discoundPolicy) {
        this.memberRepository = memberRepository;
        this.discoundPolicy = discoundPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
    
        Member member = memberRepository.findById(memberId);
        int discountPrice = discoundPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
