<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 1/2/2023
  Time: 11:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <div class="allClassesContainer">
        <%--@elvariable id="userDto" type="com.nf.dto"--%>
        <form:form action="${pageContext.request.contextPath}views/createUser" modelAttribute="userDto" method="post">
          <table>
            <tr>
              <td colspan="2">
                <h3>Add User</h3>
              </td>
            </tr>

            <tr>
              <td>
                User Name:
              </td>
              <td>
                <form:input type="text" cssClass="form-control" id="userName" placeholder="userName" path="userName"></form:input>
              </td>
            </tr>

            <tr>
              <td>Email: </td>
              <td>
                <form:input type="text" cssClass="form-control" id="email" placeholder="email" path="email"></form:input>
              </td>
            </tr>

            <tr>
              <td>Organization: </td>
              <td>

                <from:select path="organizationType">
                  <option>--SELECT--</option>
                  <c:forEach items="${orType}" var="key">
                    <option value="${key}">${key}</option>
                  </c:forEach>
                </from:select>
              </td>
            </tr>
            <tr>
              <td>
                Password:
              </td>
              <td>
                <form:input type="password" cssClass="form-control" id="password" placeholder="password" path="password"></form:input>
              </td>
            </tr>

            <tr>
              <td colspan="2">
                <input type="submit" value="Add">
              </td>
            </tr>
          </table>
        </form:form>
    </div>

</body>
</html>
