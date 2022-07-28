package com.harry.responsibilitychain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequest {
    private int type = 0; //请求类型
    private float price = 0.0f; //请求金额
    private int id = 0;
}
