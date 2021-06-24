package com.acme.g8v3.baker.internal.configuration.admin.display;

import com.acme.g8v3.able.internal.configuration.G8V3AbleConfiguration;

import com.liferay.configuration.admin.display.ConfigurationVisibilityController;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import java.io.Serializable;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	property = "configuration.pid=com.acme.g8v3.baker.internal.configuration.G8V3BakerConfiguration",
	service = ConfigurationVisibilityController.class
)

public class G8V3BakerConfigurationVisibilityController
	implements ConfigurationVisibilityController {

		@Override
		public boolean isVisible(
			ExtendedObjectClassDefinition.Scope scope, Serializable scopePK) {

			return g8v3AbleConfiguration.enableAdvancedSettings();

		}

		@Reference
		private G8V3AbleConfiguration g8v3AbleConfiguration;

}