package com.lec.ch19.dao;

import com.lec.ch19.dto.Member;

public interface MemberDao {
	
	public int idConfirm(String mid);
	public int joinMember(Member member);
	public Member getDetailMember(String mid);
	public int modifyMember(Member member);
	
}
