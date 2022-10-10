package com.example.demo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DemoApplication {
	private static List<Integer> chains = new ArrayList<Integer>();
	private static List<Integer> primes = new ArrayList<Integer>();

	public static void main(String[] args) {
		System.out.println(probSixty());
	}
	private static int probOne(){
		int sum = 0;
		int limit = 1000;
		for(int i = 0; i < limit; i++){
			if(i % 3 == 0 || i % 5 == 0){
				sum += i;
			}
		}
		return sum;
	}
	private static int probTwo(){
		int sum = 0;
		int limit = 4000000;
		List<Integer> nums = fib(limit);
		for(Integer i : nums){
			if(i % 2 == 0){
				sum += i;
			}
		}
		return sum;
	}
	private static List<Integer> fib(int limit){
		List<Integer> nums = new ArrayList<Integer>();
		Boolean limitReached = false;
		nums.add(1);
		nums.add(2);
		int index = 2;
		while(!limitReached){
			int next = nums.get(index -1) + nums.get(index - 2);
			if(next < limit){
				nums.add(next);
			}
			else{
				limitReached = true;
			}
			index++;
		}
		return nums;
	}
	private static long probThree(){
		Long num = Long.valueOf("600851475143");
		Long lpf = (long) 0; 	//largest prime factor
		while(num % 2 == 0){
			num = num/2;
			lpf = (long) 2;
		}
		for(long i = 3; i <= (long)Math.sqrt(num); i +=2){
			while((num % i == 0)){
				num = num/i;
				if(i > lpf){
					lpf = i;
				}
			}
		}
		if(num > lpf){
			lpf = num;
		}
		return lpf;
	}
	private static Long probFour(){
		Long palindrome = (long)0;
		for(int i = 100; i < 1000; i++){
			for(int j = 100; j < 1000; j++){
				if(isPalindrome(i, j)){
					palindrome = Math.max(palindrome, i*j);
				}
			}
		}
		return palindrome;
	}
	private static Boolean isPalindrome(int i, int j){
		Long n = (long)(i*j);
		char[] num = Long.toString(n).toCharArray();
		Boolean isPalindrome = true;
		int start = 0;
		int end = num.length - 1;
		while(start < end){
			if(num[start] != num[end]){
				isPalindrome = false;
			}
			start ++;
			end--;
		}
		return isPalindrome;
	}
	private static Long probFive(){
		Boolean isDivisible = false;
		Long result = (long)2520;
		while(!isDivisible){
			result++;
			isDivisible = true;
			for(int i = 2; i <= 20 ; i++){
				if(!(result % i == 0)){
					isDivisible = false;
				}
			}
		}
		return result;
	}
	private static int probSix(){
		int sumOfSq = 0;
		int sqOfSum = 0;
		for(int i = 0; i < 101; i++){
			sumOfSq += i*i;
			sqOfSum +=i;
		}
		sqOfSum = sqOfSum * sqOfSum;
		return sqOfSum - sumOfSq;
	}
	private static int probSeven(){
		int num = 0;
		int limit = 10001;
		int count = 0;
		while(count < limit){
			num++;
			if(isPrime(num)){
				count++;
			}
		}
		return num;
	}
	private static Boolean isPrime(int num){
		if(num <= 1){
			return false;
		}
		for(int i = 2; i < num; i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}
	private static Long probNine() {
		int a = 0; 
		int b = 0; 
		double c = 0;
		Boolean solved = false;
		while(!solved){
			b++;
			if(b >= 500){
				b = 0;
				a++;
			}
			c = Math.sqrt((a*a) + (b*b));
			if((a+b+c == 1000)){
				solved = true;
			}
		}
		System.out.println(a + ", " + b + ", " + c);
		return (long)a*b*(int)c;
	}
	private static Long probTen(){
		Long sum = (long)2;
		int limit = 2000000;
		for(int i = 3; i < limit; i+=2){
			if(isPrime(i)){
				sum += i;
			}
		}
		return sum;
	}
	private static int probFourteen(){
		int max_len = 0;
		int start = 0;
		int limit = 1000000;
		for(int i = 0; i < limit; i++){
			int len = lenOfChain(i);
			if(len > max_len){
				max_len = len;
				start = i;
			}
			chains.add(len);
		}
		return start;
	}
	private static int lenOfChain(int start){
		// List<Long> testing = new ArrayList<Long>();
		int count = 1;
		Long next = (long)start;
		// testing.add(next);
		if(start == 0 || start == 1){
			return 1;
		}
		while(next != (long)1){
			if(next % 2 == 0){
				next = next/2;
			}
			else{
				next = (3*next) + 1;
			}
			count++;
			if(next < chains.size() - 1){
				count += chains.get(Integer.valueOf(next.toString()));
				next = (long)1;
			}
			// testing.add(next);
		}
		return count;
	}
	private static int probTwenty(){
		BigInteger root = BigInteger.valueOf(100);
		int sum = 0;
		BigInteger fact = factorial(root);
		char[] digits = fact.toString().replaceAll("0", "").toCharArray();
		for(char digit : digits){
			sum += Character.getNumericValue(digit);
		}
		System.out.println(fact);
		System.out.println(digits);
		return sum;
	}
	private static BigInteger factorial(BigInteger root){
		BigInteger fact = root;
		for(int i = 1; !root.equals(BigInteger.valueOf(i)); i++){
			fact = fact.multiply(BigInteger.valueOf(i));
			System.out.println(i);
		}
		System.out.println(fact);
		return fact;
	}
	private static int probThirty(){
		List<Integer> nums = new ArrayList<Integer>();
		int sum = 0;
		int limit = 350000;
		for(int i = 10; i < limit; i++){
			if(thirtyHelper(i)){
				nums.add(i);
			}
		}
		for(Integer num : nums){
			sum += num;
		}
		return sum;
	}
	private static Boolean thirtyHelper(Integer num){
		Double sum = 0.0;
		char[] digits = num.toString().toCharArray();
		for(char digit : digits){
			sum += Math.pow(Character.getNumericValue(digit), 5);
		}
		if(sum == (num/1.0)){
			return true;
		}
		return false;
	}
	private static Long probForty(){
		String frac = "0.";
		int num = 1;
		while(frac.length() < 1000002){
			frac += num;
			num++;
		}

		int[] indices = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000};
		Long result = (long)1;
		for(int index : indices){
			int digit = Character.getNumericValue(frac.charAt(index + 1));
			result = result * digit;
		}

		return result;
	}
	private static int probFifty(){
		//consecutive prime sum
		for(int i = 0; i < 1000000; i++){
			if(isPrime(i)){
				primes.add(i);
			}
		}
		int sum = 0;
		Map<Integer, Integer> max = new HashMap<Integer, Integer>();
		int max_sum = primes.get(0);
		int max_count = 1;
		int count = 0;
		System.out.println(primes.get(primes.size() - 1));
		for(int i = 0; i < primes.size() - 1; i++){
			int j = i;
			sum = primes.get(i);
			count = 1;
			while(sum < primes.get(primes.size() - 1)){
				j++;
				sum += primes.get(j);
				count++;
				if(isPrime(sum) && count > max_count && sum < primes.get(primes.size() -1)){
					max_sum = sum;
					max_count = count;
					max.put(max_count, max_sum); 
				}
			}
		}
		return Collections.max(max.entrySet(), (entry1, entry2) -> entry1.getKey() - entry2.getKey()).getValue();
	}
	private static double probFiftySix(){
		double max = 0;
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				BigInteger pow = BigInteger.valueOf(i).pow(j);
				char[] digits = pow.toString().toCharArray();
				double temp_max = 0;
				for(char digit : digits){
					double num = Character.getNumericValue(digit);
					if(num != -1){
						temp_max += num;
					}
				}
				// System.out.println(i + ", " + j + ", " + pow + ", " + temp_max);
				if(temp_max > max){
					max = temp_max;
				}
			}
		}
		// System.out.println(a + ", " + b);
		return max;
	}
	private static long probSixty(){
		//prime pair sets
		for(int i = 0; i < 10000; i++){
			if(isPrime(i)){
				primes.add(i);
			}
		}
		HashMap<Integer, List<Integer>> pairs = new HashMap<Integer, List<Integer>>();
		Long result = Long.MAX_VALUE;
		for(int i = 0; i < primes.size(); i++){
			int a = primes.get(i);
			if((a * 5) >= result){
				break;
			}
			if(pairs.get(a) == null){
				pairs.put(a, makePairs(a));
			}
			for(int j = i+1; j < primes.size(); j++){
				int b = primes.get(j);
				if(a + b * 4 >= result){
					break;
				}
				if(pairs.get(a).contains(b)){
					if(pairs.get(b) == null){
						pairs.put(b, makePairs(b));
					}
					for(int k = j + 1; k < primes.size(); k++){
						int c = primes.get(k);
						if(a + b + c * 3 >= result){
							break;
						}
						if(pairs.get(a).contains(c) && pairs.get(b).contains(c)){
							if(pairs.get(c) == null){
								pairs.put(c, makePairs(c));
							}
							for(int l = k + 1; l < primes.size(); l++){
								int d = primes.get(l);
								if(a + b + c + d * 2 >= result){
									break;
								}
								if(pairs.get(a).contains(d) && pairs.get(b).contains(d) && pairs.get(c).contains(d)){
									if(pairs.get(d) == null){
										pairs.put(d, makePairs(d));
									}
									for(int m = l + 1; m < primes.size(); m++){
										int e = primes.get(m);
										if(a + b + c + d + e >= result){
											break;
										}
										if(pairs.get(a).contains(e) && pairs.get(b).contains(e) && pairs.get(c).contains(e) && pairs.get(d).contains(e)
											&& result > a + b + c + d + e){
												result = (long)(a + b + c + d + e);
												System.out.println(a + "+" + b + "+" + c + "+" + d + "+" + e + "=" + result);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	private static List<Integer> makePairs(int a) {
		List<Integer> pairs = new ArrayList<Integer>();
		int i = primes.indexOf(a);
		for(int j = i + 1; i < primes.size(); i++){
			int b = primes.get(j);
			int ab = Integer.valueOf(a + "" + b);
			int ba = Integer.valueOf(b + "" + a);
			if(isPrime(ab) && isPrime(ba)){
				pairs.add(b);
			}
		}
		return pairs;
	}

}
