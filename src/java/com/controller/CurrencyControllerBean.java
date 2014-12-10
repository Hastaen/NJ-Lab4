/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;
import com.model.Currency;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.Query;
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


@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class CurrencyControllerBean {
    @PersistenceContext(unitName = "NJ-Lab4PU")
    private EntityManager em;
    
    
    public String convert(String src, String sink, int amount){
        System.out.println("FUCK IS THIS jkahskjahskjahskjahkjahskjhaskjahskahskjahskjahsjkahskjahs "+src);
        System.out.println("FUCK IS THIS jkahskjahskjahskjahkjahskjhaskjahskahskjahskjahsjkahskjahs "+sink);
        System.out.println("FUCK IS THIS jkahskjahskjahskjahkjahskjhaskjahskahskjahskjahsjkahskjahs "+amount);
          
        //System.out.println(newCurr);
        Currency newCurr = em.find(Currency.class , src);
        if (newCurr == null) {
            throw new EntityNotFoundException("No account with number " + src);
        }
        if(newCurr == null){
            
        System.out.println("newCurr is null not fins fuck");
        }else{
            
        System.out.println("Have the curr" + newCurr.getSrc());
        }
        System.out.println("BEaaaaaaaaFORE CNQ !!!!!!!!!!!!!!!!!!!!!!!!! ");
       // System.out.println(newCurr);
        System.out.println("BEFORE CNQ !!!!!!!!!!!!!!!!!!!!!!!!! ");
        
        //Query query = em.createNamedQuery("Currency.findBySrc");
        
        System.out.println("BEFORE SP !!!!!!!!!!!!!!!!!!!!!!!!! ");
        //query.setParameter("src", src);
        System.out.println("BEFORE GETSINGLERESULT !!!!!!!!!!!!!!!!!!!!!!!!! ");
       /* List<Currency> list = (List<Currency>)query.getResultList();
        if(list == null){
            System.out.println("list is null");
        }else{
            System.out.println("list is NOT null");
        }
               
       for( Currency e:list )
	   	{
                    System.out.println("The source "+ e.getSrc());
                }*/
        System.out.println("wwwwwwwwwwwwwaaaaaaaaaaaatttttttt!!!!!!!!!!!!!!!!!!!!!!!!! ");
        //newCurr = (Currency)query.getSingleResult();
        System.out.println("AFTER GETSINGLERESULT !!!!!!!!!!!!!!!!!!!!!!!!! ");
        String convertResult =  newCurr.convert(sink,amount );
        System.out.println(convertResult);
        return convertResult;
        
    }
    
    
}
