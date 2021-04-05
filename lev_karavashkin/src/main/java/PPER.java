import com.google.common.math.BigIntegerMath;

import java.math.BigInteger;

public class PPER {
    public static String getPartPermutations(int n, int k) {
        return BigIntegerMath.factorial(n).divide(BigIntegerMath.factorial(n - k))
                .mod(new BigInteger("1000000")).toString();

    }
}
