import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PrimeTest {

    @Test
    public void getAll(){
        int n=1000000;
        //System.out.println(countPrimes(n));
        System.out.println(countPrimes2(n));
        //1  3  5  7  9
        //11 13 15 17 19
        //21 23 25 27 29
        //31 33 35 37 39
        //41 43 45 47 49

       /* int primeCount = 0;
        for (int i = 1; i < odd.length; i+=2) {
            if(odd[i]!=0) {
                primeCount++;
                System.out.println(odd[i]);
            }
        }
        System.out.println("素数个数："+primeCount);*/

        //2、3、5、7、11、13、17、19、23、29、31、37、41、43、47、53、59、61、67、71、73、79/83、89、97
      /*  int[] odd = new int[]{1,3,5,7,9};
        ArrayList<Integer> notPrimeInOdd = new ArrayList<>();
        notPrimeInOdd.add(1);
        notPrimeInOdd.add(3);
        notPrimeInOdd.add(5);
        notPrimeInOdd.add(7);
        notPrimeInOdd.add(9);

        //int[] notPrimeInOdd = new int[] {1, 3, 5, 7, 9};

        for (int i = 0; i < notPrimeInOdd.size(); i++) {
            for (int j = i; j < notPrimeInOdd.size(); j++) {
                int newNumber = notPrimeInOdd.get(i)*notPrimeInOdd.get(j);
                notPrimeInOdd.add(newNumber);
                System.out.println(notPrimeInOdd.get(i)*notPrimeInOdd.get(j));
            }
        }*/

       /* int base=10;
        int max=n/base; //n=100时i=10

        for(int j=0;j<max;j++) {
            for (int i = 0; i < 5; i++) {
                int prime = j*base+odd[i];
                System.out.println(prime);
            }
        }*/



    }

    public int countPrimes(int n) {
        //int[] odd = new int[n+1];
//        for (int i = 1; i <= odd.length-1; i+=2) {
//            odd[i] = i;
//        }
        int count = 0;
        int oddCount = (int)Math.ceil((double)n/2); //奇数的个数
        HashSet<Integer> set = new HashSet<>();
        //结果数字是 n/3=33.34
        //System.out.println(n/3);
        for (int i = 3; i <= n/3; i += 2) {
            for (int j = i; j <= n/3; j += 2) {
                count++;
                int result = i*j;
                if(result<=n){
                    //set.add(result);
                    //oddCount--;
//                    try {
//                        odd[notPrime] = 0; //将奇数中非素数去除
//                    }catch (Exception e){
//                        System.out.println(notPrime);
//
//                    }
                    //System.out.println(i+"*"+j+"="+i*j);
                }else {
                    continue; //本轮超出最大数，则不继续求了。
                }

            }
        }
        //System.out.println("素数个数："+(oddCount-set.size()));
        System.out.println(count);
        return oddCount-set.size();

    }


    public int countPrimes2(int n) {
        int count=0;
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                count++;
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        System.out.println(count);
        return primes.size();
    }


}
