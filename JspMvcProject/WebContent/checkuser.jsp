<jsp:useBean id="ob" class="com.zensar.models.loginBean" scope="request"></jsp:useBean>
<jsp:setProperty property="username" name="ob"/>
<jsp:setProperty property="password" name="ob"/>
<%
	
	
	//Bussiness Logic
	
	if(ob.validateUser())
	{%>
		<jsp:forward page="welcome.jsp" >
		<jsp:param value="Core java" name="book1"/>
		<jsp:param value="Spring" name="book2"/>
		</jsp:forward>
		
	<%}
	else
	{%>
		<p>Invalid Username or Password</p>
		<jsp:include page="login.jsp"></jsp:include>
	<%}

 %>