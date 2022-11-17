package com.common.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyMd5 {

    public final  static  String MY_SALT="biqi is best";

    public static  String getMd5(String str){
        MessageDigest md =null;
        try {
            md = MessageDigest.getInstance("MD5");
            String temp = str+MY_SALT;
            md.update(temp.getBytes());

            System.out.println(new BigInteger(1, md.digest()).toString(16));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new BigInteger(1, md.digest()).toString(16);
    }

    public static Boolean check(String str, String md5Str){
        return md5Str.equals(getMd5(str));
    }

    public static void main(String[] args) {
        String test = "test";
        String md5 = getMd5(test);
        System.out.print(check(test,md5));
    }

}
