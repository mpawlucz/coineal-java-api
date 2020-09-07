package com.github.mpawlucz.coineal.domain.response.items;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersListItem {

    @SerializedName("id")
    private Long id;

    @SerializedName("side")
    private String side;

    @SerializedName("price")
    private BigDecimal price;

    @SerializedName("volume")
    private BigDecimal volume;

    @SerializedName("total_price")
    private BigDecimal totalPrice;

    @SerializedName("baseCoin")
    private String baseCoin;

    @SerializedName("countCoin")
    private String quoteCoin;

    @SerializedName("created_at")
    private Long createdAt;

}
