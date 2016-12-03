<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jlc" %>

<html>
<body>
<br><br><center>
<h1>Java Learning Center</h1>
<h2>Search Contact Form</h2>
<logic:present name="NOT_FOUND">
<table>
<tr>
<td><font color="red" size="6"><b>${NOT_FOUND}</b></font></td></tr>
</table>
</logic:present>
<html:form action="/SearchContactSubmit.do?method=searchContact">
<table style="font-size:25">

<tr>
<td>Email Id:</td>
<td><html:text property="email"/></td>
<td><html:submit value="Show Contact"/></td>
<td><html:errors property="email"/></td></tr>
</table>
</html:form>
</center>
</body>
</html>
