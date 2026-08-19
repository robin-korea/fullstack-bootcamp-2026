package days05.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.doit.domain.DeptVO;

import com.util.DBConn;

import days05.board.domain.BoardDTO;
import days05.board.domain.PageDTO;
import days05.board.persistence.BoardDAO;
import days05.board.persistence.BoardDAOImpl;

@WebServlet("/cstvsboard/list.htm")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public List() {
        super();
    }
    
    int currentPage = 1;    // 현재 페이지 번호
    int numberPerPage = 10; // 한 페이지에 출력할 게시글 수
    int numberOfPageBlock = 10;  // [1] 2 3 4 5 6 7 8 9 10 >
    int totalRecords = 0;   // 총 레코드 수
    int totalPages = 0 ;    // 총 페이지 수
    
    // http://localhost/cstvsboard/list.htm?currentPage=1
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("> List.doGet()...");
		
		// [1] 현재 페이지
		String pCurrentPage = request.getParameter("currentPage");
		if(pCurrentPage == null || pCurrentPage.isBlank()) {
			pCurrentPage = "1";
		}
		currentPage = Integer.parseInt(pCurrentPage);
		
		// [2] 한 페이지에 출력할 게시글 수
		try {
			this.numberPerPage = Integer.parseInt(request.getParameter("numberPerPage"));
		} catch (Exception e) {
			this.numberPerPage = 10;
		}
		
		// [3] + [4] 검색조건, 검색어
		String searchCondition = request.getParameter("searchCondition");
		
		if(searchCondition == null || searchCondition.isBlank()) {
			searchCondition = "t";
		}
		
		String searchKeyword = request.getParameter("searchKeyword");
		
		// 1. 목록 로직 처리
		Connection conn = DBConn.getConnection(); 
		java.util.List<BoardDTO> list = null;
		PageDTO pDto = null;
		BoardDAO dao = new BoardDAOImpl(conn);
		
		try {
			if(searchKeyword == null || searchKeyword.isBlank()) {
				pDto = new PageDTO(currentPage, numberPerPage, numberOfPageBlock);
				list = dao.select(currentPage, numberPerPage);
			}else {
				pDto = new PageDTO(currentPage, numberPerPage, numberOfPageBlock, searchCondition, searchKeyword);
				list = dao.search(searchCondition, searchKeyword, currentPage, numberPerPage);
			}
			
		} catch (SQLException e) {
			System.out.println("> 1. List.doGet() Exception... ");
			e.printStackTrace();
		} finally {
			DBConn.close();
		}
		
		// System.out.println(list.size());
		request.setAttribute("list", list);
		request.setAttribute("pDto", pDto);
		
		/*
		 * String message = (String) request.getSession().getAttribute("message");
		 * 
		 * if(message != null) { request.setAttribute("message", message);
		 * request.getSession().removeAttribute("message"); }
		 */
		
		// 2. list.jsp 포워딩
		String path = "/days05/board/list.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
