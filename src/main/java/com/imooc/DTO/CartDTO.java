package com.imooc.DTO;

import lombok.Data;

/**
 * 购物车
 * @author Donqiuxote
 * @data 2018/2/5 15:08
 */
@Data
public class CartDTO {
    //商品id
    private String productId;
    //商品数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
