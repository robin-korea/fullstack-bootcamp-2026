package days22.sec03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Student implements Comparable<Student>{
	
	private String name;
	private int score;
	
	@Override
	public int compareTo(Student o) {
		// return this.score - o.score;
		return Integer.compare(this.score, o.score); 
	}

}
