package com.lwl.plus.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lwl
 * @since 2019-07-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Lalal implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idlalal;

    private String name;

    private Integer age;


}
