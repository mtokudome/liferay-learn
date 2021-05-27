package com.acme.n2f3.able.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.acme.n2f3.able.web.internal.configuration.N2F3WebConfiguration", localization = "content/Language", name = "n2f3-configuration-name")
public interface N2F3WebConfiguration {

		@Meta.AD(deflt = "blue", required = false)
		public String text();

	}