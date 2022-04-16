import java.lang.Math;

public class Problem6{
    public static void main(String[] args){
        //sum of squares
        double sumOfSquares = 0;
        for(int i = 1; i <= 100; i++){
            sumOfSquares += Math.pow(i, 2);
        }
        //square of the sum
        int squareOfSum = 0;
        for(int i = 1; i <= 100; i++){
            squareOfSum += i;
        }
        System.out.println(Math.pow(squareOfSum, 2) - sumOfSquares);
    }
}