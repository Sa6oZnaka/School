package org.elsys.vending;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EspressoVendingMachine {

    private List<String> ingrediantContainer;
    private List<Double> weights;

    private Integer sales;
    private double maxWeight;
    private double collectedMoney;

    /*
     * Collection of all ingredients supported by the vending machine.
     */
    public EspressoVendingMachine(Collection<String> containers) {
        this.ingrediantContainer = (List<String>) containers;
        this.maxWeight = 5;
        this.collectedMoney = 0;
        this.weights = new ArrayList<>();
        for(int i =0; i < containers.size(); i ++){
            weights.add(5d);
        }
        this.sales = 0;
    }

    /*
     * Returns the current turnover from all the sells after last resupply of the 
     * vending machine.
     */
    public double getTurnover() {
        return sales;
    }

    public void resupplyContainer(String ingredient) {
        for(int i = 0; i < ingrediantContainer.size(); i++){
            if(ingrediantContainer.get(i).equals(ingredient)){
                weights.set(i, maxWeight);
            }
        }
    }

    public void resupply() {
        for(int i = 0; i < ingrediantContainer.size(); i ++){
            weights.set(i, maxWeight);
        }
        sales = 0;
    }

    public boolean hasEnoughIngredientSupply(String ingredient, int amount) {
        for(int i = 0; i < ingrediantContainer.size(); i ++){
            if(ingrediantContainer.get(i).equals(ingredient) && weights.get(i) >= amount){
                return true;
            }
        }
    	return false;
    }

    public Collection<String> getIngredientContainers() {
        return ingrediantContainer;
    }
    
    public Double getIngredientContainerCapacity(String ingredient) {
        for(int i = 0; i < ingrediantContainer.size(); i++){
            if(ingrediantContainer.get(i).equals(ingredient)){
                return weights.get(i);
            }
        }
        throw new RuntimeException();
    }

    public Double getIngredientSupply(String ingredient) {
        for(int i = 0; i < ingrediantContainer.size(); i++){
            if(ingrediantContainer.get(i).equals(ingredient)){
                return weights.get(i);
            }
        }
        throw new RuntimeException();
    }

    public void useIngredient(String ingredient, int amount) {
        if(ingrediantContainer.stream().anyMatch(i -> i.equals(ingredient))){
            throw new RuntimeException();
        }
        ingrediantContainer.add(ingredient);
        weights.add((double) amount);
    }

    public void brewRecipe(Recipe recipe) {
        //if(ingrediantContainer.stream().anyMatch(i -> i.equals(recipe.getName()))){
        for(int i = 0; i < ingrediantContainer.size(); i ++){
            weights.set(i, weights.get(i) - 1);
            collectedMoney += recipe.getPrice();
            sales ++;
        }
    }
}
