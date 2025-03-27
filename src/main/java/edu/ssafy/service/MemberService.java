package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.MemberDto;

/**
 * CRUD - insert / select / update / delete
 */

public interface MemberService {
	
	public int insertMember(MemberDto member) throws Exception;
	public MemberDto selectMember(String id) throws Exception;
	public List<MemberDto> selectAllMember() throws Exception;
	public int updateMember(MemberDto member) throws Exception;
	public int deleteMember(String id) throws Exception;

}
