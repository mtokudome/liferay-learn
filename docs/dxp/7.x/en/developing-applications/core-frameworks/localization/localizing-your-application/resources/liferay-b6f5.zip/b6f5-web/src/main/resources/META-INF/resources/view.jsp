<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:actionURL name="processAction" var="processActionURL" />

<p>
	<h1><liferay-ui:message key="b6f5-portlet-welcome" /></h1>
</p>

<aui:form action="<%= processActionURL %>" method="post" name="fm">
	<aui:input label="Email" name="Email" value="">
		<aui:validator errorMessage="b6f5-please-enter-a-valid-email-address" name="email" />
	</aui:input>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
