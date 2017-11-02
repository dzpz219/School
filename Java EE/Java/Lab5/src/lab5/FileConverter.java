/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author Danny
 */
public class FileConverter {
    private String input;
    private String output;
    private Boolean inputEncrypted;
    private Sentence[] test;
    
    public FileConverter(String input, String output, Boolean inputEncrypted ){
        this.input = input;
        this.output = output;
        this.inputEncrypted = inputEncrypted;
    }
    
    public Boolean readInput(){
        return true;
    }
    
    public Boolean writeOutput(){
        return true;
    }
    
}
