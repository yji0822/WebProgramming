package home.ex07_book;

public class BookInfo {
	// String bookNo
	// String bookTitle
	// String writer
	
	private String bookNo; // å��ȣ 890��-101-1��
	private String bookTitle; // å����
	private String writer; // ����
	
	public BookInfo(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	
	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
	}
	
	
}
