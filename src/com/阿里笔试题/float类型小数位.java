package com.阿里笔试题;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/28 10:22
 * # @version 1.0
 * # @File : float类型小数位.java
 * # @Software: IntelliJ IDEA
 */
public class float类型小数位 {
    public static void main(String[] args) {
        float num1 = 1.23556f;
        float num2 = (float)(Math.round(num1*100))/100;  //100指的是要保留的小数位数
        System.out.println(num2);

        float num = 11.23456f;
        DecimalFormat df = new DecimalFormat("0.00");
        String num3 = df.format(num);
        System.out.println(num3);

        float f = 134.5455f;
        int scale = 2;//设置尾数
        int roundingMode = 4;//表示四舍五入，可以选择其他的舍值方式，例如去位等等
        BigDecimal b = new BigDecimal(f);
        b = b.setScale(scale, roundingMode);
        System.out.println(String.valueOf(b.floatValue()));

        //方法二:
        float scale2 = (float) 34.236323;
        DecimalFormat format = new DecimalFormat("##0.00");
        String dd = format.format(scale2);
        System.out.println(dd);

        // 方法三:
        float a = 12.32334f;
        float c = Math.round(a * 100) / 100;

        //方法四：
        float d = 123.2335f;
        String e= String.format("%.3f", d);
        System.out.println(e);

        //方法5
        float g = 123.2334f;
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(g));

    }
}
