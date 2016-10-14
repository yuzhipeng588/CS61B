import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P3 {
    private static ArrayList<Integer> Got;
    private static PrintStream _output;

    public static void main(String... ignored) {
        File file = new File("3/test1.inp");
        ArrayList<Integer> input=new ArrayList<Integer>();
        try {
            Scanner s = new Scanner(file);
            while(s.hasNextInt()){
                input.add(s.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            _output = new PrintStream(new File("3/Myresults"));
            for(int i=0;i<input.size();i++) {
                ArrayList<Integer> result=new ArrayList<Integer>();
                if(Got!=null){
                    Got=null;
                }
                recsolu(result,1,input.get(i));
                _output.println("The smallest good numeral of length "+input.get(i)+" is "+Got.toString());
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public static void recsolu(ArrayList<Integer> L,int next,int size){
        ArrayList<Integer>L1=new ArrayList<Integer>(L);
        L1.add(next);
        if(L1.size()==size&&gdorbd(L1)){
            setGot(L1);
        }else{
            if(gdorbd(L1)&&L1.size()<=size&&Got==null){
                for(int i=1;i<=3;i++){
                    if(gdorbd(L1,i)&&Got==null){
                        recsolu(L1,i,size);
                    }
                }
            }
        }
    }
    public static void setGot(ArrayList<Integer> L){
        Got=L;
    }
    public static boolean gdorbd(ArrayList<Integer> L){
        if(L.size()==0&&L.size()==1){
            return true;
        }
        for(int i=1;i<=L.size()/2;i++){
            for(int j=0;j<=L.size()-2*i;j++){
                List<Integer> L1=new ArrayList<Integer>();
                List<Integer> L2=new ArrayList<Integer>();
                L1=L.subList(j,j+i);
                L2=L.subList(j+i,j+2*i);
                if(L1.equals(L2)){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean gdorbd(ArrayList<Integer> L,int l){
        ArrayList<Integer> L2=new ArrayList<Integer>(L);
        L2.add(l);
        return gdorbd(L2);
    }


}
