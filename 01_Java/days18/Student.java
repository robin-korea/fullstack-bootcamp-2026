package days18;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private String no; // 학번  -  학생을 구별할 수 있는 고유한 필드
	private String name;
	private int age;
	
	
	@Override
	public int hashCode() {
		return this.no.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Student other = (Student) obj;
		return Objects.equals(no, other.no);
	}
	
	

}






