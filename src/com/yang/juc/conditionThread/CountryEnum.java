package com.yang.juc.conditionThread;


import javax.annotation.Generated;

/**
 * # @author  chilcyWind
 * # @Time   2020/6/2 9:14
 * # @version 1.0
 * # @File : CountryEnum.java
 * # @Software: IntelliJ IDEA
 */
public enum CountryEnum {
    ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕");

    private Integer retCode;

    public Integer getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;

    }

    public static CountryEnum forEach_CountryEnum(int index) {
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum element : countryEnums) {
            if (index == element.getRetCode()) {
                return element;
            }

        }
        return null;
    }
}