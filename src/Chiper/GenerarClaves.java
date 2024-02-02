/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chiper;

import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Método que genera las claves publicas y privadas para hacer la criptografia
 * asimetrica entre el cliente y el servidor
 *
 * @author Diego
 */
public class GenerarClaves {

    /**
     * Método que genera las claves
     *
     * @param folderPath
     */
    public void keyGenerator(String folderPath) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            File folder = new File(folderPath);
            if (!folder.exists()) {
                if (folder.mkdirs()) {
                    System.out.println("Carpeta creada exitosamente en: " + folderPath);
                } else {
                    System.err.println("Error al crear la carpeta");
                    return;
                }
            }

            saveKeyToFile(folderPath + File.separator + "publicKey.der", keyPair.getPublic().getEncoded());
            saveKeyToFile(folderPath + File.separator + "privateKey.der", keyPair.getPrivate().getEncoded());

            System.out.println("Ficheros de Clave Generados!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que gaurda las claves generadas
     *
     * @param filePath
     * @param keyBytes
     */
    private void saveKeyToFile(String filePath, byte[] keyBytes) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(keyBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Main que genera las claves desde el servidor
     *
     * @param args
     */
    public static void main(String[] args) {
        GenerarClaves generarClaves = new GenerarClaves();
        generarClaves.keyGenerator("C:\\Cifrado");

    }

}
