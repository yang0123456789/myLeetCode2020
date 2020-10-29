package com.Leetcode_top100;

import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/17 11:12
 * # @version 1.0
 * # @File : 前K个高频元素347.java
 * # @Software: IntelliJ IDEA
 */
public class 前K个高频元素347 {

    class Solution {
        HashMap<Integer, Integer> map = new HashMap<>();

        class repComparator implements Comparator<Integer> {
            public int compare(Integer k1, Integer k2) {
                // TODO Auto-generated method stub
                return map.get(k2) - map.get(k1);
            }
        }

        public int[] topKFrequent(int[] nums, int k) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i])) {
                    list.add(nums[i]);
                }
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
//            ArrayList<Integer> list=new ArrayList<Integer>();


//            Collections.sort(list, new repComparator());
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer k1, Integer k2) {
                    return map.get(k2) - map.get(k1);
                }
            });

            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = (Integer) list.get(i);
            }
            return res;
        }

    }

    class Solution2 {
        //借助小顶堆，只保存前k多的元素，堆顶为第k多的值，插入的时候，如果大于堆顶，就替换堆顶
        public int[] topKFrequent(int[] nums, int k) {

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                public int compare(Integer k1, Integer k2) {
                    return map.get(k1) - map.get(k2);

                }
            });
            for (Integer key : map.keySet()
            ) {
                if (queue.size() < k) {
                    queue.add(key);
                } else if (map.get(key) > map.get(queue.peek())) {
                    queue.remove();
                    queue.add(key);
                }
            }
            int[] res = new int[k];
            for(int i=0;i< k;i++){

                res[i]=queue.remove();
            }

            return res;


        }
    }
    //基于桶排序求解「前 K 个高频元素」
    class Solution3 {
        public int[] topKFrequent(int[] nums, int k) {

            // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
            HashMap<Integer,Integer> map = new HashMap();
            for(int num : nums){
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }

            //桶排序
            //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
            List<Integer>[] list = new List[nums.length+1];
            for(int key : map.keySet()){
                // 获取出现的次数作为下标
                int i = map.get(key);
                if(list[i] == null){
                    list[i] = new ArrayList();
                }
                list[i].add(key);
            }
            int[] res=new int[k];
            int j=0;

            // 倒序遍历数组获取出现顺序从大到小的排列
            for(int i = list.length - 1;i >= 0 && j < k;i--){
                if(list[i] == null) continue;
                for(int n=0;n<list[i].size() ;n++){
                    res[j++]=list[i].get(n);

                }
            }
            return res;
        }
    }


    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(5, 5);
        map.put(5, map.getOrDefault(5, 0) + 1);
        System.out.println(map.get(5));
//        int[] nums=new int[]{1,2,3,4};
//        List list = Arrays.asList(nums);
//        System.out.println((Integer)list.get(0));
        Integer[] nums = new Integer[]{1, 2, 3, 4};
        List list = Arrays.asList(nums);
        System.out.println((Integer) list.get(0));
    }

}
