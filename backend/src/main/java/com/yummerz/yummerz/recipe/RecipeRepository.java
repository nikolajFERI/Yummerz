package com.yummerz.yummerz.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByNameContainingIgnoreCaseOrIngredientsContainingIgnoreCaseOrInstructionsContainingIgnoreCase(String name, String ingredients, String instructions);
    @Query("SELECT r FROM Recipe r WHERE r.owner = :owner AND " +
            "(LOWER(r.name) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
            "LOWER(r.ingredients) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
            "LOWER(r.instructions) LIKE LOWER(CONCAT('%', :query, '%')))")
    List<Recipe> searchMyRecipes(String query, String owner);

    List<Recipe> findAllByOwner(String owner);
}
