<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.acme.p1z2.web.internal.configuration.P1Z2WebConfiguration" %>

<%@ page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.util.Constants" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
P1Z2WebConfiguration p1z2WebConfiguration = (P1Z2WebConfiguration)renderRequest.getAttribute(P1Z2WebConfiguration.class.getName());
String favoriteFruit = StringPool.BLANK;

if (p1z2WebConfiguration != null) {
	favoriteFruit = portletPreferences.getValue("favoriteFruit", p1z2WebConfiguration.favoriteFruit());
}
%>

<liferay-portlet:actionURL
	portletConfiguration="<%= true %>"
	var="configurationActionURL"
/>

<liferay-portlet:renderURL
	portletConfiguration="<%= true %>"
	var="configurationRenderURL"
/>

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input
		name="<%= Constants.CMD %>"
		type="hidden"
		value="<%= Constants.UPDATE %>"
	/>

	<aui:input
		name="redirect"
		type="hidden"
		value="<%= configurationRenderURL %>"
	/>

	<aui:fieldset>
		<aui:select
			label="Favorite Fruit"
			name="favoriteFruit"
			value="<%= favoriteFruit %>"
		>
			<aui:option value="apple">apple</aui:option>
			<aui:option value="banana">banana</aui:option>
			<aui:option value="orange">orange</aui:option>
		</aui:select>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>