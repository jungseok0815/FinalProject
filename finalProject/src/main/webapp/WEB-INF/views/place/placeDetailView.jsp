<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/final/resources/css/place/placeDetailView.css">
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.6.0/kakao.min.js"
integrity="sha384-6MFdIr0zOira1CHQkedUqJVql0YtcZA1P0nbPrQYJXVJZUkTk/oX4U9GhUIs3/z8" crossorigin="anonymous"></script>
<script>
  Kakao.init('955fd1b6a15de821bfc4496937d1d8d2'); // 사용하려는 앱의 JavaScript 키 입력
</script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=955fd1b6a15de821bfc4496937d1d8d2&libraries=services"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="resources/js/place/placeDetailView.js"></script>
<script src="resources/js/place/placeAjax/placeAjax.js"></script>
</head>
<body onload="init(`${fieldDate}`,`${pl.fieldArea}`,`${pl.startTime}`)">
	<jsp:include page="../common/header.jsp" />
	<div class="outer">
        <div class="slider">
            <c:forEach var="item" items="${plImgList}">
              <div class="slide">
                <img src="${item.fieldChangeName}">
              </div>
            </c:forEach>
        </div>
        <div id="fieldMap"></div>
        <section>
            <div class="section_body">
                <div class="section_div body_left">
                    <div class="section_header">
                        <h3>매치 포인트</h3>
                    </div>
                    <div>
                        <ul>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_level.svg" class="icon">
                                <div>
                                    <p>${pl.matchLevel}</p>
                                </div>
                            </li>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_gender.svg" class="icon">
                                <div>
                                  <c:choose> 
                                    <c:when test="${pl.matchGender eq 1}">
                                      <p>남자만</p>
                                    </c:when> 
                                    <c:when test="${pl.matchGender eq 2}">
                                      <p>여자만</p>
                                    </c:when> 
                                    <c:otherwise>
                                      <p>남녀모두</p>
                                    </c:otherwise> 
                                  </c:choose> 
                                </div>
                            </li>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_stadium.svg" class="icon">
                                <div>
                                    <p>${pl.matchType}</p>
                                </div>
                            </li>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_max_player_cnt.svg" class="icon">
                                <div>
                                    <p>${pl.fieldCount}명</p>
                                </div>
                            </li>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_shoes.svg" class="icon">
                                <div>
                                    <p>${pl.shoes}</p>
                                </div>
                            </li>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_park.svg" alt="유료주차" class="icon">
                                <div>
                                  <c:choose> 
                                    <c:when test="${pl.parking eq 1}">
                                      <p>무료 주차</p>
                                    </c:when> 
                                    <c:when test="${pl.parking eq 2}">
                                      <p>유료 주차</p>
                                    </c:when> 
                                    <c:otherwise>
                                      <p>주차장 없음</p>
                                    </c:otherwise> 
                                  </c:choose> 
                                </div>
                            </li>
                        </ul>
                    </div>
                    <hr>
                    <div>
                        <ul>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_info_fire.svg" class="icon">
                                <p>아직 여자플레이어가 ${gender}명이에요</p>
                            </li>
                            <br>
                            <li>
                                <img src="https://d31wz4d3hgve8q.cloudfront.net/static/img/ic_manager.svg" class="icon">
                                <p>${pl.manager} 매니저가 진행해요</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="body_right section_div">
                    <p>${pl.fieldDate} ${pl.startTime}</p>
                    <h1 onclick="location.href='${pageContext.request.contextPath}/placeInfo.pl'" style="cursor: pointer;">${pl.fieldName}</h1>
                    <p id="copy_text">${pl.fieldArea}</p><h6><a onclick="copyText()">주소복사</a><a onclick="drawMapBtn(`${pl.fieldArea}`)">지도보기</a>
                        <a id="kakaotalk-sharing-btn" href="javascript:;">
                          <img src="${pageContext.request.contextPath}/resources/img/place/share.svg"
                            alt="카카오톡 공유 보내기 버튼" style="width: 20px;" />
                      </h6>
                    </a>
                    <hr>
                    <h1 class="body_right_pay">${matchPay}</h1><h6 class="body_right_pay">/2시간</h6>
                    <hr>
                    <div class="body_right_btn_div">
                      <c:choose> 
                        <c:when test="${pl.fieldCount-resCount le 0}">
                          <p>현재 이 경기는 마감되었습니다.</p>
                          <button class="btn btn-secondary" id="soldoutBtn">신청마감</button>
                        </c:when> 
                        <c:when test="${pl.fieldCount-resCount le 5}">
                          <p>마감까지 ${pl.fieldCount-resCount}자리남았어요.</p>
                          <button class="btn btn-primary" data-bs-target="#matchUpModal" data-bs-toggle="modal" 
                          onclick="resMatchBtn('${loginUser.userNo}','${pl.categoryNum}','${pageContext.request.contextPath}')">신청하기</button>
                        </c:when> 
                        <c:otherwise>
                          <p>지금 신청하면<br>진행 확정이 빨라져요!</p>
                          <button class="btn btn-primary" data-bs-target="#matchUpModal" data-bs-toggle="modal" 
                          onclick="resMatchBtn('${loginUser.userNo}','${pl.categoryNum}','${pageContext.request.contextPath}')">신청하기</button>
                          </c:otherwise> 
                      </c:choose>
                    </div>
                    <div id="weatherBody">
                      <div class="spinner-border"></div>
                    </div>
                </div>

            </div>
        </section>
    </div>

    <!-- 팀 리스트 모달-->
    <div class="modal fade" id="matchUpModal" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
              <!-- <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button> -->
            <div class="modal-body">
                <div class="accordion" id="accordionExample">
                    <div class="accordion-item">
                      <h2 class="accordion-header">
                        <form action="insertSoloResMatch.pl">
                          <input type="hidden" name="matchPay" value="${pl.matchPay}">
                          <input type="hidden" name="fieldNo" value="${pl.fieldNo}">
                          <button type="submit" class="match-solo-btn">
                              개인 신청
                          </button>
                        </form>
                        <button class="accordion-button match-team-btn collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                            <span>팀별 신청</span>
                        </button>
                      </h2>
                      <div id="collapseOne" class="accordion-collapse collapse collapse" data-bs-parent="#accordionExample">
                        <!--불러온 myTeamList 그려주기-->
                      </div>
                    </div>
                    
                  </div>
            </div>
          </div>
        </div>
      </div>
      <!-- 팀원 리스트 모달-->
      <div class="modal fade" id="exampleModalToggle2" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalToggleLabel2">팀원</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="insertResMatch.pl">
              <input type="hidden" name="matchPay" value="${pl.matchPay}">
              <input type="hidden" name="fieldNo" value="${pl.fieldNo}">
              <div class="modal-body" id="myteam-member-list">
                <!--불러온 teamMemberList-->
              </div>
              <div class="modal-footer">
                <button class="btn btn-primary" type="submit">신청</button>
              </div>
            </form>
          </div>
        </div>
      </div>
      <i class="bi bi-share"></i>
     
	<jsp:include page="../common/footer.jsp" />
</body>
</html>