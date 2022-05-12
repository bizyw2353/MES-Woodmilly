<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="../../layout/top.jsp">
    <jsp:param name="title" value="${URLEncoder.encode(accountManager == null ? \"거래처 등록하기\" : \"거래처 수정하기\")}"/>
</jsp:include>

<div class="wrapper">
    <div id="content">
        <jsp:include page="../../layout/content-header.jsp"/>
        <div class="box box-bg">
            <c:set var="action" value="${accountManager == null ? '/accountManagerCreateProc.do' : '/accountManagerEditProc.do'}"/>
            <form name="accountManager-form" method="POST" action="${action}">
                <c:if test="${accountManager != null}">
                    <input type="hidden" name="id" value="${accountManager.id }">
                </c:if>

                <table class="table-input xs">
                    <colgroup>
                        <col width="150px">
                        <col width="*">
                        <col width="150px">
                        <col width="*">
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>담당자명</th>
                        <td colspan="3"><input type="text" name="name" class="form-control xs" value="${accountManager.name}"></td>
                    </tr>
                    <tr>
                        <th>직급</th>
                        <td colspan="3"><input type="text" name="grade" class="form-control xs" value="${accountManager.grade}"></td>
                    </tr>
                    <tr>
                        <th>전화번호</th>
                        <td colspan="3"><input type="text" name="tel" class="form-control xs" value="${accountManager.tel}"></td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td colspan="3"><input type="text" name="email" class="form-control xs" value="${accountManager.email}"></td>
                    </tr>
                    <tr>
                        <th>비고</th>
                        <td colspan="3"><input type="text" name="etc" class="form-control xs" value="${accountManager.etc}"></td>
                    </tr>
                    </tbody>
                </table>

                <div class="mt-1 flex-content-between">
                    <button type="button" id="btnBack" class="btn_back btn btn-default">
                        <i class="fa fa-arrow-left" aria-hidden="true"></i>
                        취소하기
                    </button>
                    <button type="submit" id="btnQuestionSubmit" class="btn btn-primary">
                        <i class="fa fa-pencil" aria-hidden="true"></i>
                        저장하기
                    </button>
                </div>
            </form>
        </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        <c:if test="${account == null}">
        $('input[name="accounts_code"]').val(makeRandomCode('A-', 5));
        </c:if>

        $('form[name="accountManager-form"]').validate({
            rules: {
                name: "required",
            }, messages: {
                name: "담당자명을 입력해 주세요.",
            }, submitHandler: function (form) {
                form.submit();
            }
        });

        $('#btnBack').on('click', function () {
            window.location.href = "/accountList.do";
        });


    });
</script>
<jsp:include page="../../layout/bottom.jsp"/>