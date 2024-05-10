package com.callor.hello.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.hello.models.ImagesVO;
import com.callor.hello.service.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService{

	private final ServletContext context;
	private final String folder;
		
	public FileUploadServiceImpl(ServletContext context) {
		super();
		this.context = context;
		folder = "/app/upload";
	}

	@Override
	public String fileUpload(MultipartFile file) throws Exception {
		String originalFileName = file.getOriginalFilename() ;
		if(originalFileName.isEmpty()) {
			return null;
		}
		
		File path = new File(folder);
		if(!path.exists()) {
			path.mkdirs();
		}
		
		String uuid = UUID.randomUUID().toString();
		String upLoadName = String.format("%s-%s", uuid, originalFileName);
		
		
		
		File upLoadFile = new File(folder, upLoadName);
		
		file.transferTo(upLoadFile);
		
		return upLoadName;
			
		
		
		
	}

	@Override
	public List<ImagesVO> fileUpload(MultipartHttpServletRequest files) throws Exception {
		
		List<MultipartFile> result = files.getFiles("image_files");
		List<ImagesVO> resultImages = new ArrayList<>();
		for(MultipartFile  f : result) {
			String resName = this.fileUpload(f);
			resultImages.add(ImagesVO.builder()
						.i_seq(UUID.randomUUID().toString())
						.i_origin_image(f.getOriginalFilename())
						.i_up_image(resName).build());
		}
		
		return resultImages;
	}
	
	

}
