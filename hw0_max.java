public class hw0_max{
    public static void main(String[] args){
          int[] a={1,2,3,4};
          System.out.print(Max(a));
    }
    static int Max(int[] nums){
        int k=nums[0];
        /*for(int i=0;i<=(nums.length-2);i++){
            if(k<=nums[i+1]){
                k=nums[i+1]; 
            }
        }*/
        int i=0;
        while(i<=(nums.length-2)){
            if(k<=nums[i+1]){
                k=nums[i+1]; 
            }
            i++;
        }
        return k;
     }
}
