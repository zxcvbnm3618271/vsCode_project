package org.example.components;


import org.junit.Test;

public class KMPmatch {

    @Test
    public void test(){

        getNext("ababc");
    }
    public static int[] getNext(String ps) {

        char[] p = ps.toCharArray();

        int[] next = new int[p.length];

        next[0] = -1;

        int j = 0;

        int k = -1;

        while (j < p.length - 1) {

            if (k == -1 || p[j] == p[k]) {

                if (p[++j] == p[++k]) {
                    // 当两个字符相等时要跳过

                    next[j] = next[k];

                } else {

                    next[j] = k;

                }

            } else {

                k = next[k];

            }

        }

        return next;

    }

}
