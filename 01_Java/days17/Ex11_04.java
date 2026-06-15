package days17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Ex11_04 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		final int LOTTO_PRICE = 1000; // 로또 1게임 1000 
		int gameCount; // 게임횟수

		System.out.print("> 게임 횟수 입력: "); 
		gameCount = scanner.nextInt();

		ArrayList lottoList = new ArrayList();

		createLottoNumbers(lottoList, gameCount);
		displayLottoNumbers(lottoList);

	} // main

	private static void displayLottoNumbers(ArrayList lottoList) {
		
		Iterator ir = lottoList.iterator();
		while (ir.hasNext()) {
			HashSet lottoSet = (HashSet) ir.next();
			displayLottoNumbers(lottoSet);
		}
	}

	private static void createLottoNumbers(ArrayList lottoList, int gameCount) {
		HashSet lottoSet = null;

		for (int i = 1; i <= gameCount; i++) {
			lottoSet = new HashSet(6);
			createLottoNumbers(lottoSet); 
			lottoList.add(lottoSet);
		} // for

	}

	// Ex11_02.java 복사
	// HashSet  로또를 채우는 함수, 로또 번호 한 게임 발생..
	public static void createLottoNumbers(HashSet lottoSet) {
		int lottoNumber; 
		while (lottoSet.size() < 6 ) { 
			lottoNumber = (int)(Math.random() * 45) + 1;
			//            System.out.println( lottoNumber );
			lottoSet.add(lottoNumber);
		} // while
	}

	// 한 게임 출력하는 메소드
	public static void displayLottoNumbers(HashSet lottoSet) {
		
		// 로또번호 오름차순 정렬
		// HashSet lottoSet : 순서유지 X, 중복허용 X
		// LinkedHashSet 컬렉션 클래스 : 순서 유지 O, 중복 허용 X
		// ArrayList 컬렉션 클래스: 순서 유지O
		
		// HashSet -> ArrayList 변환 -> 오름차순 정렬 -> 출력

		// Arrays 클래스 : 배열을 사용하기 쉽게 만들어 놓은 클래스
		// Collections 클래스: Collection을 사용하기 쉽게 만들어 놓은 클래스
		
		 // List<Integer> lotto = new ArrayList<>(lottoSet);
		 ArrayList lotto = new ArrayList<>(lottoSet);
//		 Collections.sort(lotto);
		 lotto.sort(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				int a = (int) o1;
				int b = (int) o2;
				return a-b;
			}
		});
		 System.out.println(lotto);
	}


}
