package org.doit.ik.club.entity;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ClubMember extends BaseEntity{
	
	@Id
	@Column(name="email", length = 100)
	private String email;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(nullable = false, columnDefinition = "boolean default false")
	@Builder.Default
	private boolean fromSocial = false;
	
	// 1. Set: 중복 허용 X, 권한 여러 개
	// 2. 역할: 1개의 컬럼 추가 X 테이블을 생성해서 roleSet 칼럼 여러개 저장
	@ElementCollection(fetch = FetchType.LAZY)
	@Builder.Default // 필드에 지정한 값을 기본값으로 유지하도록 하는 어노테이션
	private Set<ClubMemberRole> roleSet = new HashSet<>();
	
	public void addMemberRole(ClubMemberRole clubMemberRole) {
		this.roleSet.add(clubMemberRole);
	}
	
}
