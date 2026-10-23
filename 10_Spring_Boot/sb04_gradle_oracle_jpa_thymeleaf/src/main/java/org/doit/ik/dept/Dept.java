package org.doit.ik.dept;

import java.util.List;

import org.doit.ik.emp.Emp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "tbl_dept")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dept {
	
	@Id
	@SequenceGenerator( name = "seq_deptno", sequenceName = "seq_tbldept_deptno", initialValue = 10, allocationSize = 10)
	@GeneratedValue(generator = "seq_deptno", strategy = GenerationType.SEQUENCE)
	private Integer deptno;
	
	@Column(length = 14, nullable = true)
	private String dname;
	
	@Column(length = 13, nullable = true)
	private String loc;
	
	public Dept(String dname, String loc) {
		this.dname = dname;
		this.loc = loc;
	}
	
	// cascade = CascadeType.ALL: 부모 엔티티에 수행한 영속성 관련 작업을 자식 엔티티에도 모두 적용
	@OneToMany(mappedBy = "dept", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Emp> empList;
}	
