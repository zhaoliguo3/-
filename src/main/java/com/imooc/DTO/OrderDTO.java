package com.imooc.DTO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.dataobject.OrderDetail;
import com.imooc.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Donqiuxote
 * @data 2018/2/5 11:53
 */
@Data
//空字段不显示
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    //订单id
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
    private Integer orderStatus;
    //支付状态默认0未支付
    private Integer payStatus;
    //创建时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    //更新时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
    //订单详情列表
    private List<OrderDetail> orderDetailList;
}



