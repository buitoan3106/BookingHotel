<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Room"%>
<%@page import="Model.Reservation"%>
<%@page import="java.util.ArrayList"%>
<html>
    <head>
        <link rel="stylesheet" href="./assets/css/style-home.css" type="text/css"/>
        <link rel="stylesheet" href="./assets/css/base.css" type='text/css'/>
        <link rel="stylesheet" href="./assets/font/fontawesome-free-6.3.0-web/css/all.min.css" type="text/css"/>

        <title>Home</title>
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
                <div class="info">
                    <div class="inside">
                        <div class="welcom">
                            <div class="welcom_p">Welcome ${name} <br>Dưới đây là lịch check in phòng của bạn</div>
                            <div class="update">
                                <a href="updateUser?acc=${acc}&mod=1"><button class="btn">Chỉnh sửa thông tin</button></a>
                            </div>
                        </div>
                        <div class="list_reservations">
                            <table>
                                <tr>
                                    <th>Phòng</th>
                                    <th>CheckIn</th>
                                    <th>CheckOut</th>
                                    <th>Tổng số tiền</th>
                                    <c:if test="${acc == 'admin'}">
                                        <th><a href="admin">List All Reservations</a></th>
                                    </c:if>
                                </tr>
                                <c:forEach items="${rdata}" var="item">
                                    <tr>
                                        <td>${item.getRid()}</td>
                                        <td>${item.getCheckIn()}</td>
                                        <td>${item.getCheckOut()}</td>
                                        <td>${item.getTprice()}</td>
                                        <td><a href="home?rid=${item.getRid()}&checkIn=${item.getCheckIn()}&mod=1">Hủy đặt phòng</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="find_room">
                    <div class="tittle">Tìm phòng trống:</div>
                    <div class="form">
                        <form action="home" method="get">
                            Check In:<input type="date" name="checkIn" value="${checkIn}">
                            Check Out:<input type="date" name="checkOut" value="${checkOut}">
                            <select name="type">
                                <option value="1">Phòng đơn</option>
                                <option value="2">Phòng đôi</option>
                                <option value="3">Phòng vip</option>
                                <option value="4">All</option>
                            </select>

                            <button class="btn">Tìm</button>
                        </form>
                    </div>
                </div>
                <div class="logOut">
                    <a href="login.jsp"><i class="fa-solid fa-right-from-bracket"></i>Đăng xuất</a>
                </div>
                <div class="show">
                    <div class="show_single">
                        <p>Phòng đơn - <i>Giá chỉ từ 299k</i></p>
                        <ul class="list">
                            <c:forEach  items="${data}" var="item">
                                <c:if test="${item.getType() == '1'}">
                                    <li>
                                        <div class="item_img"><img src="./assets/img/${item.getDes()}" alt="alt"/></div>
                                        <div class="item__btn">
                                            <a href="booking?uname=${name}&gid=${acc}&des=${item.getDes()}&name=${item.getId()}&type=${item.getType()}&price=${item.getPrice()}&checkIn=${checkIn}&checkOut=${checkOut}" style="text-decoration: none; color: white"><button class="btn" name="login">Đặt phòng</button></a>
                                        </div>
                                    </li>    
                                </c:if>
                            </c:forEach>
                        </ul>
                    </div>

                    <div class="show_double">
                        <p>Phòng đôi - <i>Giá chỉ từ 599k</i></p>
                        <ul class="list">
                            <c:forEach  items="${data}" var="item">
                                <c:if test="${item.getType() == '2'}">
                                    <li>
                                        <div class="item_img"><img src="./assets/img/${item.getDes()}" alt="alt"/></div>
                                        <div class="item__btn">
                                            <a href="booking?uname=${name}&gid=${acc}&des=${item.getDes()}&name=${item.getId()}&type=${item.getType()}&price=${item.getPrice()}&checkIn=${checkIn}&checkOut=${checkOut}" style="text-decoration: none; color: white"><button class="btn" name="login">Đặt phòng</button></a>
                                        </div>
                                    </li>    
                                </c:if>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="show_vip">
                        <p>Phòng Vip - <i>Giá chỉ từ 999k</i></p>
                        <ul class="list">
                            <c:forEach  items="${data}" var="item">
                                <c:if test="${item.getType() == '3'}">
                                    <li>
                                        <div class="item_img"><img src="./assets/img/${item.getDes()}" alt="alt"/></div>
                                        <div class="item__btn">
                                            <a href="booking?uname=${name}&gid=${acc}&des=${item.getDes()}&name=${item.getId()}&type=${item.getType()}&price=${item.getPrice()}&checkIn=${checkIn}&checkOut=${checkOut}" style="text-decoration: none; color: white"><button class="btn" name="login">Đặt phòng</button></a>
                                        </div>
                                    </li>    
                                </c:if>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>

            <footer class="footer">
                <h3>LandBCoporation</h3><br>
                <div class="contact">
                    <i class="fa-sharp fa-solid fa-location-dot"></i>Địa chỉ: Phòng BE-302, Tòa Beta, Đại học FPT Hà Nội <br>
                    <i class="fa-solid fa-phone"></i>Điện thoại: 0123 456 678 <br>
                    <i class="fa-solid fa-envelope"></i>E-mail: toanbdhe161559@fpt.edu.vn <br>
                    Hoặc liên hệ với chúng tôi qua: 
                    <a href="https://www.facebook.com/profile.php?id=100056192735310" target="_blank"><i class="fa-brands fa-facebook"></i></a>
                    <a href="https://www.instagram.com/lyoo_3106/?fbclid=IwAR0UBiuC_EAcs2cWaQsE_Jgm6yYkB_JNpJKpg0CRi4mkdXz69l16U8PlBDM" target="_blank"><i class="fa-brands fa-instagram"></i></a>
                </div>
            </footer>
        </div>
    </body>
</html>
