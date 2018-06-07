package com.wjspc.constant;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by 79445 on 2018/6/4.
 */
public enum UserStatus implements IEnum<UserStatus, String>{

    /**
     *
     */
    NOMAL("1", "正常使用"),
    CLOSE("0", "关闭");
    /**
     * enum map
     */
    private static Map<String, UserStatus> enumMap = new HashMap();

    static {
        for (UserStatus type : UserStatus.values()) {
            enumMap.put(type.getValue(), type);
        }
    }

    /**
     * key
     */
    private String value;
    /**
     * value
     */
    private String label;

    UserStatus(String value, String label) {
        this.value = value;
        this.label = label;
    }

    /**
     * 获取值
     *
     * @return
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * 获取展示的label
     *
     * @return
     */
    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("value", value)
                .append("label", label)
                .toString();
    }

    /**
     * 获取value的枚举
     *
     * @param value String
     * @return
     */
    public static UserStatus getEnum(String value) {
        return enumMap.get(value);
    }

    /**
     * 获取label的枚举
     *
     * @param label String
     * @return
     */
    public static UserStatus getEnumByLabel(String label) {
        Set<Map.Entry<String, UserStatus>> entries = enumMap.entrySet();
        Iterator<Map.Entry<String, UserStatus>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, UserStatus> next = iterator.next();
            if (label.equals(next.getValue().getLabel())) {
                return next.getValue();
            }
        }
        return null;
    }
}
