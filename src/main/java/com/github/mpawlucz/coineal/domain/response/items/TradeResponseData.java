package com.github.mpawlucz.coineal.domain.response.items;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TradeResponseData {

    @SerializedName("order_id")
    private Long orderId;

}
