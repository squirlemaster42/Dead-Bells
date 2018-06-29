package com.nerds.utils;

public class Utils {

    public static int parseInt(String str){
        try{
            return Integer.parseInt(str);
        }catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }
}
