package days18;

import java.util.ArrayList;

/**
 * @author An
 * @date 2026. 6. 5. 오후 4:50:03 
 * @subject [제한된 제네릭 클래스]
 * @content 
 *
 */
/*
public class Ex15_04 {

	public static void main(String[] args) {
		
		Box04<Fruit> fruitBox = new Box04();
		Box04<Apple> appleBox = new Box04();
		Box04<Grape> grapeBox = new Box04();
		Box04<Toy> toyBox = new Box04();
		
		// 제한된 제네릭 클래스 선언
		
		FruitBox<Grape> gFruitBox = new FruitBox();
		
		// FruitBox<Toy> tFruitBox = new FruitBox(); X F/G/A <T> 사용할 수 없다.
		
	

	}

}

interface Eatable{}

class Toy{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Toy";
	}
	
}

class Fruit implements Eatable{
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

// <T> 모든 타입을 담을 수 있는 상자 클래스
class Box04<T>{
	
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {this.list.add(item);}
	T get(int index){return this.list.get(index);}
	int size() {return this.list.size();}
	@Override
	public String toString() {return this.list.toString();}
}

// 먹을 수 있는 타입(F,A,G)을 담을 수 있는 상자 클래스
// <T> 제한된 제네릭 클래스 선언
class FruitBox<T extends Fruit>{

}

class Bread implements Eatable{
	
}

class EatBox<T extends Eatable>{
	
}

// 이 타입은 Eatable 인터페이스를 구현한 Fruit 클래스의 자식 클래스만 타입으로 제한한다
class EatFruitBox<T extends Fruit & Eatable>{
	
}
*/











