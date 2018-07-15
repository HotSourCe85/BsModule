<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Book Search Test</title>

<!--  <style type="text/css"></style>-->
<link rel="stylesheet" type="text/css" href="../css/tableStyle.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript"></script>
<script src="../js/vue.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div id="bookDetail">	
	<table cellspacing='0'>
		<thead>
			<th colspan="6">책 세부 정보</th>
		</thead>
		<tbody>
			<tr>
				<th>제목</th><td>${title}</td>
				<th>저자</th><td>${authors }</td>
				<th>번역자</th><td>${translators }</td>
			</tr>
			<tr>
				<th>도서소개</th><td colspan="5">${contents }</td>
				<!--  <th>Thumnail</th><td></td>-->
			</tr>
			<tr>
				<th>ISBN</th><td>${isbn }</td>
				<th>출판사</th><td>${publisher }</td>
				<th>Category</th><td>${category }</td>
			</tr>
			<tr>
				<th>도서 정가</th><td>${price } 원</td>
				<th>도서 판매가</th><td>${sale_price } 원</td>
				<th>도서 판매 여부</th><td>${sale_yn }</td>
			</tr>
			<tr>
				<th>책 링크</th><td><a href="${url }" target="_blank">${url } </a></td>
				<th>출판 날짜</th><td>${datetime }</td>
				<th>도서 상태 정보</th><td>${status }</td>
			</tr>
		</tbody>
	</table>
</div>
<button type="submit" class="btn btn-success" style="position: absolute; right: 0;" onclick="javascript:window.close();">닫기</button>
<script src="../js/searchBookList.js"></script>
</body>
</html>