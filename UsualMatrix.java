import java.util.Comparator;

/**
 * Created by Алена on 02.05.2017.
 */
public class UsualMatrix implements Comparable<UsualMatrix> {
    protected int [][] array;
    protected int r = 0;
    protected int c = 0;

    public UsualMatrix(int row1, int column1) {
        array = new int [row1][column1];
        r = row1; c = column1;
        for(int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                array[i][j] = 0;
    }

    public UsualMatrix sum (UsualMatrix a) {
        if(r == a.getR() && c == a.getC()) {
            UsualMatrix res = new UsualMatrix(r, c);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int tmp = a.getElement(i,j) + this.getElement(i,j);
                    res.setElement(i, j, tmp);
                }
            }
            return res;
        }
        return null;
    }

    public UsualMatrix product(UsualMatrix a) {
        if(c == a.getR()) {
            UsualMatrix res = new UsualMatrix(r, a.getC());
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < a.getC(); j++) {
                    res.setElement(i, j, 0);
                    for (int k = 0; k < c; k++) {
                        res.setElement(i, j, res.getElement(i, j) + (this.getElement(i, k) * a.getElement(k, j)));
                    }
                }
            }
            return res;
        }
        return null;
    }

    public int getR() { return r; }

    public int getC() { return c; }

    public void setElement(int row1, int column1, int value){ array[row1][column1] = value; }

    public int getElement(int row1, int column1){ return array[row1][column1]; }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                res.append(" ").append(getElement(i,j));
            res.append("\n");
        }
        return  res.toString();
    }

    public boolean equals(Object obj) {
        boolean res = false;

        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(!( obj instanceof UsualMatrix))
            return false;

        UsualMatrix a = (UsualMatrix) obj;
        if (r != a.getR() || c != a.getC())
            return false;
        int flag = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (this.getElement(i, j) != a.getElement(i, j))
                    flag++;
            }
        }
        if (flag == 0)
            res = true;
        return res;
    }

    @Override
    public int compareTo(UsualMatrix o2) {

        int sum1 = 0;
        for(int i = 0; i < this.getR(); i++)
            for(int j = 0; j < this.getC(); j++)
                sum1 += this.getElement(i,j);
        int sum2 = 0;
        for(int i = 0; i < o2.getR(); i++)
            for(int j = 0; j < o2.getC(); j++)
                sum2 += o2.getElement(i,j);

        if(sum1 == sum2)
            return 0;
        if(sum1 > sum2)
            return 1;
        return -1;
    }
}
