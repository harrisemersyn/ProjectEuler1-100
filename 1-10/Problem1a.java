public class Problem1a{

    //Brute force solution

    public static void main(String[] args){
        long startTime = System.nanoTime();
        int sum = 0;
        for(int i = 1; i < 1000; i++){
            if(i % 3 == 0){
                sum += i;
            } 
            if(i % 5 == 0){
                //excludes duplicates
                if((i % 3) != 0){
                    sum += i;
                }
            }   
        }
        System.out.println(sum);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Runtime:" + totalTime);
    }
}