package com.joyxj.leetcode.difficulty.easy;

import java.util.ArrayList;
import java.util.List;

public class E119_PascalsTriangleII {

    public static void main(String[] args) {
    
    }
    
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> result = new ArrayList<>();
            for (int i=0;i<rowIndex + 1;i++) {
                // 第一个位置为1
                // 关键就在于add方法，i每增加1就会新增填充一个元素在初始位置，
                // 此时result的元素个数就和rowIndex一致了,后面只需要重置元素的值就可以了
                result.add(0, 1);
                for (int j=1;j<i;j++) {
                    result.set(j,result.get(j) + result.get(j+1));
                }
            }
            return result;
        }
    }

}