package com.imooc.converter;

import com.imooc.DTO.OrderDTO;
import com.imooc.dataobject.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Donqiuxote
 * @data 2018/2/11 11:25
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
       /* List<OrderDTO> orderDTOList = new ArrayList<>();
        for (OrderMaster orderMaster : orderMasterList) {
            OrderDTO orderDTO = convert(orderMaster);
            orderDTOList.add(orderDTO);
        }
        return orderDTOList;*/
        return orderMasterList.stream().map(e -> convert(e)).collect(Collectors.toList());
    }
}
