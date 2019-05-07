package controllers;

import java.util.List;
import java.util.Optional;

import data.RequestHandler;
import dk.eamv.bank.domain.Bank;

public class BankController {
	RequestHandler handler = new RequestHandler();

	public Optional<Bank> getBank(int regNr) {
		return handler.getBank(regNr);
	}

	public List<Bank> getBanks() {
		return handler.getBanks();
	}
	
	public void createBank(Bank bank) {
		handler.createBank(bank);
	}
	
	public void editBank(Bank bank) {
		handler.editBank(bank);
	}
	
	public void deleteBank(String address) {
		handler.deleteBank(address);
	}
	
}
