package org.doit.ik.di3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RecordImpl3 implements Record3{
	
	private int kor;
	private int mat;
	private int eng;	
	
	@Override
	public int total() {
		return this.kor + this.mat + this.eng;
	}

	@Override
	public double avg() {
		return this.total()/3.0;
	}

}
