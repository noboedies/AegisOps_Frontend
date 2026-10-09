package com.tausif.services;

import com.tausif.beans.User;
import com.tausif.dto.UserLoginDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Value("${rest_webservice_url}")
    private String url;

    private RestTemplate restTemplate = new RestTemplate();

    public User register(User user) {
        String api="/user/register";
        HttpEntity<User> requestEntity = new HttpEntity<User>(user);
        ResponseEntity<User> u = restTemplate.exchange(url+api, HttpMethod.POST, requestEntity, User.class);
        return u.getBody();
    }



    public User checkLogin(UserLoginDto userLoginDto) {
        String api = "/user/login";
        HttpEntity<User> reEntity = new HttpEntity<User>(userLoginDto);
        ResponseEntity<User> u = restTemplate.exchange(url+api, HttpMethod.POST, reEntity, User.class);
        return u.getBody();
    }
}
