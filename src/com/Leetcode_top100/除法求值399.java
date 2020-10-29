package com.Leetcode_top100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/16 15:00
 * # @version 1.0
 * # @File : 除法求值399.java
 * # @Software: IntelliJ IDEA
 *[["a","b"],["b","c"]]
 * [2.0,3.0]
 * [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 *
 */
public class 除法求值399 {
    class Solution {
        /**
         * key : 当前节点
         * value : 其父节点
         */
        private Map<String, String> parents = new HashMap<>();
        /**
         * key : 当前节点
         * value : 父节点/当前节点
         */
        private Map<String, Double> values = new HashMap<>();

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            for (int i = 0; i < equations.size(); i++) {
                union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
            }
            double[] result = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                String e = queries.get(i).get(0);
                String q = queries.get(i).get(1);
                if (!(parents.containsKey(e) && parents.containsKey(q))) {
                    result[i] = -1;
                    continue;
                }
                if (e.equals(q)) {
                    result[i] = 1;
                    continue;
                }
                String r1 = root(e);
                String r2 = root(q);
                if (!r1.equals(r2)) {
                    // 如果两者不相等，说明两个节点是不连通的
                    result[i] = -1;
                    continue;
                }
                result[i] = pm(q)/pm(e);
            }
            return result;
        }

        private void union(String parent, String child, double value) {
            add(parent);//不包含，就是自己是自己的父节点，parents.put(x, x);
            add(child);//不包含，就是自己是自己的父节点，parents.put(x, x);
            String r1 = root(parent);//找到x的根节点
            String r2 = root(child);//找到x的根节点
            if (!r1.equals(r2)) {
                parents.put(r2, r1);
                values.put(r2, value * (pm(parent)/pm(child)));
            }
        }
        private void add(String x) {
            if (!parents.containsKey(x)) {
                parents.put(x, x);
                values.put(x, 1.0);
            }
        }



        /**
         * 找到x的根节点
         */
        private String root(String x) {
            while (!parents.get(x).equals(x)) {
                x = parents.get(x);
            }
            return x;
        }


        /**
         * 循环的pm函数
         */
        private double pm(String x) {
            double v = 1;
            while (!parents.get(x).equals(x)) {
                v*= values.get(x);
                x = parents.get(x);
            }
            return v;
        }

//    /**
//     * 递归的pm函数
//     * @param x
//     * @return
//     */
//    private double pm(String x){
//        return parents.get(x).equals(x)?1:values.get(x)*pm(parents.get(x));
//    }

    }
    class Solution3 {
         Map<String, String> parents;
         Map<String, Double> val;
//        首先如果有a/b = 3，我们令parent[a] = b，即让b成为a的父亲，同时让val[a] = 3。
//        所以此处的定义非常重要：即val[]数组存放的是节点与他直接父节点的关系


        public String find(String x) {

            if (!x.equals(parents.get(x))) {
                String tmpParent = parents.get(x);
                String root = find(tmpParent);
                double oldVal = val.get(x);
                val.put(x, oldVal * val.get(tmpParent));
                parents.put(x, root);
            }
            return parents.get(x);
        }

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            parents = new HashMap<>();
            val = new HashMap<>();
            int i = 0;
            for (List<String> equation : equations) {
                String from = equation.get(0);
                String to = equation.get(1);
                double cur = values[i];
                if (!parents.containsKey(from) && !parents.containsKey(to)) {
                    parents.put(from, to);
                    val.put(from, cur);
                    parents.put(to, to);
                    val.put(to, 1.0);
                } else if (!parents.containsKey(from)) {
                    parents.put(from, to);
                    val.put(from, cur);
                } else if (!parents.containsKey(to)) {
                    parents.put(to, from);
                    val.put(to, 1 / cur);
                } else {
                    String pa = find(from);
                    String pb = find(to);
                    if (!pa.equals(pb)) {
                        parents.put(pa, pb);
                        val.put(pa, cur * val.get(to) / val.get(from));
                    }
                }
                i++;
            }
            i = 0;
            double[] res = new double[queries.size()];
            for (List<String> query : queries) {
                String from = query.get(0);
                String to = query.get(1);
                if (!parents.containsKey(from) || !parents.containsKey(to)) {
                    res[i++] = -1;
                    continue;
                }
                String pa = find(from);
                String pb = find(to);
                if (!pa.equals(pb)) res[i] = -1;
                else {
                    res[i] = val.get(from) / val.get(to);
                }
                i++;
            }
            return res;
        }
    }

//    作者：kevincxks
//    链接：https://leetcode-cn.com/problems/evaluate-division/solution/zhen-zheng-de-xiao-bai-du-neng-kan-dong-de-bing-ch/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
