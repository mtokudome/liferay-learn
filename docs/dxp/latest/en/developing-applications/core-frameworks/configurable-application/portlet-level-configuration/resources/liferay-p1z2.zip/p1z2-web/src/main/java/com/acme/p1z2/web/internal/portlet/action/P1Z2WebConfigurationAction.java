package com.acme.p1z2.web.internal.portlet.action;

import com.acme.p1z2.web.internal.configuration.P1Z2WebConfiguration;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

@Component(
	configurationPid = "com.acme.p1z2.web.internal.configuration.P1Z2WebConfiguration",
	configurationPolicy = ConfigurationPolicy.OPTIONAL,
	property = "javax.portlet.name=P1Z2Portlet",
	service = ConfigurationAction.class
)
public class P1Z2WebConfigurationAction extends DefaultConfigurationAction {

	@Override
	public void include(
			PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		try {
			P1Z2WebConfiguration p1z2WebConfiguration =
				portletDisplay.getPortletInstanceConfiguration(
					P1Z2WebConfiguration.class);

			httpServletRequest.setAttribute(
				P1Z2WebConfiguration.class.getName(), p1z2WebConfiguration);
		}
		catch (Exception exception) {
			_log.error(exception, exception);
		}

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		String favoriteFruit = ParamUtil.getString(
			actionRequest, "favoriteFruit");

		setPreference(actionRequest, "favoriteFruit", favoriteFruit);

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		P1Z2WebConfigurationAction.class);

}