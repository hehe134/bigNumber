/**
 * Created by 中奇 on 2017/2/9.
 */
package test;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

class test {


    final String f1 = "170";
    final String f2 = "10";

//    final BigInteger bi1 = new BigInteger(f1);
//    final BigInteger bi2 = new BigInteger(f2);

    MyBigNum mb1 = new MyBigNum(f1);
    MyBigNum mb2 = new MyBigNum(f2);

//    MyBigNum mresult = mb1.bigNumberAdd(mb2);
//    BigInteger result = bi1.add(bi2);

    @Test
    public void add() {
        assertEquals("180", mb1.bigNumberAdd(mb2).getString());
    }

    @Test
    public void comp() {
        assertEquals(1, mb1.bigNumberCom1(mb2));
    }

    @Test
    public void sub() {
        assertEquals("160", mb1.bigNumberSub(mb2).getString());
    }

    @Test
    public void multi() {
        assertEquals("1700", mb1.bigNumberSimpleMulti(mb2).getString());
    }

    @Test
    public void mul() {
        assertEquals(17, mb1.bigNumberMul(mb2));
    }

    @Test
    public void mod() {
        assertEquals("0", mb1.bigNumberSub(mb2).getString());
    }
}
