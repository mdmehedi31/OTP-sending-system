<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 1/4/2023
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <div class="allClassesContainer">

      <%--@elvariable id="addWorkDto" type="com.nf.dto"--%>
      <form:form action="${pageContext.request.contextPath}views/addWork" modelAttribute="addWorkDto"
                 method="post">

          <table>
              <tr>
                  <td>Email: </td>
                  <td>
                      <form:input type="text" cssClass="form-control" id="mailId"  placeholder="mailId" path="mailId"></form:input>
                  </td>
              </tr>
              <tr>
                  <td>Mail Subtitle: </td>
                  <td><form:input type="text" cssClass="form-control" id="mailSubtitle" placeholder="mailsubtitle" path="mailSubtitle"></form:input></td>
              </tr>
              <tr>
                  <td>Mail Topic: </td>
                  <td>
                      <form:input type="text" cssClass="form-control" id="mailTopic" placeholder="mailTopic" path="mailTopic"></form:input>
                  </td>
              </tr>

              <tr>
                  <td>Mail Date: </td>
                  <td>
                    <%--  <form:input type="date" cssClass="form-control" id="mailDate"  path="mailDate" ></form:input>--%>
                      <form:input type="date" cssClass="form-control" id="mailDate" path="mailDate"></form:input>
                  </td>
              </tr>
              <tr>
                  <td colspan="2">
                      <input type="submit" value="Add Schedule">
                  </td>
              </tr>
          </table>
      </form:form>
    </div>
</body>
</html>
