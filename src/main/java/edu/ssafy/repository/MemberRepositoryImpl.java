package edu.ssafy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.ssafy.dto.MemberDto;
import edu.ssafy.util.DBUtil;

public class MemberRepositoryImpl implements MemberRepository {

	@Override
	public int insertMember(Connection conn, MemberDto member) throws Exception {
		String sql = "INSERT INTO memberdb (id, pw, name) VALUES (?, ?, ?)";
		
		int cnt = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {	
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			cnt = pstmt.executeUpdate();
		} 
		return cnt;
	}

	@Override
	public MemberDto selectMember(String id) throws Exception {
		String sql = "SELECT * FROM memberdb WHERE id = ?";
		
		MemberDto member = null;
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new MemberDto();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
			}
		}
		
		return member;
	}

	@Override
	public List<MemberDto> selectAllMember() throws Exception {
		String sql = "SELECT * FROM memberdb";
		
		List<MemberDto> members = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
		
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDto member = new MemberDto();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				members.add(member);
			}
		}
		
		return members;
	}

	@Override
	public int updateMember(Connection conn, MemberDto member) throws Exception {
		String sql = "UPDATE members SET pw = ?, name = ? WHERE id = ?";
		
		int cnt = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getId());
			
			cnt = pstmt.executeUpdate();
		} 
		
		return cnt;
	}

	@Override
	public int deleteMember(Connection conn, String id) throws Exception {
		String sql = "DELETE FROM memberdb WHERE id = ?";
		
		int cnt = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			
			cnt = pstmt.executeUpdate();
		} 
		
		return cnt;
	}
	


}
