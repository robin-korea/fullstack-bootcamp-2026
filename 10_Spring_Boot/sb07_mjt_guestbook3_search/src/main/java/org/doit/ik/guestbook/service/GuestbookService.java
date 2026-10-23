package org.doit.ik.guestbook.service;

import org.doit.ik.guestbook.dto.GuestbookDTO;
import org.doit.ik.guestbook.dto.PageRequestDTO;
import org.doit.ik.guestbook.dto.PageResultDTO;
import org.doit.ik.guestbook.entity.Guestbook;

public interface GuestbookService {

	// [1] 방명록 목록 
	PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO pageRequestDTO);

	// [2] 방명록 쓰기
	Long register(GuestbookDTO guestbookDTO);
	
	// [3] 방명록 상세보기
	GuestbookDTO read(Long gno);
	
	// [4] 방명록 수정
	void modify(GuestbookDTO guestbookDTO);
	
	// [5] 방명록 삭제
	void remove(Long gno);

	// ModelMapper라이브러리(http://modelmapper.org), MapStruct(https://mapstruct.org) 등 이용
	// DTO -> Entity 변환 메서드
	default Guestbook dtoToEntity(GuestbookDTO dto) {
		Guestbook entity = Guestbook.builder()
				.gno(dto.getGno())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(dto.getWriter())
				.build();		
		return entity;
	}

	// Entity -> DTO 변환 메서드
	default GuestbookDTO entityToDto(Guestbook entity) {
		GuestbookDTO dto = GuestbookDTO.builder()
				.gno(entity.getGno())
				.title(entity.getTitle())
				.content(entity.getContent())
				.writer(entity.getWriter())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();		
		return dto;
	}

}
