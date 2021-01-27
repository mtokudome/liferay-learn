package com.acme.t4n9.able.internal;

import com.acme.t4n9.T4N9;

import org.osgi.service.component.annotations.Component;

@Component(service = T4N9.class)
public class T4N9AbleImpl implements T4N9 {

	@Override
	public String doSomething() {
		return "This is the T4N9 Able implementation.";
	}

}