package com.stocks.stocksapi.models;

import com.stocks.stocksapi.resources.StockDataResource;
import com.stocks.stocksapi.utilities.FieldConversionUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StockDataKey.class)
public class StockData extends BaseModel {


    private int quarter;

    @Id
    private String stock;

    @Id
    private Date date;

    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;

    private int volume;

    private Double percent_change_price;
    private Double percent_change_volume_over_last_wk;

    private int previous_weeks_volume;

    private BigDecimal next_weeks_open;
    private BigDecimal next_weeks_close;

    private Double percent_change_next_weeks_price;

    private int days_to_next_dividend;

    private Double percent_return_next_dividend;

    public StockData(StockDataResource stockDataResource) {
        this.quarter = Integer.parseInt(stockDataResource.getQuarter());
        this.stock = stockDataResource.getStock();
        this.date = FieldConversionUtils.getDateFromString(stockDataResource.getDate());
        this.open = FieldConversionUtils.getCurrency(stockDataResource.getOpen());
        this.high = FieldConversionUtils.getCurrency(stockDataResource.getHigh());
        this.low = FieldConversionUtils.getCurrency(stockDataResource.getLow());
        this.close = FieldConversionUtils.getCurrency(stockDataResource.getClose());
        this.volume = Integer.parseInt(stockDataResource.getVolume());
        this.percent_change_price = Double.parseDouble(stockDataResource.getPercentChangePrice());
        this.percent_change_volume_over_last_wk = Double.parseDouble(stockDataResource.getPercentChangeVolumeOverLastWk());
        this.previous_weeks_volume = Integer.parseInt(stockDataResource.getPreviousWeeksVolume());
        this.next_weeks_open = FieldConversionUtils.getCurrency(stockDataResource.getNextWeeksOpen());
        this.next_weeks_close = FieldConversionUtils.getCurrency(stockDataResource.getNextWeeksClose());
        this.percent_change_next_weeks_price = Double.parseDouble(stockDataResource.getPercentChangeNextWeeksPrice());
        this.days_to_next_dividend = Integer.parseInt(stockDataResource.getDaysToNextDividend());
        this.percent_return_next_dividend = Double.parseDouble(stockDataResource.getPercentReturnNextDividend());
    }

    public void setDate(String dateString) {
        this.date = FieldConversionUtils.getDateFromString(dateString);
    }

    public void setOpen(String open) {
        this.open = BigDecimal.valueOf(Double.parseDouble(open.replace("$", "")));
    }

    public void setHigh(String high) {
        this.high = BigDecimal.valueOf(Double.parseDouble(high.replace("$", "")));
    }

    public void setLow(String low) {
        this.low = BigDecimal.valueOf(Double.parseDouble(low.replace("$", "")));
    }

    public void setClose(String close) {
        this.close = BigDecimal.valueOf(Double.parseDouble(close.replace("$", "")));
    }

    public void setNext_weeks_open(String nextWeeksOpen) {
        this.next_weeks_open = BigDecimal.valueOf(Double.parseDouble(nextWeeksOpen.replace("$", "")));
    }

    public void setNext_weeks_close(String nextWeeksClose) {
        this.next_weeks_close = BigDecimal.valueOf(Double.parseDouble(nextWeeksClose.replace("$", "")));
    }
}

class StockDataKey implements Serializable {

    @Column(name = "stock", nullable = false)
    private String stock;

    @Column(name = "date", nullable = false)
    private Date date;
}
