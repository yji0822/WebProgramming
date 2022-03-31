package home.ex07_book;
// Book 작업명세
public interface ILendable {
	
	public byte STATE_BORROWED = 1; // 대출중
	public byte STATE_NORMAL = 0; // 대출가능
	// static final 상수
	
	public void checkOut(String borrower, String checkoutDate); 
	// 대출 시 대출인과 대출날짜 확인
	public void checkIn(); // 반납
	public void printState(); // 도서 정보와 대출상태 출력

}
