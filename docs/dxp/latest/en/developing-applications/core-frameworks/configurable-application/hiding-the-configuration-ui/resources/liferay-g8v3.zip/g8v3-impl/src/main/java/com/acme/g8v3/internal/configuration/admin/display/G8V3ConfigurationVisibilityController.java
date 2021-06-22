package com.acme.g8v3.internal.configuration.admin.display;

import com.liferay.configuration.admin.display.ConfigurationVisibilityController;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import java.io.Serializable;

import org.osgi.service.component.annotations.Component;

@Component(
	property = "configuration.pid=com.acme.g8v3.internal.configuration.G8V3Configuration",
	service = ConfigurationVisibilityController.class
)

public class G8V3ConfigurationVisibilityController
	implements ConfigurationVisibilityController {

		@Override
		public boolean isVisible(
			ExtendedObjectClassDefinition.Scope scope, Serializable scopePK) {

			return scope.equals(ExtendedObjectClassDefinition.Scope.COMPANY);

		}

}