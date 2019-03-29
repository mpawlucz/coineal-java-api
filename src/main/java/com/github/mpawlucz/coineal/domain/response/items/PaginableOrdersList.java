package com.github.mpawlucz.coineal.domain.response.items;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaginableOrdersList {

    @SerializedName("count")
    private Integer count;

    @SerializedName("resultList")
    private List<OrdersListItem> orderList;

}
