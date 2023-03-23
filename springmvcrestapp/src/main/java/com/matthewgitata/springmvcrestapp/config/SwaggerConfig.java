package com.matthewgitata.springmvcrestapp.config;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectory.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
    }
}