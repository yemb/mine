<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>空气质量列表</title>

</head>
<body>

	<title>城市空气质量列表</title>

	<a href='<c:url value="/yonghu/yonghu_info" />'>增加空气质量</a>

	<table border=1>
		<thead>
			<tr>
				<th>序号</th>
				<th>城市</th>
				<th>省份</th>
				<th>日期</th>
				<th>等级</th>
				<th>AQI指数</th>
				<th>AQI排名</th>
				<th>PM2.5</th>
				<th>PM10</th>
				<th>SO2</th>
				<th>NO2</th>
				<th>CO</th>
				<th>O3</th>
				<th>修改操作</th>
				<th>删除操作</th>
			</tr>
		</thead>
		<c:forEach var="aqi" items="${aqiList}">
			<tr>
				<td>${aqi.id}</td>
				<td>${aqi.city}</td>
				<td>${aqi.province}</td>
				<td>${aqi.date}</td>
				<td>${aqi.level}</td>
				<td>${aqi.aqi}</td>
				<td>${aqi.aqirank}</td>
				<td>${aqi.pm25}</td>
				<td>${aqi.pm10}</td>
				<td>${aqi.so2}</td>
				<td>${aqi.no2}</td>
				<td>${aqi.co}</td>
				<td>${aqi.o3}</td>
				<td><a href="<c:url value="/user/user_update" />?id=${aqi.id}">修改</a></td>
				<td><a href="<c:url value="/user/user_delete" />?id=${aqi.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>

</body>

</html>
