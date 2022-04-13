public class ProblemFour{
    public static void main(String[] args){
        //Note: coming back to relook at this one later to look for a better solution that isn't brute force
        String temp = "";
        String tempTwo = "";
        boolean found = false;
        int finalPalindrome = 0;
        for(int i = 999; i >= 100; i--){
            for(int j = 999; j >= 100; j--){
                temp = String.valueOf(i * j);
                tempTwo = new StringBuilder(temp).reverse().toString();
                if(temp.compareTo(tempTwo) == 0){
                    if(Integer.parseInt(temp) > finalPalindrome){
                        finalPalindrome = Integer.parseInt(temp);
                    }
                }
            }
        }
        System.out.println(finalPalindrome);
    }
}