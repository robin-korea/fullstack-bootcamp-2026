package days21.sec06;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Member {
	
	private String id;
	private String name;
	
	public Member(String id) {
	      this.id = id;
	      System.out.println("Member(String id)");
	   }
}


