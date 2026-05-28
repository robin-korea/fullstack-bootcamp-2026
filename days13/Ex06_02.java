package days13;

public class Ex06_02 {

	public static void main(String[] args) {

		Document doc1 = new Document();
		Document doc2 = new Document();
		Document doc3 = new Document();
		Document doc4 = new Document("자바문서.txt");
		Document doc5 = new Document();

	}

}

class Document{

	String fileName;
	static int count = 1;
	
	public Document() {
		// this() 명시적으로 생성자를 호출하는 동안에는 this, super 를 참조할 수 없다
		// Cannot refer to 'this' nor 'super' while explicitly invoking a constructor
		this(String.format("Noname%d.txt", count));
		// String fileName = String.format("Noname%d.txt", this.count);
		// The Java feature 'Flexible Constructor Bodies' is only available with source level 25 and above
		count++;
	}
	
	public Document(String fileName) {
		this.fileName = fileName;
		System.out.printf("문서 \"%s\"가 생성되었습니다.\n",this.fileName);
	}

}