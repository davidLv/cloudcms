package org.cloudcms.controller;

import javax.ws.rs.Path;

@Path("/admin")
public class AdminLoginController {
    @Path("index")
    public String indexAction() {
        return "";
    }
}
