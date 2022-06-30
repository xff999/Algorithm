package com.xff2.hot40;


import java.util.Arrays;

/**
 * @author xff
 * @createTime 2022/6/29 20:11


给定一个 n × n 的二维矩阵 matrix 表示一个图像。
 请你将图像顺时针旋转 90 度。
 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。
 请不要 使用另一个矩阵来旋转图像。



输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[[7,4,1],[8,5,2],[9,6,3]]

输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]


 */
public class c48_旋转图像 {


    public static void main(String[] args) {
       int  [][] maxtri = { {1,2,3},{4,5,6},{7,8,9}};
        System.out.println("转换前");
        for (int i = 0; i <maxtri.length ; i++) {
            System.out.println(Arrays.toString(maxtri[i]));
        }

        rotate(maxtri);

        System.out.println("转换后");
        for (int i = 0; i <maxtri.length ; i++) {
            System.out.println(Arrays.toString(maxtri[i]));
        }

    }
    //不使用 新的矩阵，直接要在 元素上修改

    //使用 水平反转 ，和主对角线反
       // matrix[row][col]水平轴翻转 matrix[n−row−1][col]
      //matrix[row][col]主对角线翻转matrix[col][row]
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        //水平反转
        for(int i=0; i< n/2 ;i++){  //遍历 行上面的一半
            for (int j = 0; j < n; j++) {  //列要转换
                int temp = matrix[i][j]; //保存这个位置的值
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


    }
}
