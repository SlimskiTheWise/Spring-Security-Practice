package com.spring.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.spring.dao.BoardDAO;
import com.spring.dao.FilesDAO;
import com.spring.dto.BoardDTO;
import com.spring.dto.FilesDTO;
import com.spring.service.BoardService;
import com.spring.service.FileService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private FileService fService;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("list")
	public String list(Model model) {
		List<BoardDTO> list = boardService.selectAll();
		model.addAttribute("list",list);
		return "board/list";
	}

	@RequestMapping("toWrite")
	public String writeForm() {
		return "board/writeForm";
	}
	
	@RequestMapping("writeProc")
	
	public String writeProc(BoardDTO boardDTO, @RequestParam("file") MultipartFile[] file) throws Exception {
		
		String realPath = session.getServletContext().getRealPath("upload");
		File realPathFile = new File(realPath);
		if(!realPathFile.exists()) {realPathFile.mkdir(); }
		
		int result = boardService.save(boardDTO,file,realPathFile);
		
		return "board/list";
	}
	
	@RequestMapping("detail")
	public String toDetail(int seq,Model model) {
		BoardDTO dto = boardService.searchBySeq(seq);
		List<FilesDTO> list = fService.selectBySeq(seq);
		
		System.out.println(list);
		model.addAttribute("dto",dto);
		model.addAttribute("files",list);
		System.out.println(seq);
		return "/board/boardDetail";
	}
	
	@RequestMapping("deleteDetail")
	public String deleteDetail(int seq) {
		int result = boardService.deleteDetail(seq);
		return "redirect: /board/list";
		
	}
	
	@RequestMapping("toEdit")
	public String editDetail(int seq, Model model) {
		BoardDTO dto = boardService.searchBySeq(seq);
		model.addAttribute("dto",dto);
		System.out.println(seq);
		return "/board/editDetail";
	}
	
	@RequestMapping("editProc")
	public String editProc(BoardDTO dto) {
		int result = boardService.editDetail(dto);
		System.out.println(dto.getSeq()+" : "+dto.getContents());
		return "redirect: /board/detail?seq="+dto.getSeq();
		
	}

	
}
