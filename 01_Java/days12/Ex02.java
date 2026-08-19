package days12;

/**
 * @author An
 * @date 2026. 5. 27. 오전 10:14:10 
 * @subject Student 클래스 : 한 학생 정보(데이터)
 * @content StudentManager 클래스 : 학생들의 리스트 관리 클래스
 * 			:
 * 			Ex02.main(){
 * 				
 * 			}
 *
 */
public class Ex02 {

	public static void main(String[] args) {

		StudentManager manager = new StudentManager(); 
		
		manager.inputStudents();
		
		manager.processRank();
		
		manager.printStudents();
	}

}
