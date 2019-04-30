package com.joyxj.leetcode.difficulty.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */

public class E118_PascalsTriangle {

    public static void main(String[] args) {
        List<List<Integer>> list = new E118_PascalsTriangle().new Solution().generate_1(5);
        System.out.println(list.size());
        for (List<Integer> nList:list) {
            for (Integer i : nList) {
                System.out.print(i) ;
            }
            System.out.println();
        }

    }

    class Solution {
        public List<List<Integer>> generate(int numRows) {
            if (numRows == 0) {
                return new ArrayList<>();
            }
            List<List<Integer>> result = new ArrayList<>();
            for (int i=1;i<=numRows;i++) {
                List<Integer> nList = new ArrayList<>();
                result.add(nList);
                // 定义边上的二个元素的值为1
                nList.add(0, 1);
                for (int j = 1; j < i-1;j ++) {
                    nList.add(j, result.get(i-2).get(j-1) + result.get(i-2).get(j));
                }
                // 防止1层的时候写入二个元素
                if (i != 1) {
                    
                    nList.add(i-1, 1);
                }
            }
            return result;
        }

        public List<List<Integer>> generate_1(int numRows) {
            List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		    ArrayList<Integer> row = new ArrayList<Integer>();
            for(int i=0;i<numRows;i++)
            {
                row.add(0, 1);
                for(int j=1;j<row.size()-1;j++)
                    row.set(j, row.get(j)+row.get(j+1));
                allrows.add(new ArrayList<Integer>(row));
            }
            return allrows;
        }
    }

}