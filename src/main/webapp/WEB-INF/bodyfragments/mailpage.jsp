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
</head>
<body>
<%@include file="businessMessage.jsp" %>
<div class="container">
<sf:form method="post" action="${pageContext.request.contextPath}/sendMail" modelAttribute="form">

		<div style="margin-top: 50px;">
		
	           <div class="col-md-6 mb-4 pb-2">
                  <s:bind path="toEmail">
                  <div class="form-outline">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="toEmail" id="emailAddress" class="form-control form-control-lg"  path="toEmail"/>
                    <label class="form-label" for="emailAddress">Email</label>
                  </div>
                  </s:bind>
           <div class="form-check d-flex justify-content-center mb-4 mt-2">
             <input type="submit" name="operation"
						class="btn btn-primary  pull-right" value="Send"> &nbsp; 
            </div>
                </div>
          
		
		</div>
		
		</sf:form>

</div>

</body>
</html>