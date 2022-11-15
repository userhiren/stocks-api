package com.stocks.stocksapi.services;

import com.stocks.stocksapi.models.StockData;
import com.stocks.stocksapi.models.repositories.StockDataRepository;
import com.stocks.stocksapi.resources.StockDataResource;
import com.stocks.stocksapi.utilities.CsvFileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
@Slf4j
public class StockDataService {

    private final StockDataRepository stockDataRepository;

    public List<StockDataResource> getStockData(String stock) {
        return stockDataRepository.findAllByStock(stock).stream()
                .map(StockDataResource::new)
                .collect(Collectors.toList());
    }

    public StockDataResource addMissingStockData(String clientId, StockDataResource stockDataResource) {
        StockData missingStockData = new StockData(stockDataResource);
        return new StockDataResource(stockDataRepository.save(missingStockData));
    }

    public void bulkInsertStockDate(String clientId, MultipartFile stockDataFile) throws IOException {
        List<StockData> stockDataToInsert = CsvFileMapper.read(StockData.class, stockDataFile.getInputStream());
        stockDataRepository.saveAll(stockDataToInsert);
    }
}
