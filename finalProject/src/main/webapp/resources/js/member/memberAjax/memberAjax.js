const memberAjaxController = {
    getJoinMemeber : (data,callback) =>{
        $.ajax({
            url: "join.me",
            type: "post",
            data,
            success: (result) => {
                result !== "joinfail" ? callback(result) : alert("회원가입 오류발생")  
               
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    getMemberSportInfo : (data,callback)=>{
        console.log(data)
        $.ajax({
            url: "insertSportInfo.me",
            type: "post", 
            data,
            success: (result) => { 
               
                callback();
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    getCheckUserID : (data,callback) =>{
        $.ajax({
            url: 'idCheck.me',
            data,
            success: (result) =>{
                
                callback(result)
            },
            error: ()=>{
                console.log("아이디 중복체크 ajax통신 실패");
            }
        })
    },
    getPostFriend : (callback) =>{
        console.log("hihi")
        $.ajax({
            url: "getPostFriend.me",
            type: "post",
            success: (result) => {
                callback(result)
                
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    getAddFriend : (data) =>{
        $.ajax({
            url: "addFriend.me",
            type: "post",
            data,
            success: (result) => {
                result === "addFriendOk" ? selectPostFriend() : alert("에러 발생 다시 시도");
                
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    selectFriendList : (callback) =>{
        $.ajax({
            url: "selectFriendList.me",
            type: "post",
            success: (result) => {
                callback(result)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    // 친구 삭제
    deleteFriend : (data) =>{
        $.ajax({
            url: "deleteFriend.me",
            type: "post",
            data,
            success: (result) => {
                result === "deleteFriendOk" ? selectFriendList() : alert("에러 발생 다시 시도");
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    //나의 팀 리스트를 보기위한 
    selectMyteamListAjax : (data, callback) =>{
        $.ajax({
            url: "selectMyTeam.me",
            type: "post",
            data,
            success: (result) => {
                console.log(result)
                callback(result);
            },
            error: (err) => {
                console.log(err)
            }
        })

    },

    selectUserSportInfoAjax : (data, callback) =>{
        $.ajax({
            url: "selectUserSportInfo.me",
            type: "post",
            data,
            success: (result) => {
                callback(result);
            },
            error: (err) => {
                console.log(err)
            }
        })

    },
    //핸드폰 문자를 보내기위한 
    sendPhoneAuthAjax: (data,callback) =>{
        $.ajax({
            url: "send-one",
            type: "post",
            data,
            success: (result) => {
                result === "sendOAuthOk" ?  callback(result) : alert("전화번호를 확인해주시요")
               
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    //사용자가 입력한 인증번호 확인(회원가입)
    checkPhoneAuthAjax: (data,callback) =>{
        $.ajax({
            url: "checkPhoneAuthJoin.me",
            type: "post",
            data,
            success: (result) => {
                callback(result)
               
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    //사용자가 입력한 인증번호 확인(아이디 찾기)
    checkPhoneAuthFindAjax: (data,callback) =>{
        $.ajax({
            url: "checkPhoneAuthfind.me",
            type: "post",
            data,
            success: (result) => {
                callback(result)
                
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    
    getResDrawAjax: (data,callback) =>{
        $.ajax({
            url: "dateChoiceRes.pl",
            type: "post",
            data,
            success: (result) => {
                callback(result)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    getAllResDrawAjax:(callback) =>{
        $.ajax({
            url: "dateAllRes.pl",
            type: "post",
            success: (result) => {
                callback(result)
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    checkUserNamePhone:(data,callback) =>{
        $.ajax({
            url: "checkUserNamePhone.me",
            type: "post",
            data,
            success: (result) => {
                callback(result) 
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
    //아이디랑 휴대폰번호로 유저가 있는지 검사
    checkUserIdPhone:(data,callback) =>{
        $.ajax({
            url: "checkUserIdPhone.me",
            type: "post",
            data,
            success: (result) => {
                callback(result) 
            },
            error: (err) => {
                console.log(err)
            }
        })
    },
      //아이디랑 휴대폰번호로 유저가 있는지 검사
    updatePasswordAjax:(data,callback) =>{
        $.ajax({
            url: "updatePassword.me",
            type: "post",
            data,
            success: (result) => {
                callback(result) 
            },
            error: (err) => {
                console.log(err)
            }
        })
    }





   
}

