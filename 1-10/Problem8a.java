import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

/*
NOTE

This was purely an experiment to see if doing things methodically would make run times shorter.
To nobody's surprise, it did not run faster than the brute force method.
This is entire thing is just duct-taped together
*/

public class Problem8a {
    public static void main(String[] arg) throws IOException{
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
        //Finds the largest digit in the string, and revolves around that digit to find the largest sequence
        {
            BigInteger largest = new BigInteger("1");
            for(int i = 0; i < allStrings.size(); i++){
                int largestDigit = -1;
                for(int k = 0; k < (allStrings.get(i)).length(); k++){
                    //Largest digit in the string finder
                    char c = (allStrings.get(i)).charAt(k);
                    if(Character.getNumericValue(c) == 9){
                        largestDigit = 9;
                        break;
                    }
                    else if(Character.getNumericValue(c) > largestDigit){
                        largestDigit = Character.getNumericValue(c);
                    }
                }

                //Revolving around the point
                String tempLargest = "";
                for(int j = 0; j < allStrings.get(i).length(); j++){
                    if(Character.getNumericValue((allStrings.get(i)).charAt(j)) == largestDigit){
                        tempLargest = "";
                        tempLargest += (allStrings.get(i)).charAt(j);
                        int count = 1;
                        int a = j - 1;
                        int b = j + 1;
                        while(count < 13){
                            if(a < 0){
                                tempLargest += (allStrings.get(i)).charAt(b);
                                b++;
                            }
                            else if(b >= (allStrings.get(i)).length()){
                                tempLargest += (allStrings.get(i)).charAt(a);
                                a--;
                            }
                            else if(Character.getNumericValue((allStrings.get(i)).charAt(a)) < Character.getNumericValue((allStrings.get(i)).charAt(b))){
                                tempLargest += (allStrings.get(i)).charAt(b);
                                b++;
                            }
                            else if(Character.getNumericValue((allStrings.get(i)).charAt(a)) >= Character.getNumericValue((allStrings.get(i)).charAt(b))){
                                tempLargest += (allStrings.get(i)).charAt(a);
                                a--;
                            }
                            count++;
                        }
                        String tempToString = tempLargest;
                        BigInteger tempMult = new BigInteger("1");
                        for(int z = 0; z < tempToString.length(); z++){
                            tempMult = tempMult.multiply(BigInteger.valueOf(Character.getNumericValue(tempToString.charAt(z))));
                        }

                        String tempLarge = largest.toString();
                        BigInteger tempMultCurr = new BigInteger("1");
                        for(int z = 0; z < tempLarge.length(); z++){
                            tempMultCurr = tempMultCurr.multiply(BigInteger.valueOf(Character.getNumericValue(tempLarge.charAt(z))));
                        }

                        if(tempMult.compareTo(tempMultCurr) == 1){
                            largest = new BigInteger(tempLargest);;
                        }
                    }
                }
            }
            //Takes every digit from the largest string and gets the product and prints it
            String largestToString = largest.toString();
            BigInteger finalMultiple = new BigInteger("1");
            for(int z = 0; z < largestToString.length(); z++){
                finalMultiple = finalMultiple.multiply(BigInteger.valueOf(Character.getNumericValue(largestToString.charAt(z))));
            }
            System.out.println(finalMultiple);
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(totalTime);
        }
    }
}
