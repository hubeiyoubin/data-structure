package com.datastructure.chapter_04_recursion;

/**
 * @date : 2019-11-6
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(sum(arr,0));
    }
    // 计算arr[l...n)这个区间内所有数字的和
    private static int sum(int[] arr,int level){
        //递归终止条件
        if(level == arr.length - 1)
            return 0;
        //当前层处理逻辑
        int level2 = level + 1;
        //前往下一层
        int sum = arr[level] + sum(arr,level2);
        return sum;
        //其他数据处理
    }
}
