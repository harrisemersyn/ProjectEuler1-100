import java.util.Random;
import java.lang.Math;
import java.math.BigInteger;

public class ProblemThree{
    public static void main(String[] args){
        int randNum;
        BigInteger largestPrime = new BigInteger("0");
        BigInteger temp = new BigInteger("0");
        BigInteger num = new BigInteger("600851475143");
        Random random = new Random();
        int randomInt;
        for(int i = 1; -1 == BigInteger.valueOf(i).compareTo(num); i++){
            if(num.mod(BigInteger.valueOf(i)).intValue() == 0){
                temp = num.divide(BigInteger.valueOf(i));
                //fermat primality test
                for(int j = 0; j < 20; j++){
                    randomInt = random.nextInt(2000);
                    if((((BigInteger.valueOf(randomInt)).modPow(temp.subtract(BigInteger.valueOf(1)), temp)).compareTo(BigInteger.valueOf(1))) != 0){
                        break;
                    }
                    else if(j == 19){
                        largestPrime = temp;
                    }
                }
            }
            if(largestPrime.compareTo(BigInteger.valueOf(0)) != 0){
                System.out.println(largestPrime);
                break;
            }
        }
    }
}