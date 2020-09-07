# Coineal Java API
coineal-java-api is a lightweight Java library for interacting with the [Coineal API](https://www.coineal.com/static-page/api/en_US/api.html)

## Features
- [x] getBalance
- [x] createOrder
- [x] getOpenOrders
- [x] cancelOrder

## Installation
1. Install library into your Maven's local repository by running `mvn install`
2. Add the following Maven dependency to your project's `pom.xml`:
```
<dependency>
    <groupId>com.github.mpawlucz.coineal</groupId>
    <artifactId>coineal-java-api</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## Example
```
CoinealApi api = new CoinealApi(ApiKey.builder()
                .key("<YOUR-API-KEY>")
                .secret("<YOUR-API-SECRET>")
                .build()
);
BalanceResponse balance = api.getBalance();
BigDecimal summaryBtc = balance.getData().getSummaryBtc();
```
