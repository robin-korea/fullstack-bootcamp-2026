package days20;

import java.io.Serializable;

public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String password;
	int age;

	public UserInfo() {
		this("UnKnown","1111",0);
	}

	public UserInfo(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}

	@Override
	   public String toString() {
	      return "UserInfo [name=" + name + ", password=" + password + ", age=" + age + "]";
	   }
}
