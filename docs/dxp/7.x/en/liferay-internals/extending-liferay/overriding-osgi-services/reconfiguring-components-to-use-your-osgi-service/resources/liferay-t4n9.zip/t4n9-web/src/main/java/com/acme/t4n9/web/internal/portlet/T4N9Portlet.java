package com.acme.t4n9.web.internal.portlet;

import com.acme.t4n9.T4N9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.Portlet;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"javax.portlet.display-name=T4N9 Portlet"
	},
	service = Portlet.class
)
public class T4N9Portlet extends GenericPortlet {

	@Override
	protected void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException {

		PrintWriter printWriter = renderResponse.getWriter();

		printWriter.println("This is the portlet.<br />");
		printWriter.println(_t4N9.doSomething());
	}

	@Reference(unbind = "-")
	private T4N9 _t4N9;

}