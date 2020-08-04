package com.hackerrank.stocktrade.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.model.User;
import com.hackerrank.stocktrade.repo.TradeRepository;
import com.hackerrank.stocktrade.repo.UserRepository;

@Service
public class TradeServiceImpl implements TradeService {
	@Autowired
	private TradeRepository tradeRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public void eraseAllTrades() {
		tradeRepository.deleteAll();
	}

	@Override
	public Trade getTradeById(Long id) {
		if (tradeRepository.findById(id).isPresent()) {
			return tradeRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public List<Trade> getAllTradesOrderById() {
		List<Trade> tradesList= tradeRepository.findAllByOrderByIdAsc();
		if(!tradesList.isEmpty()) {
			return tradesList;
		}
		return Collections.emptyList();
	}

	@Override
	public List<Trade> getTradeByUserId(Long id) {
		Long userId = null;
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userId = user.get().getId();
			System.out.println("trade by user id" + userId);
			Optional<List<Trade>> trade = tradeRepository.findByUserOrderByIdAsc(user.get());
			if (trade.isPresent()) {
				return trade.get();
			}
			return Collections.emptyList();
		}
		return Collections.emptyList();
	}

	@Override
	public List<Trade> getTradeBySymbol(String symbol) {
		Optional<List<Trade>> tradesList = tradeRepository.findBySymbolOrderByIdAsc(symbol);
		if (tradesList.isPresent())
			return tradesList.get();
		return Collections.emptyList();
	}

	@Override
	public List<Trade> getTradeByUserIdAndSymbol(Long id, String symbol) {
		Long userId = null;
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userId = user.get().getId();
			System.out.println("trade by user id and symbol" + userId);
			Optional<List<Trade>> tradesList = tradeRepository.findByUserAndSymbolOrderByIdAsc(user.get(), symbol);
			if (tradesList.isPresent()) {
				return tradesList.get();
			}
			return Collections.emptyList();
		}
		return Collections.emptyList();
	}

	@Override
	public boolean createTrade(@Valid Trade trade) {
		Long id = trade.getId();
		Optional<Trade> optTrade = tradeRepository.findById(id);
		if (!optTrade.isPresent()) {
//			User user = new User(trade.getUser().getId(), trade.getUser().getName());
			userRepository.save(trade.getUser());
			Optional<User> user1 = userRepository.findById(trade.getUser().getId());
			tradeRepository.findAll().forEach(t -> System.out.println("Trade Id----->"+t.getId()));
			System.out.println("user name"+user1.get().getName());
			tradeRepository.save(trade);
			return true;
		}
		return false;
	}

}
