package com.lec.ch19.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dao.BookDao;
import com.lec.ch19.dto.Book;
import com.lec.ch19.util.Paging;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	String backupPath = "D:/webPro/source/09_Spring/ch19_memberBookUp/src/main/webapp/bookImgFileUpload/"; 
	// 백업하는 패스를 지정 / 맨 뒤에 슬래쉬 추가
	
	@Override
	public List<Book> mainList() {
		return bookDao.mainList();
	}

	@Override
	public List<Book> bookList(String pageNum) {
		
		Paging paging = new Paging (bookDao.totCntBook(), pageNum, 3, 3);
		Book book = new Book();
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		
		return bookDao.bookList(book);
	}

	@Override
	public int totCntBook() {
		return bookDao.totCntBook();
	}

	@Override
	public Book getDetailBook(int bnum) {
		return bookDao.getDetailBook(bnum);
	}

	@Override
	public int registerBook(MultipartHttpServletRequest mRequest, Book book) {
		// 사진 파일 이름 받아서 서버에 저장하고 그 서버에 저장된 파일 복사 붙여넣기 하는 로직.
		// 공통된 부분은 어케함? - 경로만 따로 맨 위에 적어주기
		
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // 파라미터 이름 받기 - tempBimg1, tempBimg2
		String[] bimg = new String[2];
		int idx = 0;
		
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체 이름 
			// 파일 이름 받아오기
			bimg[idx] = mFile.getOriginalFilename(); 
			// 파일 첨부를 안했으면 긴 로직이 필요 없음. 조건문으로 걸러낼 수 있도록
			if(bimg[idx] != null && !bimg[idx].equals("")) {
				// 첨부함
				if(new File(uploadPath + bimg[idx]).exists()) {
					// 첨부 파일 이름과 동일한 파일명이 서버에 이미 존재하는 경우
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
				} // if
				
				try {
					
					mFile.transferTo(new File(uploadPath + bimg[idx])); // 서버에 저장
					System.out.println("서버파일:" + uploadPath + bimg[idx]);
					System.out.println("백업파일: " + backupPath + bimg[idx]);
					// 파일 복사 진행
					boolean result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx +"번째 백업 성공" : idx+"번째 백업 실패");
			
				} catch (Exception e) {
					System.out.println(e.getMessage() + "파일 첨부 실패");
				}
			} else {
				// 파일 첨부 안하면 bimg[idx] = ""
				// bimg[idx]
			} // if-else문 
			
			idx++;
			
		} // while
		
		// 나머지 사항은 book으로 들어온다. bookimg2는 없는 상황
		book.setBimg1(bimg[0]); // 첫번째 첨부한 파일 이름
		book.setBimg2(bimg[1]); // 두번째 첨부한 파일 이름
		
		return bookDao.registerBook(book); // 데이터 베이스 book Save
	}

	@Override
	public int registerBook(MultipartHttpServletRequest mRequest) {
		// book을 mRequest 객체로부터 받아와야 하는 번거로움 보여주는 함수
		
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // 파라미터 이름 받기 - tempBimg1, tempBimg2
		String[] bimg = new String[2];
		int idx = 0;
		
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체 이름 
			// 파일 이름 받아오기
			bimg[idx] = mFile.getOriginalFilename(); 
			// 파일 첨부를 안했으면 긴 로직이 필요 없음. 조건문으로 걸러낼 수 있도록
			if(bimg[idx] != null && !bimg[idx].equals("")) {
				// 첨부함
				if(new File(uploadPath + bimg[idx]).exists()) {
					// 첨부 파일 이름과 동일한 파일명이 서버에 이미 존재하는 경우
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
				} // if
				
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx])); // 서버에 저장
					System.out.println("서버파일:" + uploadPath + bimg[idx]);
					System.out.println("백업파일: " + backupPath + bimg[idx]);
					// 파일 복사 진행
					boolean result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx +"번째 백업 성공" : idx+"번째 백업 실패");
			
				} catch (Exception e) {
					System.out.println(e.getMessage() + "파일 첨부 실패");
				}
			} else {
				// 파일 첨부 안하면 bimg[idx] = ""
				// bimg[idx]
			} // if-else문 
			
			idx++;
			
		} // while- bimg 배열에 파일이름 저장하는 로직
		
		// Book 객체들 불러와서 저장할 것들 가져오기
		Book book = new Book();
		book.setBnum(Integer.parseInt(mRequest.getParameter("bnum")));
		book.setBtitle(mRequest.getParameter("btitle"));
		book.setBwriter(mRequest.getParameter("bwriter"));
		book.setBrdate(Date.valueOf(mRequest.getParameter("brdate")));
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		book.setBinfo(mRequest.getParameter("binfo"));
		
		return bookDao.registerBook(book);
	}

	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book) {
		// TODO Auto-generated method stub
		
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // 파라미터 이름 받기 - tempBimg1, tempBimg2
		String[] bimg = new String[2];
		int idx = 0;
		
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체 이름 
			// 파일 이름 받아오기
			bimg[idx] = mFile.getOriginalFilename(); 
			// 파일 첨부를 안했으면 긴 로직이 필요 없음. 조건문으로 걸러낼 수 있도록
			if(bimg[idx] != null && !bimg[idx].equals("")) {
				// 첨부함
				if(new File(uploadPath + bimg[idx]).exists()) {
					// 첨부 파일 이름과 동일한 파일명이 서버에 이미 존재하는 경우
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
				} // if
				
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx])); // 서버에 저장
					System.out.println("서버파일:" + uploadPath + bimg[idx]);
					System.out.println("백업파일: " + backupPath + bimg[idx]);
					// 파일 복사 진행
					boolean result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx +"번째 백업 성공" : idx+"번째 백업 실패");
			
				} catch (Exception e) {
					System.out.println(e.getMessage() + "파일 첨부 실패");
				}
			} else {
				// 파일 첨부 안하면 bimg[idx] = ""
				// bimg[idx]
			} // if-else문 
			
			idx++;
			
		} // while- bimg 배열에 파일이름 저장하는 로직
		
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		
		return bookDao.modifyBook(book);
	}

	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest) {
		// 
		
		return 0;
	}

	
	// ** filecopy method 추가하기
	private boolean fileCopy(String serverFile, String backupFile) {
		
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
	} // 파일 복사 클래스
	
	
}
