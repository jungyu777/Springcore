package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //가입을하고 회원을 찾을려면 MemberRepository 인터페이스가 필요하다 인터페이스만 가지고있으면 널포인트 나온다 그래서 구현 객체 MemoryMemberRepository
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);// join으로 save를 호출하면 다형성에의해서 MemoryMemberRepository에 있는  save메소드가 호출이된다
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
