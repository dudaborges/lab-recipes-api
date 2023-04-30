package com.spring.LabRecipes.Service;

import com.spring.LabRecipes.Model.Category;
import com.spring.LabRecipes.Model.Recipe;
import com.spring.LabRecipes.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public Recipe findById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.orElse(null);
    }

    public List<Recipe> findRecipeCategory() {
        return recipeRepository.findRecipeCategory();
    }

    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public boolean existsById(Long id) {
        return recipeRepository.existsById(id);
    }

    public Recipe update(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void delete(Long id) {
        Recipe recipe = findById(id);
        if( recipe != null ) {
            recipeRepository.delete(recipe);
        }
    }

}
