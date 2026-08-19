package days10;

/**
 * @author An
 * @date 2026. 5. 22. 오전 11:12:44 
 * @subject 검색(Search)
 * @content  	ㄴ 항목의 집합 중에 특정 항목을 찾아내는 것
 * 				1) 순차 검색 (Sequence Search) : 순차적으로 검사해서 체크
 * 				2) 이진 검색 (Binary Search)
 *					필수조건: 정렬
 */
public class Ex05 {

	public static void main(String[] args) {

		int [] m = { 0, 4, 5, 15, 20, 21, 22, 24, 25, 28, 29, 30, 32, 33, 40, 43, 46, 47, 48, 58, 62, 63, 71, 76, 
				86, 91, 94, 99, 111, 116, 128, 135, 137, 139, 142, 145, 146, 150, 151, 160, 161, 166, 168, 
				169, 172, 181, 184, 185, 191, 198 };

		// Arrays.binarySearch(m,9);

		int n = 198;

		int index = binarySearch(m,n);


		System.out.println(index);
	}

	private static int binarySearch(int[] m, int n) {
		// 1. bottom/top 변수 선언해서 저장
		// 2. middle 값 구해서 저장
		//  m[middle] == n 
		// 3. m[middle] > n middle -1 = top
		// 4. m[middle] < n  middle+1 = bottom

		int bottom = 0; 
		int top = m.length-1;
		int middle;
		int count = 0;
		while(bottom <= top){
			System.out.println(++count);
			middle = (bottom + top) / 2;
			if(m[middle] == n) {
				return middle;
			} else if (m[middle] > n) {
				top = middle - 1;
			} else {
				bottom = middle + 1;
			}
		}
		return -1;
	}

}
