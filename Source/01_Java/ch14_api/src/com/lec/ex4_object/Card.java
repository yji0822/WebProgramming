package com.lec.ex4_object;
// ��	��	��	��
public class Card {
	private char kind; // ���� ��	��	��	��
	private int num; // 1~13
	
	public Card(char kind, int num) {
		super();
		this.kind = kind;
		this.num = num;
	}

	@Override
	public String toString() {
		return "ī��� " + kind + ", " + num;
	}
	// c1.equals(c2) -> c1�� kind�� c2�� kind, c1�� num�� c2�� num ��
	@Override
	public boolean equals(Object obj) {
		// c1.equals(c2) => c1�� �� ��ü, c2�� obj.
		if(obj != null && obj instanceof Card) {
			// �� ��ü�� kind �� obj.kind ��
			boolean kindChk = (kind == ((Card)obj).kind);
			boolean numChk = (num == ((Card)obj).num);
			return kindChk && numChk;
			// return (kind == ((Card)obj).kind) && (num == ((Card)obj).num);
		}
		return false;
	}
	
	
	
	
}
