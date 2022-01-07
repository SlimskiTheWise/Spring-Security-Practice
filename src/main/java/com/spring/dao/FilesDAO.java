package com.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.FilesDTO;

@Repository
public class FilesDAO {

	
	@Autowired
	private SqlSessionTemplate mybatis;

	public int insert(FilesDTO fdto) {
		return mybatis.insert("Files.insert",fdto);
		
	}

	public List<FilesDTO> selectBySeq(int seq) {
		
		System.out.println(seq);
		return mybatis.selectList("Files.selectBySeq",seq);
	}
}
