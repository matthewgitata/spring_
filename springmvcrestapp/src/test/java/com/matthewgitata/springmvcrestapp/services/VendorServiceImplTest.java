package com.matthewgitata.springmvcrestapp.services;

import com.matthewgitata.springmvcrestapp.api.v1.mapper.VendorMapper;
import com.matthewgitata.springmvcrestapp.api.v1.model.VendorDTO;
import com.matthewgitata.springmvcrestapp.api.v1.model.VendorListDTO;
import com.matthewgitata.springmvcrestapp.domain.Vendor;
import com.matthewgitata.springmvcrestapp.repositories.VendorRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class VendorServiceImplTest {

    @Mock
    VendorRepository vendorRepository;

    VendorService vendorService;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        vendorService = new VendorServiceImpl(VendorMapper.INSTANCE, vendorRepository);
    }

    @org.junit.jupiter.api.Test
    public void getVendorById() throws Exception {
        //given
        Vendor vendor = getVendor1();

        //mockito BDD syntax
        given(vendorRepository.findById(anyLong())).willReturn(Optional.of(vendor));

        //when
        VendorDTO vendorDTO = vendorService.getVendorById(1L);

        //then
        then(vendorRepository).should(times(1)).findById(anyLong());

        //JUnit Assert that with matchers
        assertThat(vendorDTO.getName(), is(equalTo(NAME_1)));
    }

    @org.junit.jupiter.api.Test
    public void getVendorByIdNotFound() throws Exception {
        //given
        given(vendorRepository.findById(anyLong())).willReturn(Optional.empty());
        //when
        VendorDTO vendorDTO = vendorService.getVendorById(1L);
        //then
        then(vendorRepository).should(times(1)).findById(anyLong());
    }

    @org.junit.jupiter.api.Test
    public void getAllVendors() throws Exception {
        //given
        List<Vendor> vendors = Arrays.asList(getVendor1(), getVendor2());

        //when
        VendorListDTO vendorListDTO = vendorService.getAllVendors();

        //then
        then(vendorRepository).should(times(1)).findAll();
        assertThat(vendorListDTO.getVendors().size(), is(equalTo(2)));
    }

    @org.junit.jupiter.api.Test
    public void createNewVendor() throws Exception {
        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME_1);

        Vendor vendor = getVendor1();

        given(vendorRepository.save(any(Vendor.class))).willReturn(vendor);

        //when
        VendorDTO savedVendorDTO = vendorService.createNewVendor(vendorDTO);

        //then
        //'should' defaults to times = 1
        then(vendorRepository).should().save(any(Vendor.class));
        assertThat(savedVendorDTO.getVendorUrl(), containsString("1"));
    }

    @org.junit.jupiter.api.Test
    public void saveVendorByDTO() throws Exception {
        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME_1);

        Vendor vendor = getVendor1();

        given(vendorRepository.save(any(Vendor.class))).willReturn(vendor);

        //when
        VendorDTO savedVendorDTO = vendorService.saveVendorByDTO(ID_1, vendorDTO);

        //then
        //'should' default to times = 1
        then(vendorRepository).should().save(any(Vendor.class));
        assertThat(savedVendorDTO.getVendorUrl(), containsString("1"));
    }

    @org.junit.jupiter.api.Test
    void patchVendor() {
    }

    @org.junit.jupiter.api.Test
    void deleteVendorById() {
    }
}