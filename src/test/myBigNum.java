/**
 * Created by 中奇 on 2017/3/23.
 */
package test;

public class myBigNum {
    char[] a;
    char[] b;

    String f, s;


    public myBigNum(String f, String s) {
        a = new StringBuffer(f).reverse().toString().toCharArray();
        b = new StringBuffer(s).reverse().toString().toCharArray();
        this.f = f;
        this.s = s;
    }


    //Compare
    public int bigNumberCom(String f, String s) {
        //f>s -> 2
        //f=s   ->1
        // f<s   -> 0
        char[] a = new String(f).toCharArray();
        char[] b = new String(s).toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        if (lenA < lenB) return -1;
        else if (lenA > lenB) return 1;
        else {
            for (int i = 0; i < lenA; i++) {
                if (a[i] < b[i]) return -1;
                else if (a[i] > b[i]) return 1;
            }
            return 0;
        }
    }

    //Compare1
    public void bigNumberCom1() {
        //f>s -> 2
        //f=s   ->1
        // f<s   -> 0
        int lenA = a.length;
        int lenB = b.length;
        if (lenA < lenB) System.out.println(f + "<" + s);
        else if (lenA > lenB) System.out.println(f + ">" + s);
        else {
            for (int i = 0; i < lenA; i++) {
                if (a[i] < b[i]) System.out.println(f + "<" + s);
                else if (a[i] > b[i]) System.out.println(f + ">" + s);
            }
            System.out.println(f + "=" + s);
        }
    }

    // разделить
    public void bigNumberMul() {

        int n = 1;
        String f1 = f;
        if (bigNumberCom(f, s) == -1)
            System.out.println(f + "/" + s + "=" + 0);
        else if (bigNumberCom(f, s) == 0)
            System.out.println(f + "/" + s + "=" + 1);
        else while (bigNumberCom(f = bigNumberSub(f, s), "0") == 1) {
                n++;
            }
        System.out.println(f1 + "/" + s + "=" + n);
    }

    // остаток
    public void bigNumberMod() {
        int n = 0;
        String f1 = f;
        String f2 = f;
        if (bigNumberCom(f, s) == -1)
            System.out.println(f1 + "%" + s + "=" + f);
        else if (bigNumberCom(f, s) == 0)
            System.out.println(f1 + "%" + s + "=" + 0);
        else while (bigNumberCom(f2 = bigNumberSub(f2, s), "0") == 1) {
                n++;
            }
        System.out.println(f1 + "%" + s + "=" + f2);
    }

    // вычесть
    public String bigNumberSub() {
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
        if (sb.toString().equals("")) {
            sb.append("0");
        }
        return sb.toString();
    }


    // 重载
    public String bigNumberSub(String f, String s) {
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
        if (sb.toString().equals("")) {
            sb.append("0");
        }
        return sb.toString();
    }


    //сложить
    public String bigNumberAdd() {
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

        // System.out.println(sb.toString());
        return sb.toString();
    }

    // умножить
    public void bigNumberSimpleMulti() {
        System.out.print(f + "*" + s + "=");

        char[] a = new StringBuffer(f).reverse().toString().toCharArray();
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        int len = lenA + lenB;
        int[] result = new int[len];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[i + j] += (a[i] - '0') * (b[j] - '0');
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        boolean flag = true;
        for (int i = len - 1; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(result[i]);
        }
        System.out.println(sb.toString());
    }
}
