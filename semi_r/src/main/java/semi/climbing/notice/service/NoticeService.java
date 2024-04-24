package semi.climbing.notice.service;


import static semi.climbing.jdbc.common.JdbcTemplate.*;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import semi.climbing.notice.model.dao.NoticeDao;
import semi.climbing.notice.model.dto.FileReadDto;
import semi.climbing.notice.model.dto.NoticeDto;
import semi.climbing.notice.model.dto.NoticeInsertDto;
import semi.climbing.notice.model.dto.NoticeListDto;
import semi.climbing.notice.model.dto.NoticeReadDto;


public class NoticeService {
	private NoticeDao dao = new NoticeDao(); 
	
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
				
		List<NoticeListDto> dtolist = dao.selectPageList(conn, start, end);
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
	
	public List<FileReadDto> selectFileList(Integer noticeNo){
		List<FileReadDto> result = null;
		Connection conn = getSemiConnection(true);
		result = dao.selectFileList(conn, noticeNo);
		close(conn);
		return result;
	}
	
	public List<NoticeListDto> selectAllList() {
		List<NoticeListDto> result = null;
		Connection conn = getSemiConnection(true);
		result = dao.selectAllList(conn);
		close(conn);
		return result;
	}
	// select one
	public NoticeReadDto selectOne(Integer noticeNo) {
		NoticeReadDto result = null;
		Connection conn = getSemiConnection(true);
		result = dao.selectOne(conn, noticeNo);
		List<FileReadDto> filelist = dao.selectFileList(conn, noticeNo);
		System.out.println("filelist : "+filelist);
		result.setFileDtoList(filelist);
		close(conn);
		return result;
	}
	// insert
	public int insert(NoticeInsertDto dto) {
		int result = 0;
		Connection conn = getSemiConnection(true);
		result = dao.insert(conn, dto);
		close(conn);
		return result;
	}

	// update
//	public int update(NoticeDto dto) {
//		int result = 0;
//		Connection conn = getSemiConnection(true);
//		result = dao.update(conn, dto);
//		close(conn);
//		return result;
//	}
	// delete
	public int delete(Integer noticeNo) {
		int result = 0;
		Connection conn = null;
		result = dao.delete(conn, noticeNo);
		close(conn);
		return result;
	}
}
