package no.hib.dat104.project.helpers;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;
public class Passordkryptering {
     
    private static final int SALTLENGDE = 32;
    private static final String PASSORD_TEGNSETT = "UTF-8";
    private static final String HASH_ALGORITME = "SHA-256";
    private static final int HASH_ITERATIONS = 1000;
    
    /**
     * @param passord Passord som skal krypteres
     * @return (salt + digest) kodet som en base64-streng. 
     */
    public static String krypterPassord(String passord) {
        byte[] salt = genererTilfeldigSalt();
        return krypterMedSalt(salt, passord);
    }

    /**
     * @param passord Passord som skal sjekkes
     * @param kryptert (salt + digest) tidligere generert med {@link #krypterPassord(String)}
     * @return om passordet matcher det krypterte passordet
     */
    public static boolean sjekkPassord(String passord, String kryptert) {
        byte[] salt = hentUtSaltFraKryptertStreng(kryptert);
        return krypterMedSalt(salt, passord).equals(kryptert);
    }
    
    /*--- Private hjelpemetoder ---*/

    private static byte[] genererTilfeldigSalt() {
        byte[] salt = new byte[SALTLENGDE];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    private static byte[] hentUtSaltFraKryptertStreng(String kryptert) {
        byte[] saltPlusDigest = DatatypeConverter.parseBase64Binary(kryptert);
        byte[] salt = Arrays.copyOf(saltPlusDigest, SALTLENGDE);
        return salt;
    }

    private static String krypterMedSalt(byte[] salt, String passord) {

        String kryptert = "";

        try {
            byte[] passordBytes = passord.getBytes(PASSORD_TEGNSETT);

            byte[] saltPlusPassord = leggSammen(salt, passordBytes);

            MessageDigest md = MessageDigest.getInstance(HASH_ALGORITME);
            
            byte[] digest = saltPlusPassord;
            for (int i=1; i<=HASH_ITERATIONS; i++) {
                digest = md.digest(digest);
            }

            byte[] saltPlusDigest = leggSammen(salt, digest);

            kryptert = DatatypeConverter.printBase64Binary(saltPlusDigest);
            
        } catch (Exception e) {
        }
        return kryptert;
    }

    private static byte[] leggSammen(byte[] tabell1, byte[] tabell2) {
        
        byte[] enOgTo = new byte[tabell1.length + tabell2.length];
        System.arraycopy(tabell1, 0, enOgTo, 0, tabell1.length);
        System.arraycopy(tabell2, 0, enOgTo, tabell1.length, tabell2.length);
        return enOgTo;
    }
}

