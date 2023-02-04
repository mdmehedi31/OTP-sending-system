<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

  <style>
          #mailList{
            border: 1.5px solid darkred;
            border-radius: 12px;
          }
          #mailHead{
            background-color: darkgoldenrod;
          }
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
           <%-- <c:forEach var="mail"  items="${mailId}">--%>
              <td>${mailId}</td>
            <%--</c:forEach>--%>
         <%--  <form:input type="text" cssClass="form-control" id="userEmail" path="userEmail"></form:input>--%>
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

<div>
    <h1><b><u>ToDay Mail Schedule</u></b></h1>
   <table id="mailList" class="table table-striped table-hover">
       <thead id="mailHead">
       <tr>
       <th>#</th>
       <th>Mail Id</th>
       <th>Sub Title</th>
       <th>Mail Date</th>
       <th>Operation</th>
     </tr>
       </thead>

     <tbody>

        <c:forEach var="mail" items="${mailList}" varStatus="counter">
          <tr>
          <td>${counter.count}</td>
          <td>${mail.mailId}</td>
          <td>${mail.subTitle}</td>
          <td>${mail.mailDate}</td>
          <td>
            <a href="<c:url value="/writeEmail/${customer.customerId}"/>" class="btn btn-success">Send Email</a>
            <a href="<c:url value="/viewCustomer/${customer.customerId}"/>" class="btn btn-success">Views</a>
          </td>
          </tr>
        </c:forEach>

     </tbody>
   </table>
</div>
</body>
</html>
