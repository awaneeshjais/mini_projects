package helpclass;

import java.math.BigDecimal;

public class Numbers {

    public double coren(int i){
        double coren2;
        if (i!=0){
            coren2 = Math.sqrt(i);
        }else {
            coren2 = 1.0;
        }
        return coren2;
    }
    public double rounder(double d, int c){
        double result = new BigDecimal(d).setScale(c, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }
}
