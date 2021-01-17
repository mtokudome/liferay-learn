package override.my.service.reference.service.impl;

import override.my.service.reference.service.api.SomeService;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		service = SomeService.class
)
public class SomeServiceImpl implements SomeService {

	@Override
	public String doSomething() {

		return this.getClass().getName();
	}

}
