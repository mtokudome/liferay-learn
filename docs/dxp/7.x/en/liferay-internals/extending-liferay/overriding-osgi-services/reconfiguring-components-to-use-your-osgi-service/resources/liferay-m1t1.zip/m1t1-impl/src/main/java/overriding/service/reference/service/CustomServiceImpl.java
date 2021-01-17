package overriding.service.reference.service;

import override.my.service.reference.service.api.SomeService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = SomeService.class
)
public class CustomServiceImpl implements SomeService {

	@Override
	public String doSomething() {

		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName());
		sb.append(", which delegates to ");
		sb.append(_defaultService.doSomething());

		return sb.toString();
	}

	@Reference  (
		unbind = "-",
		target = "(component.name=override.my.service.reference.service.impl.SomeServiceImpl)"
	)
	private SomeService _defaultService;
}
