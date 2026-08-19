package days21.sec02;

import lombok.Setter;

@Setter
public class Button {
	
	@FunctionalInterface
	public static interface ClickListener{
		
		void onClick();
	}
	
	private ClickListener clickListener;
	
	public void click() {
		this.clickListener.onClick();
	}

}
