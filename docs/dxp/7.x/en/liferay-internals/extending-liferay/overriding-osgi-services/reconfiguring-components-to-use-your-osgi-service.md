# Reconfiguring Components to Use Your OSGi Service

In many cases, assigning your [custom service (service)](./creating-a-custom-osgi-service.md) a higher ranking convinces components to unbind from their current service and bind to yours. In other cases, components keep using their current service. Why is that? And how do you make components adopt your service? The component's [service reference policy option](./examining-an-osgi-service-to-override.md) is the key to determining the service.

Here are the policy options:

`greedy`: The component uses the matching, highest ranking service as soon as it's available. 

`reluctant`: The component uses the matching, highest ranking service available in the following events:

* the component is (re)activated
* the component’s existing referenced service becomes unavailable
* the component’s reference is modified so that it no longer matches the existing bound service

In short, references with greedy policy options adopt your higher ranking service right away, while ones with reluctant policy options require particular events. What’s great is that Liferay DXP’s Configuration Admin lets you use configuration files (config files) or the API to swap in service reference changes on the fly. Here you’ll use a config file to reconfigure a service reference to use your custom service immediately.

This article uses example modules `override-my-service-reference` and `overriding-service-reference` to demonstrate reconfiguring a service reference, binding the component to a different service. you can apply the steps below to configure your own customization.

* `override-my-service-reference`: This module's portlet component `OverrideMyServiceReferencePortlet`'s field  `_someService` references a service of type `SomeService`. The reference's policy is static and reluctant. By default, it binds to an implementation called `SomeServiceImpl`. 

* `overriding-service-reference`: Provides a custom `SomeService` implementation called `CustomServiceImpl`. The module's configuration file overrides `OverrideMyServiceReferencePortlet`'s `SomeService` reference so that it binds to `CustomServiceImpl`. 

## Run an Example

To get an example up and running on your instance of Liferay DXP,

1. Start Liferay DXP. If you don't already have a docker container, use

    ```bash
    docker run -it -p 8080:8080 [$LIFERAY_LEARN_DXP_DOCKER_IMAGE$]
    ```
    f you're running a different Liferay Portal CE version or Liferay DXP, adjust the above command accordingly.

1. Download and unzip [Acme Reconfiguring Components](./liferay-m1t1.zip).

    ```bash
    curl https://learn.liferay.com/dxp/7.x/en/liferay-internals/extending-liferay/overriding-osgi-services/liferay-m1t1.zip -O
    ```

    ```bash
    unzip liferay-m1t1.zip
    ```

1. From the module root, build and deploy.

    ```bash
    ./gradlew deploy -Ddeploy.docker.container.id=$(docker ps -lq)
    ```

    ```note::
       This command is the same as copying the deployed jars to /opt/liferay/osgi/modules on the Docker container.
    ```

1. Confirm the deployment in the Liferay Docker container console.

    ```bash
    STARTED com.acme.m1t1.impl_1.0.0 [1009]
    ```

You're ready to reconfigure a component's service reference to target your custom service.

## Reconfiguring the Service Reference

Liferay DXP’s Configuration Admin lets you use configuration files to swap in service references on the fly.