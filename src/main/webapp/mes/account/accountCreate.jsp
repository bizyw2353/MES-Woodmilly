<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="../layout/top.jsp">
    <jsp:param name="title" value="${URLEncoder.encode(account == null ? \"거래처 등록하기\" : \"거래처 수정하기\")}"/>
</jsp:include>

<div class="wrapper">
    <jsp:include page="../layout/sidebar.jsp">
        <jsp:param name="active" value="account-list"/>
    </jsp:include>

    <div class="container">
        <jsp:include page="../layout/header.jsp"/>

        <div id="content">
            <jsp:include page="../layout/content-header.jsp"/>

            <div class="box box-bg">
                <c:set var="action" value="${account == null ? '/accountCreateProc.do' : '/accountEditProc.do'}"/>
                <form name="account-form" method="POST" action="${action}">
                    <c:if test="${account != null}">
                        <input type="hidden" name="id" value="${account.id }">
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
                            <th>거래처코드</th>
                            <td>
                                <c:if test="${account == null}">
                                    <input type="text" name="accounts_code" class="form-control xs" readonly>
                                </c:if>
                                <c:if test="${account != null}">
                                    <input type="hidden" name="accounts_code" value="${account.code}">
                                    ${account.code}
                                </c:if>
                            </td>
                            <th>유형</th>
                            <td></td>
                        </tr>
                        <tr>
                            <th>거래처명</th>
                            <td colspan="3"><input type="text" name="name" class="form-control xs"
                                                   value="${account.name}"></td>
                        </tr>
                        <tr>
                            <th>사업자번호</th>
                            <td><input type="text" name="business_number" class="form-control xs"
                                       value="${account.business.businessNumber}"></td>
                            <th>대표</th>
                            <td><input type="text" name="ceo" class="form-control xs" value="${account.ceo}"></td>
                        </tr>
                        <tr>
                            <th>업종</th>
                            <td><input type="text" name="business_type" class="form-control xs"
                                       value="${account.business.businessType}"></td>
                            <th>업테</th>
                            <td><input type="text" name="business_category" class="form-control xs"
                                       value="${account.business.businessCategory}"></td>
                        </tr>
                        <tr>
                            <th>전화</th>
                            <td><input type="text" name="tel" class="form-control xs" value="${account.tel}"></td>
                            <th>Fax</th>
                            <td><input type="text" name="fax" class="form-control xs" value="${account.fax}"></td>
                        </tr>
                        <tr>
                            <th>이메일</th>
                            <td colspan="3"><input type="text" name="email" class="form-control xs"
                                                   value="${account.email}"></td>
                        </tr>
                        <tr>
                            <th rowspan="3">주소 1</th>
                            <td colspan="3">
                                <input type="text" name="zip_code_1" class="form-control xs w-100"
                                       value="${account.address1.zipCode}" readonly>
                                <button type="button" id="btnAddressSearch1" class="btn btn-xs">
                                    <i class="fa fa-search" aria-hidden="true"></i>
                                    주소찾기
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <input type="text" name="address_1" class="form-control xs"
                                       value="${account.address1.address}" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <input type="text" name="address_detail_1" class="form-control xs"
                                       value="${account.address1.addressDetail}">
                            </td>
                        </tr>
                        <tr>
                            <th rowspan="3">주소 2</th>
                            <td colspan="3">
                                <input type="text" name="zip_code_2" class="form-control xs w-100"
                                       value="${account.address2.zipCode}" readonly>
                                <button type="button" id="btnAddressSearch2" class="btn btn-xs">
                                    <i class="fa fa-search" aria-hidden="true"></i>
                                    주소찾기
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <input type="text" name="address_2" class="form-control xs"
                                       value="${account.address2.address}" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <input type="text" name="address_detail_2" class="form-control xs"
                                       value="${account.address2.addressDetail}">
                            </td>
                        </tr>
                        <tr>
                            <th>비고</th>
                            <td colspan="3"><input type="text" name="etc" class="form-control xs"
                                                   value="${account.etc}"></td>
                        </tr>
                        </tbody>
                    </table>

                    <div class="mt-1 flex-content-between">
                        <button type="button" id="btnBack" class="btn_back btn btn-default">
                            <i class="fa fa-arrow-left" aria-hidden="true"></i>
                            이전페이지
                        </button>
                        <button type="submit" id="btnQuestionSubmit" class="btn btn-primary">
                            <i class="fa fa-pencil" aria-hidden="true"></i>
                            저장하기
                        </button>
                    </div>
                </form>
            </div>

            <c:if test="${account != null}">
                <jsp:include page="accountManagerList.jsp"/>
            </c:if>
        </div>
    </div>
</div>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        <c:if test="${account == null}">
        $('input[name="accounts_code"]').val(makeRandomCode('A-', 5));
        </c:if>

        $('form[name="account-form"]').validate({
            rules: {
                name: "required",
            }, messages: {
                name: "거래처명을 입력해 주세요.",
            }, submitHandler: function (form) {
                form.submit();
            }
        });

        $('#btnAddressSearch1').on('click', function (e) {
            getAddressSearch(['zip_code_1', 'address_1', 'address_detail_1'], 'account-form');
        });

        $('#btnAddressSearch2').on('click', function (e) {
            getAddressSearch(['zip_code_2', 'address_2', 'address_detail_2'], 'account-form');
        });

        $('#btnBack').on('click', function () {
            window.location.href = "/accountList.do";
        });


    });
</script>

<jsp:include page="../layout/bottom.jsp"/>