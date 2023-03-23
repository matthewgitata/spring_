package com.matthewgitata.springmvcrestapp.config;

import java.util.ArrayList;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {//} extends WebMvcConfigurationSupport {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectory.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        Contact contact = new Contact("Matthew Gitata", "https://www.matthewgitata.com/about/", "no-email@gmail.com");
        return new ApiInfo(
                "Fruit Shop API",
                "An API for a Fruit Shop",
                "1.0",
                "Terms of Service: blah",
                contact,
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }

//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
}