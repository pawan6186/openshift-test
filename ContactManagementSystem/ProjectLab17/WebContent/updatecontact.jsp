<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page isELIgnored="false" %>

<html>
<body>
<br><br><center>
<h1>Java Learning Center</h1>
<h1>Update Contact Form</h1>

<html:form action="/UpdateContactSubmit.do?method=updateContact">
<table style="font-size:25;color:green">

<tr>
<td>Contact ID: </td>
<td><html:text property="contactId" value="${sessionScope.contactForm.contactId}"/></td>
<td></td>
</tr>

<tr>
<td>First Name</td>
<td><html:text property="fname" value="${sessionScope.contactForm.fname}"/></td>
<td><html:errors property="fname"/></td>
</tr>


<tr>
<td>Last Name</td>
<td><html:text property="lname" value="${sessionScope.contactForm.lname}"/></td>
<td><html:errors property="lname"/></td>
</tr>

<tr>
<td>Email Id</td>
<td><html:text property="email" value="${sessionScope.contactForm.email}"/></td>
<td><html:errors property="email"/></td>
</tr>

<tr>
<td>Phone</td>
<td><html:text property="phone" value="${sessionScope.contactForm.phone}"/></td>
<td><html:errors property="phone"/></td>
</tr>

<tr>
<td>Status</td>
<td><html:select property="status" value="${sessionScope.contactForm.status}">
<html:option value="Enabled">Enabled</html:option>
<html:option value="Disabled">Disabled</html:option>
</html:select>
</td>
<td><html:errors property="status"/></td>
</tr>

<tr><td align="center" colspan="2">
<html:submit value="Update Contact"/></td></tr>
</table>
</html:form>

</center>
</body>
</html>
