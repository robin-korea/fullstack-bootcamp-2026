package days07.mvc.member.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import days07.mvc.board.domain.BoardDTO;
import days07.mvc.member.domain.MemberDTO;


public class MemberDAOImpl implements MemberDAO{

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private MemberDTO edto = null;
	private ResultSet rs = null;

	// 생성자를 사용한 의존성 주입(DI)
	public MemberDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public Connection getConn() {
		return conn;
	}

	@Override
	public MemberDTO login(String id, String pwd) throws SQLException {
		
		String sql = """
	            SELECT id, pwd, role
	            FROM member
	            WHERE id = ? AND pwd = ?
	            """;
	    
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, id);
	        pstmt.setString(2, pwd);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            edto = MemberDTO.builder()
	                    .id(rs.getString("id"))
	                    .pwd(rs.getString("pwd"))
	                    .role(rs.getString("role"))
	                    .build();
	        }
	    } finally {
	        if (rs != null) rs.close();
	        if (pstmt != null) pstmt.close();
	    }

	    return edto;
	}

	
}
