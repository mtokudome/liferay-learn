package com.acme.m1t1.web.internal.portlet;

import com.acme.m1t1.M1T1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=M1T1 Portlet",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class M1T1Portlet extends GenericPortlet {

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {

		PrintWriter printWriter = response.getWriter();

		printWriter.println("I'm calling a service ...<br>");

		printWriter.println(_m1t1.doSomething());
	}

	@Reference(unbind = "-")
	private M1T1 _m1t1;

}