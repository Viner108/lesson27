package com.dmdev.lesson27;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFindExample {
    public static void main(String[] args) {
        String phoneNumber = "+375 (29) 898-12-13 dasffdf dvszA +375 (44) 548-11-10 " +
                " fsdfsvs +375 (25) 643-54-83 +375 (33) 781-32-33 DVX";
        String regex = "(?:\\+375)? ?\\((?<code>\\d{2})\\) ?(\\d{3})-(\\d{2})-(\\d{2})";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        StringBuilder stringBuilder=new StringBuilder();
        while (matcher.find()){
            String gr1 = matcher.group(2);
            String gr2 = matcher.group(3);
            String gr3 = matcher.group(4);
            matcher.appendReplacement(stringBuilder,"$2 $3 $4");
        }
        matcher.appendTail(stringBuilder);
        System.out.println(stringBuilder);
        System.out.println(phoneNumber.replaceAll(regex,"$2 - $3 - $4"));
    }
}
