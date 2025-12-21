package com.yummerz.yummerz;

import com.yummerz.yummerz.recipe.Recipe;
import com.yummerz.yummerz.recipe.RecipeRepository;
import com.yummerz.yummerz.recipe.RecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) 
public class RecipeServiceTest {

    @Mock 
    private RecipeRepository recipeRepository;

    @InjectMocks 
    private RecipeService recipeService;

    // get recipe test

    @Test
    @DisplayName("Gets recipes")
    void getAllRecipes_NoSearchTerm_ReturnsAll() {
        Recipe r1 = new Recipe(); r1.setName("Palačinke");
        Recipe r2 = new Recipe(); r2.setName("Pizza");
        when(recipeRepository.findAll()).thenReturn(Arrays.asList(r1, r2));

        List<Recipe> result = recipeService.getAllRecipes(Optional.empty());

        Assertions.assertEquals(2, result.size());
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Mora vrniti filtrirane recepte, ko je podan iskalni niz")
    void getAllRecipes_WithSearchTerm_ReturnsFiltered() {
        String query = "Test";
        Recipe r1 = new Recipe(); r1.setName("Test Recipe");
        when(recipeRepository.findByNameContainingIgnoreCaseOrIngredientsContainingIgnoreCaseOrInstructionsContainingIgnoreCase(query, query, query))
                .thenReturn(List.of(r1));

        List<Recipe> result = recipeService.getAllRecipes(Optional.of("Test"));

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Test Recipe", result.get(0).getName());
    }

    // md import test

    @Test
    @DisplayName("Markdown import sucess")
    void importRecipeFromMarkdown_ValidFile_SavesRecipe() throws IOException {
        String markdownContent = "# Super Torta\n\n## Ingredients\n- Moka\n- Sladkor\n\n## Instructions\nZmešaj in peci.";
        MockMultipartFile file = new MockMultipartFile(
                "file", 
                "test.md", 
                "text/markdown", 
                markdownContent.getBytes()
        );

        recipeService.importRecipeFromMarkdown(file);

        verify(recipeRepository, times(1)).save(argThat(recipe -> 
            recipe.getName().equals("Super Torta") &&
            recipe.getIngredients().contains("Moka") &&
            recipe.getInstructions().equals("Zmešaj in peci.")
        ));
    }

    @Test
    @DisplayName("returns empty on non existing id (bad)")
    void updateRecipe_NonExistentId_ReturnsEmpty() {
        Long invalidId = 99L;
        Recipe newData = new Recipe();
        when(recipeRepository.findById(invalidId)).thenReturn(Optional.empty());

        Optional<Recipe> result = recipeService.updateRecipe(invalidId, newData);

        Assertions.assertTrue(result.isEmpty());
        verify(recipeRepository, never()).save(any()); // Preverimo, da se save NI poklical
    }

    // Delete test

    @Test
    @DisplayName("return true on delete")
    void deleteRecipe_ExistingId_ReturnsTrue() {
        Long id = 1L;
        when(recipeRepository.existsById(id)).thenReturn(true);

        boolean deleted = recipeService.deleteRecipe(id);

        Assertions.assertTrue(deleted);
        verify(recipeRepository).deleteById(id);
    }
}
