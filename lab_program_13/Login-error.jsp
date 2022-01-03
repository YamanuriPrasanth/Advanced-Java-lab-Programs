<p>Sorry! username or password error</p>  
<%@ include file="index.jsp" %>
Web.xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app>
  <servlet>  
  <servlet-name>s1</servlet-name>  
  <servlet-class>mypack.ControllerServlet</servlet-class>  
  </servlet>  
  <servlet-mapping>  
  <servlet-name>s1</servlet-name>  
  <url-pattern>/ControllerServlet</url-pattern>  
  </servlet-mapping>  
</web-app>
