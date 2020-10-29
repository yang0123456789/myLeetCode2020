package com.LeetCode_jianzhioffer.MoreThanHalfNum_Solution29;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/18 17:33
 * # @version 1.0
 * # @File : 候选法.java
 * # @Software: IntelliJ IDEA
 * 链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 方法三：候选法（最优解）
 * 加入数组中存在众数，那么众数一定大于数组的长度的一半。
 * 思想就是：如果两个数不相等，就消去这两个数，最坏情况下，每次消去一个众数和一个非众数，那么如果存在众数，最后留下的数肯定是众数。
 *
 * 具体做法：
 *
 * 初始化：候选人cond = -1， 候选人的投票次数cnt = 0
 * 遍历数组，如果cnt=0， 表示没有候选人，则选取当前数为候选人，++cnt
 * 否则，如果cnt > 0, 表示有候选人，如果当前数=cond，则++cnt，否则--cnt
 * 直到数组遍历完毕，最后检查cond是否为众数
 */
public class 候选法 {
//    链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163?f=discussion
//    来源：牛客网

    public int MoreThanHalfNum_Solution(int [] array) {
        int length=array.length;
        if(array==null||length<=0){
            return 0;
        }

        int result=array[0];
        int times=1;
        for(int i=1;i<length;i++){
            if(times==0){
                result=array[i];
                times=1;
            }else{
                if(array[i]==result){
                    times++;
                }else{
                    times--;
                }
            }
        }

        times=0;
        for(int i=0;i<length;i++){
            if(result==array[i]){
                times++;
            }
        }

        if(times*2<length){
            result=0;
        }
        return result;
    }

}
