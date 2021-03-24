package com.虾皮面试;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2021/3/20
 * @Version 1.0
 * 先切分，放在数组类型的列表里，依次取出使用
 * 要建立是否已经放置该表项的布尔数组，进行控制
 * 注意！！！判断的时候 == 和 euqals方法的区别！！！
 * ！！ “==” 比较的是两个引用在内存中指向的是不是同一对象（即同一内存空间），也就是说在内存空间中的存储位置是否一致。
 * ！！ equals方法比较的是内存空间存放的数据是否相同
 *
 * 作者：huan-le-gu
 * 链接：https://leetcode-cn.com/problems/invalid-transactions/solution/java-zhu-ge-cha-zhao-beat-80-100-by-huan-le-gu/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 **/
public class 查询无效交易1169 {
    class Solution {
        public List<String> invalidTransactions(String[] transactions) {
            int nums = transactions.length;
            List<String[]> storge = new ArrayList<>();
            List<String> result = new ArrayList<>();
            boolean[] AlreadyPut = new boolean[nums];
            String name = "";
            String city = "";
            int time = 0;


            for (int i = 0; i < nums; i++) {
                String[] afterSplit = transactions[i].split(",");
                storge.add(afterSplit);
                AlreadyPut[i] = false;
            }

            for (int i = 0; i < nums; i++) {
                int j = i + 1;
                String[] itemp = storge.get(i);
                name = itemp[0];
                city = itemp[3];
                time = Integer.parseInt(itemp[1]);


                //先过滤大于1000的无效数据
                if (Integer.parseInt(itemp[2]) > 1000 && AlreadyPut[i] == false) {
                    result.add(transactions[i]);
                    AlreadyPut[i] = true;
                }

                //往后挨个比较看是不是交易时间小于60分钟，如果符合，两笔交易都是无效的
                for (; j < nums; j++) {
                    String[] jtemp = storge.get(j);

                    if (name.equals(jtemp[0]) == true && Math.abs(time - Integer.parseInt(jtemp[1])) <= 60 && city.equals(jtemp[3]) == false) {
                        if (AlreadyPut[j] == false) {
                            result.add(transactions[j]);
                            AlreadyPut[j] = true;
                        }

                        if (AlreadyPut[i] == false) {
                            result.add(transactions[i]);
                            AlreadyPut[i] = true;
                        }
                    }
                }
            }

            return result;

        }
    }
}
