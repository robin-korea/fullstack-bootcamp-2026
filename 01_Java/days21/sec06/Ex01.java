package days21.sec06;

/**
 * @author An
 * @date 2026. 6. 10. 오전 10:33:07 
 * @subject 메서드 참조
 * @content 생성자 참조
 *            ㄴ 생성자를 참조한다는 의미 : 객체를 생성한다는 의미
 *            ㄴ 람다식이 단순히 객체를 생성하고 리턴한다면
 *              -> 생성자 참조로 대치할 수 있다
 *            ㄴ 예) (a,b) -> {return new 클래스명(a,b); }
 *                       클래스명 :: new  <- 생성자 참조
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		
		Person p = new Person(); 
		
		// [1]
//		Member m2 = p.getMember2((id,name) -> {
//			return new Member(id,name);
//		});
		
		// [2]
//		Member m2 = p.getMember2((id,name) -> new Member(id,name));
		
		// [3]
		Member m2 = p.getMember2(Member :: new);
		
		System.out.println(m2);
		
		
		/*
		// [1]
//		Member m1 = p.getMember1((id) -> {
//			return new Member(id);
//		});
		
		// [2]
//		Member m1 = p.getMember1((id) -> new Member(id));
		
		// [3]
		Member m1 = p.getMember1(Member:: new);
		
		System.out.println(m1);
		
		*/
		
	}

}
