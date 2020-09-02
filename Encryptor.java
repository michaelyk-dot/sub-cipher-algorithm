import java.util.ArrayList;

/**
 * @author Michael Kim
 *
 */
public class Encryptor {

    /**
     * Constructor for Encryptor.
     * 
     * @param plaintext
     */
    public Encryptor() {

    }
    
    /**
     * Replaces the letters in the plaintext according
     * to the randomly generated key.
     * 
     * @param key The key set
     * @param plaintext The plaintext 
     * @return The encrypted plaintext/ the ciphertext
     */
    public String genCiphertext(String plaintext) {
        ArrayList<String> key = genKey(plaintext);
        
        String temp = plaintext.toLowerCase();
        for (int k = 0; k < key.size(); k++) {
            temp = temp.replaceAll("" + (char)(k + 97), key.get(k).toUpperCase());
        }
        return temp.toString();
        
    }
    
    /**
     * Randomly generates a encryption key
     * for the plaintext.
     * 
     * @param p Plaintext
     * @return Key set
     */
    public ArrayList<String> genKey(String p) {      
        p = p.replaceAll("\\s+", "");

        ArrayList<String> a = new ArrayList<String>();
        
        while (a.size() < 26) {
            int z = genLetters();             
            
            char c = (char)z;

            while (a.contains("" + c)) {
                z = genLetters();  
                c = (char)z;
            }
            
           
            a.add("" + c);
        }
        return a;
        
    }
    
    /**
     * Generates a random letter.
     * 
     * @return Random letter
     */
    public static int genLetters() {
        int z = (int)Math.round((Math.random() * 100) % 26) + 96;
        if (z == 96) {
            z++;
        }
        return z;
    }
   
}
