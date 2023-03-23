package com.matthewgitata.springmvcrestapp.api.v1.model;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDTO {
    private String name;

    @JsonProperty("vendor_url")
    private String vendorUrl;
}