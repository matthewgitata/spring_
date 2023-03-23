package com.matthewgitata.springmvcrestapp.api.v1.mapper;

import com.matthewgitata.springmvcrestapp.api.v1.model.VendorDTO;
import com.matthewgitata.springmvcrestapp.domain.Vendor;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@Mapper
public interface VendorMapper {
    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    VendorDTO vendorToVendorDTO(Vendor vendor);

    Vendor vendorDTOtoVendor(VendorDTO vendorDTO);
}