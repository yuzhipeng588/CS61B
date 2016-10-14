public class hw0_3SUM_DISTINCT{
    public static void main(String[] args){
          int[] a={1,2,3,4,-4,8,-3};
          threeSum(a);
    }
    static void threeSum(int[] nums){
        int count=0;
        if(nums.length<3){
          System.out.print("Wrong Array");
        }
        else{
          for(int i=0;i<=(nums.length-3);i++){
            for(int j=i+1;j<=(nums.length-2);j++){
                for(int k=j+1;k<=(nums.length-1);k++){
                    if((nums[i]+nums[j]+nums[k])==0){
                        sumPrint(nums[i],nums[j],nums[k]); 
                        count++;
                    }
                }
            }
          }
        }
        if(count==0){
                System.out.println("No such integers");
        }
        else {
            System.out.println("Total: "+count);
        }

    }

     static void sumPrint(int f, int g, int h){
         System.out.println(f+","+g+","+h+"=0");
     }

}
