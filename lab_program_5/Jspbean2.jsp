<jsp:useBean id="b1" class="com.SampleBean" scope="session" />
        Welcome,
<jsp:getProperty name="b1" property="sname" /><br>
<jsp:getProperty name="b1" property="gender" />
       
