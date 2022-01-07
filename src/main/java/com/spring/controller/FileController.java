package com.spring.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.FileService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;



@Controller
@RequestMapping("/file/")
@RequiredArgsConstructor
@AllArgsConstructor
public class FileController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping("download")
	public void download(HttpServletResponse response, String oriName, String sysName) throws IOException {
		String realPath = session.getServletContext().getRealPath("upload");
		
		File target = new File(realPath+"/"+sysName);
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream(target));
				DataOutputStream dos = new DataOutputStream(response.getOutputStream());){
		
		byte[] fileContents = new byte[(int)target.length()];
		dis.readFully(fileContents);
		
		oriName = new String(sysName.getBytes(),"ISO-8859_1");
		
		response.reset();
		response.setHeader("Content-Disposition", "attachment;filename="+oriName);
		
		dos.write(fileContents);
		dos.flush();
		}
		
	}
	

}
