package com.tausif.services;

import com.tausif.beans.ProjectManager;
import com.tausif.beans.User;
import com.tausif.dto.UserLoginDto;
import com.tausif.dto.UserResDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

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

    public User checkLogin(String username, String password) {
        String api = "/user/login";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("username", username);
        body.add("password", password);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);
        ResponseEntity<User> res = restTemplate.exchange(url+api, HttpMethod.POST, request, User.class);
        return res.getBody();
    }

    public ProjectManager registerPm(ProjectManager pm) {
        return null;
    }
}
