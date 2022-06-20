package com.xff2.Hot20;

/**
 * @author xff
 * @createTime 2022/6/9 19:08
 *给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 */
public class c04_两个数组的中位数  {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int n1 = nums1.length;
       int n2 = nums2.length;
       int [] total = new int [n1+n2]; //创建新数组，存储合并之后的
       int i=0;
       int j=0; //创建每个数组的 下标指示位置
        int k=0; //新数组的下标指示
       while(i< n1 && j<n2) { // 使用 &&
           if (nums1[i] <  nums2[j]) {
              total[k] = nums1[i];
               k++;
               i++;
           } else {
               total[k] = nums2[j];
               k++;
               j++;
           }
       }
           //一个数组已经结束
           while(i < n1){ //还剩下 n1 数组 有元素
               total[k] = nums1[i];
               k++;
               i++;
           }
           while (j < n2) { //还剩下 n1  数组
               total[k] = nums2[j];
               k++;
               j++;
           }


       if((n1+n2)%2==0){ // 偶数个
           return ( total[(n1+n2)/2-1] + total[(n1+n2)/2] )/2.0; //注意 2.0 结果
       }else {
           return total[(n1+n2)/2];
       }

    }

    public static void main(String[] args) {
       int [] nums1 =  {1, 2};
        int [] nums2 = {3,4};
        double x =findMedianSortedArrays(nums1,nums2);
        System.out.println(x);
    }
}
