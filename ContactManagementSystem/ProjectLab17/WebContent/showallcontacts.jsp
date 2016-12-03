<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jlc" %>

<html>
<body>
<br><br><center>
<h1>Java Learning Center</h1>
<h2 align="right"></h2>

<logic:present name="DELETED">
<table width="100%" bgcolor="yellow">
<tr><td align="center">
<font color="green" size="6"><b>${DELETED}</b></font></td>
</tr></table>
</logic:present>

<logic:present name="NOT_FOUND">
<table width="100%" bgcolor="lightgreen">
<tr><td align="center">
<font color="red" size="6"><b>${NOT_FOUND}</b></font></td>
</tr></table>
</logic:present>

<logic:notPresent name="NOT_FOUND">
<table  style="font-size:20;border-style:dotted;border_size:1px;border_color:red" width="100%">
<tr><td align="right" colspan="8">
${BEGIN} to ${END} of ${TNOR}</td>
</tr>

<tr>
<th align="center">Contact ID</th>
<th align="center">First Name</th>
<th align="center">Last Name</th>
<th align="center">Email Id</th>
<th align="center">Phone</th>
<th align="center">Status</th>

</tr>
<logic:iterate id="cto" name="CLIST" scope="session" type="com.jlcindia.struts.ContactTO">
<tr>
<logic:equal name="CID" value="${cto.contactId}">
<logic:equal name="EDIT" value="TRUE">
<html:form action="/UpdateContactSubmit.do?method=updateContact">
<td><bean:write name="cto" property="contactId"/></td>
<html:hidden property="contactId" value="${cto.contactId}"/>
<td><html:text property="fname" value="${cto.fname}"/></td>
<td><html:text property="lname" value="${cto.lname}"/></td>
<td><html:text property="email" value="${cto.email}"/></td>
<td><html:text property="phone" value="${cto.phone}"/></td>
<td><html:select property="status" value="${cto.status}">
<html:option  value="Enabled">Enabled</html:option>
<html:option  value="Disabled">Disabled</html:option>
</html:select></td>
<td><html:submit value="Save"/></td>
</html:form>
</logic:equal> 
<logic:equal name="EDIT" value="FALSE">
<td><html:form action="/ContactEditSubmit.do?method=editContact">
<html:hidden property="cid" value="${cto.contactId}"/>
<html:submit value="Edit"/>
</html:form></td>
</logic:equal>
<td><html:form action="/ContactDeleteSubmit.do?method=deleteContact">
<html:hidden property="cid" value="${cto.contactId}"/>
<html:submit value="Delete"/>
</html:form></td>
</logic:equal> 

<logic:notEqual name="CID" value="${cto.contactId}">
<td><bean:write name="cto" property="contactId"/></td>
<td><bean:write name="cto" property="fname"/></td>
<td><bean:write name="cto" property="lname"/></td>
<td><bean:write name="cto" property="email"/></td>
<td><bean:write name="cto" property="phone"/></td>
<td><bean:write name="cto" property="status"/></td>

<logic:equal name="EDIT" value="FALSE">
<td><html:form action="/ContactEditSubmit.do?method=editContact">
<html:hidden property="cid" value="${cto.contactId}"/>
<html:submit value="Edit"/>
</html:form></td>
</logic:equal>

<logic:equal name="EDIT" value="TRUE">
<td><html:form action="/UpdateContactSubmit.do?method=updateContact">
<html:submit value="Save"/>
</html:form></td>
</logic:equal>
<td><html:form action="/ContactDeleteSubmit.do?method=deleteContact">
<html:hidden property="cid" value="${cto.contactId}"/>
<html:submit value="Delete"/>
</html:form></td>
</logic:notEqual>
</tr>
</logic:iterate>
<tr>
<td colspan="4" align="left">
<logic:present name="SHOW_PREVIOUS">
<html:link forward="showpreviouscontacts">
<b>Previous</b>
</html:link>
</logic:present></td>

<td colspan="4" align="right">
<logic:present name="SHOW_NEXT">
<html:link forward="shownextcontacts">
<b>Next</b>
</html:link>
</logic:present></td>
</tr>
</table>
</logic:notPresent>
</center>
</body>
</html>
