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

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUsers(Integer limit) {
        UserData userData = restTemplate.getForObject("http://apifaketory.com/api/user?limit=" + limit, UserData.class);
        return userData.getData();
    }
}