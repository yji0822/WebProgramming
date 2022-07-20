package com.lec.ch13.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Service
public class fileUploadService {
	// 파일 업로드 하는 로직 - 어노테이션 service를 추가하면 new를 따로 해주지 않아도 된다.
	
	public boolean fileUp(MultipartHttpServletRequest mRequest, ModelAndView mav) {
		boolean isUpload = false; // 리턴타입 변수
		// 파일 업로드 - 파일이름이 있는지 없는지 확인 후 저장. 동일 이름이 존재한다면 이름 바꿔서 업로드 되도록
		// 파일 업로드 된 파일명을 받아 서버에 업로드, 프로젝트 폴더에 복사 - 복사하는 로직jsp 로직과 동일하다
		
		// 저장될 패스 (업로드 패스)
		String uploadPath = mRequest.getRealPath("upload/"); // 서버에 들어가는 프로젝트 폴더 경로 - 현재 실행되는 경로 (톰캣)
		String backupPath = "D:\\webPro\\source\\09_Spring\\ch13_fileupload\\src\\main\\webapp\\upload\\"; 
		
		// 파일이름이 저장될 이름 - 파일이 총 3개 (파일이 존재하지 않는다면 빈스트링)
		String[] filenames = new String[3]; 
		int i = 0;
		Iterator<String> params = mRequest.getFileNames(); // file1, file2, file3 - 파일 저장을 할때는 iterator
		// 저장도 내가 해야함 enumeration은 알아서 서버에서 저장을 해준다
		// 가져올 이름이 있는지 확인, 가져오기
		while(params.hasNext()) {
			String param = params.next(); // 저장한 파일이 존재한다면 받아오기
			System.out.println(i + "번째 파라미터 이름 : " + param); // 진짜로 순서대로 이름을 불러오는지 확인
			
			MultipartFile mFile = mRequest.getFile(param); // 아직은 저장되지 않은 파일
			filenames[i] = mFile.getOriginalFilename(); // param으로 첨부한 파일의 오리지널 파일 이름
			
			if(filenames[i] != null && !filenames[i].equals("")) { // 첨부한 파일이 있을 경우
				if(new File(uploadPath + filenames[i]).exists()) {
					filenames[i] = System.currentTimeMillis() + filenames[i]; 
					// 매 순간 바뀌는 currentTimeMills 함수를 사용함으로써 파일명이 중복되지 않도록 해준다. 
				} // if 중복된 파일명일 경우 변경하도록 (a.jpg가 있다면 1a...2a... 이런식으로붙일 것 뒤에 붙이려면 lastindexof를 사용해야함)
				
				try {
					mFile.transferTo(new File(uploadPath + filenames[i])); 
					// 파일을 저장하도록 하는 transferTo - 
					System.out.println("서버에 저장된 파일 : " + uploadPath + filenames[i]);
					System.out.println("백업 복사 파일 : " + backupPath + filenames[i]);
					
					isUpload = filecopy(uploadPath + filenames[i], backupPath + filenames[i]); // 파일 복사
					
				} catch (IOException e) {
					System.out.println(e.getMessage() + "파일 저장 및 업로드 실패");
				} 
			} // if - 파일첨부여부
			i++;
		} // while
		
		mav.addObject("filenames", filenames); // 서비스 단에서 파일 저장한 것을 modelAndView로 저장을 해서 jsp 단에 넘겨주도록 한다.
		
		return isUpload;
	}

	private boolean filecopy(String serverFile, String backupFile) {
		
		boolean isCopy = false;
		
		// 복사로직
		InputStream is = null;
		OutputStream os = null;
		
		try {
			File file = new File(serverFile);
			is = new FileInputStream(serverFile); // 서버파일로 빨대를 꼽고
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int) file.length()]; // 1메가가 최대이기때문에 long형 들어올 수 없음
			
			while(true) {
				int nReadByte = is.read(buff);
				if(nReadByte == -1) { // 파일을 읽어들여올게 없다면.
					break;
				}
				os.write(buff, 0, nReadByte);
			}
			isCopy = true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + "파일 복사 실패");
		} finally {
			try {
				if(os!=null) {
					os.close();
				}
				if(is!=null) {
					is.close();
				}
			} catch(IOException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // finally
		
		return isCopy;
	}
}
