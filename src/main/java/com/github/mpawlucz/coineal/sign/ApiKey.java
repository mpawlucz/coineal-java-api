package com.github.mpawlucz.coineal.sign;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiKey {
    private String key;
    private String secret;
}
