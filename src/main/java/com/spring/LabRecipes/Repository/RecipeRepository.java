package com.spring.LabRecipes.Repository;

import com.spring.LabRecipes.Model.Category;
import com.spring.LabRecipes.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("select recipe from Recipe recipe " +
            "where recipe.category is not null")
    public List<Recipe> findRecipeCategory();
}
