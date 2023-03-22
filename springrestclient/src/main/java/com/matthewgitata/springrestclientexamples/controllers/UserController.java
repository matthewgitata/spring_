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

        MultiValueMap<String, String> map = serverWebExchange.getFormData().block();

        Integer limit = new Integer(map.get("limit").get(0));

        log.debug("Received limit value: " + limit);
        //default if null or zero
        if (limit == null || limit == 0) {
            log.debug("Setting limit to default of 10");
            limit = 10;
        }

        model.addAttribute("users", apiService.getUsers(limit));

        return "userlist";
    }
}