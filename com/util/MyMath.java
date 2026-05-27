package com.util;

public class MyMath {
	
	/**
     * Returns the greater of two {@code int} values. That is, the
     * result is the argument closer to the value of
     * {@link Integer#MAX_VALUE}. If the arguments have the same value,
     * the result is that same value.
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the larger of {@code a} and {@code b}.
     */
	
	public static int max(int a,int b) {
		// return 문 뒤에 수식이 와도 상관없다
		return a > b ? a : b;
		
		/*
		if ( a > b ) {
			return a;
		}else {
			return b;
		}
		*/
	}
	
	
}
