package semi.climbing.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static semi.climbing.jdbc.common.JdbcTemplate.close;
import semi.climbing.member.model.dto.MemberDto;
import semi.climbing.member.model.dto.MemberInfoDto;
import semi.climbing.member.model.dto.MemberLoginDto;
import semi.climbing.member.model.dto.MemberPointUpdateDto;
import semi.climbing.member.model.dto.MemberUpdateDto;

//ID        NOT NULL VARCHAR2(20)  
//PWD       NOT NULL VARCHAR2(20)  
//PHOTO     NOT NULL VARCHAR2(200) - img path 
//MEM_ADMIN NOT NULL NUMBER - default 1 : admin / set 0 : member     
//POINT     NOT NULL NUMBER - default 0

public class MemberDao {
	//member info - id, point 
	public MemberInfoDto loginGetInfo(Connection conn, MemberLoginDto dto) {
		MemberInfoDto result = null;
		String sql = " SELECT ID, POINT FROM MEMBER WHERE ID=? AND PWD=? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getMemPwd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new MemberInfoDto(rs.getString("ID"), rs.getInt("POINT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	//login
	public int login(Connection conn, MemberLoginDto dto) {
		int result = 0;
		String sql = " SELECT COUNT(*) c FROM MEMBER WHERE ID=? AND PWD=? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getMemPwd());
			rs = pstmt.executeQuery();
			//ResultSet 처리
			if(rs.next()) {
				result = rs.getInt("c");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	//중복확인
	public int selectCheckId(Connection conn, String memId) {
		int result = 0;
		String sql = " SELECT COUNT(*) c FROM MEMBER WHERE ID=? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			//ResultSet 처리
			if(rs.next()) {
				result = rs.getInt("c");
				System.out.println("rs : "+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	//select All - admin 정보 제외 모든 정보
	public List<MemberDto> selectAllList(Connection conn){
		List<MemberDto> result = null;
		String sql = " SELECT ID, PWD, PHOTO, POINT FROM MEMBER ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new ArrayList<MemberDto>();
				do {
					MemberDto dto = new MemberDto(rs.getString("ID"),rs.getString("PWD"),rs.getString("PHOTO"), rs.getInt("POINT"));
					result.add(dto);
				}while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	//select one
	public MemberDto selectOne(Connection conn, String memId) {
		MemberDto result = null;
		String sql = "SELECT ID, PWD, PHOTO, POINT FROM MEMBER WHERE ID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			//ResultSet 처리
			if(rs.next()) {
				result = new MemberDto(rs.getString("ID"),rs.getString("PWD"),rs.getString("PHOTO"), rs.getInt("POINT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	//insert
	public int insert(Connection conn, MemberDto dto) {
		int result = 0;
		String sql = " INSERT INTO MEMBER (ID, PWD, PHOTO, POINT) VALUES (?, ?, ?, ?) ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			//?처리
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getMemPwd());
			pstmt.setString(3, dto.getMemPhoto());
			pstmt.setInt(4, dto.getMemPoint());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	
	//update pwd, photo
	public int update(Connection conn, MemberUpdateDto dto) {
		int result = 0;
		String sql = " UPDATE MEMBER SET PWD=?, PHOTO=? WHERE ID=? ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			//? 처리
			pstmt.setString(1,  dto.getMemPwdNew());
			pstmt.setString(2,  dto.getMemPhotoNew());
			pstmt.setString(3,  dto.getMemId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	//update point
	public int updatePoint(Connection conn, MemberPointUpdateDto dto) {
		int result = 0;
		String sql = " UPDATE MEMBER SET POINT=? WHERE ID=? ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			//? 처리
			pstmt.setInt(1,  dto.getMemPointNew());
			pstmt.setString(2,  dto.getMemId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	
	//delete
	public int delete(Connection conn, String memId) {
		int result = 0;
		String sql = "DELETE FROM MEMBER WHERE ID=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			//? 처리
			pstmt.setString(1,  memId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	
	
	
	
}
