<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.acme.p1z2.web.internal.configuration.P1Z2WebConfiguration" %>

<%
P1Z2WebConfiguration p1z2WebConfiguration = (P1Z2WebConfiguration)request.getAttribute(P1Z2WebConfiguration.class.getName());
%>

<p>
	<liferay-ui:message key="p1z2-porlet-welcome" /><br />
	color: <%= p1z2WebConfiguration.favoriteFruit() %>
</p>