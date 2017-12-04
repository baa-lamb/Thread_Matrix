
import java.util.Arrays;
import static java.lang.Thread.sleep;
import java.util.Comparator;

public class Sort {
    Comparable []a;
    Threds []threads;
    int N = 0;
    int threadNum = 0;
    int left = 0, right = 0;

    public class Threds extends Thread {
        int l;
        int r;
        public Threds(int left, int rigth) {
            l = left;
            r = rigth;
        }
        public void run() { MergeSort(l, r, threadNum); }
    }

    public Sort (int NumberOfThreads, Comparable []array) {
        N = NumberOfThreads;
        threads = new Threds[N];
        a = array;
    }

    void MergeSort(int l, int r, int tNum) {
        if(l >= r)
            return;
        int mid = (l + r) / 2;
        if(tNum > N)
            tNum = N - tNum;
        int m = tNum, n = tNum + 1;
       // Threds t1 = new Threds(l, mid);
       // t1.start();
        threads[m] = new Threds(l, mid);
        threads[m].start();
        left = mid + 1;
        right = r;
      //  Threds t2 = new Threds(mid+1, r);
      //  t2.start();
        threads[n] = new Threds(mid+1, r);
        threads[n].start();
        try {
            threads[m].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            threads[n].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mearge(a, l, mid, r);
    }

    void mearge(Comparable []array, int l, int mid, int r){
        Comparable []buf = new Comparable[array.length];
        Comparable []res = new Comparable[array.length];
        synchronized (array){
            for(int i = 0; i < array.length; i++){
                buf[i] = array[i];
                res[i] = array[i];
            }
        }
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                res[k] = buf[j];
                j++;
            } else if (j > r) {
                res[k] = buf[i];
                i++;
            } else if (buf[j].compareTo(buf[i]) > 0) {
                res[k] = buf[i];
                i++;
            } else {
                res[k] = buf[j];
                j++;
            }
        }
        synchronized (array){
            for(int t = 0; t < array.length; t++) {
                array[t] = res[t];
            }
        }
    }

}