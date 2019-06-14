package org.elsys.vending;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Recipe {

    private String name;
    private double price;
    private List<Recipe> containings = new ArrayList<>();

    public Recipe(String name, Integer price) {
        if(price < 0){
            throw new RuntimeException();
        }
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
    	return price;
    }
    
    public String getName() {
    	return name;
    }

    /*
     * Should add an ingredient into the recipe. If given ingredient is added
     * twice a RuntimeException should be thrown.
     */
    public void addIngredient(String name, int amount) {
        if(containings.stream().anyMatch(c -> c.getName().equals(name))){
            throw new RuntimeException();
        }
        containings.add(new Recipe(name, amount));
    }

    /*
     * Should return a copy of the ingredients in the recipe.
     */
    public Map<String, Double> getIngredients() {
        return containings.stream().collect(Collectors.toMap(Recipe::getName, Recipe::getPrice));
    }
}
