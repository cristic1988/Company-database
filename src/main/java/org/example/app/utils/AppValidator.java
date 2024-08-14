package org.example.app.utils;

public class AppValidator {

    public final static String ID_RGX = "^[1-9]$";


    public static boolean isIdValid(String id) {
        if (id != null)
            return id.isEmpty() || !id.matches(ID_RGX);
        return false;
    }

 }
