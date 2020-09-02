import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.lang.*;

public class Solver {

    public static void main(String args[]) throws IOException {
        String s = "\r\n" + 
            "UZ QSO VUOHXMOPV GPOZPEVSG ZWSZ OPFPESX\r\n" + 
            "UDBMETSX AIZ VUEPHZ HMDZSHZO WSFP APPD\r\n" + 
            "TSVP QUZW YMXUZUHSX EPYEPOPDZSZUFPO MB\r\n" + 
            "ZWP FUPZ HMDJ UD TMOHMQ";
        
        
        /**
        File f = new File("dump.txt");
        
        FileWriter fw = new FileWriter("dump.txt");

        for (int k = 0; k < 1000000; k++)
            fw.write(key() + "\n"); 

        fw.close();
        **/
        
        frequencies(s);
        key(s);
        
        System.out.println(s.length());
        System.out.println(s.replaceAll("A", "").length());
    }
    
    public static String key(String e) {      
        e = e.replaceAll("\\s+", "");

        ArrayList<String> a = new ArrayList<String>();
        
        while (a.size() < 26) {
            int z = generator();             
            
            char c = (char)z;

            while (a.contains("" + c)) {
                z = generator();  
                c = (char)z;
            }
            
           
            a.add("" + c);
        }
        dump(e, a.toString());
        return allocate(a, e);
        
    }
    
    
    private static int generator() {
        int z = (int)Math.round((Math.random() * 100) % 26) + 96;
        if (z == 96) {
            z++;
        }
        return z;
    }
    
    private static String allocate(ArrayList<String> a, String text) {
        String temp = text.toLowerCase();
        for (int k = 0; k < a.size(); k++) {
            temp = temp.replaceAll("" + (char)(k + 97), a.get(k).toUpperCase());
        }
        return temp.toString();
        
    }
    
    private static void dump(String ciphertext, String alloc) {
        System.out.println(ciphertext);
        System.out.println();
        System.out.println("Alphabet:\t[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]");
        System.out.println("Guess:\t\t" + alloc);
    }
    
    public static double[] frequencies(String ciphertext) {
        double[] frqs = new double[26];
        
        for (int k = 65; k < 91; k++) {
            frqs[k - 65] = (double)(ciphertext.length() - 
                ciphertext.replaceAll("" + (char)k, "").length()) / ciphertext.length();
            frqs[k - 65] = Math.floor(frqs[k - 65] * 100000) / 100000;
            
            System.out.print(frqs[k - 65] + " ");
        }
        System.out.println();
        return frqs;
    }
}
