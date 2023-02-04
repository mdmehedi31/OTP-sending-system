<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send SMS</title>

</head>

        <%--@elvariable id="smsDto" type="com.nf.dto"--%>
        <form:form action="${pageContext.request.contextPath}views/sendSms" method="post"
                   modelAttribute="smsDto">

          <table>
            <tr>
              <td>
                <label>To</label>
              </td>
              <td>
                <form:input type="text" cssClass="form-control" id="phoneNumber" path="phoneNumber"></form:input>
              </td>
            </tr>

            <tr>
              <td>
                <label>SMS Body</label>
              </td>
              <td>
               <form:textarea path="message"  cssClass="form-control" id="message" rows="5" cols="35"></form:textarea>
              </td>
            </tr>
            <tr>
              <td>
                <button style="background-color: #3baddc;" type="submit">Send</button>
              </td>
            </tr>
          </table>
        </form:form>
</body>
</html>
