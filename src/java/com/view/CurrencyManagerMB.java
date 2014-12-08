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
    private double amount;
    
    
    
    
    public CurrencyManagerMB() {
    }
    
}
