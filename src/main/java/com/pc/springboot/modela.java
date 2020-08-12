package com.pc.springboot;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author panchi
 * @Type model.java
 * @Desc
 * @date 2020/5/30 15:51
 */
@Getter
@Setter
public class modela {
    @NotBlank(message = "id不能为空")
    @NotNull(message = "id不能为null")
    @Min(value = 18,message = "年龄最小为18")
    private String id;
    private String name;
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * <p>
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/5/30 panchi creat
 */
 
