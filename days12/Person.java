package days12;

public class Person {
	// Alt + Shift + S
	// 필드
	private String name;
	private int age;
	private boolean gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// boolean 은 get 안쓰고 is 쓴다
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	// setter
	public void setAge(int a) {
		if(a >= 0 && a <= 120) {
			age = a;
		}else {
			// 강제로 에러 메세지를 발생
			throw new RuntimeException("[오류] 나이는 0~120 이어야 한다.");
		}
	}
	// getter
	public int getAge() {
		return age;
	}
	// 생성자
	public Person() {
		
	}
	
	public Person(String name, int age, boolean gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	// 메서드
	public void dispPerson() {
		System.out.printf("> 이름:%s ,나이:%d살, 성별:%s\n",name,age,gender?"남자":"여자");
	}
}
