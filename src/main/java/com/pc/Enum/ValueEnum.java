package com.pc.Enum;

import lombok.Getter;
import lombok.ToString;

/**
 * @author panchi
 * @Type ValueEnum.java
 * @Desc
 * @date 2020/3/11 16:41
 */
@Getter
@ToString
public enum ValueEnum {
    LINGXI("1","灵犀"),
    BWEG("2","贝瓦儿歌");

    private String code;
    private String msg;

    ValueEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/11 panchi create
 */ 
