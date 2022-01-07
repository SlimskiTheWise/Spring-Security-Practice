package com.spring.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dao.BoardDAO;
import com.spring.dto.BoardDTO;
import com.spring.dto.FilesDTO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private FileService fileService;
	
	

	public List<BoardDTO> selectAll() {
	
		return boardDAO.selectAll() ;
	}

	public int save(BoardDTO boardDTO, MultipartFile[] file,File realPathFile) throws Exception {
		
		int result = boardDAO.save(boardDTO);
		int result2 = 0;
		
		for(MultipartFile mf: file) {
			if(!mf.isEmpty()) {
			
			String oriName = mf.getOriginalFilename(); //사용자가 업로드 한 파일의 원본 이름..
			String sysName = UUID.randomUUID()+"_"+oriName; //서버쪽에 저장할 일 이름..
			
			//서버에 업로드되어 메모리에 적재된 파일의 내용을 어디에 저장할지 결정하는 부분..
			mf.transferTo(new File(realPathFile+"/"+sysName));//업로드된 파일 폴더에 업로드..
			result2 = fileService.insert(new FilesDTO(0,oriName,sysName,result));//첨부된 파일 정보를 디비에 저장..
			}
		}
		return result2;
	}

	public BoardDTO searchBySeq(int seq) {
		
		return boardDAO.searchBySeq(seq);
	}

	public int deleteDetail(int seq) {
		
		return boardDAO.deleteDetail(seq);
	}

	public int editDetail(BoardDTO dto) {
	
		return boardDAO.editDetail(dto);
	}
	
	

	
}
