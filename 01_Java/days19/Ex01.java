package days19;

import java.util.ArrayList;

public class Ex01 {

	public static void main(String[] args) {

		FruitBox<Fruit> fruitBox = new FruitBox<>();
		Juice juice = Juicer.makeJuce(fruitBox);
		System.out.println(juice);

		FruitBox<Grape> grapeBox = new FruitBox<>();
		FruitBox<Apple> appleBox = new FruitBox<>();
		// The method makeJuce(FruitBox<Fruit>) in the type Juicer is not applicable for the arguments (FruitBox<Apple>)
		juice = Juicer.makeJuce(appleBox);
		System.out.println(juice);



	}

}

class Fruit{   public String toString() { return "Fruit";   }}
class Apple extends Fruit{   public String toString() {return "Apple";   }}
class Grape extends Fruit{   public String toString() {return "Grape";   }}

class Box<T>{
	ArrayList<T>  list = new ArrayList<T>();
	void add(T item) {this.list.add(item);}
	T get(int i) {return  this.list.get(i);}
	int size() {return this.list.size();}
	public String toString(){return this.list.toString();}
}

// 제한된 제네릭 클래스
class FruitBox<T extends Fruit> extends Box<T>{

}

// 과일 -> 쥬스
class Juice{
	// 구현 가정
}

// 과일 상자 -> 쥬스를 생산하는 기기
class Juicer{

	// 메소드를 똑같은 기능의 제네릭 메소드로 선언
	static <T extends Fruit> Juice makeJuce(FruitBox<T> box) {
		//
		//
		return new Juice();
	}


	/* 와일드카드 제네릭 사용
	static Juice makeJuce(FruitBox<? extends Fruit> box) {
		//
		//
		return new Juice();
	}
	 */

	/* 오버로딩 불가
	static Juice makeJuce(FruitBox<Fruit> box) {
		//
		//
		return new Juice();
	}

	static Juice makeJuce(FruitBox<Apple> box) {
		//
		//
		return new Juice();


	}
	 */
	// 제네릭 메서드
	static <T extends Fruit> void printAll( ArrayList<T> list
	         , ArrayList<T> list2 ) {
	      // 구현 코딩
	      // 구현 코딩
	      // 구현 코딩
	   }
	   
}