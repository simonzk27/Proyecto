<%-- 
    Document   : studentinfo
    Created on : 7/09/2024, 04:26:34 PM
    Author     : UUSARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./ProyectoServlet" method="POST">
            <table>
                <tr>
                    <td>Proyecto Id</td>
                    <td><input type="text" name="id" value="${proyecto.id}" /></td>
                </tr>
                <tr>
                    <td>Nombre Proyecto</td>
                    <td><input type="text" name="nombre" value="${proyecto.nombre}" /></td>
                </tr>
                <tr>
                    <td>Localidad</td>
                    <td><input type="text" name="localidad" value="${proyecto.localidad}" /></td>
                </tr>
                <tr>
                    <td>Presupuesto</td>
                    <td><input type="text" name="prosupuesto" value="${proyecto.prosupuesto}" /></td>
                </tr>
                <tr>
                    <td>Habitantes</td>
                    <td><input type="text" name="habitantes" value="${proyecto.habitantes}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                        <input type="submit" name="action" value="ViewAll" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Proyecto Id</th>
            <th>Nombre Proyecto</th>
            <th>Localidad</th>
            <th>Presupuesto</th>
            <th>Habitantes</th>
            <c:forEach items="${allProyectos}" var="pr">
                <tr>
                    <td>${pr.id}</td>
                    <td>${pr.nombre}</td>
                    <td>${pr.localidad}</td>
                    <td>${pr.prosupuesto}</td>
                    <td>${pr.habitantes}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
