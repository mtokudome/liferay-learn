package com.acme.m1t1.internal;

import com.acme.m1t1.M1T1;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = M1T1.class)
public class M1T1CustomImpl implements M1T1 {

	@Override
	public String doSomething() {
		StringBuilder sb = new StringBuilder();

		M1T1CustomImpl cl = new M1T1CustomImpl();

		Class<?> clClass = cl.getClass();

		String className = clClass.getName();

		sb.append(className);

		sb.append(", which delegates to ");
		sb.append(_m1t1.doSomething());

		return sb.toString();
	}

	@Reference(
		target = "(component.name=com.acme.m1t1.internal.M1T1Impl)",
		unbind = "-"
	)
	private M1T1 _m1t1;

}