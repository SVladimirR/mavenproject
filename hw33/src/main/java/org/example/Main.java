package org.example;


public class Main {


    public static void main(String[] args) {
        SimpleCache cache = new SimpleCache();


        cache.put("stringCache", "key1", "Hello!");
        cache.put("intCache", "key2", 322);


        String str = (String) cache.get("stringCache", "key1");
        int num = (int) cache.get("intCache", "key2");

        if (str != null) {
            System.out.println("String from cache: " + str);
        } else {
            System.out.println("String not found in cache.");
        }

        System.out.println("Integer from cache: " + num);


        boolean stringCacheExists = cache.isCacheExist("stringCache");
        boolean intCacheExists = cache.isCacheExist("intCache");

        System.out.println("String Cache exists: " + stringCacheExists);
        System.out.println("Int Cache exists: " + intCacheExists);


        cache.clear("stringCache");


        cache.clear();
    }

}


