<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Administracja</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .w3-sidebar a {font-family: "Roboto", sans-serif}
    body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
</style>
<body class="w3-content" style="max-width:1200px">


<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top" style="z-index:3;width:250px; margin-top:128px;">
    <div class="w3-padding-64 w3-large w3-text-grey" style="font-weight:bold">
        <a href="${pageContext.request.contextPath}/admin/add-kategoria" class="w3-bar-item w3-button">Dodaj kategorię</a>
        <a href="${pageContext.request.contextPath}/admin/add-autor" class="w3-bar-item w3-button">Dodaj autora</a>
        <a href="${pageContext.request.contextPath}/admin/add-ksiazka" class="w3-bar-item w3-button">Dodaj książkę</a>
        <a href="${pageContext.request.contextPath}/admin/kategorie/list" class="w3-bar-item w3-button">Kategorie - edycja</a>
        <a href="${pageContext.request.contextPath}/admin/autorzy/list" class="w3-bar-item w3-button">Autorzy - edycja</a>
        <a href="${pageContext.request.contextPath}/admin/books/list" class="w3-bar-item w3-button">Książki - edycja</a>
        <a href="${pageContext.request.contextPath}/admin/zamowienia/list" class="w3-bar-item w3-button">Zamówienia</a>
        <a href="${pageContext.request.contextPath}/admin/wiadomosci/list" class="w3-bar-item w3-button">Wiadomości</a>
        <a href="${pageContext.request.contextPath}/admin/subskrybcje/list" class="w3-bar-item w3-button">Subskrybcje</a>
    </div>
    <a href="${pageContext.request.contextPath}/admin/sklep" class="w3-bar-item w3-button w3-padding w3-dark-grey w3-large">Powrót do sklepu</a>
</nav>



<div class="w3-main" style="margin-left:250px">

    <div>
        <header class="w3-container w3-large w3-padding-64">
            <div class="w3-xxlarge w3-center w3-text-grey">Narzędzia administratora</div>
        </header>
    </div>


    <div id="main">
        <div class="w3-container">
            <h2>Zamówienia</h2>
            <ol class="w3-ul">
                <li class=" w3-bar">
                    <div class="w3-bar-item">
                        <span class="w3-block w3-left" style="width:200px"><b>Login</b> </span>
                        <span class="w3-block w3-left" style="width:180px"><b>Data</b> </span>
                        <span class="w3-block w3-left w3-center" style="width:200px"><b>Kwota</b> </span>
                    </div>
                </li>
                <c:forEach var="zamowienie" items="${zamowienia}" >
                    <li class ="w3-bar">
                        <div class="w3-bar-item">
                            <span class="w3-block w3-left" style="width:200px">${zamowienie.username} </span>
                            <span class="w3-block w3-left" style="width:180px">${zamowienie.data}</span>
                            <span class="w3-block w3-left w3-center" style="width:200px">${zamowienie.kwota} zł</span>
                            <span class="w3-block w3-right w3-right-align" style="width:200px"> <a onclick="myFunction(${zamowienie.id})"  class="w3-button w3-right w3-white w3-tiny w3-margin-right" >Pokaż szczegóły</a></span>
                        </div>
                        <div id="${zamowienie.id}" class="w3-hide w3-container">
                            <table class="w3-table w3-margin-right w3-margin-left w3-small">
                            <c:forEach var="szczegol" items="${zamowienie.zamowienieSzczegolyList}">
                                <tr>
                                <td>${szczegol.ksiazka.nazwa}</td>
                                <td>
                                <c:forEach var="autor" items="${szczegol.ksiazka.autorzy}" >
                                    ${autor.imie} ${autor.nazwisko} &nbsp;&nbsp;
                                </c:forEach>
                                </td>
                                    <td>${szczegol.ksiazka.cena} zł</td>
                                </tr>
                            </c:forEach>
                            </table>
                        </div>
                    </li>

                        <%--<td>${zamowienie.username}</td>
                        <td>${zamowienie.data}</td>
                        <td>${zamowienie.kwota}</td>
                        <td><a href="${pokaz}" class="w3-button w3-right w3-white w3-tiny w3-margin-right" >Pokaż szczegóły</a></td>
                        <div>
                            <c:forEach var="szczegol" items="${zamowienie.zamowienieSzczegolyList}">
                                   ${szczegol.ksiazka.nazwa}<br>
                            </c:forEach>
                        </div>--%>

                </c:forEach>
            </ol>
        </div>
    </div>


    <div style="height: 50px"></div>
    <div class="w3-black w3-center w3-padding-24">Narzędzia administratora</div>

</div>

<script>
    function myFunction(id) {
        var x = document.getElementById(id);
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
            x.previousElementSibling.className += " w3-theme-d1";
        } else {
            x.className = x.className.replace("w3-show", "");
            x.previousElementSibling.className =
                x.previousElementSibling.className.replace(" w3-theme-d1", "");
        }
    }
</script>


</body>
</html>
