package hello.core.order;

import hello.core.discount.DiscoundPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscoundPolicy discoundPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
    
        Member member = memberRepository.findById(memberId);
        int discountPrice = discoundPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
