package com.acme.p1z2.web.internal.portlet;

import com.acme.p1z2.web.internal.configuration.P1Z2WebConfiguration;

import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	configurationPid = "com.acme.p1z2.web.internal.configuration.P1Z2WebConfiguration",
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"javax.portlet.display-name=P1Z2 Portlet",
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=P1Z2Portlet",
		"javax.portlet.resource-bundle=content.Language"
	},
	service = Portlet.class
)
public class P1Z2Portlet extends MVCPortlet {

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		try {
			P1Z2WebConfiguration p1z2WebConfiguration =
				portletDisplay.getPortletInstanceConfiguration(
					P1Z2WebConfiguration.class);

			renderRequest.setAttribute(
				P1Z2WebConfiguration.class.getName(), p1z2WebConfiguration);
		}
		catch (ConfigurationException configurationException) {
			throw new PortletException(configurationException);
		}

		super.render(renderRequest, renderResponse);
	}

}