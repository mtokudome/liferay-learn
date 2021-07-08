package com.acme.p1z2.web.internal.portlet.action;

import com.acme.p1z2.web.internal.configuration.P1Z2WebConfiguration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

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

		httpServletRequest.setAttribute(
			P1Z2WebConfiguration.class.getName(), _p1z2WebConfiguration);

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

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_p1z2WebConfiguration = ConfigurableUtil.createConfigurable(
			P1Z2WebConfiguration.class, properties);
	}

	private volatile P1Z2WebConfiguration _p1z2WebConfiguration;

}