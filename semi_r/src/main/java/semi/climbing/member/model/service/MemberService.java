package semi.climbing.member.model.service;

import static semi.climbing.jdbc.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import semi.climbing.common.file.FileWriteDto;
import semi.climbing.member.model.dao.MemberDao;
import semi.climbing.member.model.dto.MemberDto;
import semi.climbing.member.model.dto.MemberInfoDto;
import semi.climbing.member.model.dto.MemberJoinDto;
import semi.climbing.member.model.dto.MemberLoginDto;
import semi.climbing.member.model.dto.MemberPointUpdateDto;
import semi.climbing.member.model.dto.MemberUpdateDto;

public class MemberService {

	private MemberDao dao = new MemberDao();

	//member info - id, point 
	public MemberInfoDto loginGetInfo(String memId) {
		MemberInfoDto result = null;
		Connection conn= getSemiConnection(true);
		result = dao.loginGetInfo(conn, memId);
		close(conn);
		return result;
	}
	
	//login
	public int login(MemberLoginDto dto) {
		int result = 0;
		Connection conn= getSemiConnection(true);
		result = dao.login(conn, dto);
		close(conn);
		return result;
	}
		
	//중복확인
	public int selectCheckId(String memId) {
		int result = 0;
		Connection conn= getSemiConnection(true);
		result = dao.selectCheckId(conn, memId);
		close(conn);
		return result;
	}
	
	//select All - admin 정보 제외 모든 정보
//	public List<MemberDto> selectAllList(){
//		List<MemberDto> result = null;
//		Connection conn= getSemiConnection(true);
//		result = dao.selectAllList(conn);
//		close(conn);
//		return result;
//	}
	
	//select one
	public MemberDto selectOne(String memId) {
		MemberDto result = null;
		Connection conn= getSemiConnection(true);
		result = dao.selectOne(conn, memId);
		close(conn);
		return result;
	}
		
	//insert join
	public int insert(MemberJoinDto dto, FileWriteDto fdto) {
		int result = 0;
		Connection conn= getSemiConnection(true);
		result = dao.insert(conn, dto, fdto);
		close(conn);
		return result;
	}
	
	//update pwd, photo
//	public int update(MemberUpdateDto dto) {
//		int result = 0;
//		Connection conn= getSemiConnection(true);
//		result = dao.update(conn, dto);
//		close(conn);
//		return result;	
//	}
		
	//update point
	public int updatePoint(MemberPointUpdateDto dto) {
		int result = 0;
		Connection conn= getSemiConnection(true);
		result = dao.updatePoint(conn, dto);
		close(conn);
		return result;	
	}
		
	//delete
	public int delete(String memId) {
		int result = 0;
		Connection conn= null;
		result = dao.delete(conn, memId);
		close(conn);
		return result;
	}
		
		
		
	
}
