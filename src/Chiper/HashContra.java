package Chiper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Método que se encarga de hacer un resumen MD5 de la contraseña en el servidor
 *
 * @author Diego,Adrian.
 */
public class HashContra {

    private static final Logger LOGGER = java.util.logging.Logger.getLogger("/Cipher/HashContra");

    /**
     * Método que realiza el hasheo en MD5
     *
     * @param texto
     * @return
     */
    public static String hashContra(String texto) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md5.digest(texto.getBytes());

            // Convert the byte array to a hexadecimal representation
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = String.format("%02X", b);
                hexStringBuilder.append(hex);
            }
            System.out.println(hexStringBuilder.toString());
            return hexStringBuilder.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }
}
