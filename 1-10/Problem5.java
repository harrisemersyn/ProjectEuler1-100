public class Problem5{
    public static void main(String[] args){
        //won't check for mod with numbers that are divisible amongst each other in 1-20
        //check: 20, 19, 18, 17, 16, 15, 14, 13, 12, 11
        //Note: come back to this one to find another solution that isn't brute force
        int smallestPos = 20 * 19 * 18 * 17 * 16 * 15 * 14 * 13 * 12 * 11;
        int temp = smallestPos;
        for(; temp >= 20; temp--){
            for(int i = 20; i >= 11; i--){
                if(temp % i != 0){
                    break;
                }
                else if(i == 11){
                    smallestPos = temp;
                }
            }
        }
        System.out.println(smallestPos);
    }
}