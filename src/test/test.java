/**
 * Created by 中奇 on 2017/2/9.
 */
package test;

public class test {
    public static void main(String[] args) {
        String len1 = "150";
        String len2 = "25";
        String result;
        myBigNum FirstNum = new myBigNum(len1, len2);

        result = FirstNum.bigNumberAdd();
        System.out.println(result);

        result = FirstNum.bigNumberSub();
        System.out.println(result);

        //-----
        //result = FirstNum.bigNumberSub(len1,len2);
        //System.out.println(result);
        //-----

        FirstNum.bigNumberCom1();

        //int a = FirstNum.bigNumberCom(len2,len1);
        //System.out.println(a);
        FirstNum.bigNumberMod();

        FirstNum.bigNumberSimpleMulti();
        FirstNum.bigNumberMul();
        /*
        bigNumberSimpleMulti(len1, len2);
        System.out.println(len1 + "-" + len2 + "=" + bigNumberSub(len1, len2));
        System.out.println(len1 + "+" + len2 + "=" + bigNumberAdd(len1, len2));
        bigNumberCom1(len1, len2);
        bigNumberMod(len1, len2);
        bigNumberMul(len1, len2);
        */
    }


}

