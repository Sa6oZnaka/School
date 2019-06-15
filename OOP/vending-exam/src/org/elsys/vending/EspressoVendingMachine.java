package org.elsys.vending;
import java.util.*;

public class EspressoVendingMachine {

    private Map<String, Integer> containers;
    private int turnOvers;

    public EspressoVendingMachine(Collection<String> containers) {
        this.containers = new HashMap<>();
        for(String s: containers){
            this.containers.put(s, 5);
        }
        this.turnOvers = 0;
    }

    /*
     * Returns the current turnover from all the sells after last resupply of the 
     * vending machine.
     */
    public double getTurnover() {
        return turnOvers;
    }

    public void resupplyContainer(String ingredient) {
        containers.put(ingredient, 5);
    }

    public void resupply() {
        for(String s: getIngredientContainers()){
            this.containers.put(s, 5);
        }
        turnOvers = 0;
    }

    public boolean hasEnoughIngredientSupply(String ingredient, int amount) {
        return containers.get(ingredient) > amount;
    }

    public Collection<String> getIngredientContainers() {
        return containers.keySet();
    }
    
    public Integer getIngredientContainerCapacity(String ingredient) {
        return containers.get(ingredient);
    }

    public Integer getIngredientSupply(String ingredient) {
        return containers.get(ingredient);
    }

    public void useIngredient(String ingredient, int amount) {
        containers.put(ingredient, getIngredientSupply(ingredient) - amount);
    }

    public void brewRecipe(Recipe recipe) {
        useIngredient(recipe.getName(), 1);
        turnOvers ++;
    }
}
