package org.cloudcms.rest;

import org.cloudcms.bean.User;
import org.cloudcms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.web.client.HttpMessageConverterExtractor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/user")
public class UserResource {
    @Autowired
    private IUserService userService;

    /*@GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> list() {
        return userService.getAllUser();
    }*/

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map list() {
        Map map = new HashMap();
        map.put("id", "1");
        map.put("username", "admin");
        return map;
    }
}
