package org.cloudcms.rest;

import org.cloudcms.bean.User;
import org.cloudcms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/user")
@Component
public class UserResource {

    @Autowired
    private UserService userService;

    /*@GET
    @Path("/getUserList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUserList() {
        return userService.getUserList();
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
