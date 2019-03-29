package com.github.mpawlucz.coineal;

import com.github.mpawlucz.coineal.domain.response.BalanceResponse;
import com.github.mpawlucz.coineal.rest.RestClient;
import com.github.mpawlucz.coineal.sign.ApiKey;
import com.github.mpawlucz.coineal.sign.Hmac;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CoinealApi {
    final static DecimalFormat decimalFormat;
    static {
        final DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        decimalFormat = new DecimalFormat("#0.##########", symbols);
        decimalFormat.setDecimalSeparatorAlwaysShown(true);
        decimalFormat.setGroupingUsed(false);
    }

    public static final String LIMIT_ORDER_TYPE = "1";
    public static final String BUY = "BUY";
    public static final String SELL = "SELL";
    private final Gson gson = new Gson();
    private final RestClient restClient = new RestClient();
    private final ApiKey apiKey;
    public static final Type BALANCE_TYPE_TOKEN = new TypeToken<BalanceResponse>() {
    }.getType();

    public CoinealApi(ApiKey apiKey) {
        this.apiKey = apiKey;
    }

    public BalanceResponse getBalance() throws IOException {
        final String responseText = authorizedGet(
                "https://exchange-open-api.coineal.com/open/api/user/account",
                new HashMap<>()
        );
//        System.out.println(responseText);
        final BalanceResponse response = gson.fromJson(responseText, BALANCE_TYPE_TOKEN);
        return response;
    }

    private String authorizedGet(String url, HashMap<String, String> additionalParams) throws IOException {
        final HashMap<String, String> params = getBaseParams();
        params.putAll(additionalParams);

        final String signString = params.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(e -> e.getKey() + e.getValue())
                .collect(Collectors.joining(""))
                + apiKey.getSecret();

//        System.out.println("signString: " + signString);
        final String sign = Hmac.calculateMd5(signString);
//        System.out.println("sign: " + sign);

        params.put("sign", sign);

        final String getParams = params.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));

        final String finalUrl = url + "?" + getParams;
//        System.out.println(finalUrl);

        return restClient.get(finalUrl);
    }

    private String authorizedPost(String url, HashMap<String, String> additionalParams) throws IOException {
        final HashMap<String, String> params = getBaseParams();
        params.putAll(additionalParams);

        final String signString = params.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(e -> e.getKey() + e.getValue())
                .collect(Collectors.joining(""))
                + apiKey.getSecret();

//        System.out.println("signString: " + signString);
        final String sign = Hmac.calculateMd5(signString);
//        System.out.println("sign: " + sign);

        params.put("sign", sign);

        final List<NameValuePair> postParams = params.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(e -> new BasicNameValuePair(e.getKey(), e.getValue()))
                .collect(Collectors.toList());

        return restClient.post(url, postParams, new HashMap<>());
    }

    private HashMap<String, String> getBaseParams() {
        final HashMap<String, String> params = new HashMap<>();
        params.put("api_key", apiKey.getKey());
        params.put("time", ""+(int)(System.currentTimeMillis()/1000));
        return params;
    }

    protected static String formatSatoshi(BigDecimal bigDecimal){
        if (bigDecimal == null){
            return null;
        } else {
            return decimalFormat.format(bigDecimal);
        }
    }

}
