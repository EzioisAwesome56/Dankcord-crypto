package com.eziosoft.dankcord;

public class crypto {

    public static void main(String[] args){
        // first check if they provided any arguments
        if (args.length < 1){
            // print help screen
            System.out.println("Dankcord Crypto v1.0");
            System.out.println("Usage: boolean base64-data base64-key");
            System.out.println("True = encrypt, False = decrypt");
            System.exit(-1);
        }
    }
}
