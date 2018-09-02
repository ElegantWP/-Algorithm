package com.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Solution {

	/*
	 * ����
	 * 
	 * 
	 * 
	 * Array �����㷨�⼯��ѡ Given a sorted array, remove the duplicates in place such
	 * that each element appear only once and return the new length. Do not allocate
	 * extra space for another array, you must do this in place with constant
	 * memory. For example, Given input array A = [1,1,2] , Your function should
	 * return length = 2, and A is now [1,2] .
	 */
	public static int removeSame(int[] nums) {
		/*
		 * �㷨ʱ�临�Ӷ�Ҫ��ΪO(n)�ռ临�Ӷ�Ҫ��ΪO(n) ����ʹ�ö���Ŀռ� �ռ临�Ӷ�������
		 * ��󷵻�ֵ�Ľ��Ҫ�󷵻����ȥ����ͬԪ�����ݵĳ���
		 */

		if (nums.length == 0) {
			return 0;
		}

		int index = 1;// index��ΪҪ���ص�����ĳ��� ��ʼ��Ϊ1
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[index - 1]) //
				nums[index++] = nums[i];
		}
		return index;

	}

	/*
	 * ���� Follow up for "Remove Duplicates": What if duplicates are allowed at
	 * most twice? For example, given sorted array A = [1,1,1,2,2,3] , your function
	 * should return length = 5 , and A is now [1,1,2,2,3] ����
	 * ��һ��������¼һ��Ԫ�س��ֵĴ������ɡ�������Ϊ���Ѿ���������飬����һ���������ɽ���������
	 * û����������飬����Ҫ����һ��hashmap����¼���ִ�����
	 */

	// �ܽ����һ�����Ʋ���һ��������¼�������ֳ��ֵĴ���

	// ����һ ������ķ�������
	private static int RemoveDuplicates(int[] nums) {
		if (nums.length < 2) {
			return 0;
		}
		int flag = 2;// ���ü������� ��¼�������ݳ��ֵĴ���
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] != nums[flag - 2]) {// ѭ���������� ����ǰ���Ǹ�����ֵ���бȽϲ������ ����һ������ֵ����
				nums[flag++] = nums[i];
			}
		}
		return flag;
	}

	/*
	 * �ҳ������е��ظ�����
	 * 
	 * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڣ�������ĳЩ�������ظ��ģ�����֪���м����
	 * ������ظ��� Ҳ��֪�������ظ��˼������ҳ�����������һ���ظ������� ���磺[2,3,1,,0,2,5,3]
	 * ��ô��Ӧ���ظ���������2����3
	 * 
	 * ע�� ����˳����Ըı�
	 * 
	 * ˼· ����ѡ��ʹ�������㷨 ��ʱ�临�Ӷ�������nLogn
	 *
	 * Ҳ����ֻ��Hash�� ���Ƕ���������n�ĸ����ռ� ʱ�临�Ӷ���n
	 * 
	 * 
	 * ˼· ��������һά�������������Լ��Խ��
	 * 
	 * 
	 * 
	 */
	public static Collection<Integer> Solution(int[] num) {
		int temp = 0;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		if (num.length == 0 || num == null) {
			return null;
		}
		for (int i = 0; i < num.length; ++i) {
			while (num[i] != i) {
				if (num[i] != num[num[i]]) {
					temp = num[i];
					num[i] = num[temp];
					num[temp] = temp;
				} else {
					numbers.add(num[i]);
					break;// ������ǰѭ�� �ҳ����鵱���ظ������� ����������ѭ�� ������һά���������
							// ����O(n)��ʱ�临�Ӷ�
				}
			}
		}
		return numbers;
	}

	/*
	 * ���� Given an array of integers, find two numbers such that they add up to a
	 * specific target number. The function twoSum should return indices of the two
	 * numbers such that they add up to the target, where index1 must be less than
	 * index2. Please note that your returned answers (both index1 and index2) are
	 * not zero-based. You may assume that each input would have exactly one
	 * solution. Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
	 * 
	 * 
	 * ������ ˼·һ�� ������� ʱ�临�Ӷ�o(n^2)�������� ˼·����
	 * ������Hash��Ѱ�ң��㷨�¼����Ӷ�ΪO(n) ˼·���� ����Ҫ���в��ҵ������������ʱ�临�Ӷ�ΪnLogn
	 * 
	 */
	private static int[] twoSum(int[] num, int target) {
		// ����Hash������Ԫ�ؼ����±����Hash��
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			hash.put(num[i], i);
		}
		for (int i = 0; i < num.length; i++) {
			Integer v = hash.get(target - num[i]);
			if (v != null && v > i) {
				return new int[] { i + 1, v + 1 };
			}

		}
		return null;

	}

	/*
	 * Remove Element ���� Given an array and a value, remove all instances of that
	 * value in place and return the new length. The order of elements can be
	 * changed. It doesn't matter what you leave beyond the new length. ������
	 * ����Ƚϼ򵥷������̿ɲο�ȥ����ͬ���ֵ�˼· ���븨���±�flag �� ���� // Remove Element //
	 * Time Complexity: O(n), Space Complexity: O(1)
	 */
	private static int removeElement(int[] nums, int target) {

		int flag = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != target) {
				nums[flag++] = nums[i];
			}
		}
		return flag;
	}

	/*
	 * Move Zeroes ���� Given an array nums , write a function to move all 0's to
	 * the end of it while maintaining the relative order of the non-zero elements.
	 * For example, given nums = [0, 1, 0, 3, 12] , after calling your function,
	 * nums should be [1, 3, 12, 0, 0] . Note: 1. You must do this in-place without
	 * making a copy of the array. 2. Minimize the total number of operations.
	 * 
	 * ���� ����ע ��������һ����˼·���й�֮ͬ��
	 *
	 * ע���������� һ�㶼��Ҫ����ԭλ���Ͻ��в��� ����ʱ�临�Ӷ� ���пռ临�Ӷ� �ڵڶ����е��û���
	 * ���һ������ ֻ�轫����ĺ�λԪ������Ϊ0���ɴﵽ���ǵ�Ŀ�ġ�
	 */
	private int[] moveZero(int[] nums, int target) {
		int flag = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != target) {
				nums[flag++] = nums[i];
			}
		}
		for (int i = flag; i < nums.length; i++) {
			nums[i] = 0;
		}
		return nums;

	}

	/*
	 * 3Sum ���� Given an array S of n integers, are there elements a, b, c in S
	 * such that a + b + c = 0 ? Find all unique triplets in the array which gives
	 * the sum of zero. Note: Elements in a triplet (a,b,c) must be in
	 * non-descending order. (ie, a �� b �� c) The solution set must not contain
	 * duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4} . A
	 * solution set is: (-1, 0, 1) (-1, -1, 2) ����
	 * 
	 * ����Ŀ���з������֪������2sum��������������ڱ���Ľⷨ˼·
	 * 
	 * ��Ȼ �м򵥵ı����㷨 3��forѭ�� �㷨��ʱ�临�Ӷ�ΪO(N^3����Ȼ�������д����ظ�ֵ�����⵱ȻҲ���ܻᵼ��
	 * ��ʱ������� �ڴ�����˼��
	 * �ڶ������Ѿ�����������Ļ����ϣ����ǿ����ȹ̶�һ������Ȼ���ٵ������ڲ�ѯ2��������������ָ�
	 * 룬һ�� ָ������ͷ��һ��ָ������β�� ����Ѿ��̶������� �����ɶ�3SUM����Ľ��
	 * 
	 * 
	 */
	public List<List<Integer>> threeSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return null;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int j = i;
			int k = nums.length - 1;
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] < target) {
					j++;
					while (nums[j] == nums[j + 1] && j < k) {
						j++;
					}
				} else if (nums[i] + nums[j] + nums[k] > target) {
					k--;
					while (nums[k] == nums[k - 1] && j < k) {
						k--;
					}
				} else if (nums[i] + nums[j] + nums[k] == target) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
					while (nums[j] == nums[j + 1] && j < k) {
						j++;
					}
					while (nums[k] == nums[k - 1] && j < k) {
						k--;
					}
				}
			}
		}
		return result;
	}

	/*
	 * Description Description
	 * 假设有一类题目：给定一个数组，其中元素皆为int型，所有元素绝对值之和在int型示数范围内。在给定限制内选数，求在所有选法选中数之和中，最大值是多少。限制
	 * ：对于问题“最大限制相邻选数和（N）”，其限制为相邻的N个元素不能被同时选中。
	 * 聪明的WRZ同学马上知道这类题目可以按某个方向递推解决，并给出对于m个元素的数组a，N=1，2时的解法：（动态规划递推过程中用到的数组一般叫“dp”）
	 * N=1时 dp[0]=max(a[0],0); dp[i]=dp[i-1]+max(a[i],0); answer=dp[m-1]; N=2时
	 * dp[0]=max(a[0],0); dp[1]=max(a[1],dp[0]); dp[i]=max(dp[i-2]+a[i],dp[i-1]);
	 * answer=dp[m-1];
	 * 由于不管N多大，解题的代码都差不多，但N太大时代码可能会很长，WRZ不想大家花太多时间在码代码上，所以将这类问题中N=3作为题目，留给大家解决。
	 * Input 多组输入，每组两行，第一行给出m(1<=m<=100000)，第二行给出a的元素,保证a中所有元素绝对值之和在int型示数范围内 Output
	 * 对于输入的每组输出一行，问题的答案 Sample Input 4 -1 -1 -1 -1 1 0 4 1 4 3 6 Sample Output 0 0
	 * 11
	 * 
	 * 
	 * 
	 * 
	 */
	public int rec_DP(int[] arr, int i) {
		if (i == 0) {
			return arr[0];
		} else if (i == 1) {
			return Math.max(arr[0], arr[1]);
		} else {
			int select = rec_DP(arr, i - 2) + arr[i];
			int unselect = rec_DP(arr, i - 1);
			return Math.max(select, unselect);
		}
	}

	public int opt_DP(int[] arr) {
		// 创建与目标数组大小相同的数组
		int[] opt = new int[arr.length];
		opt[0] = arr[0];
		opt[1] = arr[0] > arr[1] ? arr[0] : arr[1];
		for (int i = 2; i < opt.length; i++) {
			int select = opt[i - 2] + arr[i];
			int unselect = opt[i - 1];
			opt[i] = Math.max(select, unselect);
		}
		return opt[arr.length - 1];
	}

	/**
	 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
	 * 
	 * 示例:
	 * 
	 * 输入: [0,1,0,3,12] 输出: [1,3,12,0,0] 说明:
	 * 
	 * 必须在原数组上操作，不能拷贝额外的数组。 尽量减少操作次数。
	 * 
	 * @param args
	 */
	public void moveZeroes(int[] nums) {
		int flag = 0;
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				if (i != flag) {
					temp = nums[flag];
					nums[flag] = nums[i];
					nums[i] = temp;
					flag++;
				} else {
					flag++;
				}
			}
		}
	}

	/**
	 * 167. 两数之和 II - 输入有序数组
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] numbers, int target) {
		int left = 0, right = numbers.length - 1;
		int[] res = new int[2];
		while (left < right) {
			if (numbers[left] + numbers[right] == target) {
				res[0] = left + 1;
				res[1] = right + 1;
				return res;
			} else if (numbers[left] + numbers[right] > target) {
				right--;
			} else {
				left++;
			}
		}
		return null;
	}

	/**
	 * 209 输入: s = 7, nums = [2,3,1,2,4,3] 输出: 2 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
	 * 
	 * 思路采用滑动窗口的思想维持一个循环不变量的不变 从而解决问题
	 * 
	 * @param args
	 */

	public int minSubArrayLen(int s, int[] nums) {
		int l = 0, r = -1;
		int sum = 0;
		// 最小数组的长度
		int res = nums.length + 1;
		while (l < nums.length) {
			if (sum < s && r + 1 < nums.length) {
				sum += nums[++r];
			} else {
				sum -= nums[l++];
			}
			if (sum >= s) {
				res = Math.min(res, r - l + 1);
			}

		}
		if (res == nums.length + 1) {
			return 0;
		}
		return res;
	}

	/**
	 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
	 * 
	 * 示例 1:
	 * 
	 * 输入: "abcabcbb" 输出: 3 解释: 无重复字符的最长子串是 "abc"，其长度为 3。 示例 2:
	 * 
	 * 输入: "bbbbb" 输出: 1 解释: 无重复字符的最长子串是 "b"，其长度为 1。 思路采用滑动窗口解决
	 * 
	 * @param args
	 */
	public int lengthOfLongestSubstring(String s) {
		int l = 0, r = -1;
		int res = 0;
		int[] freq = new int[256];
		while (r + 1 < s.length()) {
			if (freq[s.charAt(r + 1)] == 0 && r + 1 < s.length()) {
				freq[s.charAt(++r)]++;// 更新数据字典中对应位置的值
			} else {
				freq[s.charAt(l++)]--;// 左窗口移动
			}
			res = Math.max(res, r - l + 1);
		}
		return res;
	}

	/**
	 * 438问题思路解读 依然采用类似的滑动窗口的思想去解决
	 * 
	 * @param args
	 */

	public List<Integer> findAnagrams(String s, String p) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		int l = 0,r = 0,count = s.length();
		int[] freq = new int[256];//利用hash的思想解决字母在自创中是否出现
		char[] temp = p.toCharArray();
		for (char c : temp) {
			freq[c]++;//存贮对应位置的数值
		}
		while (r<s.length()) {
			if (freq[s.charAt(r)]>0) {
				//窗口向右移动
				r++;
				//子川的相似程度有进一步增加
				count--;
			}
			if (count == 0) {
				arrayList.add(l);
			}
			if (freq[s.charAt(l)]>0&&r-l == p.length()) {
				l++;
				count++;
			}
		}
		return arrayList;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 7, 11, 15 };
		Solution solution = new Solution();
		int[] nums = solution.twoSum2(arr, 9);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}

	}

}
