package com.aliTest;

import com.JAVA并发编程的艺术.Instance;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/16 0:54
 * # @version 1.0
 * # @File : SafeDoubleCheck.java
 * # @Software: IntelliJ IDEA
 */
public class SafeDoubleCheck {
    private static volatile Instance instance;

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (SafeDoubleCheck.class) {
                instance = new Instance();

            }
        }
        return instance;

    }
}
