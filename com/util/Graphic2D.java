package com.util;

public class Graphic2D {

	// 메서드 선언 부분
	public static void drawLine() {
		System.out.println("---------------");
	}

	// [접] [기] 리턴자료형 메소드명([매개변수...])
	public static void drawLine(int length) {
		for (int i = 1; i <= length; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public static void drawLine(int length, char style) {
		for (int i = 1; i <= length; i++) {
			System.out.print(style);
		}
		System.out.println();

	}
}
