package com.matthewgitata.springrestclientexamples.services;

import com.matthewgitata.api.domain.User;
import com.matthewgitata.api.domain.UserData;

import java.util.List;

/**
 * created by @matthewgitata on 22/03/2023.
 */
@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;

    private final String api_url;

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
    }

    @Override
    public List<User> getUsers(Integer limit) {

        UriComponentsBuilder uriBuilder = UriComponentBuilder
                .fromUriString(api_url)
                .queryParam("limit", limit);

        UserData userData = restTemplate.getForObject(uriBuilder.toUriString(), UserData.class);
        return userData.getData();
    }
}