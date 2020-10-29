package com.面试算法题;

import org.junit.Test;

import java.math.BigInteger;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/28 0:56
 * # @version 1.0
 * # @File : BigIntegerTest.java
 * # @Software: IntelliJ IDEA
 *
 * https://blog.csdn.net/weixin_44259720/article/details/87002816
 */
public class BigIntegerTest {
    //基本运算:add(),subtract(),multiply(),divide(),mod(),remainder(),pow(),abs(),negate()
    @Test
    public void testBasic() {
        BigInteger a = new BigInteger("13");
        BigInteger b = new BigInteger("4");
        int n = 3;

        //1.加
        BigInteger bigNum1 = a.add(b);			//17
        //2.减
        BigInteger bigNum2 = a.subtract(b);		//9
        //3.乘
        BigInteger bigNum3 = a.multiply(b);		//52
        //4.除
        BigInteger bigNum4 = a.divide(b);		//3
        //5.取模(需 b > 0，否则出现异常：ArithmeticException("BigInteger: modulus not positive"))
        BigInteger bigNum5 = a.mod(b);			//1
        //6.求余
        BigInteger bigNum6 = a.remainder(b);	//1
        //7.平方(需 n >= 0，否则出现异常：ArithmeticException("Negative exponent"))
        BigInteger bigNum7 = a.pow(n);			//2197
        //8.取绝对值
        BigInteger bigNum8 = a.abs();			//13
        //9.取相反数
        BigInteger bigNum9 = a.negate();		//-13
    }

    //比较大小:compareTo(),max(),min()
    @Test
    public void testCompare() {
        BigInteger bigNum1 = new BigInteger("52");
        BigInteger bigNum2 = new BigInteger("27");

        //1.compareTo()：返回一个int型数据（1 大于； 0 等于； -1 小于）
        int num = bigNum1.compareTo(bigNum2);			//1

        //2.max()：直接返回大的那个数，类型为BigInteger
        //	原理：return (compareTo(val) > 0 ? this : val);
        BigInteger compareMax = bigNum1.max(bigNum2);	//52

        //3.min()：直接返回小的那个数，类型为BigInteger
        //	原理：return (compareTo(val) < 0 ? this : val);
        BigInteger compareMin = bigNum1.min(bigNum2);	//27
    }

    //常量(返回BigInteger类型)
    //有朋友提到的-1和2，源码注释里面已表明不再输出(Not exported.)
    @Test
    public void testFinalNum() {
        //0
        BigInteger zero = BigInteger.ZERO;
        //1
        BigInteger one = BigInteger.ONE;
        //10
        BigInteger ten = BigInteger.TEN;
    }

    
}
