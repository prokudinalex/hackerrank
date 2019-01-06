package bignumbers;

import java.math.BigDecimal;
import java.util.*;

public class BigDec {

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        s[n+1] = "END1";
        s[n] = "END2";
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if ("END1".equals(o1)) {
                    return 1;
                }
                if ("END1".equals(o2)) {
                    return -1;
                }
                if ("END2".equals(o1)) {
                    return 1;
                }
                if ("END2".equals(o2)) {
                    return -1;
                }
                BigDecimal b1 = new BigDecimal(o1);
                BigDecimal b2 = new BigDecimal(o2);
                return b2.compareTo(b1);
            }
        });

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
