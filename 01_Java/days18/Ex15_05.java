package days18;

import java.util.ArrayList;
import java.util.HashSet;

import days12.Person;

/**
 * @author An
 * @date 2026. 6. 5. 오후 5:19:21 
 * @subject [와일드 카드 파라미터]
 * @content <? extends Student>
 * 
 * 			<?> == <? extends Object> 모든 타입 제한 없이 사용
 * 			<? extends T> T 타입의 자식 타입만 제한   ex) <? extends Student>
 * 			<? super T>   T 타입의 부모 타입으로만 제한
 * 			
 *
 */
public class Ex15_05 {

	public static void main(String[] args) {
		
		HashSet<Person> hs = new HashSet<Person>();
		HashSet<Student> hs2 = new HashSet<Student>();
		
		// ArrayList<Student> list = new ArrayList<>(Collection<? extends Student)
		ArrayList<Student> list = new ArrayList<Student>();
		// FruitBox<Toy> fVox = new FruitBox<>();
		
	}

}

class Toy{    public String toString() {      return "Toy";   }  }

class Fruit{   public String toString() { return "Fruit";   }}
class Apple extends Fruit{   public String toString() {return "Apple";   }}
class Grape extends Fruit{   public String toString() {return "Grape";   }}

class Box05<T>{
	   ArrayList<T>  list = new ArrayList<T>();
	   void add(T item) {    this.list.add(item);  }
	   T get(int i) {  return  this.list.get(i); }
	   int size() {  return this.list.size();  }
	   public String toString(){  return this.list.toString(); }
	}

// 제한된 제네릭 클래스 선언
class FruitBox<T extends Fruit> extends Box05<T>{
	
}

