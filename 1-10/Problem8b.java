import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*
NOTE

This is my third attempt at problem 8. It combines both my first attempt and second attempt to go for better efficiency.
Fully expected, this attempt is not faster than my original attempt, but is faster than my second.
*/

public class Problem8b{
    public static void main(String[] args) throws IOException{
        long startTime = System.nanoTime();
        Path fileName = Path.of("DigitStringTwo.txt");
        String digitString = Files.readString(fileName, StandardCharsets.US_ASCII);
        List<String> allStrings = new ArrayList<>();
        //Strings are parsed into sections of 13 or more that do not contain the number 0, and added to a list
        {
            String temp = "";
            for(int i = 0; i < digitString.length(); i++){
                if(Character.getNumericValue(digitString.charAt(i)) != 0){
                    temp += digitString.charAt(i);
                }
                else{
                    if(temp.length() >= 13){
                        allStrings.add(temp);
                    }
                    temp = "";
                }
            }
        }
        BigInteger biggestProduct =  new BigInteger("0");
        BigInteger temporaryProduct = new BigInteger("1");
        for(int a = 0; a < allStrings.size(); a++){
            for(int i = 0; i < (allStrings.get(a)).length()-12; i++){
                for(int j = 0; j < 13; j++){
                    temporaryProduct =  temporaryProduct.multiply(BigInteger.valueOf(Character.getNumericValue((allStrings.get(a)).charAt(i + j))));
                 }  
                 if(temporaryProduct.compareTo(biggestProduct) == 1){
                biggestProduct = temporaryProduct;
            }
            temporaryProduct = BigInteger.valueOf(1); 
            }
            
        }
        System.out.println(biggestProduct);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}