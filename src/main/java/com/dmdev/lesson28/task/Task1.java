package com.dmdev.lesson28.task;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla");
        System.out.println(car);
        System.out.println(insert(car));
    }

    private static String insert(Car car) {
        String string = "INSERT INTO %s.%s (%s) VAlUE (%s)";
        Table table = car.getClass().getAnnotation(Table.class);
        Field[] fields = car.getClass().getDeclaredFields();
        String fieldNames = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .map(field -> field.getAnnotation(Column.class))
                .map(Column::name)
                .collect(Collectors.joining(", "));
        String fieldValue = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .peek(field -> field.setAccessible(true))
                .map(field -> {
                    try {
                        return String.valueOf(field.get(car));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return "";
                    }
                })
                .map(value -> "'"+value+"'")
                .collect(Collectors.joining(", "));
        return String.format(string,table.schema(),table.value(),fieldNames,fieldValue);
    }
}
