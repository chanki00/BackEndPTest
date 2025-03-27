package edu.ssafy.repository;

import java.sql.Connection;
import java.util.List;

import edu.ssafy.dto.MemberDto;

public interface MemberRepository {
	public int insertMember(Connection conn, MemberDto member) throws Exception;
	public MemberDto selectMember(String id) throws Exception;
	public List<MemberDto> selectAllMember() throws Exception;
	public int updateMember(Connection conn, MemberDto member) throws Exception;
	public int deleteMember(Connection conn, String id) throws Exception;
}
