package com.acme.z4h3.internal.configuration;

@Component(
	property = {
		"configuration.field.name=enabledClassNames",
		"configuration.pid=com.liferay.asset.auto.tagger.google.cloud.natural.language.internal.configuration.GCloudNaturalLanguageAssetAutoTaggerCompanyConfiguration",
		"configuration.pid=com.liferay.asset.auto.tagger.opennlp.internal.configuration.OpenNLPDocumentAssetAutoTaggerCompanyConfiguration"
	},
	service = ConfigurationFieldOptionsProvider.class
)

public class Z4H3ConfigurationFieldOptionsProvider implements ConfigurationFieldOptionsProvider {

	public List<Option> getOptions() {
		List<AssetRendererFactory<?>> assetRendererFactories =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactories(
				CompanyThreadLocal.getCompanyId());

		Stream<AssetRendererFactory<?>> stream =
			assetRendererFactories.stream();

		return stream.filter(
			assetRendererFactory -> {
				TextExtractor textExtractor =
					_textExtractorTracker.getTextExtractor(
						assetRendererFactory.getClassName());

				return textExtractor != null;
			}
		).map(
			assetRendererFactory -> new Option() {

				@Override
				public String getLabel(Locale locale) {
					return assetRendererFactory.getTypeName(locale);
				}

				@Override
				public String getValue() {
					return assetRendererFactory.getClassName();
				}

			}
		).collect(
			Collectors.toList()
		);
	}

}