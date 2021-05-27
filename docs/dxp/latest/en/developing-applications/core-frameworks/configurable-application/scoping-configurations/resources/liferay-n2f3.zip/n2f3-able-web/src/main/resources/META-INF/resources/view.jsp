<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.acme.n2f3.able.web.internal.configuration.N2F3WebConfiguration" %>

<%
N2F3WebConfiguration n2f3WebConfiguration = (N2F3WebConfiguration)request.getAttribute(N2F3WebConfiguration.class.getName());
%>

<p>
	<liferay-ui:message key="n2f3-porlet-welcome" /><br />
	Text: <%= n2f3WebConfiguration.text() %>
</p>