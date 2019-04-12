package org.elsys.cardgame.api;


import java.util.Objects;

public class OperationImplement implements Operation{


    private String name;

    public OperationImplement(String string) {
        this.name = string;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {

    }

}
