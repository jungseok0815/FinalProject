package com.kh.finalProject.team.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.team.model.dao.TeamDao;
import com.kh.finalProject.team.model.vo.Team;
import com.kh.finalProject.team.model.vo.TeamImg;
import com.kh.finalProject.team.model.vo.TeamMember;
import com.kh.finalProject.team.model.vo.TeamOffer;
import com.kh.finalProject.team.model.vo.TeamReq;

@Service
public class TeamService implements TeamServiceImp{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private TeamDao teamDao;
	
	@Override
	public int selectListCount() {
		return teamDao.selectListCount(sqlSession);
	}

	@Override
	public int insertTeam(Team t) {
		return teamDao.insertTeam(sqlSession, t);
	}
	
	@Override
	public int insertTeamImg(TeamImg ti) {
		return teamDao.insertTeamImg(sqlSession, ti);
	}
	
	@Override
	public int insertTeamMember(Member m) {
		return teamDao.insertTeamMember(sqlSession, m);
	}

	@Override
	public ArrayList<TeamOffer> selectList(PageInfo pi) {
		return teamDao.selectList(sqlSession, pi);
	}

	@Override
	public int increaseCount(int offerNo) {
		return teamDao.increaseCount(sqlSession, offerNo);
	}

	@Override
	public TeamOffer selectOfferDetail(int offerNo) {
		return teamDao.selectOfferDetail(sqlSession, offerNo);
	}

	@Override
	public ArrayList<TeamOffer> selectCity(String activityAtea, int category, PageInfo pi) {
		return teamDao.selectCity(sqlSession, activityAtea, category, pi);
	}

	@Override
	public int selectOfferListCount(String activityAtea, int category) {
		return teamDao.selectOfferListCount(sqlSession, activityAtea, category);
	}

	@Override
	public int deleteOffer(int offerNo) {
		return teamDao.deleteOffer(sqlSession, offerNo);
	}

	@Override
	public int teamReq(int userNo, String reqContent, int offerNo) {
		return teamDao.teamReq(sqlSession, userNo, reqContent, offerNo);
	}

	@Override
	public TeamMember selectInformation(int userNo) {
		return teamDao.selectInformation(sqlSession, userNo);
	}

	@Override
	public int insertOfferList(TeamOffer t, int teamNo) {
		return teamDao.insertOfferList(sqlSession, t, teamNo);
	}

	@Override
	public int insertOfferImg(TeamImg ti, int teamNo) {
		return teamDao.insertOfferImg(sqlSession, ti, teamNo);
	}

	@Override
	public TeamImg selectOfferImg(int tno) {
		return teamDao.selectOfferImg(sqlSession, tno);
	}

	@Override
	public int selectListCountCate(int category) {
		return teamDao.selectListCountCate(sqlSession, category);
	}

	@Override
	public ArrayList<TeamOffer> selectCityAll(int category, PageInfo pi) {
		return teamDao.selectCityAll(sqlSession, category, pi);
	}

	@Override
	public int selectNotCategory(String activityAtea) {
		return teamDao.selectNotCategory(sqlSession, activityAtea);
	}

	@Override
	public ArrayList<TeamOffer> selectOnlyCity(String activityAtea, PageInfo pi) {
		return teamDao.selectOnlyCity(sqlSession, activityAtea, pi);
	}
	
	@Override
	public int teamMemberCount(int tno) {
		return teamDao.teamMemberCount(sqlSession, tno);
	}
	
	@Override
	public int teamAvgAge(int tno) {
		return teamDao.teamAvgAge(sqlSession, tno);
	}

	@Override
	public Team teamProfile(int tno) {
		return teamDao.teamProfile(sqlSession, tno);
	}

	@Override
	public ArrayList<Team> searchTeam(String selectValue) {
		return teamDao.searchTeam(sqlSession, selectValue);
	}


	@Override
	public ArrayList<TeamMember> teamMemberList(int tno) {
		return teamDao.teamMemberList(sqlSession, tno);
	}

	@Override
	public int updateTeam(Team t) {
		return teamDao.updateTeam(sqlSession, t);
	}

	@Override
	public int updateTeamImg(TeamImg ti) {
		return teamDao.updateTeamImg(sqlSession, ti);
	}
	// 팀 번호 조회
	@Override
	public int getTeamNumber(int userNo) {
		return teamDao.getTeamNumber(sqlSession, userNo);
	}

	@Override
	public String selectTeamImg(int teamNo) {
		return teamDao.selectTeamImg(sqlSession, teamNo);
	}
//	@Override
//	public ArrayList<TeamOffer> selectTeamImg(int teamNo, PageInfo pi) {
//		return teamDao.selectTeamImg(sqlSession, teamNo, pi);
//	}
	
	@Override
	public ArrayList<Team> selectMyTeamList(HashMap<String, Integer> map) {
		return teamDao.selectMyTeamList(sqlSession, map);
	}

	@Override
	public int deleteTeam(int tNo) {
		return teamDao.deleteTeam(sqlSession, tNo);
	}

	@Override
	public int deleteTeamMemberAll(int tNo) {
		return teamDao.deleteTeamMemberAll(sqlSession, tNo);
	}

	@Override
	public int deleteTeamImg(int tNo) {
		return teamDao.deleteTeamImg(sqlSession, tNo);
	}

	@Override
	public int changeTeamGradeUp(TeamMember tm) {
		return teamDao.changeTeamGradeUp(sqlSession, tm);
	}

	@Override
	public int changeTeamGradeDown(TeamMember tm) {
		return teamDao.changeTeamGradeDown(sqlSession, tm);
	}

	@Override
	public int deleteTeamMember(TeamMember tm) {
		return teamDao.deleteTeamMember(sqlSession, tm);
	}
	
	@Override
	public TeamImg offerProfileImg(int teamNo) {
		return teamDao.offerProfileImg(sqlSession, teamNo);
	}

	@Override
	public ArrayList<TeamMember> selectLoginUserNo(int userNo) {
		return teamDao.selectLoginUserNo(sqlSession, userNo);
	}

	@Override
	public ArrayList<TeamReq> selectReqList(int tno) {
		return teamDao.selectReqList(sqlSession, tno);
	}

	@Override
	public int teamReqAccept(int reqNo) {
		return teamDao.teamReqAccept(sqlSession, reqNo);
	}

	@Override
	public int teamReqReqRefuse(int reqNo) {
		return teamDao.teamReqReqRefuse(sqlSession, reqNo);
	}

	@Override
	public String selectTeamName(int tno) {
		return teamDao.selectTeamName(sqlSession, tno);
	}

	@Override
	public String selectTeamProImg(int tno) {
		return teamDao.selectTeamProImg(sqlSession, tno);
	}

	@Override
	public int reqList(int reqNo) {
		return teamDao.reqList(sqlSession, reqNo);
	}

	@Override
	public int acceptTeamMember(int reqList, int tno) {
		return teamDao.acceptTeamMember(sqlSession, reqList, tno);
	}

	@Override
	public ArrayList<TeamReq> selectReqUserNo(int tno) {
		return teamDao.selectReqUserNo(sqlSession, tno);
	}

	@Override
	public String selectMemberProImg(int userNo) {
		return teamDao.selectMemberProImg(sqlSession, userNo);
  }
	@Override
	public ArrayList<Team> selectMyteam(int userNo) {
		return teamDao.selectMyteam(sqlSession, userNo);
	}

	@Override
	public ArrayList<Team> chattingSelectTeam(HashMap info) {
		return teamDao.chattingSelectTeam(sqlSession, info);

	}

	@Override
	public int selectReqListCheck(int userNo, int tno) {
		return teamDao.selectReqListCheck(sqlSession, userNo, tno);
	}
	
	@Override
	public int selectReqListCheck22(int userNo, int tno, int teamNo) {
		return teamDao.selectReqListCheck22(sqlSession, userNo, tno, teamNo);
	}
	
	@Override
	public int selectReqListCheck33(int userNo, int tno, int offerNo) {
		return teamDao.selectReqListCheck33(sqlSession, userNo, tno, offerNo);
	}

	@Override
	public int deleteOfferAll(int tNo) {
		return teamDao.deleteOfferAll(sqlSession, tNo);
	}

	@Override
	public ArrayList<TeamOffer> teamOfferListNo(int tNo) {
		return teamDao.teamOfferListNo(sqlSession, tNo);
	}

	@Override
	public int deleteTeamReqAll(int offerNo) {
		return teamDao.deleteTeamReqAll(sqlSession, offerNo);
	}

	@Override
	public int teamReqSolo(int userNo, String reqContent, int offerNo) {
		return teamDao.teamReqSolo(sqlSession, userNo, reqContent, offerNo);
	}

	@Override
	public int deleteOfferImg(int offerNo) {
		return teamDao.deleteOfferImg(sqlSession, offerNo);
	}

	@Override
	public ArrayList<TeamOffer> listCountNo(int tno) {
		return teamDao.listCountNo(sqlSession, tno);
	}

	@Override
	public ArrayList<TeamReq> selectListReqCount(int tno) {
		return teamDao.selectListReqCount(sqlSession, tno);
	}

	



	


}
