package com.acme.g8v3.internal.configuration.admin.display;

import com.acme.g8v3.internal.configuration.G8V3AbleConfiguration;

import com.liferay.configuration.admin.display.ConfigurationVisibilityController;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil;

import java.io.Serializable;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

@Component(
	property = "configuration.pid=com.acme.g8v3.internal.configuration.G8V3BakerConfiguration",
	service = ConfigurationVisibilityController.class
)

public class G8V3BakerConfigurationVisibilityController
	implements ConfigurationVisibilityController {

		@Override
		public boolean isVisible(
			ExtendedObjectClassDefinition.Scope scope, Serializable scopePK) {

			return !g8v3AbleConfiguration.hideAdvancedSettings();

		}

		@Activate
		@Modified
		protected void activate(Map<Object, Object> properties) {
		g8v3AbleConfiguration = ConfigurableUtil.createConfigurable(
				G8V3AbleConfiguration.class, properties);
		}

		@Reference
		private G8V3AbleConfiguration g8v3AbleConfiguration;

}