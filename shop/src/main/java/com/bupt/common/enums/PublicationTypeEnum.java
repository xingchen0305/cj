package com.bupt.common.enums;

/**
 * Created by Xtj on 2017/7/6.
 */
public enum PublicationTypeEnum {
    BOOK_SALE(1,"出售"),
    BOOK_RENT(2,"出租"),
    BOOK_EXCHANGE(3,"以物易物");
    private int value;
    private String name;
    PublicationTypeEnum(final int value,final String name){
        this.setValue(value);
       this.setName(name);
    }
    // 根据index获取enum对象
    public static PublicationTypeEnum findByIndex(int index){
        for(PublicationTypeEnum positionEnum :PublicationTypeEnum.values()){
            if(index==positionEnum.getValue()){
                return positionEnum;
            }
        }
        return null;
    }
    public static String findByValue(int value){
        for(PublicationTypeEnum positionEnum :PublicationTypeEnum.values()){
            if(value==positionEnum.getValue()){
                return positionEnum.getName();
            }
        }
        return null;
    }
    public static int findByValue(String name){
        for(PublicationTypeEnum positionEnum :PublicationTypeEnum.values()){
            if(name.equalsIgnoreCase(positionEnum.getName())){
                return positionEnum.getValue();
            }
        }
        return -1;
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
