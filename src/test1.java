import java.util.ArrayList;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args){
        Table t = new Table(5,2);
        String[] fl = new String[]{"color","shape"};
        t.featureLables = new ArrayList<String>(Arrays.asList(fl));
        t.add(new String[]{"red","sq","A"});
        t.add(new String[]{"red","tri","A"});
        t.add(new String[]{"blue","sq","B"});
        t.add(new String[]{"blue","tri","C"});
        t.add(new String[]{"blue","tri","D"});

        System.out.println(t);
        System.out.println("entropy of t:"+t.tableEntropy());
        System.out.println("highest gain feature is:"+t.highestGainFeature());
        int i = t.highestGainFeature();
        for(Table temp : t.makeSubTables(i)){
            System.out.print(temp);
            System.out.println(Table.rowsep);
        }

        System.out.println(Table.rowsep);
        Node n = new Node("root",t);
        n.split();
        System.out.println(n);
    }
}
