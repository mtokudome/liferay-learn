package com.acme.p1z2.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
	category = "p1z2", scope = ExtendedObjectClassDefinition.Scope.COMPANY
)
@Meta.OCD(
	id = "com.acme.p1z2.web.internal.configuration.P1Z2WebConfiguration",
	localization = "content/Language", name = "p1z2-configuration-name"
)
public interface P1Z2WebConfiguration {

	@Meta.AD(
		deflt = "apple", name = "favorite-fruit",
		optionLabels = {"%apple", "%banana", "%orange"},
		optionValues = {"apple", "banana", "orange"}, required = false
	)
	public String favoriteFruit();

}