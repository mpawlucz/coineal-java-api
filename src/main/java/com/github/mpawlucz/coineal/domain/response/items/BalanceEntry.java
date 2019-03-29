package com.github.mpawlucz.coineal.domain.response.items;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BalanceEntry {

    @SerializedName("coin")
    private String currency;

    @SerializedName("normal")
    private BigDecimal normal;

    @SerializedName("btcValuatin")
    private BigDecimal btcValuatin;

    @SerializedName("locked")
    private BigDecimal locked;

}
