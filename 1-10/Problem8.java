import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;

/*
My original attempt at problem 8, and my most efficient. The if statement that breaks the loop on line 23
when a 0 is found in the substring makes it slightly faster than just pure brute-forcing without terminating on a 0 being found.
*/

public class Problem8{
    public static void main(String[] args) throws IOException{
        long startTime = System.nanoTime();
        BigInteger biggestProduct =  new BigInteger("0");
        BigInteger temporaryProduct = new BigInteger("1");
        Path fileName = Path.of("DigitStringTwo.txt");
        String digitString = Files.readString(fileName, StandardCharsets.US_ASCII);
        for(int i = 0; i < digitString.length()-13; i++){
            for(int j = 0; j < 13; j++){
                if(BigInteger.valueOf(Character.getNumericValue(digitString.charAt(i + j))).compareTo(BigInteger.valueOf(0)) == 0){
                    temporaryProduct = BigInteger.valueOf(1);
                    break;
                }
                else{
                    temporaryProduct =  temporaryProduct.multiply(BigInteger.valueOf(Character.getNumericValue(digitString.charAt(i + j))));
                }
            }
            if(temporaryProduct.compareTo(biggestProduct) == 1){
                biggestProduct = temporaryProduct;
            }
            temporaryProduct = BigInteger.valueOf(1);
        }
        System.out.println(biggestProduct);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}