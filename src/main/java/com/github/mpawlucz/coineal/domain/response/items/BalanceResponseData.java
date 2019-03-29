package com.github.mpawlucz.coineal.domain.response.items;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BalanceResponseData {

    @SerializedName("total_asset")
    private BigDecimal summaryBtc;

    @SerializedName("coin_list")
    private List<BalanceEntry> coinList;

}
