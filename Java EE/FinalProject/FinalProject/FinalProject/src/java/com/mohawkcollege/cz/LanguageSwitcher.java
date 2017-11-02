/*
 * StAuth10066: I Chao Zhang, 000306946 certify that this material is my original work. 
 * No other person's work has been used without due acknowledgement. 
 * I have not made my work available to anyone else.
 */
package com.mohawkcollege.cz;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Danny
 */
@ManagedBean(name = "language")
@SessionScoped
public class LanguageSwitcher implements Serializable{

private Locale locale;

    public LanguageSwitcher() {
    }
    
    @PostConstruct
    public void init(){
        locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    }
    
    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        locale = new Locale(language);
    }

    /**
     * Sets the current {@code Locale} for each user session
     *
     * @param languageCode - ISO-639 language code
     */
    public void changeLanguage(String languageCode) {
        locale = new Locale(languageCode);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
}
