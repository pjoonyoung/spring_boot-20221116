package com.joonyoung.test.dao;

import java.util.ArrayList;

import com.joonyoung.test.dto.MemberDto;

public interface IDao {
	public void memberJoin(String mid, String mpw, String mname, String memail);
	public ArrayList<MemberDto> memberList();// 모든 회원 리스트 가져오기(무조건 모두 가져오기)
	public MemberDto searchIdOk(String mid);
}
