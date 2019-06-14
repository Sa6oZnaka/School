package org.elsys.vending;
import java.util.*;

public class EspressoVendingMachine {

    private Map<String, Integer> containers = new HashMap<>();

    public EspressoVendingMachine(Collection<String> containers) {
        containers.addAll(containers);
    }

    /*
     * Returns the current turnover from all the sells after last resupply of the 
     * vending machine.
     */
    public double getTurnover() {

    }

    public void resupplyContainer(String ingredient) {
        containers.put(ingredient, 5);
    }

    public void resupply() {

    }

    public boolean hasEnoughIngredientSupply(String ingredient, int amount) {
        return containers.get(ingredient) > amount;
    }

    public Collection<String> getIngredientContainers() {
        containers.keySet();
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

    }
}
