<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="layout/top.jsp">
    <jsp:param name="title" value="${URLEncoder.encode(\"메인\")}"/>
</jsp:include>

<div class="wrapper">
    <jsp:include page="layout/sidebar.jsp"/>

    <div class="container">

        <div id="content">
            <div class="content-header">
                <p class="title">메인</p>

                <ol class="breadcrumb">
                    <li><i class="fa fa-home" aria-hidden="true"></i></li>
                    <li>메인</li>
                </ol>
            </div>
        </div>
    </div>
</div>

<jsp:include page="layout/bottom.jsp"/>