package days18;

import java.util.TreeSet;

/**
 * @author An
 * @date 2026. 6. 5. 오전 11:10:41
 * @subject Set - HashSet, LinkedHashSet
 * @content       TreeSet
 * 
 */
public class Ex06 {

	public static void main(String[] args) {
		/*
		 * 1. 중복 허용 X, 순서 유지 X
		 * 2. 이진 검색 트리( binary Search Tree) 라는 자료구조로 데이터 저장 
		 *    하는 컬렉션 클래스  
		 * 3. 이진 검색 트리( binary Search Tree)  - 정렬, 검색, 범위 검색 높은 성능.
		 * 4. 링크드리스트 처럼 노드( Node )가 서로 연결된 구조이다. 
		 * 5.                      최상위노드 --   루트(root)노드
		 *    노드들 간의 관계    :   부모노드 - 자식노드
		 *                            형제노드 
		 * 6. 노드 구조
		 *    class TreeNode{
		 *       TreeNode 왼쪽자식노드;
		 *       int value;
		 *       TreeNode 오른쪽자식노드;
		 *    }                           
		 * 7. 이진 검색 트리 구조
		 *   부모노드의 왼쪽에는 부모노드 값보다 작은 값의 자식노드가 배치가 되고
		 *              오른쪽에는      "        큰값의    자식노드가 배치가 된다. 
		 *              
		 *                      [0x100][7][0x300] 최상위 노드(root 노드)  
		 *                      
		 *          [0x200][4][0x400]            [null][9][null]
		 *          0x100                       0x300
		 *   
		 *  [null][1][null]     [null][5][Ox600]
		 *  0x200               0x400   
		 *  
		 *                                   [null][6][null] 
		 *                                   Ox600                       
		 * */

		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(7);
		ts.add(4);
		ts.add(1);
		ts.add(9);
		ts.add(5);
		ts.add(6);
	} // main

} // class
