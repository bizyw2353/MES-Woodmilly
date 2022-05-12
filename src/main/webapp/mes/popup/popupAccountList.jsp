<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../layout/top.jsp">
    <jsp:param name="title" value="거래처 정보 관리"/>
</jsp:include>
<div class="popupList">
    <form method="GET" action="/admin/accountList.do">
        <table class="table-input">
            <colgroup>
                <col width="10%">
                <col width="22%">
                <col width="10%">
                <col width="22%">
                <col width="10%">
                <col width="*">
            </colgroup>
            <tbody>
            <tr>
                <th>거래처코드</th>
                <td><input type="text" name="account_code" class="form-control xs" value="${param.account_code}"></td>
                <th>거래처명</th>
                <td><input type="text" name="account_name" class="form-control xs" value="${param.account_name}"></td>
                <th>유형</th>
                <td>
                    <select name="account_kind" class="form-control xs">
                        <option value="" ${param.account_kind eq '' ? 'selected' : ''}>전체</option>
                        <option value="a" ${param.account_kind eq 'a' ? 'selected' : ''}>매출처</option>
                        <option value="b" ${param.account_kind eq 'b' ? 'selected' : ''}>매입처</option>
                        <option value="c" ${param.account_kind eq 'c' ? 'selected' : ''}>기타</option>
                    </select>
                </td>
            </tr>
            </tbody>
        </table>

        <div class="mt-1 mb-1 txt-right">
            <button type="submit" class="btn">
                <i class="fa fa-search" aria-hidden="true"></i>
                검색하기
            </button>
        </div>
    </form>
    <div class="content">
        <div class="content-header">
            <div class="box box-bg">
            <p class="title">거래처 정보 관리</p>
                <table class="table-list full">
                    <colgroup>
                        <col width="100px">
                        <col width="100px">
                        <col width="100px">
                        <col width="100px">
                        <col width="100px">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>거래처코드</th>
                        <th>거래처명</th>
                        <th>사업자번호</th>
                        <th>대표자</th>
                        <th>비고</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="accountList" items="${accountList}" varStatus="status">
                        <tr>
                            <td class="txt-center">${accountList.code}</td>
                            <td class="txt-center">
                                <a onclick="accountSelect(this)" id="a_name" data-value="${accountList.id}">${accountList.name}</a>
                            </td>
                            <td class="txt-center">${accountList.business.businessNumber}</td>
                            <td class="txt-center">${accountList.ceo}</td>
                            <td class="txt-center">${accountList.etc}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../../mes/layout/bottom.jsp" />
<script>
    function accountSelect(a_info) {
        const id = a_info.getAttribute('data-value');
        const name = $(a_info).text();

        //window.close();
        window.opener.document.getElementById('accountId').value = id;
        window.opener.document.getElementById('accountName').value = name;
        window.console.log(id);
    }
</script>