package com.Leetcode_top100.图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/31 10:48
 * # @version 1.0
 * # @File : 课程表II.java
 * # @Software: IntelliJ IDEA
 */
public class 课程表II_210 {
//    对于一个节点 uu，如果它的所有相邻节点都已经搜索完成，那么在搜索回溯到 uu 的时候，uu 本身也会变成一个已经搜索完成的节点。
//    这里的「相邻节点」指的是从 uu 出发通过一条有向边可以到达的所有节点。
//    方法一：深度优先搜索
    class Solution {
        // 存储有向图.例如第i-1个位置存储的事 [2,3,4]，表示完成 i-1才能完成2,3,4课程
        List<List<Integer>> edges;

        // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
        int[] visited;

        // 用数组来模拟栈，下标 n-1 为栈底，0 为栈顶。按顺序存储学习课程的顺序
        int[] result;

        // 判断有向图中是否有环
        boolean valid = true;

        // 栈下标
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<Integer>());
            }

            visited = new int[numCourses];
            result = new int[numCourses];

            index = numCourses - 1;
//            现在你总共有 n 门课需要选，记为 0 到 n-1。
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
            }
            // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索valid=true表示无环
            for (int i = 0; i < numCourses && valid; ++i) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            if (!valid) {
                return new int[0];
            }
            // 如果没有环，那么就有拓扑排序
            return result;
        }



        public void dfs(int u) {
            // 将节点标记为「搜索中」
            visited[u] = 1;
            // 搜索其相邻节点
            // 只要发现有环，立刻停止搜索
            for (int v: edges.get(u)) {
                // 如果「未搜索」那么搜索相邻节点
                if (visited[v] == 0) {
                    dfs(v);
                    if (!valid) {
                        return;
                    }
                }
                // 如果「搜索中」说明找到了环
                else if (visited[v] == 1) {
                    valid = false;
                    return;
                }
            }
            // 将节点标记为「已完成」。假设我们当前搜索到了节点 uu，如果它的所有相邻节点都已经搜索完成，那么这些节点都已经在栈中了，此时我们就可以把 uu 入栈。
            visited[u] = 2;
            // 将节点入栈
            result[index--] = u;
        }
    }
    class Solution2 {
        //  广度优先搜索

        // 存储有向图
        List<List<Integer>> edges;

        // 存储每个节点的入度
        int[] indeg;

        // 存储答案
        int[] result;

        // 答案下标
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<Integer>());
            }
            indeg = new int[numCourses];
            result = new int[numCourses];
            index = 0;
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
                ++indeg[info[0]];
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            // 将所有入度为 0 的节点放入队列中
            for (int i = 0; i < numCourses; ++i) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                // 从队首取出一个节点
                int u = queue.poll();
                // 放入答案中
                result[index++] = u;
                for (int v: edges.get(u)) { //u是v的入度
                    --indeg[v];
                    // 如果相邻节点 v 的入度为 0，就可以选 v 对应的课程了
                    if (indeg[v] == 0) {
                        queue.offer(v);
                    }
                }
            }

            if (index != numCourses) {
                return new int[0];
            }
            return result;
        }
    }

}
