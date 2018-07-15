<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<title>Book Search Test</title>

<!--  <style type="text/css"></style>-->
<link rel="stylesheet" type="text/css" href="../css/tableStyle.css">
<link rel="stylesheet" type="text/css" href="../css/paging.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript"></script>
<script src="../js/vue.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div id="listWrap">
	<form name="frmPopup" method = "post">
		<input type="hidden" name="title" id="title">
		<input type="hidden" name="contents" id="contents">
		<input type="hidden" name="isbn" id="isbn">
		<input type="hidden" name="price" id="price">
		<input type="hidden" name="authors" id="authors">
		<input type="hidden" name="publisher" id="publisher">
		<input type="hidden" name="sale_price" id="sale_price">
		<input type="hidden" name="translators" id="translators">
		<input type="hidden" name="thumbnail" id="thumbnail">
		<input type="hidden" name="sale_yn" id="sale_yn">
		<input type="hidden" name="status" id="status">
		<input type="hidden" name="category" id="category">
		<input type="hidden" name="url" id="url">
		<input type="hidden" name="datetime" id="datetime">
		<input type="hidden" name="status" id="status">
	</form>
	<div>
	<table cellspacing='0'>
		<thead>
			<tr class="trbig">
				<th>검색 조건</th>
				<th>
					<select name="target" v-model="target" id="target" class="selectbox">
								<option value="all">전체</option>
								<option value="title">제목</option>
								<option value="isbn">ISBN</option>
								<option value="keyword">주제어</option>
								<option value="contents">목차</option>
								<option value="overview">책소개</option>
								<option value="publisher">출판사</option>
					</select>
					<input type="text" name="query" v-model="query" id="query" value="" placeholder="검색어 입력">
				</th>
				<th>Category</th>
				<th>
					<input type="text" name="category" v-model="category" id="category" value="" placeholder="Category 번호 입력.">
				</th>
				<th>정렬 순서</th>
				<th>
					<select name="" v-model="sort" id="sort" class="selectbox">
								<option value="accuaracy">정확도순</option>
								<option value="recency">최신순</option>
								<option value="sales">판매량순</option>
					</select>
				</th>
				<th>
					<button type="button" class="btn btn-primary" v-on:click="searchBookList(1)" >Search</button>
				</th>
			</tr>
		</thead>
	</table>
	</div>	
	<table cellspacing='0'> 
		<thead>
			<tr><!-- 8칸 -->
				<th>Isbn</th>
				<th>Category</th>
				<th>도서 제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>도서 판매가</th>
				<th>도서 판매 여부</th>
				<th>출판일</th>
			</tr>
		</thead><!-- Table Header -->
		<tbody v-if="noData">
			<tr>
				<td colspan="8" text-align: center>No search data.</td>
			</tr>
		</tbody>
		<tbody v-if="isData">
			<tr v-for="list in searchList">
				<td><a href="#" v-on:click="toBookDetailPage(list)">{{list.isbn}}</a></td>
				<td>{{list.category}}</td>
				<td> <a href="#" v-on:click="toBookDetailPage(list)">{{list.title}}</a></td>
				<td>{{list.authors}}</td>
				<td>{{list.publisher}}</td>
				<td>{{list.sale_price}} 원</td>  
				<td>{{list.sale_yn}}</td>
				<td>{{list.datetime.substring( 0, 10 )}}</td>
			</tr>
		</tbody>
	</table>
	
	<div v-if="isData" class="paging">
	<template v-if="pageNo <= 1">
		<a v-on:click="searchBookList(1)" class="first off"><i class="sp ico_paging_first">First</i></a>
		<a v-on:click="searchBookList(pageNo - 1)" class="prev off"><i class="sp ico_paging_prev">Prev</i></a>
	</template>
	<template v-else>
		<a href="#" v-on:click="searchBookList(1)"><i class="sp ico_paging_first">First</i></a>
		<a href="#" v-on:click="searchBookList(pageNo - 1)"><i class="sp ico_paging_prev">Prev</i></a>
	</template>
	
	<template v-for="n in pageArray">
		<template v-if="pageNo == n">
			<a href="#" v-on:click="searchBookList(n)" class="on"> {{ n }} </a>
		</template>
		<template v-else>
			<a href="#" v-on:click="searchBookList(n)"> {{ n }} </a>
		</template>
	</template>
	
	<template v-if="pageNo >= totalPageCount">
		<a v-on:click="searchBookList(pageNo + 1)" class="next off"><i class="sp ico_paging_next">Next</i></a>
		<a v-on:click="searchBookList(totalPageCount)" class="last off"><i class="sp ico_paging_last">Last</i></a>
	</template>
	<template v-else>
		<a href="#" v-on:click="searchBookList(pageNo + 1)"><i class="sp ico_paging_next">Next</i></a>
		<a href="#" v-on:click="searchBookList(totalPageCount)" class="last"><i class="sp ico_paging_last">Last</i></a>
	</template>
	</div>
</div>
<script src="../js/searchBookList.js"></script>
</body>
</html>