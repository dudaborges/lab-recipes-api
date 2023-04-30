package com.spring.LabRecipes.Controller;

import com.spring.LabRecipes.Model.Category;
import com.spring.LabRecipes.Model.Recipe;
import com.spring.LabRecipes.Repository.RecipeRepository;
import com.spring.LabRecipes.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping
    public ResponseEntity<List<Recipe>> findAll() {
        return ResponseEntity.ok().body(recipeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(recipeService.findById(id));
    }

    @GetMapping("/recipeCategory")
    public ResponseEntity<List<Recipe>> findRecipeCategory() {
        return ResponseEntity.ok().body(recipeService.findRecipeCategory());
    }

    @PostMapping
    public ResponseEntity<Recipe> save(@RequestBody Recipe recipe) {
        return ResponseEntity.created(null).body(recipeService.save(recipe));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> update(@PathVariable Long id, @RequestBody Recipe recipe) {
        if ( recipeService.existsById(id) ) {
            return ResponseEntity.ok().body(recipeService.update(recipe));
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> delete(@PathVariable Long id) {
        if ( recipeService.existsById(id) ) {
            recipeService.delete(id);
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.status(406).build();
        }
    }
}
