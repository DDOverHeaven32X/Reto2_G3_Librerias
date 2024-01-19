/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chiper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @author Egoitz
 */
public class GenerarClaves {

    public void keyGenerator() {
        try {
            // Especificamos el algoritmo de encriptación
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            // Especificamos el tamaño en bits de las claves
            keyPairGenerator.initialize(2048);
            // Se genera el par de claves
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            PublicKey publicKeyAndMore = keyPair.getPublic();
            byte[] publicKeyBytes = publicKeyAndMore.getEncoded();

            try (FileOutputStream publicKeyFile = new FileOutputStream("c:\\claves\\publicKey.der")) {
                publicKeyFile.write(publicKeyBytes);
            }

            PrivateKey privateKey = keyPair.getPrivate();
            byte[] privateKeyBytes = privateKey.getEncoded();
            try (FileOutputStream privateKeyFile = new FileOutputStream("c:\\claves\\privateKey.der")) {
                privateKeyFile.write(privateKeyBytes);
            }

            System.out.println("Ficheros de Clave Generados!");
        } catch (IOException | NoSuchAlgorithmException e) {
        }
    }
}
