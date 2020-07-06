<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <h2>Kategoria</h2>
            <form:form action="saveKategoria" modelAttribute="kategoria" method="POST">
            <div class="w3-container">
                <table>
                    <tbody>
                    <tr>
                        <td><label>nazwa:</label></td>
                        <td><form:input  class="w3-input" path="nazwa" /></td>
                        <td><form:hidden path="id"/></td>
                    </tr>
                    </tbody>
                </table>
            </div>
                <input type="submit" value="Zapisz" class="save w3-button w3-black w3-right w3-margin-top" style="margin-right: 50px" />
            </form:form>
        </div>
    </div>


    <div style="height: 50px"></div>
    <div class="w3-black w3-center w3-padding-24">Narzędzia administratora</div>

</div>

</body>
</html>
