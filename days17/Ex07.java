package days17;

/**
 * @author An
 * @date 2026. 6. 4. 오후 2:09:09 
 * @subject 한반 30명 학생의 이/국/영/수/총/평/등 관리
 * @content -> Student 클래스를 클래스 배열로 선언해서 위의 처리
 *				days12.Ex01.java
 *					.Student.java
 *					.StudentManager.java
 *
 *				클래스 배열 대신에 ArrayList 사용해서 수정
 */
public class Ex07 {

	public static void main(String[] args) {

		StudentManager manager = new StudentManager(15);

		manager.inputStudents();
		manager.processRank();      
		manager.printStudents();

	}

}
