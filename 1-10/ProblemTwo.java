public class ProblemTwo{
    public static void main(String[] args){
        //first term
        int i = 1;
        //second term
        int j = 2;
        //initialzes with the only equal term out of i and j
        int sum = 2;
        //temporary variable to hold the next number in
        int temp = 0;
        while((i <= 4000000) & (j <= 4000000)){
            temp = i + j;
            i = j;
            j = temp;
            if((j % 2) == 0){
                sum += j;
            }
        }
        System.out.println(sum);
    }
}