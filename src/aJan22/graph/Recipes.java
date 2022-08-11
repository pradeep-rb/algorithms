package aJan22.graph;

import java.util.*;
import java.util.stream.Collectors;

//2115
//https://poitevinpm.medium.com/leetcode-2115-find-all-possible-recipes-from-given-supplies-4f6d50958eaf
/*
    revise:
        The usage of two boolean arrays : one to check if the a node has already bene visited to prevent loops
        another to cache the result.
        If a node has already been visited, directly return the cached answer. if(visited[i]) return validRecipe[i];

 */

public class Recipes {
    List<String> ans = new ArrayList<>();
    Set<String> supplySet = new HashSet<>();
    //map of recipes to indices.
    Map<String, Integer> recipeMap = new HashMap<>();
    List<List<String>> ingredients;
    boolean[] validrecipe;
    boolean[] visited;


    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        supplySet = Arrays.stream(supplies).collect(Collectors.toSet());
        this.ingredients = ingredients;
        validrecipe = new boolean[recipes.length];
        visited = new boolean[recipes.length];

        for (int i = 0; i < recipes.length; i++) recipeMap.put(recipes[i], i);
        for (int i = 0; i < recipes.length; i++) {
            if(exploreRecipe(i)) ans.add(recipes[i]);
        }
        return ans;
    }

    private boolean exploreRecipe(int i) {
        if(visited[i]) return validrecipe[i];
        visited[i] = true; // this line prevents loops and TLE
        for (String ingredient: ingredients.get(i)) {
            if(!exploreIngredient(ingredient)) return validrecipe[i] = false;
        }
        return validrecipe[i] = true;
    }

    private boolean exploreIngredient(String ingredient) {
        if(supplySet.contains(ingredient)) return true;
        else if( recipeMap.containsKey(ingredient)) {
            return exploreRecipe(recipeMap.get(ingredient));
        }
        return false;
    }

}
