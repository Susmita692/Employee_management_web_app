<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-7">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
           <%@include file="businessMessage.jsp" %>
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Employee Registration</h3>
            
             
            <sf:form method="post" action="${pageContext.request.contextPath}/AddUser" modelAttribute="form">
              <div class="row">
              <sf:input type="hidden" id="id" class="form-control form-control-lg" path="id" name="id" value="${form.id}"/>
               <div class="col-md-6 mb-4">
                  <div class="form-outline">   
                  <s:bind path="empNumber">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                  <sf:input type="text" id="empNumber" class="form-control form-control-lg" path="empNumber" name="empNumber"/>
                  </s:bind>      
                  <label class="form-label" for="empNumber">Employee Number</label>           
                  </div>
                </div>
              
              
                <div class="col-md-6 mb-4">
                  <div class="form-outline">   
                  <s:bind path="firstName">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                  <sf:input type="text" id="firstName" class="form-control form-control-lg" path="firstName" name="firstName"/>
                  </s:bind>      
                  <label class="form-label" for="firstName">First Name</label>
                  
                  </div>
				 
                </div>
                <div class="col-md-6 mb-4">
                
                  <div class="form-outline">
                  <s:bind path="lastName">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="text" id="lastName" class="form-control form-control-lg" path="lastName"/>
                    <label class="form-label" for="lastName">Last Name</label>
                  </s:bind>
                  </div>               
                </div>                
              </div>

              <div class="row">
                <div class="col-md-6 mb-4 pb-2">
                  <s:bind path="email">
                  <div class="form-outline">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="email" id="emailAddress" class="form-control form-control-lg"  path="email"/>
                    <label class="form-label" for="emailAddress">Email</label>
                  </div>
                  </s:bind>

                </div>
                  <div class="col-md-6 mb-4 pb-2">
                  <s:bind path="position">
                  <div class="form-outline">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="position" id="position" class="form-control form-control-lg" path="position"/>
                    <label class="form-label" for="position" >Position</label>
                  </div>
					</s:bind>
                </div>
                <div class="col-md-6 mb-4 pb-2">
                 <s:bind path="phoneNumber">
                  <div class="form-outline">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="tel" id="phoneNumber" class="form-control form-control-lg" path="phoneNumber" />
                    <label class="form-label" for="phoneNumber">Phone Number</label>
                  </div>
					</s:bind>
                </div>
              </div>
              

              <div class="mt-4 pt-2">
                <input class="btn btn-primary btn-lg" type="submit" value="SignUp" />
              </div>

           </sf:form>
          
          </div>
        </div>
      </div>
    </div>
  </div>
</section>