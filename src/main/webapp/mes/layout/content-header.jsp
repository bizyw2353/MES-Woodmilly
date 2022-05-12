<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wrapper">
    <jsp:include page="../layout/sidebar.jsp"/>
    <div class="container">
        <div id="content">
            <div class="content-header">
                <c:if test="${navigation ne null}">
                    <c:forEach var="title" items="${navigation}" varStatus="status" begin="${fn:length(navigation)-1}">
                        <p class="title">${title}</p>
                    </c:forEach>

                    <ol class="breadcrumb">
                        <li><i class="fa fa-home" aria-hidden="true"></i></li>
                        <c:forEach var="menu" items="${navigation}" varStatus="status">
                            <li>${ menu }</li>
                        </c:forEach>
                    </ol>
                </c:if>
            </div>