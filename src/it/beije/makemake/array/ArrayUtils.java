package it.beije.makemake.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayUtils {

    public static int max(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }

    public static int maxi(int[] a) {
        int max = a[0];
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                index = i;
            }
        }
        return index;
    }

    public static int min(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min)
                min = a[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 9, 22, 15, 24, 7, 1};
//        System.out.println(max(a));
//        System.out.println(min(a));
//        System.out.println(contains(15, new Integer[]{3, 6, 2, 15}));
//        System.out.println(contains(4, new Integer[]{3, 6, 2, 15}));
        String[] s = new String[] {"ciao", "cane", "carota"};
//        System.out.println(contains("cane", s));
//        System.out.println(contains("zanzara", s));
        System.out.println(isCrescente(a));
        System.out.println(isCrescente(a));
        int[] a2 = new int[]{3, 3, 6, 2, 6, 7, 5, 5, 5, 1, 3, 3, 5, 5, 5};
        System.out.println(mostRecurrent(a2));
        System.out.println(mediaMultipliDi3(a));
        stampaZigZag(a);
        String[] s2 = addString("potamocero", s);
        for (String x :
                s2) {
            System.out.println(x);
        }
    }

    public static boolean contains(int e, int[] arr) {
        for (int x:
                arr) {
            if (x == e) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(Object e, Object[] arr) {
        for (Object x:
                arr) {
            if (x.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCrescente(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i-1]) return false;
        }
        return true;
    }

    public static int mostRecurrent(int[] array) {
        int[] freq = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < freq.length; j++) {
                if (array[i]==array[j]) freq[j]++;
            }
        }
        return array[maxi(freq)];
    }

    public static double mediaMultipliDi3(double[] a) {
        double acc = 0;
        int n = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 3 == 0) {
                acc+=a[i];
                n++;
            }
        }
        return acc/n;
    }

    public static double mediaMultipliDi3(int[] a) {
        double acc = 0;
        int n = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 3 == 0) {
                acc+=a[i];
                n++;
            }
        }
        return acc/n;
    }

    public static void stampaZigZag(int[] a) {
        int i;
        for (i = 0; i < a.length / 2; i++) {
            System.out.print(a[i]);
            System.out.print(a[a.length-1-i]);
        }
        if (a.length % 2 !=0) System.out.print(a[i]);
    }

    public static String[] addString(String s, String[] a) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, a);
        list.add(s);
        return list.toArray(new String[0]);
    }

}
