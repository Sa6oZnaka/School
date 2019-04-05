package org.elsys.cardgame.api;

public class BasicOperation implements Operation{


    private String name;

    public BasicOperation(String string) {
        this.name = string;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        // TODO
    }

}
