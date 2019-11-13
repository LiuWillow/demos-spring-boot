package com.lwl.shardingsphere.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * author liuweilong
 * date 2019/11/12 16:56
 * desc
 */
@Data
@TableName("t_order")
public class Order extends Model<Order> {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long companyId;
    private Long userId;
}
