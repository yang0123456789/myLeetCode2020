package com.Leetcode_top100.图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/31 13:41
 * # @version 1.0
 * # @File : 课程表207.java
 * # @Software: IntelliJ IDEA
 */
public class 课程表207 {
    class Solution {
        List<List<Integer>> edges;
        int[] visited;
        boolean valid = true;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<Integer>());
            }
            visited = new int[numCourses];
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
            }
            for (int i = 0; i < numCourses && valid; ++i) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            return valid;//如果无环，说明可以完成学习，就是拓扑排序
        }

        public void dfs(int u) {
            visited[u] = 1;//设置为正在访问
            for (int v: edges.get(u)) {
                if (visited[v] == 0) {
                    dfs(v);//后续课程挨个递归
                    if (!valid) {
                        return;
                    }
                } else if (visited[v] == 1) {
                    valid = false;
                    return;
                }
            }
            visited[u] = 2;//递归结束，将这个位置设置为访问过了
        }
    }
    class Solution2 {
        List<List<Integer>> edges;
        int[] indeg;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<Integer>());
            }
            indeg = new int[numCourses];
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
                ++indeg[info[0]];
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            for (int i = 0; i < numCourses; ++i) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }

            int visited = 0;
            while (!queue.isEmpty()) {
                ++visited;
                int u = queue.poll();
                for (int v: edges.get(u)) {
                    --indeg[v];
                    if (indeg[v] == 0) {
                        queue.offer(v);
                    }
                }
            }

            return visited == numCourses;
        }
    }

}
