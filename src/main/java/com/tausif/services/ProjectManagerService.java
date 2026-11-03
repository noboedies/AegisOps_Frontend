package com.tausif.services;

import com.tausif.beans.ProjectManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ProjectManagerService {

    @Value("${rest_webservice_url}")
    private String url;

    private RestTemplate restTemplate = new RestTemplate();

    public ProjectManager login(String username, String password) {
        String api = "/pm/login";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username", username);
        map.add("password", password);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<ProjectManager> res = restTemplate.exchange(url+api, HttpMethod.POST, request, ProjectManager.class);
        return res.getBody();
    }
}
