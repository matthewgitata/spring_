package com.matthewgitata.springmvcrestapp.api.v1.model;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@Data
public class CustomerDTO {

    @ApiModelProperty(value = "This is the first name", required = true)
    private String firstName;
    private String lastName;

    @JsonProperty("customer_url")
    private String customerUrl;
}