package com.ispan.dao;

import java.util.List;

import com.ispan.model.MemberBean;

public interface MemberDao<T>{
		
		public boolean isDup(String email);

		int saveOrUpdate(MemberBean mb);

		List<MemberBean> getAllMembers();

		MemberBean getMember(int user_no);

		int deleteMember(int user_no);

		int updateMember(MemberBean mb);
		
	
}
