package com.kh.finalProject.team.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.finalProject.common.template.Pagenation;
import com.kh.finalProject.common.vo.PageInfo;
import com.kh.finalProject.team.model.service.TeamService;
import com.kh.finalProject.team.model.vo.Team;
import com.kh.finalProject.team.model.vo.TeamMember;
import com.kh.finalProject.team.model.vo.TeamOffer;

@Controller
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@RequestMapping("offerBoardList.tm")
	public ModelAndView teamOfferBoardList(@RequestParam(value="cpage", defaultValue="1") int currentPage, ModelAndView mv) {
		
		PageInfo pi = Pagenation.getPageInfo(teamService.selectListCount(), currentPage, 10, 5);
		
		mv.addObject("pi", pi)
		  .addObject("list", teamService.selectList(pi))
		  .setViewName("team/teamOfferBoardList");
		
		return mv;
	}
	
	@RequestMapping("offerDetailView.tm")
	public String teamOfferDetailView(int tno, Model model) {
		
		int result = teamService.increaseCount(tno);
		
		if (result > 0) {
			TeamOffer team = teamService.selectOfferDetail(tno);
			model.addAttribute("team", team);
			
			return "team/teamOfferListDetailView";
		} else {
			model.addAttribute("errorMsg", "게시글 조회 실패");
			return "common/errorMsg";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="offerAjax.tm", produces="application/json; charset=UTF-8")
	public String teamOfferAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String activityAtea, int category, ModelAndView mv) {
		
//		int offerCount = teamService.selectOfferListCount(activityAtea);
//		PageInfo pi = Pagenation.getPageInfo(offerCount, currentPage, 10, 5);

		// 게시물 갯수와 페이징 
//		PageInfo pi = Pagenation.getPageInfo(teamService.selectOfferListCount(activityAtea), currentPage, 10, 5);
		
		if(activityAtea.equals("all")) {
			PageInfo pi = Pagenation.getPageInfo(teamService.selectListCount(), currentPage, 10, 5);
			
			// 게시물 리스트 
			ArrayList<TeamOffer> list = teamService.selectCity(activityAtea, category, pi);
			
			mv.addObject("pi", pi)
			  .addObject("list", teamService.selectList(pi));

			return new Gson().toJson(mv);
			
		} else {
			PageInfo pi = Pagenation.getPageInfo(teamService.selectOfferListCount(activityAtea, category), currentPage, 10, 5);
			// 게시물 리스트 
			ArrayList<TeamOffer> list = teamService.selectCity(activityAtea, category, pi);
			
			mv.addObject("pi", pi)						// pi 처리
			  .addObject("list", teamService.selectCity(activityAtea, category, pi));
			
			return new Gson().toJson(mv);
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="choiceSportsAjax.tm", produces="application/json; charset=UTF-8")
	public String teamChoiceSportsAjax(@RequestParam(value="cpage", defaultValue="1") int currentPage, String activityAtea, int category, ModelAndView mv) {
		
		if(activityAtea.equals("all")) {
			int choiceCount = teamService.selectChoiceAllCount(category);

			
			// 게시물 갯수와 페이징 
			PageInfo pi = Pagenation.getPageInfo(teamService.selectChoiceAllCount(category), currentPage, 10, 5);
			// 게시물 리스트 
			ArrayList<TeamOffer> list = teamService.selectChoiceAllList(category, pi);
			mv.addObject("pi", pi)
			  .addObject("list", teamService.selectChoiceAllList(category, pi));
			
			return new Gson().toJson(mv);
		
		} else {
			int choiceCount = teamService.selectChoiceSportsCount(category, activityAtea);
			
			// 게시물 갯수와 페이징 
			PageInfo pi = Pagenation.getPageInfo(teamService.selectChoiceSportsCount(category, activityAtea), currentPage, 10, 5);
			// 게시물 리스트 
			ArrayList<TeamOffer> list = teamService.selectChoiceList(category, activityAtea, pi);
			mv.addObject("pi", pi)
			  .addObject("list", teamService.selectChoiceList(category, activityAtea, pi));
			
			return new Gson().toJson(mv);
		}
	}
	
	@RequestMapping("offerDelete.tm")
	public String teamOfferDelete(int tno, String filePath, HttpSession session, Model model) {

		int result = teamService.deleteOffer(tno);
		
		if (result > 0) { //삭제성공
			
//			if(!filePath.equals("")) {
//				new File(session.getServletContext().getRealPath(filePath)).delete();
//			}
			session.setAttribute("alertMsg", "게시글 삭제 성공");
			return "team/teamOfferBoardList";
		} else {
			model.addAttribute("errorMsg", "게시글 삭제 실패");
			return "common/errorMsg";
		}

	}
	
	@RequestMapping("teamReq.tm")
	public String teamReq(int userNo, String reqContent, int offerNo, Model model, HttpSession session) {
		
		int teamR = teamService.teamReq(userNo, reqContent, offerNo);
		
		if(teamR > 0) {
			session.setAttribute("alertMsg", "팀 신청 성공");
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "신청 실패");
			return "common/errorMsg";
		}
		
	}
	
	
	@RequestMapping("teamProfile.tm")
	public String teamProfileView() {
		return "team/teamProfile";
	}
	@RequestMapping("updateForm.tm")
	public String teamProfileUpdateForm() {
		return "team/teamProfileUpdate";
	}
	@RequestMapping("joinList.tm")
	public String teamJoinListForm() {
		return "team/teamJoinList";
	}
	
	
	//팀프로필에서 버튼 눌렀을 때 보내주는 메소드
	@RequestMapping("insertTeamOfferForm.tm")
	public String teamOfferInsertForm() {
		return "team/teamOfferInsert";
	}
	
	@RequestMapping("selectMyTeam.tm")
	public String selectMyTeam(int teamNo, int tmemberNo) {
		//categoryNum
		Team t = teamService.selectCategoryNum(teamNo);
		//userNo
		TeamMember tm = teamService.selectUserNo(tmemberNo);
		
		//팀 생성먼저
				
		return "team/teamOfferListDetailView";
	}
	
	@RequestMapping("insertTeam.tm")
	public String insertTeam(Team t, MultipartFile upfile, HttpSession session, Model model) {
		int result = teamService.insertTeam(t);
		if(result > 0) {
			session.setAttribute("alertMsg", "팀 생성 완료");
			return "redirect:main";
		} else {
			model.addAttribute("errorMsg", "팀 생성 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("insertTeamOffer.tm")
	public String teamOfferInsert() {
		return "team/teamProfile";
	}
}
