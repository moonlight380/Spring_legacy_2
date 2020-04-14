package com.google.spring_2.member;


import com.google.spring_2.member.MemberDAO;

public class MemberService {

	private MemberDAO memberDAO;
	
	

	public MemberService(MemberDAO memberDAO) {
		
		this.memberDAO = new  MemberDAO();
	}
	
	
	public int memberJoin(MemberVO memberDTO) throws Exception {
		int result =memberDAO.memberJoin(memberDTO);
		return result;
				
	}
	public MemberVO memberLogin(MemberVO memberDTO) throws Exception {
		memberDTO =memberDAO.memberLogin(memberDTO);
		return memberDTO;
				
	}
	//딜리트
	
	public int memberDelete(String id) throws Exception{
		int result=memberDAO.memberDelete(id);
		
		return result;
	}
	//업데이트
	public int memberUpdate(MemberVO memberDTO) throws Exception{
		int result=memberDAO.memberUpdate(memberDTO);
		
		return result;
		
	}
	
	
	
	/*
	 * public MemberDTO myPage(int num) throws Exception {
	 * 
	 * int result =memberDAO.memberJoin(memberDTO); return result;
	 * 
	 * }
	 */


}
