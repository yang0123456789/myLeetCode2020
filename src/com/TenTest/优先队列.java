package com.TenTest;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/25
 * @Version 1.0
 * remove(Object o)
 * 从该队列中删除指定元素的单个实例（如果存在）
 **/
public class 优先队列 {
    //自定义比较器，降序排列
    static Comparator<Integer> cmp = new Comparator<Integer>() {
        public int compare(Integer e1, Integer e2) {
            return e2 - e1;  //降序
        }
    };
    public static void main(String[] args) {
        //不用比较器，默认升序排列
        Queue<Integer> q = new PriorityQueue<>();
        q.add(8);
        q.add(5);
        q.add(13);
        q.add(2);
        System.out.println("**********不使用比较器********************");
        while(!q.isEmpty())
        {
            System.out.print(q.poll()+" ");
        }
        System.out.println();
        System.out.println("**********使用比较器********************");
        //使用自定义比较器，降序排列
        Queue qq = new PriorityQueue(cmp);
        qq.add(8);
        qq.add(5);
        qq.add(13);
        qq.add(2);
        while(!qq.isEmpty())
        {
            System.out.print(qq.poll()+" ");
        }
        //不用比较器，默认升序排列
         q = new PriorityQueue<>();
        q.add(8);
        q.add(5);
        q.add(13);
        q.add(2);
        System.out.println();
        System.out.println("**********不使用比较器********************");
        while(!q.isEmpty())
        {
            System.out.print(q.remove()+" ");
        }
        System.out.println();
    }
}
