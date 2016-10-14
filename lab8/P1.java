import java.io.PrintStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class P1 {
    private static PrintStream _output;
    public static void main(String... ignored) {
        File file = new File("1/test1.inp");
        ArrayList<Integer> results = new ArrayList<Integer>();
        try {
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                ArrayList<String> L = new ArrayList<String>();
                String ss = s.nextLine();
                while (ss.contains("X")) {
                    L.add(ss);
                    if(s.hasNextLine()) {
                        ss = s.nextLine();
                    }else break;
                }
                int result =calculatespace(L);
                results.add(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            _output = new PrintStream(new File("1/Myresults"));
            for(int i=0;i<results.size();i++) {
                _output.print("Image "+(i+1)+": ");
                _output.println(results.get(i));
                _output.println();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }
    public static int calculatespace(ArrayList<String> L){
        if(L==null){
            throw new NoSuchElementException("Bad Input");
        }
        int step=calculatestep(L);
        int count=0;
        for(int i=0;i<L.size();i++){
            for(int j=0;j<L.get(i).length();j++){
                if(L.get(i).charAt(j)==' '){
                    count++;
                }
            }
        }
        return count-step*L.size();

    }
    public static int calculatestep(ArrayList<String> L){
        if(L==null){
            throw new NoSuchElementException("Bad Input");
        }
        int step=L.get(0).length();
        for(int i=0;i<L.size();i++) {
            if (!L.get(i).contains(" ")) {
                return 0;
            } else {
                int start=L.get(i).indexOf("X ");
                int end=L.get(i).lastIndexOf(" X");
                if(step>end-start){
                    step=end-start;
                }
            }
        }
        return step;
    }


}
