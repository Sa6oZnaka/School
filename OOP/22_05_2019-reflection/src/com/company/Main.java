package com.company;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static String serialize(Object obj){


        StringBuffer str = new StringBuffer();

        str.append(String.format("%s\n", obj.getClass().getName()));

        Arrays.stream(obj.getClass().getDeclaredFields()).forEach(field -> {
            String name = field.getName(), value = field.get(obj).toString();
            str.append(String.format("%s=%s\n", name , value));

        });

        return str.toString();
    }

    public static void main(String[] args) {

        Bill bill = new Bill(10);
        Class <? extends Bill> aClass = bill.getClass();
        System.out.println(aClass.getName());
        for(Class<?> aClass1 : aClass.getSuperclass().getInterfaces()){

        }

        for(Constructor<?> constructor : aClass.getDeclaredConstructors()){
            System.out.println(constructor);
        }

        for(Field field : aClass.getFields()){
            System.out.println(field);
        }

        for(Method method : aClass.getMethods()){
            System.out.println(method);
        }

        Method method;
        try {
            method = aClass.getDeclaredMethod("getValue");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
