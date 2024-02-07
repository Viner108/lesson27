package com.dmdev.lesson27.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        String email="and@mail.com";
        String regex = "[a-zA-Z]\\w*@\\w{3,}\\.(org|com)";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(email);
        System.out.println(matcher.matches());
    }
}
