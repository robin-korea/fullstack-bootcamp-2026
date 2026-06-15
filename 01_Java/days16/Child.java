package days16;

// days16.Parent 와 같은 패키지 내부
public class Child extends Parent{
	
	void modifierAccessTest() {
		this.pub = 1;
		this.pro = 1;
		this.def = 1;
		
	}
	
}
