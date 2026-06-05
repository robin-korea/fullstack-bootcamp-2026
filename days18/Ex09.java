package days18;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Ex09 {
	
			  // key 그룹명     value 사람들의 정보 (이름, 전화번호)
	static HashMap<String, HashMap<String, String>> phoneBook = new HashMap<>();

	   public static void main(String[] args) {  //  프로그램 시작
	      //     그룹명     이름  연락처 
	      String groupName, name, tel;

	      addPhoneNo( "친구","이자바","010-1111-1111" );   
	      addPhoneNo( "친구","김자바","010-2222-2222" );
	      addPhoneNo( "친구","김자바","010-3333-3333" );
	      addPhoneNo( "회사","이대리","010-4444-4444" );
	      addPhoneNo( "회사","김대리","010-5555-5555" );
	      addPhoneNo( "회사","박대리","010-6666-6666" );
	      addPhoneNo( "동아리","김동아","010-7777-7777" );
	      addPhoneNo( null, "세탁소","010-8888-8888" ); 
	      addPhoneNo( null, "PC방","010-9999-8888" );  


	      printList();

	   } // main

	   private static void printList() { 

	      Set<Entry<String, HashMap<String, String>>> es   = phoneBook.entrySet();
	      Iterator<Entry<String, HashMap<String, String>>> ir = es.iterator();

	      while (ir.hasNext()) {
	         Entry<String, HashMap<String, String>> entry = 
	               (Entry<String, HashMap<String, String>>) ir   .next();

	         String groupName = entry.getKey();
	         HashMap<String, String> groupMap = entry.getValue();
	         System.out.printf("* %s [%d]\n",  groupName, groupMap.size() );

	         Iterator<Entry<String, String>>  ir2 = groupMap.entrySet().iterator();
	         while (ir2.hasNext()) {
	            Entry<String, String> entry2 = (Entry<String, String>) ir2.next();
	            String tel  = entry2.getKey();
	            String name = entry2.getValue();
	            System.out.printf("\t%s : %s\n", name, tel);
	         }
	      }
	   }
	                                    
	   //    addPhoneNo( "친구","이자바","010-1111-1111" );   
	   //    addPhoneNo( "기타", "PC방","010-9999-8888" ); 
	   private static void addPhoneNo(
	         String groupName, String name, String tel) {
	      
	      groupName = (  groupName == null ? "기타" : groupName  );
	      
	      addGroup(groupName);  
	      
	      HashMap<String, String>  group = phoneBook.get(groupName);
	      group.put( tel, name );
	   }

	   private static void addGroup(String groupName) {

	      if (     !phoneBook.containsKey(groupName)   ) {
	         phoneBook.put(groupName, new HashMap<String, String>());
	      }

	   }
}