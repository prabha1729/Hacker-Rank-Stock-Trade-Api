package com.hackerrank.stocktrade.service;

import java.util.List;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.model.User;

public interface TradeService {
	public void eraseAllTrades();

	public boolean createTrade(Trade trade);

	public Trade getTradeById(Long id);

	public List<Trade> getAllTradesOrderById();

	public List<Trade> getTradeByUserId(Long id);

	public List<Trade> getTradeBySymbol(String symbol);

	public List<Trade> getTradeByUserIdAndSymbol(Long id, String symbol);
}
