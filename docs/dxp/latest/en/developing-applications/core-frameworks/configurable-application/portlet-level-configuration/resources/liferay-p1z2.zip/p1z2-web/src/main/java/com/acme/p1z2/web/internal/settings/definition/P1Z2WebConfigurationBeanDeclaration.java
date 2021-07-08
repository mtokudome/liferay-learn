package com.acme.p1z2.web.internal.settings.definition;

import com.acme.p1z2.web.internal.configuration.P1Z2WebConfiguration;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

@Component(service = ConfigurationBeanDeclaration.class)
public class P1Z2WebConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return P1Z2WebConfiguration.class;
	}

}