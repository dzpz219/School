/*
 * StAuth10066: I Chao Zhang, 000306946 certify that this material is my original work. 
 * No other person's work has been used without due acknowledgement. 
 * I have not made my work available to anyone else.
 */
package com.mohawkcollege.cz;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
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
import sun.misc.BASE64Encoder;

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
        public Register() {}
        
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
        
        private List<Meters> meter;

        /**
         * Get the value of meter
         *
         * @return the value of meter
         */
        public List<Meters> getMeter() {
                return meter;
        }

        /**
         * Set the value of meter
         *
         * @param meter new value of meter
         */
        public void setMeter(List<Meters> meter) {
                this.meter = meter;
        }
        
            private List<Meters> meterAddress;

    /**
     * Get the value of meterAddress
     *
     * @return the value of meterAddress
     */
    public List<Meters> getMeterAddress() {
        return meterAddress;
    }

    /**
     * Set the value of meterAddress
     *
     * @param meterAddress new value of meterAddress
     */
    public void setMeterAddress(List<Meters> meterAddress) {
        this.meterAddress = meterAddress;
    }
        //Password hashing method
        //Salt added and iterated before returning
        public String encryptPassword(String pw) {
            String salt = "ASDASDFASD";
            MessageDigest md = null;
            String hashValue = null;
            try {
                md = MessageDigest.getInstance("SHA");
                String inputText = pw + salt;
                for (int i = 0; i < 1337; i++){
                    md.update(inputText.getBytes("UTF-8"));
                    byte rawByte[] = md.digest();
                    inputText = (new BASE64Encoder()).encode(rawByte);
                }
                hashValue = inputText;
            }
            catch (Exception e){
                
            }
            return hashValue;
        }
        
        //Create new user if all the validation criterias are met
        public String createUser() throws SystemException{
                FacesContext context = FacesContext.getCurrentInstance();
                ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msgs");
                Users newUser = new Users();
                        if (checkUserName()){
                                if(checkPassword()){
                                        if(checkMeterID()){
                                                if(checkAddress()){
                                                        Meters newMeter = new Meters();
                                                        Date date = new Date();
                                                        newMeter.setMeterId(meterID);
                                                        newMeter.setAddress(address);
                                                        newUser.setUserName(userName);
                                                        newUser.setDateCreated(date);
                                                        newUser.setPassword(encryptPassword(password));
                                                        newUser.setMeterId(newMeter);
                                                        newUser.setAddress(address);
                                                        persist(newUser);
                                                        context.addMessage("main:loginform:success", new FacesMessage(bundle.getString("registerSuccessMsg") + userName));
                                                        return "login";
                                                }
                                        }
                                }
                                return "";
                        }
                        return "";
        }
        
        //Username validation
        public Boolean checkUserName() throws SystemException{
                FacesContext context = FacesContext.getCurrentInstance();
                ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msgs");
                if (userName.isEmpty()){
                        FacesMessage message = new FacesMessage(bundle.getString("userEmptyMsg") );
                        context.addMessage("main:registerform:userName", message);
                        return false;
                }
                else {
                         try {
                                //Search for user by userName
                                user = (Users)(em.createNamedQuery("Users.findByUserName").setParameter("userName", userName)).getSingleResult();
                                
                                //Username in use if user contains item
                                if (user != null){
                                       FacesMessage message = new FacesMessage(bundle.getString("userExistMsg") );
                                       context.addMessage("main:registerform:userName", message);
                                       setUserName("");
                                       setUser(null);
                                       return false;
                                }
                         }
                         //Username available
                         catch (Exception e){
                               return true;
                         }
                }
                return true;
        }
        
        //Password validation
        public Boolean checkPassword() throws SystemException{
                FacesContext context = FacesContext.getCurrentInstance();
                ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msgs");
                
                 // Regular expression  to match
                pattern = Pattern.compile(REGEX);
                matcher = pattern.matcher(password);
                
                //Password does not meet criteria
                if (!matcher.matches()){
                        FacesMessage message = new FacesMessage(bundle.getString("registerPasswordError") );
                        context.addMessage("main:registerform:password", message);
                        setPassword("");
                        return false;
                }
                
                //Password does not match password confirm
                else if (!password.equals(passwordConfirm)){
                        FacesMessage message = new FacesMessage(bundle.getString("passwordConfirmError") );
                        context.addMessage("main:registerform:passwordConfirm", message);
                        setPassword("");
                        setPasswordConfirm("");
                        return false;
                }            
                return true;
        }
        
        //Meter ID validation
        public Boolean checkMeterID() throws SystemException{
                FacesContext context = FacesContext.getCurrentInstance();
                ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msgs");
                if (meterID.isEmpty()){
                        FacesMessage message = new FacesMessage(bundle.getString("meterIDEmptyMsg"));
                        context.addMessage("main:registerform:meterID", message);
                        return false;
                }
                else {
                         try {
                                //Search for user by meter ID
                                meter = (em.createNamedQuery("Users.findByMeterID").setParameter("meterId", meterID)).getResultList();
                                
                                //Meter ID in use if user contains item
                                if (!meter.isEmpty()){
                                        FacesMessage message = new FacesMessage(bundle.getString("meterIDExistMsg") );
                                        context.addMessage("main:registerform:meterID", message);
                                        setMeterID("");
                                        return false;
                                }
                                else {
                                        //Meter ID is available and is also a valid Meter ID
                                        if (meter.isEmpty() && findMeter()){
                                                return true;
                                        }
                                        else {
                                                //invalid meter ID
                                               FacesMessage message = new FacesMessage(bundle.getString("meterIDInvalidMsg"));
                                               context.addMessage("main:registerform:meterID", message);
                                               setMeterID("");
                                               return false;
                                        }
                                }
                         }
                         catch (Exception e){
                                 if (meter.isEmpty() && findMeter()){
                                         return true;
                                 }
                                 else {
                                        //invalid meter ID
                                        FacesMessage message = new FacesMessage(bundle.getString("meterIDInvalidMsg") );
                                        context.addMessage("main:registerform:meterID", message);
                                        setMeterID("");
                                 }
                                 return false;
                         }
                }
        }
        
        //Address validation
        public Boolean checkAddress() throws SystemException{
                FacesContext context = FacesContext.getCurrentInstance();
                ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msgs");
                Meters m = em.find(Meters.class, meterID);
                if (address.isEmpty()){
                        FacesMessage message = new FacesMessage(bundle.getString("addressEmptyMsg"));
                        context.addMessage("main:registerform:address", message);
                        return false;
                }
                else {
                         try {
                                //Search users by address
                                meterAddress = (em.createNamedQuery("Users.findByAddress").setParameter("address", address)).getResultList();
                                
                                //Address in use if user contains items
                                if (!meterAddress.isEmpty()){
                                         FacesMessage message = new FacesMessage(bundle.getString("addressExistMsg") );
                                         context.addMessage("main:registerform:address", message);
                                         setAddress("");
                                         return false;
                                 }
                                else {
                                    //Address is available and is also a valid address matching meter
                                        if (meterAddress.isEmpty() && findAddress()){
                                                if (m.getAddress().equals(address)){
                                                    return true;
                                                }
                                                else {
                                                        //Address does not match meter ID's associate address
                                                        FacesMessage message = new FacesMessage(bundle.getString("addressMismatchMsg") );
                                                        context.addMessage("main:registerform:address", message);
                                                        setAddress("");
                                                        return false;
                                                }
                                        }
                                        else {
                                                //invalid address
                                               FacesMessage message = new FacesMessage(bundle.getString("addressInvalidMsg") );
                                               context.addMessage("main:registerform:address", message);
                                               setAddress("");
                                               return false;
                                        }
                                }
                         }
                         catch (Exception e){
                                 if (meterAddress.isEmpty() && findAddress()){
                                        if (m.getAddress().equals(address)){
                                            return true;
                                        }
                                        else {
                                                FacesMessage message = new FacesMessage(bundle.getString("addressMismatchMsg") );
                                                context.addMessage("main:registerform:address", message);
                                                setAddress("");
                                                return false;
                                        }
                                }
                                else {
                                       FacesMessage message = new FacesMessage(bundle.getString("addressInvalidMsg"));
                                       context.addMessage("main:registerform:address", message);
                                       setAddress("");
                                }
                                 return false;
                         }
                }
        }
        
        //Check if Meter ID is valid by searching meters table
        public Boolean findMeter() throws SystemException{
                try {
                        Meters m = em.find(Meters.class, meterID);
                        if (m.getMeterId().isEmpty()){
                                return false;
                        }
                        else {
                                return true;
                        }
                }
                catch (Exception e){
                        return false;
                }
        }
        
        //Check if Address is valid by searching meters table
        public Boolean findAddress() throws SystemException{
                try {
                        List<Meters> m = (em.createNamedQuery("Meters.findByAddress").setParameter("address", address)).getResultList();
                        if (m.isEmpty()){
                                return false;
                        }
                        else {
                                return true;
                        }
                }
                catch (Exception e){
                        return false;
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
