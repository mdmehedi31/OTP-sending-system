<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

 <div>


     <%--@elvariable id="sendOtpDto" type="com.nf.entity"--%>
     <form:form action="${pageContext.request.contextPath}views/sendOtp" method="post"
                modelAttribute="sendOtpDto">
         <table align="center">
             <tr>
                 <td colspan="2">
                     <h3>SEND OTP</h3>
                 </td>
             </tr>
             <tr>
                 <td>
                     OTP Type
                 </td>
                 <td>

                   <from:select path="typeOtp">
                     <c:forEach items="${enums}" var="key">
                         <option value="${key}">${key}</option>
                     </c:forEach>
                   </from:select>
                 </td>
             </tr>
             <tr>
                 <td>
                     Email/SMS
                 </td>
                 <td>
                    
                        <form:input type="text" cssClass="form-control" id="sendTo" path="sendTo"></form:input>
                 </td>
             </tr>
             <tr>
                 <td>
                     <input type="submit" value="Send">
                 </td>
             </tr>
         </table>


     </form:form>

 </div>

</body>
</html>
