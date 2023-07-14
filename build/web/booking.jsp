<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Room"%>
<html>
    <head>
        <link rel="stylesheet" href="./assets/css/style-booking.css" type="text/css"/>
        <link rel="stylesheet" href="./assets/css/base.css" type='text/css'/>

        <title>Booking</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="home">
            <header class="header">
                <nav class='navbar'>
                    <h1 class='navbar__tittle'>Booking.com</h1>
                    <h1 class='navbar__label'>landbCorporation</h1>
                </nav>
            </header>

            <div class='main'>
                <div class="content">
                    <div class="img"><img src="./assets/img/${des}" alt="alt"/></div>
                    <div class="form_booking">
                        <div class="form">
                            <div class="tittle">
                                <h1>Booking Card</h1>
                            </div>
                            <form action="booking" method="post">
                                <table>
                                    <tr>
                                        <td>Account:</td>
                                        <td><input type="text" name="gid" value="${gid}" readonly style="border:none; outline:none"></td>
                                    </tr>
                                    <tr>
                                        <td>Họ và tên:</td>
                                        <td><input type="text" name="uname" value="${uname}" readonly style="border:none; outline:none"></td>
                                    </tr>
                                    <tr>
                                        <td>Phòng:</td>
                                        <td><input type="text" name="name" value="${name}" readonly style="border:none; outline:none"></td>
                                    </tr>
                                    <tr>
                                        <td>Loại phòng:</td>
                                        <td><input type="text" name="type" value="${type}" readonly style="border:none; outline:none"></td>
                                    </tr>
                                    <tr>
                                        <td>Giá phòng:</td>
                                        <td><input type="text" name="price" value="${price}" readonly style="border:none; outline:none"></td>
                                    </tr>
                                    <tr>
                                        <td>Check-in:</td>
                                        <td><input type="date" name="checkIn" value="${checkIn}"></td>
                                    </tr>
                                    <tr>
                                        <td>Check-out: </td>
                                        <td><input type="date" name="checkOut" value="${checkOut}"></td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><button class="btn" name="book">Đặt phòng ngay</button></td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
