package org.cloudcms.service;

import org.cloudcms.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    final String SERVICE_NAME = "cloud-simple-service";

    public List<User> getUserList() {
        return restTemplate.getForObject("http://"+SERVICE_NAME+"/list", List.class);
    }
}
