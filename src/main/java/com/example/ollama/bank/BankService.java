package com.example.ollama.bank;

import org.springframework.stereotype.Service;

@Service
public class BankService {



public String openAccount(OpenBankAccount openBankAccount){

    return openBankAccount.toString();
}




public String transfer(TransferMoney transferMoney){

    return transferMoney.toString();
}




    record OpenBankAccount(String name,String family,String phone,Long amount) {}
    record TransferMoney(String source,String target,Long amount) {}



}

