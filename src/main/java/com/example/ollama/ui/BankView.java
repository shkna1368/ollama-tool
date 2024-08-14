package com.example.ollama.ui;

import com.example.ollama.CustomService;
import com.example.ollama.bank.BankAccount;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;

@Route("/ai-banking")
public class BankView extends VerticalLayout {
    Grid<BankAccount> bkGrid;
    TextArea textAreaPrompt;
    Button addNewBtn;
    Span labelResult;
    CustomService customService;
    public BankView( CustomService customService) {
        this.customService = customService;
        textAreaPrompt = new TextArea();
        TextField readonlyField = new TextField();
       // readonlyField.setWidth(100, Unit.PERCENTAGE);
        readonlyField.setReadOnly(true);
        readonlyField.setValue("Welcome to Beritan AI Banking ");
        readonlyField.setSizeFull();
        textAreaPrompt= new TextArea("Enter your command here");
        labelResult= new Span("");
        textAreaPrompt.setWidth(80, Unit.PERCENTAGE);
        textAreaPrompt.setHeight(80, Unit.PIXELS);
        this.addNewBtn = new Button("Send");
        addNewBtn.setWidth(20, Unit.PERCENTAGE);

        bkGrid = new Grid<>();
       // bkGrid.setItems(modelService.getAllBanAccount());
        bkGrid.setItems(new ArrayList<BankAccount>());

        bkGrid.addColumn(BankAccount::getName).setHeader("Name");
        bkGrid.addColumn(BankAccount::getAccountNumber).setHeader("Account Number");
        bkGrid.addColumn(BankAccount::getBranchName).setHeader("Branch Name");
        bkGrid.addColumn(BankAccount::getMobileNumber).setHeader("Mobile Number");
        bkGrid.addColumn(BankAccount::getPassportNumber).setHeader("Passport Number");
        bkGrid.addColumn(BankAccount::getBalance).setHeader("Balance");
        bkGrid.setHeight(600, Unit.PIXELS);
       // bkGrid.setSizeFull();
        addNewBtn.addClickListener(buttonClickEvent -> {

      var result=      customService.sendMessage(textAreaPrompt.getValue());
            labelResult.setText(result);
            System.out.println();
    });





        HorizontalLayout horizontalLayout = new HorizontalLayout(textAreaPrompt,addNewBtn);
        horizontalLayout.setHeight(20, Unit.PERCENTAGE);
        horizontalLayout.setSizeFull();
        horizontalLayout.setAlignSelf(Alignment.CENTER, addNewBtn);




        VerticalLayout actions = new VerticalLayout(readonlyField ,bkGrid,horizontalLayout);
        actions.setSizeFull();

        add(actions);

        /*actions.setAlignSelf(Alignment.CENTER, textAreaPrompt);
        actions.setAlignSelf(Alignment.CENTER, readonlyField);
*/
    }




}