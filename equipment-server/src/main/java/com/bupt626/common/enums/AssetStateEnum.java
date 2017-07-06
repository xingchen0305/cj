package com.bupt626.common.enums;

/**
 * Created by Xtj on 2017/7/3.
 */
public enum AssetStateEnum {
    UNPUBLISH(1,"未发布"),
    PUBLISH(2,"发布");
    private int value;
    private  String name;

    AssetStateEnum(final int value,final String name){
        this.setValue(value);
        this.setName(name);
    }
    // 根据index获取enum对象
    public static AssetStateEnum findByIndex(int index) {
        for (AssetStateEnum positionEnum : AssetStateEnum.values()) {
            if (index == positionEnum.getValue()) {
                return positionEnum;
            }
        }
        return null;
    }
    // 根据value获取name
    public static String  findByValue(int value) {
        for (AssetStateEnum positionEnum : AssetStateEnum.values()) {
            if (value == positionEnum.getValue()) {
                return positionEnum.getName();
            }
        }
        return null;
    }
    // 根据name获取value
    public static int  findByName(String name) {
        for (AssetStateEnum positionEnum : AssetStateEnum.values()) {
            if (name == positionEnum.getName()) {
                return positionEnum.getValue();
            }
        }
        return 0;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
