package com.企业面试题;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/4 14:36
 * # @version 1.0
 * # @File : nc68.java
 * # @Software: IntelliJ IDEA
 */
public class nc68 {
    public class Solution {
        public int JumpFloor(int target) {
            if(target<=1) return target;
            if (target==2)return 2;
            int n=1;
            int m=2;
            int res=0;
            for(int i=3;i<=target ;i++){
                res=n+m;
                n=m;
                m=res;

            }
            return res;


        }
    }
}
