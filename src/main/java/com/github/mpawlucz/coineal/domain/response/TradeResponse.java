package com.github.mpawlucz.coineal.domain.response;

import com.github.mpawlucz.coineal.domain.response.items.TradeResponseData;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TradeResponse extends GenericResponse {

    @Builder
    public TradeResponse(String code, String msg) {
        super(code, msg);
    }

    @SerializedName("data")
    private TradeResponseData data;

}
