package com.acme.t4n9.baker.internal;

import com.acme.t4n9.T4N9;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(property = "service.ranking:Integer=100", service = T4N9.class)
public class T4N9BakerImpl implements T4N9 {

	@Override
	public String doSomething() {
		return _t4n9.doSomething() +
			"<br />This is the T4N9 Baker implementation.";
	}

	@Reference(
		target = "(component.name=com.acme.t4n9.able.internal.T4N9AbleImpl)",
		unbind = "-"
	)
	private T4N9 _t4n9;

}