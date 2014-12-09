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
    
    private static final long serialVersionUID = 16247164405L;
    @EJB
    private CurrencyControllerBean ccb;
    private String srcCurrency;
    private String toCurrency;
    private int Amount;
    private String conversionResult = null;
    @Inject
    private Conversation conversation;
    
    
    
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

    
     public String getconversionResult(){
         return conversionResult;
     }
    
    public void convertCurr(){
      
        try {
            startConversation();
            conversionResult = ccb.convert(srcCurrency,toCurrency,Amount);
        } catch (Exception e) {
            //print error
            
        }
        
        
    }
    
     public void setAmount(String input){
        this.Amount = Integer.parseInt(input);
    }
    public String getAmount(){
        return String.valueOf(Amount);
    }
    
    
    public void settoCurrency(String input){
        this.toCurrency = input;
    }
    public String gettoCurrency(){
        return toCurrency;
    }
    
    public void setsrcCurrency(String input){
        this.srcCurrency = input;
    }
    public String getsrcCurrency(){
        return srcCurrency;
    }
    
    
}
