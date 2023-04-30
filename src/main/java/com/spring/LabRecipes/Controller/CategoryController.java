package com.spring.LabRecipes.Controller;

import com.spring.LabRecipes.Model.Category;
import com.spring.LabRecipes.Model.Recipe;
import com.spring.LabRecipes.Repository.CategoryRepository;
import com.spring.LabRecipes.Repository.RecipeRepository;
import com.spring.LabRecipes.Service.CategoryService;
import com.spring.LabRecipes.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok().body(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(categoryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return ResponseEntity.created(null).body(categoryService.save(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
        if ( categoryService.existsById(id) ) {
            return ResponseEntity.ok().body(categoryService.update(category));
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable Long id) {
        if ( categoryService.existsById(id) ) {
            categoryService.delete(id);
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.status(406).build();
        }
    }
}
