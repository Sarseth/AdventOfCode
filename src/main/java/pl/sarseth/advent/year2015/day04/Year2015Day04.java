package pl.sarseth.advent.year2015.day04;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Year2015Day04 {

    public static void main(String[] args) {
        String input = "bgvyzdsv";

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String md5 = getMd5(input + i);
            if (md5.startsWith("000000")) {
                System.out.println(i);
                break;
            }
        }

    }

    static String getMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
