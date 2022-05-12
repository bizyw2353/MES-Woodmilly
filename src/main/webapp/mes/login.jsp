<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="layout/top.jsp">
    <jsp:param name="title" value="${URLEncoder.encode(\"로그인\")}" />
</jsp:include>

<div class="login-wrapper">
    <div class="login-container">
        <div class="login-header">
            <h1>bizplus</h1>
        </div>

        <form id="login-form" method="POST" action="/loginProc.do">
            <div class="login-body">
                <c:if test="${message != null}">
                <div class="alert alert-error">
                    <button type="button" class="close"><i class="fa fa-times" aria-hidden="true"></i></button>
                    ${message}
                </div>
                </c:if>

                <div class="form-group">
                    <label>
                        <i class="fa fa-user-circle-o" aria-hidden="true"></i>
                        아이디 ${requestScope.get("userId")}
                    </label>
                    <input type="text" name="userId" class="form-control" placeholder="아이디를 입력해 주세요." />
                </div>

                <div class="form-group">
                    <label>
                        <i class="fa fa-lock" aria-hidden="true"></i>
                        비밀번호
                    </label>
                    <input type="password" name="password" class="form-control" placeholder="비밀번호를 입력해 주세요.">
                </div>

                <div class="form-group">
                    <input type="submit" class="btn btn-block btn-primary" value="로그인">
                </div>

                <div class="form-group txt-center">
                    <p class="txt-center mb-2">또는</p>
                    <a href="/join.do">회원 가입을 하시겠습니까?</a>
                </div>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $("#login-form").validate({
            rules: {
                user_id: "required",
                password: "required",
            }, messages: {
                user_id: "아이디를 입력해 주세요.",
                password: "비밀번호를 입력해 주세요.",
            }, submitHandler: function(form) {
                form.submit();
            }
        });
    });
</script>

<jsp:include page="layout/bottom.jsp" />