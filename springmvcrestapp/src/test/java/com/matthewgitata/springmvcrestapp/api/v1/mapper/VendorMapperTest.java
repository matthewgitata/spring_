package com.matthewgitata.springmvcrestapp.api.v1.mapper;

import com.matthewgitata.springmvcrestapp.api.v1.model.VendorDTO;
import com.matthewgitata.springmvcrestapp.domain.Vendor;

import static org.junit.jupiter.api.Assertions.*;

/**
 * created by @matthewgitata on 23/03/2023.
 */
class VendorMapperTest {

    public static final String NAME = "someName";

    VendorMapper vendorMapper = VendorMapper.INSTANCE;

    @org.junit.jupiter.api.Test
    void vendorToVendorDTO() {
        //given
        Vendor vendor = new Vendor();
        vendor.setName(vendor);

        //when
        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);

        //then
        assertEquals(vendor.getName(), vendorDTO.getName())
    }

    @org.junit.jupiter.api.Test
    void vendorDTOtoVendor() {
        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);

        //when
        Vendor vendor = vendorMapper.vendorDTOtoVendor(vendorDTO);

        //then
        asserEquals(vendorDTO.getName(), vendor.getName());
    }
}