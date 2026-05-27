package days11;

public class Ex05 {

	public static void main(String[] args) {
		
		for (int i = 0; i < args.length; i++) {
			
			if(args.length != 3) {
				System.out.println("3명의 이름을 입력하세요");
				return;
			}
			System.out.printf("args[%d]=%s\n",i,args[i]);
		}
		
		System.out.println("END");
		

	}

}
