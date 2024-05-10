package com.callor.hello.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.hello.models.ImagesVO;

public interface FileUploadService {
	
	public String fileUpload(MultipartFile file) throws Exception;
	
	public List<ImagesVO> fileUpload(MultipartHttpServletRequest files) throws Exception;

}
