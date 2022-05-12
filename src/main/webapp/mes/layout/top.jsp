<%@ page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MES :: ${ URLDecoder.decode(param.title) }</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/colorbox.css" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.1.min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.colorbox-min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js" ></script>
</head>
<body>