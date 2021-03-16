package com.acme.c6f7.web.internal.portlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(
	id = "com.acme.c6f7.web.internal.portlet.MessageDisplayConfiguration"
)
public interface MessageDisplayConfiguration {

	@Meta.AD(required = false)
	public String fontColor();

	@Meta.AD(required = false)
	public String fontFamily();

	@Meta.AD(required = false)
	public int fontSize();

}