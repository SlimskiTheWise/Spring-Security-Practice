package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.spring.dto.MemberDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public Integer idDupleCheck(String id) {
		
		
		Integer result = mybatis.selectOne("Members.idDupleCheck",id);
		
		return result;
	}

	public int joinMember(MemberDTO memberDTO) {
		
		return mybatis.insert("Members.joinMember",memberDTO);
	}

	public int login(String id, String pw) {
		
		Map<String,String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		
		return mybatis.selectOne("Members.login",map);
	}

	public int deleteAccount(String id) {
		
		return mybatis.delete("Members.delete",id);
	}

	public MemberDTO findById(String id) {
		
		return mybatis.selectOne("Members.findById",id);
	}

	public int update(MemberDTO memberDTO) {
		
		return mybatis.update("Members.update",memberDTO);
	}
	
}

