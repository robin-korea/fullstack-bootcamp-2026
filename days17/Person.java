package days17;

// 비교자 (Comparator)가 없어도 기본 정렬 기준 선언이 되어 있으면 정렬 가능하다

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
class Person implements Comparable<Person>{
	// 필드
	private String name;
	private int age;
	
	@Override
	public int compareTo(Person o) {
		
		return this.age - o.age;
	}
	
}
