let contextPath = "";
mypageInit=(path)=>{
    contextPath = path;
}

function imgChangeUpdate(file){
    if(file.files.length == 1){
        const reader = new FileReader();

        reader.readAsDataURL(file.files[0]);

        reader.onload = function(ev){
            document.getElementById('img-upload-my').src = ev.target.result;
        }
    } else {
        document.getElementById('img-upload-my').src = null;
    }
}

//버튼누르면 기본이미지로 변경
function changeImgOrigin(){
    const imageChange = document.getElementById("img-upload-my");
    imageChange.src="./resources/img/team/teamOfferBoardList/profile.jpg";

}

function updatebtn(){
    document.getElementsByName("isDefault").value="true";
}



updateMypage =(categoryNum) =>{
    data = {
        categoryNum : categoryNum
    }
    mypageAjaxController.updateMypageAjax(data,drawUpdateMypage)
}

drawUpdateMypage =(sportInfo) =>{

    console.log(sportInfo);
    const checkStyle =  document.querySelector("#like-position");
    const likePosition1 = document.querySelector(".like-position  .position1")
    const likePosition2 = document.querySelector(".like-position  .position2")

    if(sportInfo.categoryNum === 1){
        checkStyle.innerHTML = ""
        likePosition1.innerHTML = ""
        likePosition2.innerHTML = ""
        const footballStyle = ["attack","balance","defence"]
        const footballStyleKor = ["공격","밸런스","수비"]
        const footballSkill = ["shoot","pass","drible","speed","physical","tikitaka"]
        const footballSkillKor = ["슛","패스","드리블","스피드","피지컬","티키타카"]

        for(let i=0; i<footballStyle.length; i++){
        const str =  "<div class ='cat comedy'> <label>"+
                    "<input type='checkbox' class='checkStyle' value='"+footballStyle[i]+ "' name=style>" +
                    "<span>"+footballStyleKor[i]+"</span>"+
                    "</label> </div>"
        checkStyle.innerHTML += str
        }  
        checkStyle2(sportInfo.style);
        for(let i = 0; i<footballSkill.length; i++){
            const str =  "<div class ='cat comedy'> <label>"+
            "<input type='checkbox' class='checkSkill' value='"+footballSkill[i]+ "' name=skill>"+
            "<span>"+footballSkillKor[i]+"</span>"+
            "</label> </div>"
            if(i<=2){
                likePosition1.innerHTML += str
            }else{
                likePosition2.innerHTML += str
            }

        }
        checkSkill(sportInfo.skill)


    }else if(sportInfo.categoryNum === 2){
        checkStyle.innerHTML = ""
        likePosition1.innerHTML = ""
        likePosition2.innerHTML = ""
        const baseballStyle = ["batter","catcher","pitcher"]
        const baseballStyleKor = ["타자","포수","투수"]
        const footballSkill = ["bollSpeed","power","leftHanded","outfielder","infielder","rightHanded"]
        const footballSkillKor = ["구속", "파워", "좌투", "외야수", "내야수", "우투수"]

        for(let i=0; i<baseballStyle.length; i++){
        const str =  "<div class ='cat comedy'> <label>"+
                    "<input type='checkbox' class='checkStyle' value='"+baseballStyle[i]+ "' name=style>"+
                    "<span>"+baseballStyleKor[i]+"</span>"+
                    "</label> </div>"
        checkStyle.innerHTML += str
        }
        
        checkStyle2(sportInfo.style); 

        for(let i = 0; i<footballSkill.length; i++){
            const str =  "<div class ='cat comedy'> <label>"+
            "<input type='checkbox' class='checkSkill' value='"+footballSkill[i]+ "' name=skill>"+
            "<span>"+footballSkillKor[i]+"</span>"+
            "</label> </div>"
            if(i<=2){
                likePosition1.innerHTML += str
            }else{
                likePosition2.innerHTML += str
            }

        }
        checkSkill(sportInfo.skill)
    }else{
        checkStyle.innerHTML = ""
        likePosition1.innerHTML = ""
        likePosition2.innerHTML = ""
        const footballStyle = ["attack","balance","defence"]
        const footballStyleKor = ["공격","밸런스","수비"]
        const footballSkill = ["shootGuard","pointGuard","smailForward","powerForward","center","allRounder"]
        const footballSkillKor = ["슈팅가드", "포인트가드", "스몰포워드", "파워포워드", "센터", "올라운더"]

        for(let i=0; i<footballStyle.length; i++){
        const str =  "<div class ='cat comedy'> <label>"+
                    "<input type='checkbox' class='checkStyle' value='"+footballStyle[i]+ "' name=style>"+
                    "<span>"+footballStyleKor[i]+"</span>"+
                    "</label> </div>"
        checkStyle.innerHTML += str
        }
        
        checkStyle2(sportInfo.style); 


        for(let i = 0; i<footballSkill.length; i++){
            const str =  "<div class ='cat comedy'> <label>"+
            "<input type='checkbox' class='checkSkill' value='"+footballSkill[i]+ "' name=skill>"+
            "<span>"+footballSkillKor[i]+"</span>"+
            "</label> </div>"
            if(i<=2){
                likePosition1.innerHTML += str
            }else{
                likePosition2.innerHTML += str
            }

        }
        checkSkill(sportInfo.skill)
    }
 
}

checkStyle2 = (style) =>{
    const checkBoxList2 = document.querySelectorAll('.checkStyle');
    const styles = style
    let arr2;
    if(styles !== "null"){
        arr2 = styles.split(',');
   }else{
       arr2 = []
   }
    //console.log(arr2);
    for(let i =0; i<arr2.length; i++){
        for(let j=0; j<checkBoxList2.length; j++){
            if(arr2[i].includes(checkBoxList2[j].value)){
                checkBoxList2[j].checked = true;
                break;
            }
        }
    }
}

checkSkill = (skill) =>{
 
    const checkBoxList = document.querySelectorAll('.checkSkill');
        const skills = skill
        let arr;
        if(skills !== "null"){
             arr = skills.split(',');
        }else{
            arr = []
        }
       
        //console.log(arr)
        for(let i =0; i< arr.length; i++){
            for(let j = 0; j<checkBoxList.length; j++){
                if (arr[i].includes(checkBoxList[j].value)){
                     checkBoxList[j].checked = true;
                     break;
                }
            }
        }
}
selectResListBtn = (userNo) =>{
    data = {
        userNo :userNo
    }
    mypageAjaxController.selectResListAjax(data,drawResList)
}
drawResList = (data) =>{
    let str = "";
    for (let i in data.model.arrayRes){
        const tmp = data.model.arrayRes[i];
        let category;
        switch(tmp.categoryNum){
            case 1: 
                category = ' (축구)';
                break;
            case 2: 
                category = ' (야구)';
                break;
            case 3: 
                category = ' (농구)';
                break;
        }
        str += `<div class="resListModal">`+
                `<div style="text-align: justify;">`+
                    `<span style="font-size: 20px;">`+tmp.fieldName+category+`</span><br>`+
                    `<span style="font-size: 14px;">`+" "+tmp.fieldDate+` / `+tmp.startTime+`</span>`+
                `</div>`+
                `<div>`+
                    `<button class="btn btn-danger" style="margin-top: 10px;"`+
                    `onclick="location.href='`+contextPath+`/deleteRes.pl?resNo=`+tmp.resNo+`&fieldNo=`+tmp.fieldNo+`'">예약취소</button>`+
                `</div></div>`
    }
    document.querySelector('.resListBody').innerHTML = str;
}

