package main;

import org.springframework.data.repository.CrudRepository;

import main.Bank;
public interface BankRepository extends CrudRepository<Bank, Integer> {
}
