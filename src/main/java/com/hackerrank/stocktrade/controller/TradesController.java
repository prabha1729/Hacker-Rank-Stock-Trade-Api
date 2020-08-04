package com.hackerrank.stocktrade.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.service.TradeService;

@RestController
@RequestMapping(value = "/trades")
public class TradesController {
//	@Autowired
//	private UserService userService;
	@Autowired
	private TradeService tradeService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createTrade(@Valid @RequestBody Trade trade) {
		boolean flag = tradeService.createTrade(trade);
		return flag ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		return flag ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Trade> getTradeById(@PathVariable(value = "id") Long id) {
		Trade trade = tradeService.getTradeById(id);
		if (trade!= null)
			return new ResponseEntity<>(trade, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Trade>> getAllTradesOrderById() {
		List<Trade> tradesList = tradeService.getAllTradesOrderById();
//			System.out.println(ResponseEntity.ok(tradesList));
			return new ResponseEntity<>(tradesList, HttpStatus.OK);
//			return ResponseEntity.ok(tradesList);
	}

	@RequestMapping(value = "/users/{userID}", method = RequestMethod.GET)
	public ResponseEntity<List<Trade>> getTradeByUserId(@PathVariable(value = "userID") Long userID) {
		List<Trade> tradesList = tradeService.getTradeByUserId(userID);
		if (!tradesList.isEmpty())
			return new ResponseEntity<>(tradesList, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/stocks/{stockSymbol}", method = RequestMethod.GET)
	public ResponseEntity<List<Trade>> getTradeBySymbol(@PathVariable(value = "stockSymbol") String stockSymbol) {
		List<Trade> tradesList = tradeService.getTradeBySymbol(stockSymbol);
		if (!tradesList.isEmpty())
			return new ResponseEntity<>(tradesList, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/users/{userID}/stocks/{stockSymbol}", method = RequestMethod.GET)
	public ResponseEntity<List<Trade>> getTradeByUserIdAndSymbol(@PathVariable(value = "userID") Long userID,
			@PathVariable(value = "stockSymbol") String stockSymbol) {
		List<Trade> tradesList = tradeService.getTradeByUserIdAndSymbol(userID, stockSymbol) ;
		if (!tradesList.isEmpty())
			return new ResponseEntity<>(tradesList, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
