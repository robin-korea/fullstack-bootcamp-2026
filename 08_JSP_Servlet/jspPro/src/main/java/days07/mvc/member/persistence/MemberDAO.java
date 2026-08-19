package days07.mvc.member.persistence;

import java.sql.SQLException;
import days07.mvc.member.domain.MemberDTO;



public interface MemberDAO {


	MemberDTO login(String id, String pwd) throws SQLException;


}
