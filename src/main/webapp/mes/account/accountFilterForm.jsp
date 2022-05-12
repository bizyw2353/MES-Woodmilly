<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="GET" action="/accountList.do">
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

  <div class="flex-content-between mb-1">
    <div class="ft-bold">
      Total : ${accountTotalCount} 건
    </div>
    <div>
      <button type="button" id="btnCreateAccount" class="btn btn-primary">
        <i class="fa fa-pencil" aria-hidden="true"></i>
        등록하기
      </button>
      <button type="button" id="btnDeleteAccount" class="btn btn-danger">
        <i class="fa fa-trash-o" aria-hidden="true"></i>
        삭제하기
      </button>
      <button type="button" class="btn btn-success">
        <i class="fa fa-file-excel-o" aria-hidden="true"></i>
        Excel 다운로드
      </button>
    </div>
  </div>
</form>
