package com.imooc.dataobject;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 * @author Donqiuxote
 * @data 2018/2/5 9:58
 */
@Data
@Entity
@DynamicUpdate
public class OrderMaster {
    //订单id
    @Id
    private String orderId;
    //买家名字
    private String buyerName;
    //买家电话
    private String buyerPhone;
    //买家地址
    private String buyerAddress;
    //买家微信
    private String buyerOpenid;
    //订单金额
    private BigDecimal orderAmount;
    //订单状态默认0新订单
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();
    //支付状态默认0未支付
    private Integer payStatus= PayStatusEnum.WAIT.getCode();
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
}
