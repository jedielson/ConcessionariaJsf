/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jedi.concessionaria.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jedielson Nakonieczni
 */
public class WebUtil {

    public static void addInfoMessage(String message){
        addMessage(message, FacesMessage.SEVERITY_INFO, null);
    }
    
    public static void addInfoMessage(String message, String component){
        addMessage(message, FacesMessage.SEVERITY_INFO, component);
    }
    
    public static void addErrorMessage(String message){
        addMessage(message, FacesMessage.SEVERITY_ERROR, null);
    }
    
    public static void addErrorMessage(String message, String component){
        addMessage(message, FacesMessage.SEVERITY_ERROR, component);
    }
    
    public static void addWarningMessage(String message){
        addMessage(message, FacesMessage.SEVERITY_WARN, null);
    }   
    
    public static void addWarningMessage(String message, String component){
        addMessage(message, FacesMessage.SEVERITY_WARN, component);
    }   
    
    private static void addMessage(String mensagem, FacesMessage.Severity severidade, String component){
        FacesMessage message = new FacesMessage(mensagem);
        message.setSeverity(severidade);
        
        FacesContext.getCurrentInstance().addMessage(component, message);
    }
    
}
