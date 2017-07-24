package com.bupt.common.enums;

/**
 * Created by Xtj on 2017/7/6.
 */
public enum AssetPropertyEnum {
    PERSONAL(1, "私有"),
    TEAM(2, "公有");
    private int value;
    private String name;

    AssetPropertyEnum(final int value, final String name) {
        this.setName(name);
        this.setValue(value);
    }

    public static String findByValue(int value){
        for(AssetPropertyEnum assetPropertyEnum:AssetPropertyEnum.values()){
            if(value==assetPropertyEnum.getValue()){
                return assetPropertyEnum.getName();
            }
        }
        return null;
    }
    public static int findByName(String name){
        for(AssetPropertyEnum assetPropertyEnum:AssetPropertyEnum.values()){
            if(name.equalsIgnoreCase(assetPropertyEnum.getName())){
                return assetPropertyEnum.getValue();
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
