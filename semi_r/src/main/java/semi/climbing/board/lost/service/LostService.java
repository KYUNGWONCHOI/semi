package semi.climbing.board.lost.service;

import static semi.climbing.jdbc.common.JdbcTemplate.close;
import static semi.climbing.jdbc.common.JdbcTemplate.getSemiConnection;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import semi.climbing.board.lost.model.dao.LostDao;
import semi.climbing.board.lost.model.dto.LostDto;
import semi.climbing.board.lost.model.dto.LostInsertDto;
import semi.climbing.board.lost.model.dto.LostListDto;
import semi.climbing.board.lost.model.dto.LostModifyDto;


public class LostService {
	private LostDao dao = new LostDao();
	
	public Map<String, Object> selectPageList(int pageSize, int pageBlockSize, int currentPageNum) {
		Map<String, Object> result = null;
	
		Connection conn = getSemiConnection(true);
		System.out.println("currentPageNum: " +currentPageNum);
		int start = pageSize*(currentPageNum-1)+1;
		int end = pageSize*currentPageNum;
		
		int totalCount = dao.selectTotalCount(conn);
		System.out.println("totalCount:"+totalCount);
		
		int totalPageCount = (totalCount % pageSize == 0)? totalCount/pageSize :  totalCount/pageSize+1;
		
//		-- 시작페이지 startPageNum = (현재페이지%페이지수 == 0) ? ((현재페이지/페이지수)-1)*페이지수 + 1  :((현재페이지/페이지수))*페이지수 + 1
//		-- 끝페이지 endPageNum =  (endPageNum > 전체페이지수) ? 전체페이지수 : startPageNum+페이지수 - 1;
		int startPageNum = (currentPageNum%pageBlockSize == 0) ? ((currentPageNum/pageBlockSize)-1)*pageBlockSize + 1  :((currentPageNum/pageBlockSize))*pageBlockSize + 1;
		int endPageNum = (startPageNum+pageBlockSize > totalPageCount) ? totalPageCount : startPageNum+pageBlockSize-1;
				
		List<LostListDto> dtolist = dao.selectPageList(conn, start, end);
		close(conn);
		
		result = new HashMap<String, Object>();
		result.put("dtolist", dtolist);
		result.put("totalPageCount", totalPageCount);
		result.put("startPageNum", startPageNum);
		result.put("endPageNum", endPageNum);
		result.put("currentPageNum", currentPageNum);
		System.out.println("selectPageList() : "+result);
		return result;
	}
	//select all
	public List<LostListDto> selectAllList(){
		List<LostListDto> result = null;
		Connection conn = getSemiConnection(true);
		result = dao.selectAllList(conn);
		close(conn);
		return result;
	}
	
	//select one
	public LostDto selectOne() {
		LostDto result = null;
		Connection conn = getSemiConnection(true);
		result = dao.selectOne(conn);
		close(conn);
		return result;
	}
	
	//insert
	public int insert(LostInsertDto dto) {
		int result = 0;
		return result;
	}
	
	//modify
	public int modify(LostModifyDto dto) {
		int result = 0;
		return result;
	}

	//delete
	public int delete(Integer boardNo) {
		int result = 0;
		return result;
	}
}
