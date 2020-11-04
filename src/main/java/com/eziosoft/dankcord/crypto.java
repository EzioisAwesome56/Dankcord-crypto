package com.eziosoft.dankcord;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

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
        System.err.println("Eziosoft Dankcord-Crypto v1.0 now processing data...");
        // get the value of the boolean
        boolean mode = Boolean.parseBoolean(args[0]);
        if (mode){
            // encrypt mode
            try {
                // first we need to get the private key
                
            }
        } else {
            // decrypt mode
            try {
                // first we need to get the public key
                PublicKey key = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(args[2])));
                // then we need to setup a cipher
                Cipher ci = Cipher.getInstance("RSA");
                ci.init(Cipher.DECRYPT_MODE, key);
                // decrypt text
                String data = new String(ci.doFinal(Base64.decode(args[1])));
                // shit the data the data out stdout
                System.out.print(data);
            } catch (Exception e){
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }
}
