/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohawkcollege.cz;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;

/**
 *
 * @author Danny
 */
@ManagedBean(name = "registerBean")
@SessionScoped
public class Register implements Serializable{
        @PersistenceContext(unitName = "FinalProjectPU")
        private EntityManager em;
        @Resource
        private javax.transaction.UserTransaction utx;

        /**
         * Creates a new instance of registerBean
         */
        public Register() {
        }
        private static final String REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$%^&*+=])(?=\\S+$).{8,}$";
        private static Pattern pattern;
        private static Matcher matcher;
        
        private String userName;

        /**
         * Get the value of userName
         *
         * @return the value of userName
         */
        public String getUserName() {
                return userName;
        }

        /**
         * Set the value of userName
         *
         * @param userName new value of userName
         */
        public void setUserName(String userName) {
                this.userName = userName;
        }

        private String password;

        /**
         * Get the value of password
         *
         * @return the value of password
         */
        public String getPassword() {
                return password;
        }

        /**
         * Set the value of password
         *
         * @param password new value of password
         */
        public void setPassword(String password) {
                this.password = password;
        }

        private String passwordConfirm;

        /**
         * Get the value of passwordConfirm
         *
         * @return the value of passwordConfirm
         */
        public String getPasswordConfirm() {
                return passwordConfirm;
        }

        /**
         * Set the value of passwordConfirm
         *
         * @param passwordConfirm new value of passwordConfirm
         */
        public void setPasswordConfirm(String passwordConfirm) {
                this.passwordConfirm = passwordConfirm;
        }

        private String meterID;

        /**
         * Get the value of meterID
         *
         * @return the value of meterID
         */
        public String getMeterID() {
                return meterID;
        }

        /**
         * Set the value of meterID
         *
         * @param meterID new value of meterID
         */
        public void setMeterID(String meterID) {
                this.meterID = meterID;
        }

        private String address;

        /**
         * Get the value of address
         *
         * @return the value of address
         */
        public String getAddress() {
                return address;
        }

        /**
         * Set the value of address
         *
         * @param address new value of address
         */
        public void setAddress(String address) {
                this.address = address;
        }
        
        private Users user;

        /**
         * Get the value of user
         *
         * @return the value of user
         */
        public Users getUser() {
                return user;
        }

        /**
         * Set the value of user
         *
         * @param user new value of user
         */
        public void setUser(Users user) {
                this.user = user;
        }

        public void createUser() throws SystemException{
                // Needed for the error messages
                FacesContext context = FacesContext.getCurrentInstance();
                try {
                        utx.begin();
                        // User Name validation
                        if (userName.isEmpty()){
                                FacesMessage message = new FacesMessage("User Name cannot be empty" );
                                context.addMessage("main:registerform:userName", message);
                        }
                        else {
                                // Find user in the database
                                user = (Users)(em.createNamedQuery("Users.findByUserName").setParameter("userName", userName)).getSingleResult();
                                if (user != null){
                                       FacesMessage message = new FacesMessage("User Name already exists" );
                                       context.addMessage("main:registerform:userName", message);
                                       setUserName("");
                                       setUser(null);
                                }
                        }
                }
                catch (Exception e){
                         if (user == null){
                                // Password validation
                               pattern = Pattern.compile(REGEX);
                               matcher = pattern.matcher(password);

                               if (!matcher.matches()){
                                       FacesMessage message = new FacesMessage("Password must contain at least 8 characters including an upper case letter, lower case letter, a digit and a special character (!@#$%^&*)." );
                                       context.addMessage("main:registerform:password", message);
                                       setPassword("");
                               }
                               else if (!password.equals(passwordConfirm)){
                                       FacesMessage message = new FacesMessage("Password does not match" );
                                       context.addMessage("main:registerform:passwordConfirm", message);
                                       setPassword("");
                                       setPasswordConfirm("");
                               }
                               else {
                                       if (meterID.equals("")){
                                               FacesMessage message = new FacesMessage("Meter ID cannot be empty" );
                                               context.addMessage("main:registerform:meterID", message);
                                       }
                                       else {
                                               try {
                                                        Users meter = (Users)(em.createNamedQuery("Users.findByMeterId").setParameter("meterId", meterID)).getSingleResult();
                                                        if (meter != null){
                                                                FacesMessage message = new FacesMessage("Meter ID already in use" );
                                                                context.addMessage("main:registerform:meterID", message);
                                                                setMeterID("");
                                                        }
                                               }
                                               catch (Exception ex) {
                                                        if (address.equals("")){
                                                                FacesMessage message = new FacesMessage("Address cannot be empty" );
                                                                context.addMessage("main:registerform:address", message);
                                                        }
                                                        else {
                                                                try {
                                                                        Meters addresses = (Meters)(em.createNamedQuery("Users.findByAddress").setParameter("address", address)).getSingleResult();
                                                                        if (addresses != null){
                                                                                 FacesMessage message = new FacesMessage("Address already in use" );
                                                                                 context.addMessage("main:registerform:address", message);
                                                                                 setAddress("");
                                                                         }
                                                                }
                                                                catch (Exception E){
                                                                        Meters newMeter = new Meters();
                                                                        newMeter.setMeterId(meterID);
                                                                        Users newUser = new Users();

                                                                        newUser.setUserName(userName);
                                                                        newUser.setPassword(password);
                                                                        newUser.setMeterId(newMeter);
                                                                        newUser.setAddress(address);
                                                                        newUser.setDateCreated(new Date());

                                                                        newUser.setId(3);
                                                                        
                                                                        
                                                                        
                                                                        persist(newUser);
                                                                }
                                                        }
                                                }
                                        }
                               }
                       }
                }
        }

        public void persist(Object object) {
                try {
                        utx.begin();
                        em.persist(object);
                        utx.commit();
                } catch (Exception e) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
                        throw new RuntimeException(e);
                }
        }
        
}
