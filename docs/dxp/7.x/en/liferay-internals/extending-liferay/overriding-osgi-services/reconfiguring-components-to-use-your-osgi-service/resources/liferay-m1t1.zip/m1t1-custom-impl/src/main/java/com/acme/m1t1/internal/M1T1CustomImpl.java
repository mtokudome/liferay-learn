package com.acme.m1t1.internal;

import com.acme.m1t1.M1T1;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = M1T1.class
)
public class M1T1CustomImpl implements M1T1 {

	@Override
	public String doSomething() {

		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName());
		sb.append(", which delegates to ");
		sb.append(_M1T1.doSomething());

		return sb.toString();
	}

	@Reference  (
		unbind = "-",
		target = "(component.name=com.acme.m1t1.internal.M1T1Impl)"
	)
	private M1T1 _M1T1;
}
