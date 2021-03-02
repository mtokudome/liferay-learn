package com.acme.b6f5.web.internal.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"javax.portlet.display-name=B6F5 Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.supported-locale=_en_US",
		"javax.portlet.supported-locale=_ja",
		"javax.portlet.supported-locale=_pt_BR",
		"javax.portlet.resource-bundle=content.Language"
	},
	service = Portlet.class
)
public class B6F5Portlet extends MVCPortlet {

	@Override
	public void processAction(
		ActionRequest actionRequest, ActionResponse actionResponse) {
	}

}