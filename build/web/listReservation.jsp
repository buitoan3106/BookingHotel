<%-- 
    Document   : listReservation
    Created on : Mar 22, 2023, 10:18:23 PM
    Author     : ASUS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            td {
                text-align: center
            }
            table, th, td{
                border: 1px solid;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <table>
            <tr>
                <th>Reservation Id</th>
                <th>Account Khách Hàng</th>
                <th>Phòng</th>
                <th>CheckIn</th>
                <th>CheckOut</th>
                <th>Tổng số tiền</th>
            </tr>
            <c:forEach items="${data}" var="item">
                <tr>
                    <td>${item.getId()}</td>
                    <td>${item.getGid()}</td>
                    <td>${item.getRid()}</td>
                    <td>${item.getCheckIn()}</td>
                    <td>${item.getCheckOut()}</td>
                    <td>${item.getTprice()}</td>
                    <td><a href="admin?rid=${item.getRid()}&checkIn=${item.getCheckIn()}&mod=1">Hủy đặt phòng</a></td>
                </tr>
            </c:forEach>
        </table>
        <div>
            <a href="home" style="text-decoration: none; color: white"><button class="check__btn btn">Quay lại trang chủ</button></a>
        </div>
    </body>
</html>
