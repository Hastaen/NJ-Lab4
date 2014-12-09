/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.view;

import com.controller.CurrencyControllerBean;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Jonas
 */



@Named(value = "currencyManagerMB")
@ConversationScoped
public class CurrencyManagerMB implements Serializable {

    /**
     * Creates a new instance of CurrencyManagerMB
     */

    @EJB
    private CurrencyControllerBean ccb;
    private String srcCurrency;
    private String toCurrency;
    private int amount;
    private String conversionResult;
    @Inject
    private Conversation conversation;
    
    
    public CurrencyManagerMB() {
        
    }
    
     private void startConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    private void stopConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

    
     
    
    public String convertCurr(){
        String res = null;
        try {
            res = CurrencyControllerBean.convert(srcCurrency,toCurrency,amount);
        } catch (Exception e) {
            //print error
        }
        
        return res;
    }
    public void settoCurrency(String input){
        this.toCurrency = input;
    }
    public String gettoCurrency(){
        return toCurrency;
    }
    
    public void setsrcCurrency(String input){
        this.toCurrency = input;
    }
    public String getsrcCurrency(){
        return toCurrency;
    }
    
    
}
