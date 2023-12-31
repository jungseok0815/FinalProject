package com.kh.finalProject.member.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.finalProject.member.model.vo.Friend;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.MemberImg;
import com.kh.finalProject.member.model.vo.MessageAuth;
import com.kh.finalProject.member.model.vo.SportInfo;
import com.kh.finalProject.team.model.vo.Team;

public interface MemberService {
	int joinMember(Member m);
	Member loginMember(String userId);
	Member userInfo(int userNo);
	Member selectJoinmember(String userId);
	int insertSportInfo(SportInfo info);
	int checkId(String checkId);
	SportInfo getUserSportInfo(SportInfo sport);	
	int getCountUserfriends(int userNo);
	//포인트 충전
	int updateUserPoint(Member m);
	ArrayList<Member> getPostFriends(int userNo);
	int addFriend(Friend f);
	ArrayList<Member> selectFriendList(int userNo);
	int deleteFriend(Friend f);
	ArrayList<Team>selectMyTeam(HashMap teamMap);
	int addFriend2(Friend f);
	int deleteFriend2(Friend f);
	ArrayList<Member> searchMember(String searchMain);
	int sendPostFriend(Friend f);
	ArrayList<Friend> selectReqResFriendList(int userNo);
	int checkFriendStatus(Friend f);
	int insertAuth(MessageAuth auth);
	int checkPhoneAuth(MessageAuth auth);
	
	//마이페이지 이미지 수정
	int updateMemImg(MemberImg mi);
	int insertMemImg(MemberImg mi);
	//마이페이지 멤버 수정
	int updateMyPageMember(Member m);
	//마이페이지 스포츠 수정
	int updateMyPageSport(SportInfo sport);
	//마이페이지 이미지 조회
	MemberImg selectMemberImg(int userNo);
	
	//매니저 불러오기
	ArrayList<Member> selectManegerList();

	// 운영진인 사람들만 조회
	ArrayList<Member> levelMember();
	// 카카오페이로 돈 충전하기
	int updatePay(int point, int userNo);

	ArrayList<Member> chattingSelectFriend(HashMap info);
	int checkFriendStatus2(Friend f);
	
	//이미지 셀렉트 -- 기본이미지
	int selectMemImg(int userNo);
	//이미지 삭제 --기본이미지
	int deleteMemImg(MemberImg mi);
	Member authPassFindUserInfo(MessageAuth auth);
	int checkUserIdPhone(Member m1);
	int updatePassword(Member m1);

}

