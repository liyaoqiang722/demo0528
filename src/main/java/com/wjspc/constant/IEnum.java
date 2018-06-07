package com.wjspc.constant;

/**
 * 本系统所有枚举实现的接口 规范 value, label 用于MyBatis枚举映射
 * Created by tianfei on 17/5/23.
 *
 * @param <E>
 * @param <T>
 */
public interface IEnum<E extends Enum<?>, T> {
    /**
     * 获取值
     * @return
     */
    T getValue();

    /**
     * 获取展示的label
     * @return
     */
    String getLabel();

}
