const LOGIN_PAGE = 0;
const SIGN_UP_PAGE = 1;
function PageChange(PAGE)
{
    switch (PAGE)
    {
        case LOGIN_PAGE:
            LoginPageChange();
            break;

        case SIGN_UP_PAGE:
            SignUpPageChange();
            break;
    }
}
function LoginPageChange()
{
    $("#loginBox").show();
    $("#signUpBox").hide();

    $("#useremail").val("");
    $("#userPw").val("");
}

function SignUpPageChange()
{
    $("#loginBox").hide();
    $("#signUpBox").show();

    $("#s_useremail").val("");
    $("#s_userPw").val("");
    $("#s_code").val("");
}

async function EmailCheckSend()
{
    var obj = {};
    obj.useremail = $("#s_useremail").val();

    let regex = new RegExp('[a-z0-9]+@[a-z]+\.[a-z]{2,3}');
    if (regex.test(obj.useremail) == false) { alert("유효하지 않은 이메일 형식입니다");  return;} ;

    WrapMaskLayer();

    const response = await PostJSON("../user/emailCheckSend", obj);

    if (response.result == true)
    {
        alert("이메일로 인증코드를 발송하였습니다");
        $("#uuid").val(response.authKey);
    }
    else
    {
        alert("이메일 인증코드 전송 실패");
    }

    UnWrapMaskLayer();
}

