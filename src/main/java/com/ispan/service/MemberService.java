package com.ispan.service;

import java.util.List;

import com.ispan.model.MemberBean;

public interface MemberService {

	boolean isDup(String id);

	int saveOrUpdate(MemberBean mb);

	List<MemberBean> getAllMembers();

	MemberBean getMember(int user_no);

	int deleteMember(int user_no);

	int updateMember(MemberBean mb);

}