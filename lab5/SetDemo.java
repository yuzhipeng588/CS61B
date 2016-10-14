import java.util.HashSet;
import java.lang.*;
public class SetDemo extends HashSet{
    public SetDemo(){
        super();
    }
    public static void main(String[] args){
        HashSet<String> s=new SetDemo();
        //SetDemo q=new SetDemo();   
        boolean a=s.add("papa");
        boolean b=s.add("bear");
        boolean c=s.add("mama");
        boolean d=s.add("bear");
        boolean e=s.add("baby");
        boolean f=s.add("bear");
        System.out.println(s.toString());
    }
}
