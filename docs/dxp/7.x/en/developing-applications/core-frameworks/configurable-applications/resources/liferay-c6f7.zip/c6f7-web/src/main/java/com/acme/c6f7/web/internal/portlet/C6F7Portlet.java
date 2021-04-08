package com.acme.c6f7.web.internal.portlet;

import com.acme.c6f7.web.internal.configuration.MessageDisplayConfiguration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

@Component(
	configurationPid = "com.acme.c6f7.web.internal.configuration.MessageDisplayConfiguration",
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"javax.portlet.display-name=C6F7 Portlet",
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=C6F7Portlet",
		"javax.portlet.resource-bundle=content.Language"
	},
	service = Portlet.class
)
public class C6F7Portlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		renderRequest.setAttribute(
			MessageDisplayConfiguration.class.getName(),
			_messageDisplayConfiguration);

		super.doView(renderRequest, renderResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_messageDisplayConfiguration = ConfigurableUtil.createConfigurable(
			MessageDisplayConfiguration.class, properties);
	}

	private volatile MessageDisplayConfiguration _messageDisplayConfiguration;

}