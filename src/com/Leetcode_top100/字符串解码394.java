package com.Leetcode_top100;

import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.regexp.internal.RE;

import java.util.Collections;
import java.util.LinkedList;

/**
 * # @author  chilcyWind
 * # @Time   2020/8/16 17:47
 * # @version 1.0
 * # @File : 字符串解码394.java
 * # @Software: IntelliJ IDEA
 * 在转化成 abcbcabcbc。我们可以把字母、数字和括号看成是独立的 TOKEN，并用栈来维护这些 TOKEN。具体的做法是，遍历这个栈：
 *
 * 如果当前的字符为数位，解析出一个数字（连续的多个数位）并进栈
 * 如果当前的字符为字母或者左括号，直接进栈
 * 如果当前的字符为右括号，开始出栈，一直到左括号出栈，出栈序列反转后拼接成一个字符串，此时取出栈顶的数字（此时栈顶一定是数字，
 * 想想为什么？），就是这个字符串应该出现的次数，我们根据这个次数和字符串构造出新的字符串并进栈
 *
 * 重复如上操作，最终将栈中的元素按照从栈底到栈顶的顺序拼接起来，就得到了答案。注意：这里可以用不定长数组来模拟栈操作，
 * 方便从栈底向栈顶遍历。
 *
 */
public class 字符串解码394 {

    class Solution3 {
        String src;
        int ptr;

        public String decodeString(String s) {
            src = s;
            ptr = 0;
            return getString();
        }

        public String getString() {
            if (ptr == src.length() || src.charAt(ptr) == ']') {
                // String -> EPS
                return "";
            }

            char cur = src.charAt(ptr);
            int repTime = 1;
            String ret = "";

            if (Character.isDigit(cur)) {
                // String -> Digits [ String ] String
                // 解析 Digits
                repTime = getDigits();
                // 过滤左括号
                ++ptr;
                // 解析 String
                String str = getString();
                // 过滤右括号
                ++ptr;
                // 构造字符串
                while (repTime-- > 0) {
                    ret += str;
                }
            } else if (Character.isLetter(cur)) {
                // String -> Char String
                // 解析 Char
                ret = String.valueOf(src.charAt(ptr++));
            }

            return ret + getString();
        }

        public int getDigits() {
            int ret = 0;
            while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
                ret = ret * 10 + src.charAt(ptr++) - '0';
            }
            return ret;
        }
    }

    class Solution4 {
        int ptr;
        public String decodeString(String s) {
            LinkedList<String> stk=new LinkedList<>();
            ptr=0;
            while (ptr<s.length()){
                char cur=s.charAt(ptr);
                if (Character.isDigit(cur)){//数字
                    String digits=getDigit(s);
                    stk.addLast(digits);
                }else if (Character.isLetter(cur)||cur=='['){//字母或者[，开始进行字符存储
                    stk.addLast(String.valueOf(s.charAt(ptr++)));//不能是cur，因为有可能在if别的分支里面已经改变了ptr的值
                }else {//遇见]就执行出栈操作，直到遇见数字，将字符反转，就是需要复制的字符
                    ++ptr;
                    LinkedList<String> sub=new LinkedList<>();
                    while (!"[".equals(stk.peekLast())){
                        sub.addLast(stk.removeLast());

                    }
                    Collections.reverse(sub);//将需要复制的字符串转为正常的顺序
                    stk.removeLast();//[出栈
                    int rep=Integer.parseInt(stk.removeLast());//数字出栈
                    StringBuffer t=new StringBuffer();//存储复制好的字符串
                    String o=getString(sub);//需要复制的字符串
                    // 构造字符串
                    while (rep-- > 0) {
                        t.append(o);
                    }

                    //构造好的字符转入栈
                    stk.addLast(t.toString());

                }
            }
            return getString(stk);

        }

        private String getDigit(String s) {
            StringBuffer ret=new StringBuffer();
            while (Character.isDigit(s.charAt(ptr))){
                ret.append(s.charAt(ptr++));
            }
            return ret.toString();
        }
        String getString(LinkedList<String> v){
            StringBuffer ret=new StringBuffer();
            for (String i:v
                 ) {
                ret.append(i);
            }
            return ret.toString();
        }
    }

//    总体思路与辅助栈法一致，不同点在于将 [ 和 ] 分别作为递归的开启与终止条件：
//
//    当 s[i] == ']' 时，返回当前括号内记录的 res 字符串与 ] 的索引 i （更新上层递归指针位置）；
//    当 s[i] == '[' 时，开启新一层递归，记录此 [...] 内字符串 tmp 和递归后的最新索引 i，并执行 res + multi * tmp 拼接字符串。
//    遍历完毕后返回 res。
//
//
class Solution5 {
    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }
    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();//res存储需要进行复制的字符串
        int multi = 0;//存储需要复制的倍数
        while(i < s.length()) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));//先存倍数
            else if(s.charAt(i) == '[') {
                //当 s[i] == '[' 时，开启新一层递归，记录此 [...] 内字符串 tmp 和递归后的最新索引 i，并执行 res + multi * tmp 拼接字符串。
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);//string数组第一个存储s操作完成的i的位置，第二个存储要进行复制完成的字符串
                while(multi > 0) {//将内层返回的字符串进行复制
                    res.append(tmp[1]);
                    multi--;
                }
            }
            else if(s.charAt(i) == ']')
                //当 s[i] == ']' 时，返回当前括号内记录的 res 字符串与 ] 的索引 i （更新上层递归指针位置）；
                return new String[] { String.valueOf(i), res.toString() };//string数组第一个存储i的位置，第二个存储复制完成的字符串
            else
                res.append(String.valueOf(s.charAt(i)));
            i++;
        }
        return new String[] { res.toString() };
    }
}


    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        sb.append("abc");
        sb.replace(0,1,"sdf");
        System.out.println(sb.toString());

    }


}