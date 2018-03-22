package org.cloudcms.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import java.util.HashMap;
import java.util.Map;

public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        /*Map<String, Object> property = new HashMap<String, Object>();
        property.put("jersey.config.server.mvc.encoding.freemarker", "UTF-8");
        property.put("jersey.config.server.mvc.templateBasePath.freemarker", "static");
        addProperties(property).register(FreemarkerMvcFeature.class);*/
        register(RequestContextFilter.class);
        //register(UserResource.class);
        //config restful package
        packages("org.cloudcms.rest");
    }
}
