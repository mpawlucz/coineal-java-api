package com.github.mpawlucz.coineal.domain.response;

import com.github.mpawlucz.coineal.domain.response.items.BalanceResponseData;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BalanceResponse extends GenericResponse{

    @Builder
    public BalanceResponse(String code, String msg, BalanceResponseData data) {
        super(code, msg);
        this.data = data;
    }

    @SerializedName("data")
    private BalanceResponseData data;


}
