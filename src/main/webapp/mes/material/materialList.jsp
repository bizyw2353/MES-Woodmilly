<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../layout/top.jsp">
    <jsp:param name="title" value="원자재 리스트"/>
</jsp:include>

<jsp:include page="../layout/content-header.jsp"/>
<div class="box box-bg">
    <form method="GET">
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
                <th>RM</th>
                <td colspan="2">
                    <select name="search_rm" class="form-control xs"></select>
                </td>
                <th>SHP</th>
                <td colspan="2">
                    <input type="text" name="search_shp" class="form-control xs">
                </td>
            </tr>
            <tr>
                <th>M'DT</th>
                <td class="flex-content-between">
                    <input type="text" name="mdt_min" class="form-control xs">
                    <span class="ft-3 ml-2 mr-2"> < </span>
                    <input type="text" name="mdt_max" class="form-control xs">
                </td>
                <th>M'dw</th>
                <td class="flex-content-between">
                    <input type="text" name="mdw_min" class="form-control xs">
                    <span class="ft-3 ml-2 mr-2"> < </span>
                    <input type="text" name="mdw_max" class="form-control xs">
                </td>
                <th>M'l</th>
                <td class="flex-content-between">
                    <input type="text" name="ml_min" class="form-control xs">
                    <span class="ft-3 ml-2 mr-2"> < </span>
                    <input type="text" name="ml_max" class="form-control xs">
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
                Total : ${total} 건
            </div>
            <div>
                <button type="button" class="btn btn-primary" onclick="location.href='/materialCreate.do'">
                    <i class="fa fa-pencil" aria-hidden="true"> 등록하기</i>
                </button>
                <button type="button" id="material_delete" class="btn btn-danger" href="/materialDelete.do">
                    <i class="fa fa-trash-o" aria-hidden="true"> 삭제하기</i>
                </button>
                <button type="button" class="btn btn-success">
                    <i class="fa fa-file-excel-o" aria-hidden="true"> Excel 다운로드</i>
                </button>
            </div>
        </div>
    </form>
    <table class="table-list full">
        <colgroup>
            <col width="50px">
            <col width="150px">
            <col width="150px">
            <col width="100px">
            <col width="100px">
            <col width="150px">
            <col width="150px">
            <col width="150px">
            <col width="120px">
            <col width="110px">
        </colgroup>
        <thead>
        <tr>
            <th><input type="checkbox" name="selectAll" onclick="selectAll(this)"></th>
            <th>품번</th>
            <th>품명</th>
            <th>RM</th>
            <th>SHP</th>
            <th>M'DT(두께)</th>
            <th>M'dW(폭)</th>
            <th>M'l(길이)</th>
            <th>구입처</th>
            <th>비고</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="mList" items="${materialList}">
            <tr>
                <td><input type="checkbox" name="idx[]" id="idx[]" value="${mList.id}"
                           onclick="checkSelectAll()"></td>
                <td>
                    <a href="${pageContext.request.contextPath}/materialEdit.do?id=${mList.id}&accountName=${mList.accountName}">${mList.number}</a>
                </td>
                <td>${mList.name}</td>
                <td>${mList.rm}</td>
                <td>${mList.shp}</td>
                <td>${mList.mdt}</td>
                <td>${mList.mdw}</td>
                <td>${mList.ml}</td>
                <td>${mList.accountName}</td>
                <td></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="../layout/bottom.jsp"/>
<script>

    function checkSelectAll() {
        const checkboxes = document.querySelectorAll('input[name="idx[]"]');
        const checked = document.querySelectorAll('input[name="idx[]"]:checked');
        const selectAll = document.querySelector('input[name="selectAll"]');

        if (checkboxes.length === checked.length) {
            selectAll.checked = true;
        } else {
            selectAll.checked = false;
        }
    };

    function selectAll(selectAll) {
        const checkboxes = document.getElementsByName('idx[]');
        checkboxes.forEach((checkbox) => {
            checkbox.checked = selectAll.checked;
        });
    };

    $(document).ready(function () {
        $('#material_delete').on('click', function (e) {
            let checkValueArr = [];
            let $checkbox = $('input:checkbox[name="idx[]"]:checked');

            for (let i = 0; i < $checkbox.length; i++) {
                checkValueArr.push($checkbox[i].value)
            }

            if ($checkbox.length == 0) {
                alert('선택된 항목이 없습니다.');
                return false;
            } else {
                if (confirm($checkbox.length + "개의 정보를 삭제하시겠습니까?")) {
                    $.ajax({
                        url: "/materialDelete.do",
                        type: 'POST',
                        traditional: true,
                        data: {
                            'selectedId': checkValueArr
                        }
                    })
                    window.location.reload();
                } else {
                    window.location.reload();
                }
            }

            $("input:checkbox[name=\"all\"]").on('click', function (e) {
                $('input:checkbox[name="idx[]"]').prop('checked', $(this).is(':checked'));
            });
        });
    });
</script>
