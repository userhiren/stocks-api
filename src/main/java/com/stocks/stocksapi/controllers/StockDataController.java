package com.stocks.stocksapi.controllers;

import com.stocks.stocksapi.models.StockData;
import com.stocks.stocksapi.resources.StockDataResource;
import com.stocks.stocksapi.services.StockDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/stock-data")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StockDataController {

    private final StockDataService stockDataService;

    @GetMapping("/{stock}")
    public ResponseEntity<List<StockDataResource>> getStockData(@RequestHeader("x-client_id") String clientId, @PathVariable String stock) {
        log.info("Getting stock data for {} by client: {}", stock, clientId);
        List<StockDataResource> stockDataResourceList = stockDataService.getStockData(stock);
        return new ResponseEntity<>(stockDataService.getStockData(stock), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StockDataResource> addMissingStockData(@RequestHeader("x-client_id") String clientId, @Valid @RequestBody StockDataResource stockDataResource) {
        log.info("Loading missing stock data by client: {}", clientId);
        StockDataResource createdStockDataResource = stockDataService.addMissingStockData(clientId, stockDataResource);
        return new ResponseEntity<>(createdStockDataResource, HttpStatus.CREATED);
    }

    @PostMapping(value = "/bulk-insert", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity bulkInsertStockData(@RequestHeader("x-client_id") String clientId, @RequestParam(value = "file", required = true) MultipartFile stockDataFile) throws IOException {
        log.info("Bulk loading stock data by client: {}", clientId);
        stockDataService.bulkInsertStockDate(clientId, stockDataFile);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
