import java.util.HashSet;

public class MemberCollection {
	private HashSet<Member> members;
		
		public MemberCollection(){
			this.members =  new HashSet<Member>();
		}
		
		public void add(Member member){
			this.members.add(member);
		}
		
		public void remove(Member member){
			this.members.remove(member);
		}
		
		public Member findMember(String memberId){
			Member memberFound = null;
			for (Member m : members){
				if(m.getId().equals(memberId)){
					memberFound = m;
				}
			}
			return memberFound;
		}
}
