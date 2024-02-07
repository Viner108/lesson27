package com.dmdev.lesson27.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    public static void main(String[] args) {
        String string="df sjkdkfj slldl 0xFA lksfj 0X8F jdsl15 ";
        String regex = "\\s0[Xx][0-9A-F][0-9A-F]\\s";
        Pattern pattern =Pattern.compile(regex);
        Matcher matcher=pattern.matcher(string);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }

}
