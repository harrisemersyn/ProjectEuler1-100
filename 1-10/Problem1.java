public class Problem1{
    public static void main(String[] args){
        long startTime = System.nanoTime();
        int multOfThree = 3; 
        int multOfFive = 5;
        int sum = 0;
        while((multOfThree < 1000) | (multOfFive < 1000)){
            sum += multOfThree;
            if(multOfFive < 1000){
                //excludes duplicates
                if((multOfFive % 3) != 0){
                    sum += multOfFive;
                }
            }   
            multOfThree += 3;
            multOfFive += 5;
        }
        System.out.println(sum);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Runtime:" + totalTime);
    }
}