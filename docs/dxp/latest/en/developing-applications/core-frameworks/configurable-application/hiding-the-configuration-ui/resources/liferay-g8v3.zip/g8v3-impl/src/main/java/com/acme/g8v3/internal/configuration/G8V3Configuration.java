package com.acme.g8v3.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
	category = "g8v3", scope = ExtendedObjectClassDefinition.Scope.COMPANY
)

@Meta.OCD(
	id = "com.acme.g8v3.internal.configuration.G8V3Configuration",
	localization = "content/Language", name = "g8v3-configuration-name"
)
public interface G8V3Configuration {

	@Meta.AD(required = false)
	public String text();

}