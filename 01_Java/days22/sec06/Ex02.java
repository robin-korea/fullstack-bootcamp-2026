package days22.sec06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex02 {

	public static void main(String[] args) {

		List<Student> list = new ArrayList<>();
		list.add(new Student("홍길동", "남", 92));
		list.add(new Student("김수영", "여", 87));
		list.add(new Student("감자바", "남", 95));
		list.add(new Student("오해영", "여", 93));
		
		// list -> 성별로 그룹화: 남 List,   여 List
		//            Map         key value
		
		// [2]
		 Map<String, List<Student>> map = list.stream()
				 							 .collect(Collectors.groupingBy(s -> s.getGender()));
		
		 List<Student> mlist = map.get("남");
		 mlist.stream().forEach(System.out::println);
		
		/* [1]
		Map<String, List<Student>> map =new HashMap<>();
		
		List<Student> 남list = new ArrayList<Student>();
		List<Student> 여list = new ArrayList<Student>();
		
		Iterator<Student> ir = list.iterator();
		while(ir.hasNext()) {
			Student s = ir.next();
			String key = s.getGender(); // 성별
			if (key.equals("남자")) {
				남list.add(s);
			} else {
				여list.add(s);
			}
		}
		map.put("남", 남list);
		map.put("여", 여list);
		*/
	}

}
