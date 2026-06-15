package days16;

public class Ex01_04 {

	public static void main(String[] args) {
	      /*
	      문제 설명
	      길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수
	      , solution을 완성하세요. 
	      예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.

	      제한 조건
	      n은 길이 10,000이하인 자연수입니다.
	      입출력 예
	      n   return
	      3   "수박수"
	      4   "수박수박"
	      */
	      
	      String result = solution(4);
	      System.out.println( result );

	   } // main
	   
	   private static String solution(int n) {
//	       String answer = "";
	      StringBuilder answer = new StringBuilder();
	      
	      int share = n / 2;
	      for (int i = 1; i <= n; i++) {
	         answer.append("수박");
	      }
	      if(n%2==1) answer.append( "수");
	      
	      /*
	      for (int i = 1; i <= n; i++) {
	         if ( i%2 ==0 ) {
//	            answer += "박";
	            answer.append("박");
	         } else {
//	            answer += "수";
	            answer.append("수");
	         }
	      }
	      */
	      return answer.toString();
	   }
}

