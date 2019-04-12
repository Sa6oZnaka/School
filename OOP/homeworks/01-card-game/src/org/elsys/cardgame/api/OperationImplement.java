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
    public void execute(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationImplement that = (OperationImplement) o;
        return Objects.equals(name, that.name);
    }

}
