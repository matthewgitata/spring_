package com.matthewgitata.petclinic.services.springdatajpa;

import com.matthewgitata.petclinic.model.Owner;
import com.matthewgitata.petclinic.repositories.OwnerRepository;
import com.matthewgitata.petclinic.repositories.PetRepository;
import com.matthewgitata.petclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        returnOwner = Owner.build().id(1L).lastName(LAST_NAME).build();
    }

    @org.junit.jupiter.api.Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @org.junit.jupiter.api.Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1L).build());
        returnOwnersSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);

        assertEquals(2, owners.size());
    }

    @org.junit.jupiter.api.Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    @org.junit.jupiter.api.Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

    @org.junit.jupiter.api.Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @org.junit.jupiter.api.Test
    void delete() {
        verify(ownerRepository, times(1)).delete(any);
    }

    @org.junit.jupiter.api.Test
    void deleteById() {
        verify(ownerRepository).deleteById(anyLong());
    }
}