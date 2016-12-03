<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>


<html>
<body>
<table width="99%" height="99%" bgcolor="#c3d599">
<tr height="12%"><td></td>
<td  align="center">
<tiles:insert attribute="HEADER"/>
</td>
<td></td>
</tr>

<tr height="83%">
<td width="15%" valign="middle" align="left">
<tiles:insert attribute="LMENU"/>
</td>
<td width="70%" valign="middle" >
<tiles:insert attribute="BODY"/>
</td>
<td width="15%" valign="middle" align="center">
<tiles:insert attribute="RMENU"/>
</td>
</tr>

<tr height="5%">
<td colspan="3"  align="center">
<tiles:insert attribute="FOOTER"/>
</td>
</tr>

</table>
</body>
</html>