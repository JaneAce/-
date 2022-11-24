function denglu() {
    var userCaptcha = $('#userCaptcha').val();
    var result= "3333";
    // var userName ;
    //做一层验证
    if (userCaptcha == '') {
        document.getElementById("showInfo").style.display = "block";
        document.getElementById("showInfo").innerText = "验证码不能为空!";
    } else {
        if(!checkNumber(userCaptcha)){
            document.getElementById("showInfo").style.display = "block";
            document.getElementById("showInfo").innerText = "验证码错误！";
            return ;
        }
        $.ajax({
            type: "post",   //post提交方式默认是get
            dataType: "json",
            url: ""+getRealPath()+"/UserMan/login?userNo="+userNo+"&userPass="+userPass+"",
            async: false,
            success: function (data) {
                if(data.result=="1"){
                    window.open(getRealPath()+"/View/Index/index.html?userName="+data.userName+"&userNo="+userNo+"", '_self');
                    document.cookie="status=success;path=/";//使cookie在整个网站下可用，可以将cookie_dir指定为根目录
                }else {
                    $('#showInfo').css('display','block');
                    document.getElementById("showInfo").innerText = data.message;
                }

            }
        });
    }
}
function change() {
    $('#kaptchaImage').click(function () {
        $(this).attr('src', './UserMan/getCheckNumber?' + Math.floor(Math.random() * 100));
    })
}

function checkNumber(userCaptcha){
    var flag;
    $.ajax({
        type: 'post',
        url: getRealPath()+'/UserMan/checkNumber/'+userCaptcha,
        contenType: 'application/json;charset=utf-8',
        dataType:'json',
        async: false,//false为异步传输，异步传输才能传全局变量
        success:function (data) {
            //这里的code属性是自定义的message类，可以用其他方式代替
            if(data.code == "200"){
                flag = true;
            }else if(data.code == "500"){
                flag = false;
            }
        }
    });
    return flag;
}
