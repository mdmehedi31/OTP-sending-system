<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

  <style>

  </style>
</head>
<body>

<section>
  <div class="container">

    <%--@elvariable id="mailDto" type="com.nf.dto"--%>
    <form:form action="${pageContext.request.contextPath}views/writeEmail" method="post"
          modelAttribute="mailDto">

      <table align="center">
        <tr>
          <td colspan="2">Email To</td>
          <td>
            <c:forEach var="mail"  items="${mailId}">
              <td>${mail}</td>
            </c:forEach>
          <%-- <form:input type="text" cssClass="form-control" id="userEmail" path="userEmail"></form:input>--%>
          </td>
        </tr>
        <tr>
          <td>Subject</td>
          <td>
            <form:input type="text"  cssClass="form-control" id="subject" path="subject"></form:input>
          </td>
        </tr>
        <tr>
          <td>Massage</td>
          <td><form:textarea path="message" cssClass="form-control" id="message" rows="5" cols="35"></form:textarea></td>
        </tr>
        <tr>
          <td><button type="submit">Submit</button></td>
          <td></td>
        </tr>
      </table>
    </form:form>
  </div>

</section>
</body>
</html>
