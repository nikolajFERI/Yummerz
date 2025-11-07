package com.yummerz.yummerz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipes(Optional<String> searchTerm) {
        if (searchTerm.isPresent() && !searchTerm.get().isBlank()) {
            String query = searchTerm.get();
            return recipeRepository.findByNameContainingIgnoreCaseOrIngredientsContainingIgnoreCaseOrInstructionsContainingIgnoreCase(query, query, query);
        } else {
            return recipeRepository.findAll();
        }
    }

    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    public Optional<Recipe> updateRecipe(Long id, Recipe recipeDetails) {
        return recipeRepository.findById(id)
                .map(existingRecipe -> {
                    existingRecipe.setName(recipeDetails.getName());
                    existingRecipe.setIngredients(recipeDetails.getIngredients());
                    existingRecipe.setInstructions(recipeDetails.getInstructions());
                    return recipeRepository.save(existingRecipe);
                });
    }

    public boolean deleteRecipe(Long id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}