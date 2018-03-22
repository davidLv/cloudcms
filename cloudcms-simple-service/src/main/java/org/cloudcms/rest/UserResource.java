package org.cloudcms.rest;

import org.cloudcms.bean.User;
import org.cloudcms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class UserResource {
    @Autowired
    private IUserService userService;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> list() {
        return userService.getAllUser();
    }
}
