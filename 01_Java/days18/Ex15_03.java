package days18;

import java.util.ArrayList;

/**
 * @author An
 * @date 2026. 6. 5. 오후 4:37:19 
 * @subject [제네릭 클래스의 객체 생성과 사용]
 * @content Fruit
 *            ㄴ Apple
 *            ㄴ Grape
 *            제네릭 클래스 선언 사용
 *            
 */
/*
public class Ex15_03 {

	public static void main(String[] args) {
		
		/*
		Box03<Fruit> fruitBox = new Box03();
		Box03<Apple> appleBox = new Box03();
		Box03<Grape> grapeBox = new Box03();
		Box03<Toy> toyBox = new Box03();
		
		// 과일 담는 상자객체에 과일, 사과, 포도 객체 add
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		System.out.println(fruitBox.size()); // 3
		
		// The method add(Fruit) in the type Box03<Fruit> is not applicable for the arguments (Toy)
		// fruitBox.add(new Toy());
		
		// Type mismatch: cannot convert from Box03<Grape> to Box03<Apple>
		// Box03<Apple> appleBox2 = new Box03<Grape>();

	}

}
class Box03<T>{
	
	ArrayList<T> list = new ArrayList<T>();
	
	void add(T item) {
		this.list.add(item);
	}
	
	T get(int index){
		return this.list.get(index);
	}
	
	int size() {
		return this.list.size();
	}
	
	@Override
	public String toString() {
		return this.list.toString();
	}
	
}



class Toy{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Toy";
	}
	
}

class Fruit{
	public String toString() {
		return "Fruit";
	}
	
}
class Apple extends Fruit{

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Apple";
	}
	
}
class Grape extends Fruit{

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Grape";
	}
	
}
		*/