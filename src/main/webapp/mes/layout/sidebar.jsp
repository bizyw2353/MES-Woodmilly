<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="sidebar">
    <div class="brand">
        <a href="/main.do" class="logo">MES Solution</a>
        <a href="/logout.do" class="btn-xs">로그아웃</a>
    </div>

    <ul class="sidebar-nav">
        <li class="sidebar-item">
            <label>기초 자료 관리</label>
            <nav>
                <a href="javascript:void(0)" class="sidebar-link">시스템 코드 관리</a>
                <a href="javascript:void(0)" class="sidebar-link">코드 리스트 조회</a>
            </nav>
        </li>
        <li class="sidebar-item">
            <label>거래처 관리</label>
            <nav>
                <a href="/accountList.do"
                   class="sidebar-link <c:if test="${param.active eq 'account-list'}">active</c:if>">거래처 정보 관리</a>
                <a href="javascript:void(0)" class="sidebar-link">거래처 담당 관리</a>
            </nav>
        </li>
        <li class="sidebar-item">
            <label>원자재 관리</label>
            <nav>
                <a href="/materialList.do"
                   class="sidebar-link <c:if test="${param.active eq 'account-list'}">active</c:if>">원자재 정보 관리</a>
                <a href="javascript:void(0)" class="sidebar-link" <c:if test="${param.active eq ''}">active</c:if>>원자재
                    발주 관리</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 입고 관리</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 자가 처리 관리</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 재고 조회</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 입고 일별 현황</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 입고 월별 현황</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 출고 일별 현황</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 출고 월별 현황</a>
                <a href="javascript:void(0)" class="sidebar-link">원자재 자재 입고현황</a>
                <a href="javascript:void(0)" class="sidebar-link">발주원자재 입고현황</a>
            </nav>
        </li>
    </ul>
</div>
