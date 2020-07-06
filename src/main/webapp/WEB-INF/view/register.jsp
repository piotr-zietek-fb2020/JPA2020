<!DOCTYPE html>
<html>
<title>Świat książki</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
    .w3-sidebar a {font-family: "Roboto", sans-serif}
    body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
</style>
<body class="w3-content" style="max-width:1200px">


<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top" style="z-index:3;max-width:250px">
    <div class="w3-container w3-display-container w3-padding-16">
        <a href="${pageContext.request.contextPath}" style="text-decoration:none"><h3 class="w3-wide"><b>ŚWIAT KSIĄŻKI</b></h3></a>
    </div>
    <div class="w3-padding-64 w3-large w3-text-grey" style="font-weight:bold">
        <a href="${pageContext.request.contextPath}" class="w3-bar-item w3-button w3-text-black">Strona główna</a>
        <a href="${pageContext.request.contextPath}/books/list" class="w3-bar-item w3-button">Książki</a>
        <a href="${pageContext.request.contextPath}/kategorie/list" class="w3-bar-item w3-button">Kategorie</a>
        <a href="${pageContext.request.contextPath}/autorzy/list" class="w3-bar-item w3-button">Autorzy</a>
    </div>
    <sec:authorize access="hasAuthority('ROLE_ADMIN')">
        <a href="${pageContext.request.contextPath}/admin/" class="w3-bar-item w3-button w3-padding w3-dark-grey w3-large">Narzędzia</br>administratora</a>
    </sec:authorize>
</nav>




<div class="w3-main" style="margin-left:250px">

    <div>
        <header class="w3-container w3-large" style="padding:7px 0px 7px 0px">
            <div class="w3-right  w3-padding-16">
                <div class="w3-dropdown-hover">
                    <a href="#" class="w3-button w3-black">Moje konto <i class="fa fa-user-circle-o w3-xlarge"></i></a>
                    <sec:authorize access="isAuthenticated()">
                        <div class="w3-dropdown-content w3-bar-block w3-border w3-small w3-text-grey">
                            <a href="${pageContext.request.contextPath}/zamowienia" class="w3-bar-item w3-button">MOJE ZAMÓWIENIA</a>
                            <a href="${pageContext.request.contextPath}/logout " class="w3-bar-item w3-button">WYLOGUJ</a>
                        </div>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <div class="w3-dropdown-content w3-bar-block w3-border w3-small w3-text-grey">
                            <a href="${pageContext.request.contextPath}/register " class="w3-bar-item w3-button">REJESTRACJA</a>
                            <a href="${pageContext.request.contextPath}/login " class="w3-bar-item w3-button">ZALOGUJ</a>
                        </div>
                    </sec:authorize>
                </div>
                <a href="${pageContext.request.contextPath}/koszyk/ " class="w3-button" ><i class="fa fa-shopping-cart w3-xlarge"></i></a>
                <a href="javascript:void(0)" class="w3-button" onclick="document.getElementById('wyszukiwanie').style.display='block'"><i class="fa fa-search w3-xlarge"></i></a>
            </div>
        </header>
    </div>


    <div id="main">
<%--

        <h3>Rejestracja</h3>
        <c:if test="${not empty validator}"><p><c:out value="${validator}"/></p></c:if>
        <form:form method="post" modelAttribute="user">
            <table>
                <tbody>
                <tr>
                    <td><label for="username">Nazwa:</label></td>
                    <td><form:input path="username" id="username" class="form-control"/></td>
                </tr>
                <tr>
                    <td><label for="password">Hasło:</label></td>
                    <td><form:password path="password" id="password" class="form-control"/></td>
                </tr>
                <tr>
                    <td>
                        <button type="submit">Zarejestruj</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </form:form>
--%>




        <div class="w3-padding-64 w3-light-grey" style="padding:100px;">
            <div class="w3-row-padding">
                <c:choose>
                <c:when test="${(param.error != null) && (not empty SPRING_SECURITY_LAST_EXCEPTION)}">
                <div class="w3-col s6 w3-white" style="padding:18px 40px 40px 40px">
                    <div class="w3-text-red"><<c:out value="${validator}"/></div>
                    </c:when>
                    <c:otherwise>
                    <div class="w3-col s6 w3-white" style="padding:40px">
                        </c:otherwise>
                        </c:choose>
                        <p class="w3-small w3-text-grey w3-right">* pola wymagane</p>
                        <h2>Rejestracja</h2>
                            <form:form method="post" modelAttribute="user">
                            <p><label class="w3-text-grey">Login*</label>
                                <form:input class="w3-input w3-border" style="font-family: FontAwesome;"  path="username" id="username" required="true" /></p>
                            <p><label class="w3-text-grey">Hasło*</label>
                                <form:password class="w3-input w3-border" style="font-family: FontAwesome;"  path="password" id="password" required="true" /></p>
                            <button type="submit" class="w3-button w3-block w3-black">Zarejestruj się</button>
                             </form:form>
                    </div>

                    <div class="w3-col s6" style="padding:40px;">

                    </div>
                </div>
            </div>


        </div>


    <div class="w3-container w3-black w3-padding">
        <h2 class="w3-wide">NEWSLETTER</h2>
        <p>Chcesz być na bieżąco z naszą ofertą i aktualnymi promocjami? Zapisz się do newslettera.</p>
        <form action="${pageContext.request.contextPath}/subskrybcja" method="get">
            <p><input class="w3-input w3-border" type="text" placeholder="Adres e-mail" name="adres_email_subskrybcji" required style="width:100%"></p>
            <button type="submit" class="w3-button w3-red w3-margin-bottom">Subskrybuj</button>
        </form>
    </div>

    <footer class="w3-padding-32 w3-light-grey w3-small w3-center" id="footer">
        <div class="w3-row-padding">
            <div class="w3-col s4">
                <h4>Kontakt</h4>
                <p>Masz problem?</p>
                <form action="${pageContext.request.contextPath}/kontakt " method="get">
                    <p><input class="w3-input w3-border" type="text" placeholder="Imie" name="imie_zapytania" required></p>
                    <p><input class="w3-input w3-border" type="text" placeholder="Email" name="email_zapytania" required></p>
                    <p><input class="w3-input w3-border" type="text" placeholder="Temat" name="temat_zapytania" required></p>
                    <p><input class="w3-input w3-border" type="text" placeholder="Wiadomość" name="wiadomosc_zapytania" required></p>
                    <button type="submit" name="wyslij_zapytanie" class="w3-button w3-block w3-black">Wyślij</button>
                </form>
            </div>

                <div class="w3-col s4">
                    <h4>Info</h4>
                    <p><a href="#">O nas</a></p>
                    <p><a href="#">Dostawa</a></p>
                    <p><a href="#">Płatność</a></p>
                    <p><a href="#">Zwroty</a></p>
                    <p><a href="#">Pomoc</a></p>
                </div>

                <div class="w3-col s4 w3-justify">
                    <h4>Sklep</h4>
                    <p><i class="fa fa-fw fa-map-marker"></i> Świat książki</br> &nbsp &nbsp &nbsp Lublin 20-654</br> &nbsp &nbsp &nbsp ul. T. Zana 16</p>
                    <p><i class="fa fa-fw fa-phone"></i> 123-456-789</p>
                    <p><i class="fa fa-fw fa-envelope"></i> biuro@swiatksiazki.pl</p>
                    <h4>Zapłacisz</h4>
                    <p><i class="fa fa-cc-visa"></i> Visa</p>
                    <p><i class="fa fa-paypal"></i> PayPal</p>
                    <br>
                </div>
            </div>
        </footer>

        <div class="w3-black w3-center w3-padding-24">Korzystanie z serwisu oznacza akceptację regulaminu</div>

    </div>

    <div id="wyszukiwanie" class="w3-modal">
        <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
            <div class="w3-container w3-white w3-center">
                <i onclick="document.getElementById('wyszukiwanie').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
                <h2>ZNAJDŹ PRODUKT</h2>
                <div class="w3-row w3-padding-32">
                    <div>
                        <form action="${pageContext.request.contextPath}/books/list/szukaj " method="get">
                            <input class="w3-input w3-border" type="text" placeholder="Nazwa produktu.." name="nazwa_szukana" required>

                            <button type="submit" class="w3-button w3-padding-large w3-black w3-margin-bottom">Wyszukaj</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


</body>
</html>
