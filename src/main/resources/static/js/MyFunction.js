function getDate(off){
    let myDate = new Date();
    myDate.setDate(myDate.getDate() + off);
    let y = myDate.getFullYear();
    let M = (myDate.getMonth()+1);
    let d = myDate.getDate();
    let M_str = (M < 10) ? ("0"+M) : (""+M);
    let d_str = (d < 10) ? ("0"+d) : (""+d);
    return  y + "-" + M_str + "-" + d_str;
}

function alert(msg){
    $("body").append("<div id='msg'><span>" + msg + "</span></div>");
    clearMsg();
}
function clearMsg(){
    let t = setTimeout(function(){
        $("#msg").remove();
    },2000)
};

function timeFormat(dateTime){
    let time = dateTime.split(" ")[1];
    let list = time.split(":");
    return list[0] + ":" + list[1];
}

function getFlightCode(flightNumber){
    return flightNumber.slice(0,2);
}


function CheckUname() {
    let uname_str = $('#username').val();
    if(uname_str.trim() === ""){
        $('.errtip-username-text').text("用户名不能为空！");
        $('.errtip-username').show();
    } else {
        $('.errtip-username').hide();
    }
}
function CheckPwd(){
    let pwd_str = $('#password').val();
    if(pwd_str.trim() === ""){
        $('.errtip-password-text').text("密码不能为空！");
        $('.errtip-password').show();
    } else {
        $('.errtip-password').hide();
    }
}

