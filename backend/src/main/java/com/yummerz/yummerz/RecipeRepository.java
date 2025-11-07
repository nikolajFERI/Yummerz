package com.yummerz.yummerz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByNameContainingIgnoreCaseOrIngredientsContainingIgnoreCaseOrInstructionsContainingIgnoreCase(String name, String ingredients, String instructions);
}
