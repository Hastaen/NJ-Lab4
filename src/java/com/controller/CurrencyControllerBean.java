/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;
import com.model.Currency;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
/**
 *
 * @author Jonas
 */



@Stateless
public class CurrencyControllerBean {
    @PersistenceContext(unitName = "NJ-Lab4")
    private EntityManager em;
    
    
    public String convert(String src, String sink, int amount){
        Currency newCurr =  em.find(Currency.class , src);
        String convertResult =  newCurr.convert(sink,amount );
        return convertResult;
        
    }
    
    
}
