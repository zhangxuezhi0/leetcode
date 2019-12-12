package practice.zxz.leetcode.hash.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 计数质数
 * <p>
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * @author zhangxz
 * @date 2019-12-08 16:18
 */

public class CountPrimes {

    public static void main(String[] args) {


        int n = 10000000;
        long currentTimeMillis0 = System.currentTimeMillis();
//        System.out.println(mySolution1(n));
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(officialSolution(n));
        long currentTimeMillis2 = System.currentTimeMillis();
        System.out.println(eulerSolution(n));
        long currentTimeMillis3 = System.currentTimeMillis();
        System.out.println("====");
        System.out.println(currentTimeMillis - currentTimeMillis0);
        System.out.println(currentTimeMillis2 - currentTimeMillis);
        System.out.println(currentTimeMillis3 - currentTimeMillis2);
    }

    //欧拉筛选
    static int eulerSolution(int n) {
        int timeCount = 0;

        if (n < 2) {
            return 0;
        }
        int primesIndex = 0;
        int[] primes = new int[n];

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        //优化点： 这里的遍历边界是可以n的一半，而不需要遍历到n
        for (int i = 2; i < n / 2; i++) {
            if (isPrime[i]) {
                primes[primesIndex++] = i;
            }
            for (int j = 0; j < primes.length && i * primes[j] < n; j++) {
                timeCount++;
                isPrime[i * primes[j]] = false;
                if (i % primes[j] == 0) {
                    //最小质因子
                    break;
                }
            }
        }

        int result = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                result++;
            }
        }
        System.out.println("euler solution: " + timeCount);
        return result;
    }

    //官方题解：厄拉多塞筛法, sieve of Eratosthenes
    //时间复杂度： O(N * loglogN)
    static int officialSolution(int n) {
        int timeCount = 0;
        if (n < 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                    timeCount++;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        System.out.println("official solution: " + timeCount);
        return count;
    }

    //时间复杂度：O(n*log2n)
    ///空间复杂度：O(n)
    static int mySolution1(int n) {
        if (n - 1 < 2) {
            return 0;
        }

        //list用来保存素数
        List<Integer> list = new ArrayList<>();
        //添加第一个素数：2
        list.add(2);

        //遍历查找素数n范围内的素数
        for (int i = 3; i < n; i++) {
            //遍历list，判定i是否素数

            //如果list中有任何一个数可以整除i，或者遍历到的list的元素数值大于i的平方根，则i为合数；
            // -这里第二个条件，遍历到达i的平方根还不能整除的话，可以判定为素数，
            // -是因为合数的因子是以其平方根为中心，分布在其两边的。
            //否则为素数。因为说到底合数都是素数相乘得到的
            for (int j = 0; j < list.size(); j++) {
                Integer integer = list.get(j);
                if (i % integer == 0) {
                    //是合数
                    break;
                }
                if (j == list.size() - 1 || integer >= (int) Math.sqrt(i)) {
                    //是素数：遍历到达末尾、或者遍历到达i的平方根
                    list.add(i);
                    break;
                }
            }
        }
        return list.size();
    }

}
