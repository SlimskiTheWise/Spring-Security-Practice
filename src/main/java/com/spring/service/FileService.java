package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.FilesDAO;
import com.spring.dto.FilesDTO;

@Service
public class FileService {
	
	@Autowired
	private FilesDAO filesDAO;

	public int insert(FilesDTO filesDTO) {
		return filesDAO.insert(filesDTO);
	}

	public List<FilesDTO> selectBySeq(int seq) {
		
		return filesDAO.selectBySeq(seq);
	}

}
