package com.github.mpawlucz.coineal.domain.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TradeRequest {
    private String base;
    private String quote;
    private BigDecimal volume;
    private BigDecimal price;
    private Boolean isBuy;
}
