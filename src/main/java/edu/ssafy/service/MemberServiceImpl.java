package edu.ssafy.service;

import java.sql.Connection;
import java.util.List;

import edu.ssafy.dto.MemberDto;
import edu.ssafy.repository.MemberRepository;
import edu.ssafy.repository.MemberRepositoryImpl;
import edu.ssafy.util.DBUtil;

public class MemberServiceImpl implements MemberService {

	MemberRepository repo;
	
	public MemberServiceImpl() {
		repo = new MemberRepositoryImpl();
	}
	
	@Override
	public int insertMember(MemberDto member) throws Exception {
		
		Connection conn = DBUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			int cnt = repo.insertMember(conn, member);
			conn.commit();
			return cnt;
		}catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			throw e;
		}finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public MemberDto selectMember(String id) throws Exception {
		return repo.selectMember(id);
	}

	@Override
	public List<MemberDto> selectAllMember() throws Exception {
		return repo.selectAllMember();
	}

	@Override
	public int updateMember(MemberDto member) throws Exception {
		
		Connection conn = DBUtil.getConnection();
		
		try {
			conn.setAutoCommit(false);
			int cnt = repo.updateMember(conn, member);
			conn.commit();
			return cnt;
		}catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			throw e;
		}finally {
			DBUtil.close(conn);
		}
	}

	@Override
	public int deleteMember(String id) throws Exception {
		
		Connection conn = DBUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			int cnt = repo.deleteMember(conn, id);
			conn.commit();
			return cnt;
		}catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			throw e;
		}finally {
			DBUtil.close(conn);
		}
	}

}
