package me.xiaoyuu.common;

public enum EnumMap {

    grant_type("grant_type","client_credential"),
    appID("appID","wxade82343d0ed7697"),
    appSecret("appSecret","f138fdc8563e412258965826def70aee"),
    token("token","xiaoyu1126"),
    encodingAESKey("encodingAESKey","ATUNmUvjQ5LMhK4vMXYRtt5It1OyGqUQRZ5hOgB9iyC"),
    access_token("access_token",""),
    man("男","1"),
    woman("女","0");

    String name;
    String value;

    EnumMap(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
