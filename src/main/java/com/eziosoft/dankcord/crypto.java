package com.eziosoft.dankcord;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

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
                PrivateKey key = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(args[2])));
                // setup the cipher
                Cipher ci = Cipher.getInstance("RSA");
                ci.init(Cipher.ENCRYPT_MODE, key);
                // un-base64 text
                String source = new String(Base64.getDecoder().decode(args[1]));
                // encrypt it
                String output = new String(Base64.getEncoder().encode(ci.doFinal(source.getBytes())));
                // shit it out stdout
                System.out.print(output);
            } catch (Exception e){
                e.printStackTrace();
                System.exit(-1);
            }
        } else {
            // decrypt mode
            try {
                // first we need to get the public key
                PublicKey key = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(args[2])));
                // then we need to setup a cipher
                Cipher ci = Cipher.getInstance("RSA");
                ci.init(Cipher.DECRYPT_MODE, key);
                // decrypt text
                String data = new String(ci.doFinal(Base64.getDecoder().decode(args[1])));
                // shit the data the data out stdout
                System.out.print(data);
            } catch (Exception e){
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }
}
