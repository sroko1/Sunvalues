<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Dynamic Drop Down List </title>
</head>
<body>

<div align="center">
    <h2>Dynamic Drop Down List Demo</h2>
    <form action="class" method="post">
        Select a Values:&#160;
        <label>
            <select name="tabelaTestowa">
                <jsp:useBean id="tabelaTestowaList" scope="page" type="java.util.List"/>
                <c:forEach items="${tabelaTestowaList}" var="tabelaTestowa">
                    <option value="${tabelaTestowa.id}"
                            <c:if test="${tabelaTestowa.id eq tabelaTestowa.selectedId}">selected="selected"</c:if>
                    >
                            ${tabelaTestowa.kolumna1}
                    </option>
                </c:forEach>
            </select>
        </label>
        <br/><br/>
        <input type="submit" value="Submit" />
    </form>
</div>
</body>
</html>