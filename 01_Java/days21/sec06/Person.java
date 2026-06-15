package days21.sec06;

public class Person {
	
	// id : Member 객체를 생성해서 반환
	public Member getMember1(Creatable creatable) {
		Member member = creatable.create("admin");
		return member;
	}
	// id,name : Member 객체를 생성해서 반환
	public Member getMember2(Creatable2 creatable) {
		Member member = creatable.create("hong","홍길동");
		return member;
	}
}
