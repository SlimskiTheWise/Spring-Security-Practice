package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Integer idDupleCheck(String id) {
		
		
		Integer result =memberDAO.idDupleCheck(id);
		
		return result;
	}

	public int joinMember(MemberDTO memberDTO) {
		
		String rawPassword = memberDTO.getPw();
	     String encPassword = bCryptPasswordEncoder.encode(rawPassword);
	      memberDTO.setPw(encPassword);
	
		return memberDAO.joinMember(memberDTO);
	}

	public int login(String id, String pw) {
		
		return memberDAO.login(id, pw);
	}

	public int deleteAccount(String id) {
		
		return memberDAO.deleteAccount(id);
	}

	public MemberDTO findById(String id) {
		
		return memberDAO.findById(id);
	}

	public int update(MemberDTO memberDTO) {
		
		return memberDAO.update(memberDTO);
	}
	
	
	
	
	
	
	

}
