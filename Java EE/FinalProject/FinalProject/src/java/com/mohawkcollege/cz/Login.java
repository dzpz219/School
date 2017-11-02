/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohawkcollege.cz;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.SystemException;

/**
 *
 * @author Danny
 */
@ManagedBean (name = "loginBean")
@SessionScoped
public class Login implements Serializable{
    @PersistenceContext(unitName = "FinalProjectPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of login
     */
    public Login() {
        loggedIn = false;
        admin = false;
    }
    
    private boolean admin;

    /**
     * Get the value of admin
     *
     * @return the value of admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Set the value of admin
     *
     * @param admin new value of admin
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    protected boolean loggedIn;

    /**
     * Get the value of loggedIn
     *
     * @return the value of loggedIn
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * Set the value of loggedIn
     *
     * @param loggedIn new value of loggedIn
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    public boolean getLoggedIn() {
        return loggedIn;
      }

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

    public String userLogin() throws SystemException {
    // Needed for the error messages
    FacesContext context = FacesContext.getCurrentInstance();
    
    try {
      utx.begin();
      // em.joinTransaction();
      // Find user in the database 
      user = (Users)(em.createNamedQuery("Users.findByUserName").setParameter("userName", userName)).getSingleResult();
      if (user != null) {
        // Found the user - confirm the password
        if (user.getPassword().equals(password)) {
          loggedIn = true;
          
          if (user.getUserName().equals("admin")) {
              admin = true;
              return "admin"; // admin page 
          }
          if(!user.getUserName().equals("admin")) {
               admin = false;
              return "summary"; //user summary page
          }
        }
        else 
        {
          // Invalid password - Generate message from code   
          loggedIn = false;
          FacesMessage message = new FacesMessage("Invalid Password for account " + getUserName());
          context.addMessage("main:loginform:password", message);
        }
      }
    }
    catch (Exception e) 
    {
      if (user == null){
        // Invalid account 
        loggedIn = false;
        FacesMessage message = new FacesMessage("Could not find a match for account " + getUserName());
        context.addMessage("main:loginform:userName", message);
        setUserName(""); // clear the name
      }
      else{
      // Database access error - Verify the Persistance is set-up correctly
      FacesMessage message = new FacesMessage("Error accessing accessing database! Unexpected error when accessing the database.  Please contact the system Administrator");
     context.addMessage("main:loginform:login", message);
      }
      utx.rollback();
    }
    return "";
  }
  
  /**
   * Log out of the account - Invalidates the Session
   * @return 
   */
  
  public String logout() {
    loggedIn = false;
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(false);
    session.invalidate();
    return "login";
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
