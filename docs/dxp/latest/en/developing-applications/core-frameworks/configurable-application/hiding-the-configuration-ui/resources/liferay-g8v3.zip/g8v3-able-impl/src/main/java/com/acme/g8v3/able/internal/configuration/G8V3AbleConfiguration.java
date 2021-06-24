package com.acme.g8v3.able.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(
	id = "com.acme.g8v3.able.internal.configuration.G8V3AbleConfiguration",
	localization = "content/Language", name = "g8v3-able-configuration-name"
)
public interface G8V3AbleConfiguration {

	@Meta.AD(deflt="false", name="enable-advanced-settings", required = false)
	public boolean enableAdvancedSettings();

}