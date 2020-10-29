package com.Leetcode_top100;

import java.util.*;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/13 15:19
 * # @version 1.0
 * # @File : 任务调度器621.java
 * # @Software: IntelliJ IDEA
 * 贪心算法，先执行n个，如果没有重复的话，都入队列，然后出队列，如果剩余的没有执行的任务
 * 还有出队列的元素，优先执行，然后此任务入队列。
 * 如果没有出队列的元素，查找下一个元素队列里面没有的元素执行，将此队列复制到另一个队列以实现遍历
 * 执行完的队列对应位置标记为'0'
 */
public class 任务调度器621 {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] map = new int[26];
            for (char c : tasks)
                map[c - 'A']++;
            Arrays.sort(map);//对数组按照升序排序 map[25]表示最大的数
            int time = 0;
// 我们规定 n + 1 个任务为一轮，这样的好处是同一轮中一个任务最多只能被安排一次。题目的意思是a执行完以后，要再执行n个，才能再执行a，这就是n+1个为一轮
//            我们将当前的任务按照它们剩余的次数降序排序，并选择剩余次数最多的 n + 1 个任务依次执行。
//            如果任务的种类 t 少于 n + 1 个，就只选择全部的 t 种任务，其余的时间空闲。

            while (map[25] > 0) {
                int i = 0;
                while (i <= n) {// 我们规定 n+1 个任务为一轮，这样的好处是同一轮中一个任务最多只能被安排一次。每执行一个，i+一次

                    if (map[25] == 0)
                        break;
                    if (i < 26 && map[25 - i] > 0) {//执行前n+1个任务
                        map[25 - i]--;

                    }
                    time++;//不管每一轮执行不执行任务，time都走1
                    i++;
                }
                Arrays.sort(map);//执行完一轮重新排序


            }
            return time;

        }
    }
    public class Solution2 {
        public int leastInterval(char[] tasks, int n) {
            int[] map = new int[26];
            for (char c: tasks)
                map[c - 'A']++;
            PriorityQueue < Integer > queue = new PriorityQueue < > (26, Collections.reverseOrder());
            for (int f: map) {
                if (f > 0)
                    queue.add(f);
            }
            int time = 0;
            while (!queue.isEmpty()) {
                int i = 0;//i为每轮执行的任务计数
                List< Integer > temp = new ArrayList< >();//队列里面存放取出来的元素，等一趟走完，再放进去
                while (i <= n) {//i从0到n。走n+1个元素出来
                    if (!queue.isEmpty()) {
                        if (queue.peek() > 1)
                            temp.add(queue.poll() - 1);
                        else
                            queue.poll();
                    }
                    time++;
                    if (queue.isEmpty() && temp.size() == 0)//如果大堆和队列都为空，说明任务已经被执行完了
                        break;
                    i++;
                }
                for (int l: temp)//一个周期循环完了以后，将list中的元素加入堆中，进行排序
                    queue.add(l);
            }
            return time;
        }
    }

}
