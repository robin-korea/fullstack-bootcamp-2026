package org.doit.ik.di5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;


@Component
public class UserRepository {
	
	private Map<String, User> userMap = new HashMap<>();
	
	public UserRepository() {
		User user1 = new User("bkchoi", "1234");
		User user2 = new User("madvirus", "qwer");
		
		userMap.put(user1.getId(), user1);
		userMap.put(user2.getId(), user2);
	}
	
	public User findUserById(String id) {
		return userMap.get(id);
	}
	
	public void setUsers(List<User> users) {
		for (User u : users)
			userMap.put(u.getId(),u);
	}
}
