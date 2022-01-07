package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public List<BoardDTO> selectAll() {
		return mybatis.selectList("Boards.selectAll");
	}

	public int save(BoardDTO boardDTO) throws Exception{
		int result = mybatis.insert("Boards.insert",boardDTO);
		System.out.println(boardDTO.getSeq());
		return boardDTO.getSeq();
	}

	public BoardDTO searchBySeq(int seq) {
		
		return mybatis.selectOne("Boards.searchBySeq",seq);
	}

	public int deleteDetail(int seq) {
		
		return mybatis.delete("Boards.delete",seq);
	}

	public int editDetail(BoardDTO dto) {
		
		return mybatis.update("Boards.editDetail",dto);
	}

	

}

