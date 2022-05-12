<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="box box-bg mt-1">
  <div class="flex-content-between">
    <div class="content-header">
      <p class="sub-title">거래처 담당자</p>
    </div>
    <div>
      <button type="button" class="btn btn-primary popup" href='/accountManagerCreate.do'>추가</button>
      <button type="button" id="btnDeleteAccountManager" class="btn btn-danger">삭제</button>
    </div>
  </div>

  <table class="table-list full">
    <colgroup>
      <col width="50px">
      <col width="15%">
      <col width="15%">
      <col width="15%">
      <col width="15%">
      <col width="*">
    </colgroup>
    <thead>
    <tr>
      <th><input type="checkbox" name="checked_all" /></th>
      <th>담당자명</th>
      <th>직급</th>
      <th>번호</th>
      <th>이메일</th>
      <th>비고</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="accountManagerList" items="${accountManagerList}" varStatus="status">
      <tr>
        <td class="txt-center">
          <input type="checkbox" name="idx[]" value="${accountManagerList.id}">
        </td>
        <td>
          ${accountManagerList.name}
        </td>
        <td>${accountManagerList.grade}</td>
        <td>${accountManagerList.tel}</td>
        <td>${accountManagerList.email}</td>
        <td>${accountManagerList.etc}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<script type="text/javascript">
  $(document).ready(function () {
    $('input:checkbox[name="checked_all"]').on('change', function (e) {
      $('input:checkbox[name="idx[]"]').prop('checked', $(this).prop('checked'));
    });
    $('#btnDeleteAccountManager').on('click', function (e) {
      console.log("btnDeleteAccountManager");
    });
    $(".popup").colorbox({
      transition: "elastic",
      speed: 150,
      opacity: 0.6,
      iframe: true,
      width: "600px",
      height: "380px"
    });
  });
</script>