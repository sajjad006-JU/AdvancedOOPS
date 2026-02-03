// 6. Consider a wrapper class for a numeric basic type. Check the support for the following: conversion 
// from i) basic type to object ii) object to basic type iii) basic type to String iv) String (holding numeric 
// data) to numeric object v) object to String.

public class WrapperClass {
    public static void main(String[] args) {
        // i) basic type to object
        int basicInt = 42;
        Integer wrappedInt = Integer.valueOf(basicInt);
        System.out.println("Basic type to object: " + wrappedInt);

        // ii) object to basic type
        int unwrappedInt = wrappedInt.intValue();
        System.out.println("Object to basic type: " + unwrappedInt);

        // iii) basic type to String
        String intToString = Integer.toString(basicInt);
        System.out.println("Basic type to String: " + intToString);

        // iv) String (holding numeric data) to numeric object
        String numericString = "123";
        Integer stringToObject = Integer.valueOf(numericString);
        System.out.println("String to numeric object: " + stringToObject);

        // v) object to String
        String objectToString = wrappedInt.toString();
        System.out.println("Object to String: " + objectToString);
    }    
}
