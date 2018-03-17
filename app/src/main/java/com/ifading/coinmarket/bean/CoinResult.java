package com.ifading.coinmarket.bean;

import java.util.List;

/**
 * Created  on 20180317//.
 *
 * @author by yangjingsheng
 */

public class CoinResult {


    private String id;

    private String name;

    private String symbol;

    private String rank;

    private String price_usd;

    private String price_btc;

    private String _24h_volume_usd;

    private String market_cap_usd;

    private String available_supply;

    private String total_supply;

    private String max_supply;

    private String percent_change_1h;

    private String percent_change_24h;

    private String percent_change_7d;

    private String last_updated;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return this.rank;
    }

    public void setPrice_usd(String price_usd) {
        this.price_usd = price_usd;
    }

    public String getPrice_usd() {
        return this.price_usd;
    }

    public void setPrice_btc(String price_btc) {
        this.price_btc = price_btc;
    }

    public String getPrice_btc() {
        return this.price_btc;
    }

    public void set_24h_volume_usd(String _24h_volume_usd) {
        this._24h_volume_usd = _24h_volume_usd;
    }

    public String get_24h_volume_usd() {
        return this._24h_volume_usd;
    }

    public void setMarket_cap_usd(String market_cap_usd) {
        this.market_cap_usd = market_cap_usd;
    }

    public String getMarket_cap_usd() {
        return this.market_cap_usd;
    }

    public void setAvailable_supply(String available_supply) {
        this.available_supply = available_supply;
    }

    public String getAvailable_supply() {
        return this.available_supply;
    }

    public void setTotal_supply(String total_supply) {
        this.total_supply = total_supply;
    }

    public String getTotal_supply() {
        return this.total_supply;
    }

    public void setMax_supply(String max_supply) {
        this.max_supply = max_supply;
    }

    public String getMax_supply() {
        return this.max_supply;
    }

    public void setPercent_change_1h(String percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public String getPercent_change_1h() {
        return this.percent_change_1h;
    }

    public void setPercent_change_24h(String percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public String getPercent_change_24h() {
        return this.percent_change_24h;
    }

    public void setPercent_change_7d(String percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }

    public String getPercent_change_7d() {
        return this.percent_change_7d;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getLast_updated() {
        return this.last_updated;
    }

    @Override
    public String toString() {
        return "CoinResult{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", rank='" + rank + '\'' +
                ", price_usd='" + price_usd + '\'' +
                ", price_btc='" + price_btc + '\'' +
                ", _24h_volume_usd='" + _24h_volume_usd + '\'' +
                ", market_cap_usd='" + market_cap_usd + '\'' +
                ", available_supply='" + available_supply + '\'' +
                ", total_supply='" + total_supply + '\'' +
                ", max_supply='" + max_supply + '\'' +
                ", percent_change_1h='" + percent_change_1h + '\'' +
                ", percent_change_24h='" + percent_change_24h + '\'' +
                ", percent_change_7d='" + percent_change_7d + '\'' +
                ", last_updated='" + last_updated + '\'' +
                '}';
    }

}
