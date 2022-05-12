<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/top.jsp">
    <jsp:param name="title" value="원자재 등록"/>
</jsp:include>
<jsp:include page="../layout/content-header.jsp"/>
<c:if test="${failedMessage}">
    <strong>${failedMessage}</strong>
</c:if>
<c:if test="${successMessage}">
    <strong>${successMessage}</strong>
</c:if>
<div class="box box-bg">

    <form id="materialCreateF" action="/materialCreateProc.do" method="post">
        <table class="table-input">
            <tbody>
            <tr>
                <th>품번</th>
                <td colspan="2"><input type="text" name="number" id="number" placeholder="품번을 입력하세요."
                                       class="form-control xs"/></td>
                <th>품명</th>
                <td colspan="2"><input type="text" name="name" id="name" placeholder="품명을 입력하세요."
                                       class="form-control xs"/></td>
            </tr>
            <tr>
                <th>UT</th>
                <td><input type="text" name="unit" class="form-control xs"/></td>
                <th>SC</th>
                <td><input type="text" name="sc" class="form-control xs"/></td>
                <th>STD</th>
                <td><input type="text" name="std" class="form-control xs"/></td>
            </tr>
            <tr>
                <th>재질</th>
                <td><input type="text" name="texture" class="form-control xs"/></td>
                <th>RM</th>
                <td><input type="text" name="rm" class="form-control xs"/></td>
                <th>SHP</th>
                <td><input type="text" name="shp" class="form-control xs"/></td>
            </tr>
            <tr>
                <th>M'dt</th>
                <td><input type="text" name="mdt" class="form-control xs"/></td>
                <th>M'dw</th>
                <td><input type="text" name="mdw" class="form-control xs"/></td>
                <th>M'l</th>
                <td><input type="text" name="ml" class="form-control xs"/></td>
            </tr>
            <tr>
                <th>Maker</th>
                <td colspan="2">
                    <input type="text" name="maker" class="form-control xs"/>
                </td>
                <th>구입처</th>
                <td colspan="2">
                    <input type="text" id="accountName" name="accountName" class="form-control xs" onclick="accountListPopup()" readonly/>
                    <input type="text" id="accountId" name="accountId" class="form-control xs"/>
                </td>
            </tr>
            <tr>
                <th>창고1</th>
                <td>
                    <select name="storage1" class="form-control xs">
                        <option value="0">-- 선택 --</option>
                        <option value="1">-- 선택 --</option>
                        <option value="2">-- 선택 --</option>
                    </select>
                </td>
                <th>창고2</th>
                <td>
                    <select name="storage2" class="form-control xs">
                        <option value="0">-- 선택 --</option>
                        <option value="1">-- 선택 --</option>
                        <option value="2">-- 선택 --</option>
                    </select>
                </td>
                <th>창고3</th>
                <td>
                    <select name="storage3" class="form-control xs">
                        <option value="0">-- 선택 --</option>
                        <option value="1">-- 선택 --</option>
                        <option value="2">-- 선택 --</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>구입단가</th>
                <td colspan="2"><input type="text" name="purchaseUnitCost" class="form-control xs"></td>
                <th>금액</th>
                <td colspan="2"><input type="text" name="price" class="form-control xs"></td>
            </tr>
            <tr>
                <th>비고</th>
                <td colspan="5"><input type="text" name="etc" class="form-control sm"/></td>
            </tr>
            </tbody>
        </table>
        <div class="mt-1">
            <button type="button" onclick="createCheck()" class="btn btn-default btn-block">등록</button>
            <button type="button" class="btn btn-default btn-block"
                    onclick="location.href='/materialList.do'">이전
            </button>
        </div>
    </form>
</div>
<jsp:include page="../layout/bottom.jsp"/>
<script type="text/javascript">
    function createCheck() {
        const number = document.getElementById("number");
        const name = document.getElementById("name");
        if (!number.value) {
            alert("품번 필수 입력입니다.");
            number.focus();
            return false;
        }
        if (!name.value) {
            alert("품명 필수 입력입니다.")
            name.focus();
            return false;
        }
        document.getElementById('materialCreateF').submit();
    }
</script>
