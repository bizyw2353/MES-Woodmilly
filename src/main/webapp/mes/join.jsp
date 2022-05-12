<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="layout/top.jsp">
    <jsp:param name="title" value="${URLEncoder.encode(\"로그인\")}"/>
</jsp:include>

<div class="login-wrapper">
    <div class="login-container">
        <div class="login-header">
            <h1>bizplus</h1>
        </div>

        <form id="join-form" method="post" action="/joinProc.do">
            <div class="login-body">
                <div class="form-group">
                    <label class="flex-content-between">
                            <span>
                                <i class="fa fa-user-circle-o" aria-hidden="true"></i>
                                아이디
                            </span>
                        <span id = "confirm">
                                <i aria-hidden="true"></i>
                                아이디 중복확인이 필요합니다.
                            </span>
                        <a href="javascript:void(0);" onclick="CheckUserId()">
                            <i class="fa fa-check-circle-o" aria-hidden="true"></i>
                            중복체크
                        </a>
                    </label>
                    <input type="text" class="form-control" name="userId" placeholder="아이디를 입력해 주세요.">
                </div>

                <div class="form-group">
                    <label>
                        <i class="fa fa-user-o" aria-hidden="true"></i>
                        이름
                    </label>
                    <input type="text" class="form-control" name="name" placeholder="이름을 입력해 주세요.">
                </div>

                <div class="form-group">
                    <label>
                        <i class="fa fa-lock" aria-hidden="true"></i>
                        비밀번호
                    </label>
                    <input type="password"  class="form-control" name="password" placeholder="비밀번호를 입력해 주세요.">
                </div>

                <div class="form-group">
                    <label>
                        <i class="fa fa-lock" aria-hidden="true"></i>
                        비밀번호 확인
                    </label>
                    <input type="password" class="form-control" name="passwordCheck" placeholder="비밀번호를 입력해 주세요.">
                </div>

                <div class="form-group">
                    <input type="submit" class="btn btn-block btn-primary" value="가입하기">
                </div>

                <div class="form-group txt-center">
                    <p class="txt-center mb-2">또는</p>
                    <a href="/login.do">로그인을 하시겠습니까?</a>
                </div>
            </div>
        </form>

    </div>
</div>

<script type="text/javascript">

    $(document).ready(function () {
        $("#join-form").validate({
            rules: {
                userId: "required",
                name: "required",
                password: "required",
                passwordCheck: "required"
            }, messages: {
                userId: "아이디를 입력해 주세요.",
                name: "이름을 입력해 주세요",
                password: "비밀번호를 입력해 주세요.",
                passwordCheck: "비밀번호 확인을 입력해 주세요"
            }, submitHandler: function(form) {
                form.submit();
            }
        });
    });

    function passwordChecking() {
        const userId = document.getElementById('userId').value;
        const name = document.getElementById('name').value;
        const password = document.getElementById('password').value;
        const passwordCheck = document.getElementById('passwordCheck').value;
        if (userId === null || userId == '') {
            alert("아이디는 필수입니다.");
            return false;
        } else if (name === null || name == "") {
            alert("이름은 필수입니다.");
            return false;
        } else if (password === null || password == "") {
            alert("비밀번호는 필수입니다.");
            return false;
        } else if (password !== passwordCheck) {
            alert("비밀번호가 일치하지 않습니다.");
            return false;
        } else {
            return true;
        }
    }

    function CheckUserId() {
        const userId = document.getElementsByName('userId')[0].value;
        if(userId.length < 1){
            alert("아이디를 입력해주세요")
        }
        $.ajax({
            type : "POST",
            url : "/userIdCheck",
            data : {'userId':userId},
            dataType : "text",
            success : function (data){
                console.log(data);
                if(data == 'true'){
                    document.getElementById('confirm').innerText = "사용가능한 아이디 입니다";
                    document.getElementById('confirm').style.color = "green";
                }else {
                    document.getElementById('confirm').innerText = "이미 사용중인 아이디 입니다";
                    document.getElementById('confirm').style.color = "red";
                }
            },error : function (data){
                alert("아이디 체크 오류")
            }
        })
    }
</script>

</body>

</html>