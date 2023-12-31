<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous">
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
    crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/5b03f739e9.js" crossorigin="anonymous"></script>
    <script src="resources/js/common/commonTeam/commonTeamAjax.js?ver=5"></script>
    <script src="resources/js/common/commonTeam/commonTeam.js?ver=5"></script>
    <script src="resources/js/common/header/headerJs/header.js"></script>
    <script src="resources/js/common/header/headerAjax/headerAjax.js"></script>
    <script src="resources/js/member/memberAjax/memberAjax.js"></script>
    <link rel="stylesheet" href="/final/resources/css/common/header.css">
    


</head>
<body>
    <c:if test="${ !empty alertMsg}">
        <script>
           alert('${alertMsg}');
        </script>
        <c:remove var="alertMsg" scope="session" />
    </c:if>
    <div class="header-body">
        <div class="header">
            <div class="header-left">
                <img class="hambuger-img" src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_hamburger.svg" />
                <a href="${pageContext.request.contextPath}" class="header-name">SCORE</a>
            </div>
            <div class="header-right">
                <div  class="search-bar">
                    <input id="search" type="text" onfocus="selectReqResList()" onkeyup="searchMain()" placeholder="검색어 입력">
                    <button><img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png"></button>
                    <div style="display: none;" class="search-data">
                        <div class="member-list">
                            <div align="center" >
                                친구 목록
                            </div>
                            <div class="member-search">
                                
                            </div>
                        </div>
                        <div class="team-list">
                            <div align="center" >
                                팀 목록
                            </div>
                            <div class="team-search">
                            
                            </div>
                        </div>
                        <div class="place-list">
                            <div align="center" >
                                경기장 목록
                            </div>
                            <div class="place-search">
                            
                            </div>
                        </div>
                    </div>
                </div>
                <div class ="search-bar-icon">
                    <c:choose>
                        <c:when test="${empty loginUser}">
                            <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_mymatch.svg" class="header-img" onclick="location.href='${pageContext.request.contextPath}/calendar.pl?userNo=0'">
                            <a href="${pageContext.request.contextPath}/loginView.me"><img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_my.svg" alt="" class="header-img"></a>
                		</c:when>
                	<c:otherwise>
		                <!-- 로그인 후 -->
                        <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_mymatch.svg" class="header-img" onclick="location.href='${pageContext.request.contextPath}/calendar.pl?userNo=${loginUser.userNo}'">
			            <a href="${pageContext.request.contextPath}/myPage.me?userNo=${loginUser.userNo}"><img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_my.svg" alt="" class="header-img"></a>

	                </c:otherwise>
	            </c:choose>    
                <c:choose>
                    <c:when test="${empty loginUser}"> 
                       
                    </c:when>
                    <c:otherwise>
                        <a onclick="showChatting()"><i class="fa-regular fa-message fa-lg"></i></i></a>
                    </c:otherwise>
                </c:choose>
                </div>
                <div class="messageDiv">
                        <div class="chattin-header">
                            <div class="chatting-mnueBar">
                                <div class="muneBar-user" onclick="chattingMemberList()"><i class="fa-regular fa-user fa-2xl"></i></div>
                                <div class="muneBar-user" onclick="chattingTeamList()"><i class="fa-solid fa-t fa-2xl"></i></div>
                                <div class="muneBar-user" onclick="chatiingRoomList()"><i class="fa-regular fa-comment fa-2xl"></i></div>
                            </div>
                            <div class="chatting-infobar">


                               
                            </div>
                            <div class="team-member-list-body">

                            </div>
                        </div>
                </div>
            </div>
        </div>

       
    </div>
   





</body>
</html>