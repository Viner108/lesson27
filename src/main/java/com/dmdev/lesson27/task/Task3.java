package com.dmdev.lesson27.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        String string ="<p id=\"21\">drfgd</p>" +
                "<t>fdsfddd" +
                "<p name=\"Mama\">jjyyd</p>" +
                "<h>hjmhg</h>" +
                "<j>esrjhd</j>" +
                "dfghdrhtsr";
        String regex="(<p .+?>)(.+?</p>)";
        System.out.println(string.replaceAll(regex,"<p>$2"));
    }
}
