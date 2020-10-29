package com.yang.single;/*
 @author
 @create 2020-05-21-18:53

静态代码块方式
 */


import java.util.Properties;

public class Singleton3 {

    public final static Singleton3 INSTANCE;
    private String info;


    static {
        try {
            Properties ps = new Properties();
            ps.load(Singleton3.class.getClassLoader().getResourceAsStream("single.properties"));
            INSTANCE = new Singleton3(ps.getProperty("info"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private Singleton3(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Singleton3{" +
                "info='" + info + '\'' +
                '}';
    }
}
