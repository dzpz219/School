/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohawkcollege.cz;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;

/**
 *
 * @author Danny
 */
@ManagedBean(name = "error")
@RequestScoped
public class ErrorBean implements Serializable {
   public String getStackTrace() {
      FacesContext context = FacesContext.getCurrentInstance();
      Map<String, Object> request 
         = context.getExternalContext().getRequestMap();
      Throwable ex = (Throwable) request.get("javax.servlet.error.exception");
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      pw.println("ERROR TRACE as reported in ErrorBean");
      fillStackTrace(ex, pw);
      return sw.toString();
   }

   private static void fillStackTrace(Throwable t, PrintWriter w) {
      if (t == null) return;
      t.printStackTrace(w);
      if (t instanceof ServletException) {
         Throwable cause = ((ServletException) t).getRootCause();
         if (cause != null) {
            w.println("Root cause:");
            fillStackTrace(cause, w);
         }
      } else if (t instanceof SQLException) {
         Throwable cause = ((SQLException) t).getNextException();
         if (cause != null) {
            w.println("Next exception:");
            fillStackTrace(cause, w);
         }
      } else {
         Throwable cause = t.getCause();
         if (cause != null) {
            w.println("Cause:");
            fillStackTrace(cause, w);
         }
      }
   }
}

