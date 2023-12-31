package com.kh.finalProject.place.model.service;


import java.util.ArrayList;
import java.util.HashMap;

import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.SportInfo;
import com.kh.finalProject.place.model.vo.Field;
import com.kh.finalProject.place.model.vo.Place;
import com.kh.finalProject.place.model.vo.PlaceImg;
import com.kh.finalProject.place.model.vo.PlaceReview;
import com.kh.finalProject.place.model.vo.Reply;
import com.kh.finalProject.place.model.vo.ReplyReply;
import com.kh.finalProject.place.model.vo.Reservation;
import com.kh.finalProject.place.model.vo.ReviewImg;

public interface PlaceService {
	//경기장 등록
	int insertPlace(Place p);
	//경기장 사진 등록
	int insertPlaceImg(PlaceImg pi);
	
	int placeListCount(Place pl);
	ArrayList<Place> selectPlaceList(PageInfo pi, Place pl);
	Place placeDetailview(int fno);
	ArrayList<Place> selectResPlaceList();
	int placeResCount(int fno);
	ArrayList<Place> searchPlace(String selectValue);
	int insertResMatch(Reservation res);
	int changePoint(Member loginUser);
	int checkResMatch(Reservation res);
	ArrayList<PlaceImg> placeImgList(int fno);
	ArrayList<Reservation> selectResList(String userNo);
	int deleteReservation(int resNo);
	int selectMatchPay(int fieldNo);
	ArrayList<Place> selectResDay(int userNo);
	ArrayList<Reservation> dateChoiceResList(Reservation res);
	ArrayList<Reservation> dateAllResList(int resUserNo);
	ArrayList<Reservation> selectReListAll(String userNo);
	// 매니저 게임 다 가져오기
	ArrayList<Field> selectManager(String userName);
	// 게임에 참가했던 애들 조회
	ArrayList<SportInfo> selectMember(int fieldNo, int categoryNum);
	// 경기 결과 업데이트 시켜주기 
	int updateEval(SportInfo spoInfo);
	// 평가 한 후 필드 이미지 삭제 
	int fieldNoDel(int fieldNo);
	// 평가 한 후 필드 삭제
	int fieldDelet(int fieldNo);
	// 평가 한 후 예약자 삭제
	int fieldReqDel(int fieldNo);
	// 게임에 참가했던 애들 조회
	ArrayList<Field> selectReservation(int fieldNo);

	//댓글 리스트
	ArrayList<Reply> selectReplyList(int fno);
	PlaceReview selectReplyField(HashMap<String, Integer> map);
	//리뷰 이미지 조회
	ArrayList<ReviewImg> placeReviewImgList(int rno);
	

	//경기장 리뷰 리스트 셀렉트
	ArrayList<PlaceReview> placeReviewList(PageInfo pi);
	ArrayList<PlaceReview> placeChoiceReviewList(PageInfo pi, String categoryNum);
	//경기장 리뷰 등록 
	int insertPlaceReview(PlaceReview pr);
	//경기장 리뷰 사진 등록
	int insertPlaceReviewImg(ReviewImg ri);
	//리뷰 리스트 총 개수
	int selectReviewListCount();
	//리뷰 게시글 검색
	int selectSearchCount(HashMap<String, String> map);
	ArrayList<PlaceReview> selectSearchList(HashMap<String, String> map, PageInfo pi);
	
	//대댓글 등록
	int addReplyReply(ReplyReply p);
	//대댓글 셀렉트
	ArrayList<ReplyReply> selectReplyReply(int replyNo);

	//댓글 등록
	int addReply(Reply r);
	//댓글 수정
	int upadateReply(Reply r);
	//댓글 삭제
	int deleteReply(Reply r);
	//답글 삭제
	int deleteReplyReply(ReplyReply rr);
	//답글 수정
	int updateReplyReply(ReplyReply rr);
	//댓글 삭제할때 답글 삭제
	int deleteReplyRe(Reply rr);

	
	//리뷰게시글 조회수증가(update)
	int reviewIncreaseCount(int rno);
	
	//자기가 리뷰 쓴 경기장 못 쓰게 막음
	int checkReview(PlaceReview pr);
	
	//리뷰 삭제
	int deleteReview(int rno);
	
	//리뷰 게시글 업데이트
	int updateReview(PlaceReview pr);
	
	//리뷰 사진 업데이트
	int updateReviewImg(ReviewImg ri);
	
	// 평가 끝난 후 매니저 이름 바꾸기
	int fieldManagerUpdate(int fieldNo);
	// 여성플레이어 구하는 메소드
	int countFemalePlayer(int fno);


}
