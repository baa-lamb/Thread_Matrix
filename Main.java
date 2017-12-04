import java.util.Arrays;

import static java.lang.Thread.sleep;

/**
 * Created by Алена on 02.05.2017.
 */
public class Main {
    static public void main(String[] args) {
       // long time2 = System.currentTimeMillis();
      /*  ParallelMatrixProduct p = new ParallelMatrixProduct(700);
        UsualMatrix a = new UsualMatrix(700,700);
        UsualMatrix b = new UsualMatrix(700,700);
        for(int i = 0; i < 700; i++){
            for(int j = 0;  j < 700; j++) {
                a.setElement(i, j, 1);
                b.setElement(j, i, 1);
            }
        }
        UsualMatrix res = p.productParallel(a, b);
        //System.out.println(res);
        long t = System.currentTimeMillis();
       // time2 = t - time2;
        System.out.println("______TIME TO PRODUCT PARALLEL:_______" + time2 + "\n");

        long time1 = System.currentTimeMillis();
        //ParallelMatrixProduct P = new ParallelMatrixProduct(1000);
        UsualMatrix c = new UsualMatrix(700,700);
        UsualMatrix d = new UsualMatrix(700,700);
        for(int i = 0; i < 700; i++){
            for(int j = 0;  j < 700; j++) {
                c.setElement(i, j, 1);
                d.setElement(j, i, 1);
            }
        }
        c.product(d);
        long s = System.currentTimeMillis();
        time1 = s - time1;
        System.out.println("______TIME TO PRODUCT USUAL:_______" + time1 + "\n");*/

        UsualMatrix a = new UsualMatrix(4,4);
        UsualMatrix b = new UsualMatrix(4,4);
        UsualMatrix c = new UsualMatrix(4,4);
        for(int i = 0; i < 4; i++){
            for(int j = 0;  j < 4; j++) {
                a.setElement(i, j, 3);
                b.setElement(j, i, 1);
                c.setElement(j, i, 4);
            }
        }
        //System.out.println(a);
        //System.out.println(b);
      //  Comparable []a1 = {a,b,c};
        Comparable []a1 = /*{9, 8, 7, 6, 5, 4, 3, 2, 1};*/{2,3,5,4,7,1,4, 100,8};
        Sort m = new Sort(2, a1);
        m.MergeSort(0,8, 0);

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < a1.length; i++)
            System.out.println(a1[i]);
    }
}
