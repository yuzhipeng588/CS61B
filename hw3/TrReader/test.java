/**
 * Created by Nero on 2016/10/7.
 */
import java.util.*;
import java.lang.*;
public class test {
    static String rollingString(String s, String[] operations) {
        String alphabet="abcdefghigklmnopqrstuvwxyza";
        s=s.toLowerCase();
        char[] c=s.toCharArray();
        int start=0;
        int end=0;
        String direction="";
        for(int i=0;i<operations.length;i++){
            String[] splited=operations[i].split(" ");
            if(splited.length<=1){
                continue;
            }
            start=Character.getNumericValue(splited[0].charAt(0));
            end=Character.getNumericValue(splited[1].charAt(0));
            direction=splited[2];
            s=new String(c);
            for(int j=start;j<end+1;j++) {
                String L="L";
                if (direction.equals("L")) {
                    int indexL = alphabet.indexOf(s.charAt(j)) + 1;
                    c[j]=alphabet.charAt(indexL);
                }
                else if(direction=="R"){
                    if(alphabet.contains(s.substring(j,j+1))){

                    }
                    int indexR = alphabet.lastIndexOf(s.charAt(j))-1;
                    c[j]=alphabet.charAt(indexR);
                }
            }
        }
        return c.toString();
    }
    static String canReach(int a, int b, int c, int d) {
            while(true) {
                if (a  > c ||  b > d) {
                    return "No";
                }
                if(a==c&&b==d){
                    return "Yes";
                }
                else{
                    String s1=canReach(a,a+b,c,d);
                    String s2=canReach(a+b,b,c,d);
                    if (s1.equals("Yes")||s2.equals("Yes")){
                        return "Yes";
                    }
                    else return "No";
                }
            }
        }
}
