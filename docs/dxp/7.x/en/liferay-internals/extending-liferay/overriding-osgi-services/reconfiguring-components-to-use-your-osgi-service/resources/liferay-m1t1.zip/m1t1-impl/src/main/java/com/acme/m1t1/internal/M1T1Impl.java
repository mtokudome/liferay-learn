package com.acme.m1t1.internal;

import com.acme.m1t1.M1T1;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		service = M1T1.class
)
public class M1T1Impl implements M1T1 {

	@Override
	public String doSomething() {

		return this.getClass().getName();
	}

}
