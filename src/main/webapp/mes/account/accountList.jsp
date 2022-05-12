<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="../layout/top.jsp">
  <jsp:param name="title" value="${URLEncoder.encode(\"거래처 정보 관리\")}" />
</jsp:include>

<div class="wrapper">
  <jsp:include page="../layout/sidebar.jsp">
    <jsp:param name="active" value="account-list" />
  </jsp:include>

  <div class="container">
    <jsp:include page="../layout/header.jsp" />

    <div id="content">
      <jsp:include page="../layout/content-header.jsp" />

      <div class="box box-bg">
        <jsp:include page="accountFilterForm.jsp" />

        <table class="table-list full">
          <colgroup>
            <col width="50px">
            <col width="180px">
            <col width="200px">
            <col width="100px">
            <col width="150px">
            <col width="150px">
            <col width="*">
          </colgroup>
          <thead>
          <tr>
            <th><input type="checkbox" name="checked_all" /></th>
            <th>거래처코드</th>
            <th>거래처명</th>
            <th>유형</th>
            <th>사업자번호</th>
            <th>대표자</th>
            <th>비고</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="accountList" items="${accountList}" varStatus="status">
            <tr>
              <td class="txt-center">
                <input type="checkbox" name="idx[]" value="${accountList.id}" />
              </td>
              <td><a href="/admin/updateAccount.do?id=${accountList.id}">${accountList.code}</a></td>
              <td>${accountList.name}</td>
              <td></td>
              <td>${accountList.business.businessNumber}</td>
              <td>${accountList.ceo}</td>
              <td>${accountList.etc}</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('input:checkbox[name="checked_all"]').on('change', function (e) {
            $('input:checkbox[name="idx[]"]').prop('checked', $(this).prop('checked'));
        });

        $('input:checkbox[name="idx[]"]').on('change', function (e) {
            var totalCount = $('input:checkbox[name="idx[]"]').length;
            var totalCheckedCount = $('input:checkbox[name="idx[]"]:checked').length;

            $('input:checkbox[name="checked_all"]').prop('checked', (totalCount === totalCheckedCount));
        });

        $('#btnCreateAccount').on('click', function () {
            window.location.href = "/accountCreate.do";
        });

        $('#btnDeleteAccount').on('click', function () {
            console.log('btnDeleteAccount')
        });
    });
</script>

<jsp:include page="../layout/bottom.jsp" />