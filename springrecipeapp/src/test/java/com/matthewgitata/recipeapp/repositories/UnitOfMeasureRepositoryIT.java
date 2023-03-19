package com.matthewgitata.recipeapp.repositories;

import com.matthewgitata.recipeapp.domain.UnitOfMeasure;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * created by @matthewgitata on 19/03/2023
 */
@RunWith(SpringRunner.class)
@DatJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowire
    UnitOfMeasureRepository unitOfMeasureRepository;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception {
    }

    @org.junit.jupiter.api.Test
    void findByDescription() throws Exception {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        asserEquals("Teaspoon", uomOptional.get().getDescription());
    }

    @org.junit.jupiter.api.Test
    void findByDescriptionCup() throws Exception {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
        asserEquals("Cup", uomOptional.get().getDescription());
    }
}