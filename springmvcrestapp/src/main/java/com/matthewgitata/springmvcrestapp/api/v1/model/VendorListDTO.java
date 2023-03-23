package com.matthewgitata.springmvcrestapp.api.v1.model;

import java.util.List;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorListDTO {
    List<VendorDTO> vendors;
}