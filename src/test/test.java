/**
 * Created by 中奇 on 2017/2/9.
 */
package test;

public class test {
    public static void main(String[] args) {
        String len1 = "170";
        String len2 = "50";
        String result;
        MyBigNum FirstNum = new MyBigNum(len1);
        MyBigNum secondNum = new MyBigNum(len2);

        FirstNum.bigNumberAdd(secondNum);

        result = FirstNum.bigNumberSub(secondNum);
        System.out.println(len1+"-"+len2+"="+result);

        //-----
        //result = FirstNum.bigNumberSub(len1,len2);
        //System.out.println(result);
        //-----

        FirstNum.bigNumberCom1(secondNum);

        //int a = FirstNum.bigNumberCom(len2,len1);
        //System.out.println(a);

        FirstNum.bigNumberSimpleMulti(secondNum);

        FirstNum.bigNumberMul(secondNum);
        //System.out.println(FirstNum.getString());

        FirstNum.bigNumberMod(secondNum);



    }


}

