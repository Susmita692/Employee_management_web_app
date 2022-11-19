<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
 var tableToExcel = (function() {
      var uri = 'data:application/vnd.ms-excel;base64,'
        , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
        , base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) }
        , format = function(s, c) { return s.replace(/{(\w+)}/g, function(m, p) { return c[p]; }) }
      return function(table, name) {
        if (!table.nodeType) table = document.getElementById(table)
        var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}
        window.location.href = uri + base64(format(template, ctx))
      }
    })()
</script>

</head>
<body>

<div class="container">

<sf:form method="post" action="${pageContext.request.contextPath}/search" modelAttribute="form">

		<div style="margin-top: 50px;">
		
		<div class="form-outline ">
            <s:bind path="firstName">
			<sf:input  path="${status.expression}" placeholder="Search by First Name" class="form-control"/>
			<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}" /></font>
		    </s:bind>

            </div>
            <div class="form-check d-flex justify-content-center mb-4 mt-2">
             <input type="submit" name="operation"
						class="btn btn-primary  pull-right" value="Search"> &nbsp; 
            </div>
		
		</div>

<br>
<h1>Employee List</h1>

<br>
<%@include file="businessMessage.jsp" %>

<table id="testTable" class="table">
  <thead>
    <tr>
      <th scope="col">empNumber</th>
      <th scope="col">FirstName</th>
      <th scope="col">LastName</th>
      <th scope="col">PhoneNumber</th>
      <th scope="col">Position</th>
      <th scope="col">Email</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${emplist}" var="list" varStatus="u">
    <tr>
  
 <c:choose>
  <c:when test="${list.empNumber<10}">
    <th scope="row">00${list.empNumber}</th>
  </c:when>
  <c:when test="${list.empNumber>=10 && list.empNumber<100}">
    <th scope="row">0${list.empNumber}</th>
  </c:when>
  <c:otherwise>
    <th scope="row">${list.empNumber}</th>
  </c:otherwise>
</c:choose>
      
      
      <td>${list.firstName}</td>
      <td>${list.lastName}</td>
      <td>${list.phoneNumber}</td>
      <td>${list.position}</td>
      <td>${list.email}</td>
      <td>
      
      <a href="${pageContext.request.contextPath}/empEdit?id=${list.id}">Edit</a>
      <a href="${pageContext.request.contextPath}/empDelete?id=${list.id}">Delete</a>
      
      </td>
    </tr>
   </c:forEach>
  </tbody>
</table>
</sf:form>
<input type="button" onclick="tableToExcel('testTable', 'W3C Example Table')" value="Print">

<a href="${pageContext.request.contextPath}/sendMailPage">Send Data to mail</a>


</div>

</body>
</html>