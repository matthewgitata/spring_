package com.matthewgitata.recipeapp.domain;

import java.math.BigDecimal;

/**
 * created by @matthewgitata on 18/03/2023
 */
@Entity
public class Ingredient {
    @Id
    @GenerateValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
    //private UnitOfMeasure uom
    @ManyToOne
    private Recipe recipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}