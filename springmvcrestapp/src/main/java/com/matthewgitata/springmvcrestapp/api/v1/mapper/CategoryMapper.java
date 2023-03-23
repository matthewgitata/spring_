package com.matthewgitata.springmvcrestapp.api.v1.mapper;

import com.matthewgitata.springmvcrestapp.api.v1.model.CategoryDTO;
import com.matthewgitata.springmvcrestapp.domain.Category;

/**
 * created by @matthewgitata on 23/03/2023.
 */
@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}