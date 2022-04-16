import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;

public class Problem8{
    //Revist for more efficient solution
    public static void main(String[] args) throws IOException{
        BigInteger biggestProduct =  new BigInteger("0");
        BigInteger temporaryProduct = new BigInteger("1");
        Path fileName = Path.of("DigitString.txt");
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
    }
}