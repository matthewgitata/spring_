package com.matthewgitata.springrestclientexamples.controllers;

import com.matthewgitata.springrestclientexamples.services.ApiService;

/**
 * created by @matthewgitata on 22/03/2023.
 */
@Slf4j
@Controller
public class UserController {
    private ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"", "/", "/index"})
    public String index() {
        return "index";
    }

    @PostMapping("/users")
    public String formPost(Model model, ServerWebExchange serverWebExchange) {

        model.addAttribute("users",
                apiService
                        .getUsers(serverWebExchange
                                .getFormData()
                                .map(data -> new Integer(data.getFirst("limit")))));

        return "userlist";
    }
}