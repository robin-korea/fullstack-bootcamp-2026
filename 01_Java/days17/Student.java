package days17;

public class Student {
	
	// 필드
	public int no;
	public String name;
	public int kor, eng, mat, tot, rank, wrank;
	public double avg;
	// 메소드
	
	public String getInfo() { // 한 학생 정보 입력
	      return String.format("[%d]\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\t%d"
	            , no
	            , name 
	            , kor , eng , mat, tot 
	            , avg , rank, wrank);
	   }

}

/*
+----------------+
|   Student      |
+----------------+
| name           |
| kor            |
| eng            |
| math           |
| total          |
| avg            |
| rank           |
+----------------+
| calcTotal()    |
| calcAvg()      |
+----------------+

▲
|
|

+--------------------+
|  StudentManager    |
+--------------------+
| List<Student>      |
+--------------------+
| addStudent()       |
| printStudents()    |
| processRank()      |
+--------------------+
*/
