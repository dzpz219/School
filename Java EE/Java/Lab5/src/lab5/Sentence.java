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
public class Sentence {
    private String sentence;
    private int key;
    private Boolean encrypted;
    
    public Sentence(String sentence){
        this.sentence = sentence;
        this.encrypted = false;
        keyCheck(sentence);
    }
    
    public Sentence(String sentence, Boolean encrypted){
        this.sentence = sentence;
        this.encrypted = encrypted;
        keyCheck(sentence);
    } 
        
    private void keyCheck(String sentence){
        if (sentence.isEmpty()){
            this.key = 0;
        }       
        String pattern = "[a-zA-Z]*";
        int wordCount = sentence.split(" ").length;
        int nonLetterChar = sentence.replaceAll(pattern, "").length();
        int firstChar = 0;
        for (int i = 0; i < sentence.length(); i++){
            char first = sentence.toLowerCase().charAt(0);
            String lower = sentence.toLowerCase();
            if (lower.charAt(i) == first){
                firstChar++;
            }
        }
        key = wordCount + nonLetterChar + firstChar;
        
        if (key % 26 == 0){
            key+=1;
        }
    }
    
    public void encryptSentence(){
        StringBuilder sb = new StringBuilder();
        String pattern = "[a-zA-Z0-9]*";
        for (int i = 0; i < this.sentence.length(); i++){
            char c = this.sentence.charAt(i);
            if (Character.isAlphabetic(c)){
                sb.append(encrypt(c));
            }
            else{
                sb.append(c);
            }
        }
        this.sentence = sb.toString();
    }
    
    public void decryptSentence(){
        StringBuilder sb = new StringBuilder();
        String pattern = "[a-zA-Z0-9]*";
        for (int i = 0; i < this.sentence.length(); i++){
            char c = this.sentence.charAt(i);
            if (Character.isAlphabetic(c)){
                sb.append(decrypt(c));
            }
            else{
                sb.append(c);
            }
        }
        this.sentence = sb.toString();
    }
    
    public char encrypt(char c){
        char shifted;
        int alphabet = 26;
        int shift =  key % alphabet;
        char asciiShift = Character.isUpperCase(c) ? 'A' : 'a';
        // shift down to 0..25 for a..z
        shifted = (char) (c - asciiShift);
        // rotate the letter and handle "wrap-around" for negatives and value >= 26
        shifted = (char) ((shifted + shift + alphabet) % alphabet);
        // shift back up to english characters
        return (char) (shifted + asciiShift);
    }
    
    public char decrypt(char c){
        char shifted;
        int alphabet = 26;
        int shift =  key % alphabet;
        char asciiShift = Character.isUpperCase(c) ? 'A' : 'a';
        // shift down to 0..25 for a..z
        shifted = (char) (c - asciiShift);
        // rotate the letter and handle "wrap-around" for negatives and value >= 26
        shifted = (char) ((shifted + shift + alphabet) % alphabet);
        // shift back up to english characters
        return (char) (shifted - asciiShift);
    }
    
    @Override
    public String toString(){
        if (isEncrypted()){
            encryptSentence();
        }
        else {
            decryptSentence();
        }
        return this.sentence;
    }
    
    public Boolean toggleEncryption(){
        return !this.encrypted;
    }
    
    public Boolean isEncrypted(){
        return this.encrypted;
    }
    
    public int getKey(){
        return this.key;
    }
}
