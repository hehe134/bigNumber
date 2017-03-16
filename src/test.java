/**
 * Created by 中奇 on 2017/2/9.
 */
package test;

public class test {
    public static void main(String[] args) {
        String len1 = "1234567";
        String len2 = "2345678";

        bigNumberSimpleMulti(len1, len2);
        bigNumberSub(len1, len2);
        System.out.println(bigNumberAdd(len1, len2));
        System.out.println(bigNumberCom(len1, len2));
        System.out.println(bigNumberMod(len1, len2));
        System.out.println(bigNumberMul(len1, len2));
    }

    //Compare
    public static int bigNumberCom(String f, String s) {
        //f>s -> 2
        //f=s   ->1
        // f<s   -> 0
        char[] a = new String(f).toCharArray();
        char[] b = new String(s).toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        int len = lenA > lenB ? lenA : lenB;
        int[] result = new int[len + 1];
        for (int i = 0; i < len + 1; i++) {
            int aint = i < lenA ? (a[i] - '0') : 0;
            int bint = i < lenB ? (b[i] - '0') : 0;
            result[i] = aint + bint;
        }
        for (int i = 0; i < len; i++) {
            if (a[i] < b[i]) return -1;
            else if (a[i] > b[i]) return 1;
        }
        return 0;
    }


    // разделить
    public static String bigNumberMul(String f, String s) {
        int n = 0;
        if (bigNumberCom(f, s) == -1)
            return "0";
        else if (bigNumberCom(f, s) == 0)
            return "1";
        else while (bigNumberCom(f = bigNumberSub(f, s), "0") == 1)
                n++;
        return n + "0";
    }

    // остаток
    public static String bigNumberMod(String f, String s) {
        int n = 0;
        if (bigNumberCom(f, s) == -1)
            return f;
        else if (bigNumberCom(f, s) == 0)
            return "0";
        else while (bigNumberCom(f = bigNumberSub(f, s), "0") == 1)
                n++;
        return f;
    }

    // вычесть
    public static String bigNumberSub(String f, String s) {
        System.out.print(f + "-" + s + "=");

        char[] a = new StringBuffer(f).reverse().toString().toCharArray();
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        int len = lenA > lenB ? lenA : lenB;
        int[] result = new int[len];
        char sign = '+';
        if (lenA < lenB) {
            sign = '-';
        } else if (lenA == lenB) {
            int i = lenA - 1;
            while (i > 0 && a[i] == b[i]) {
                i--;
            }
            if (a[i] < b[i]) {
                sign = '-';
            }
        }
        for (int i = 0; i < len; i++) {
            int aint = i < lenA ? (a[i] - '0') : 0;
            int bint = i < lenB ? (b[i] - '0') : 0;
            if (sign == '+') {
                result[i] = aint - bint;
            } else {
                result[i] = bint - aint;
            }
        }
        // 如果结果集合中的某一位小于零，那么就向前一位借一，然后将本位加上10。其实就相当于借位做减法
        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] < 0) {
                result[i + 1] -= 1;
                result[i] += 10;
            }
        }

        StringBuffer sb = new StringBuffer();
        if (sign == '-') {
            sb.append('-');
        }

        boolean flag = true;
        for (int i = len - 1; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(result[i]);
        }
        // 如果最终结果集合中没有值，就说明是两值相等，最终返回0
        if (sb.toString().equals("")) {
            sb.append("0");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }


    //сложить
    public static String bigNumberAdd(String f, String s) {
        char[] a = new StringBuffer(f).reverse().toString().toCharArray();
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        int len = lenA > lenB ? lenA : lenB;
        int[] result = new int[len + 1];
        for (int i = 0; i < len + 1; i++) {
            int aint = i < lenA ? (a[i] - '0') : 0;
            int bint = i < lenB ? (b[i] - '0') : 0;
            result[i] = aint + bint;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        boolean flag = true;
        for (int i = len; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }

    // умножить
    public static void bigNumberSimpleMulti(String f, String s) {
        System.out.print(f + "*" + s + "=");

        char[] a = new StringBuffer(f).reverse().toString().toCharArray();
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        int len = lenA + lenB;
        int[] result = new int[len];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[i + j] += (int) (a[i] - '0') * (int) (b[j] - '0');
            }
        }
        // 处理结果集合，如果是大于10的就向前一位进位，本身进行除10取余
        for (int i = 0; i < result.length; i++) {
            if (result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        // 该字段用于标识是否有前置0，如果是0就不需要打印或者存储下来
        boolean flag = true;
        for (int i = len - 1; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(result[i]);
        }

        // 返回最终结果
        System.out.println(sb.toString());
    }
}

