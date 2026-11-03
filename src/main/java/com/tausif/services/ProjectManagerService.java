package com.tausif.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProjectManagerService {

    @Value("${rest_webservice_url}")
    private String url;

    private RestTemplate restTemplate = new RestTemplate();
}
