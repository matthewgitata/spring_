package com.matthewgitata.springdi.services;

/**
 * created by @matthewgitata on 16/03/2023
 */
@Profile("EN")
@Service("i18nService")
public class I18nEnglishService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}