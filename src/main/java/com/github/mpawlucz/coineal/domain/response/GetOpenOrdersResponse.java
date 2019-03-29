package com.github.mpawlucz.coineal.domain.response;

import com.github.mpawlucz.coineal.domain.response.items.PaginableOrdersList;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetOpenOrdersResponse extends GenericResponse {

    @Builder
    public GetOpenOrdersResponse(String code, String msg, PaginableOrdersList data) {
        super(code, msg);
        this.data = data;
    }

    @SerializedName("data")
    private PaginableOrdersList data;

}
