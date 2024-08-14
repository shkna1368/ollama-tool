package com.example.ollama.bank;

import com.example.ollama.funcs.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.List;
import java.util.function.Function;


@Configuration(proxyBeanMethods = false)

public class BankFunction {

    @Bean
    @Description("Open bank account ")
    public Function<BankService.OpenBankAccount, String> openBankAccount(BankService bankService) {


        return bankService::openAccount;
    }


    @Bean
    @Description("transfer money")
    public Function<BankService.TransferMoney, String> fundTransfer(BankService bankService) {


        return bankService::transfer;
    }



}
