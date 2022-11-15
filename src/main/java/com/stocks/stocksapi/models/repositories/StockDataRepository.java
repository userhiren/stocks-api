package com.stocks.stocksapi.models.repositories;

import com.stocks.stocksapi.models.StockData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface StockDataRepository extends CrudRepository<StockData, UUID> {
    List<StockData> findAllByStock(String stock);
}
