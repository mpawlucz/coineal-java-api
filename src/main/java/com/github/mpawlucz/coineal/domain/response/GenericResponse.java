package com.github.mpawlucz.coineal.domain.response;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse {

    @SerializedName("code")
    private String code;

    @SerializedName("msg")
    private String msg;

    public boolean isSuccess(){
        return "0".equalsIgnoreCase(code);
    }

}
