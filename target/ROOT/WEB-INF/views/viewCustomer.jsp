<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #views{
            padding-top: 20px;
        }
    </style>
</head>
<body>

    <%--@elvariable id="addCustomer" type="com.nf.entity"--%>
    <form:form action="${pageContext.request.contextPath}/viewCustomer" modelAttribute="addCustomer">
        <table align="center" id="views">
            <tr>
                <td style="font-weight: bold">Customer Name: </td>
                <td><label>${addCustomer.name}</label></td>
            </tr>

            <tr>
                <td style="font-weight: bold">Email: </td>
                <td><label>${addCustomer.email}</label></td>
            </tr>

            <tr>
                <td style="font-weight: bold">Customer Details: </td>
                <td><label>${addCustomer.customerDetails}</label> </td>
            </tr>
            <tr>
               <%-- <td>
                    <a href="<c:url value="/updateCustomer/${customer.customerId}"/>" class="btn btn-success">Update</a>
                </td>--%>
            </tr>
        </table>
    </form:form>
</body>
</html>
