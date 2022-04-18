public class Problem2{
    public static void main(String[] args){
        long startTime = System.nanoTime();
        //first term
        int i = 1;
        //second term
        int j = 2;
        //initialzes with the only equal term out of i and j
        int sum = 2;
        //temporary variable to hold the next number in
        int temp = 0;
        while(j <= 4000000){
            temp = i + j;
            i = j;
            j = temp;
            if((j % 2) == 0){
                sum += j;
            }
        }
        System.out.println(sum);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Runtime:" + totalTime);
    }
}