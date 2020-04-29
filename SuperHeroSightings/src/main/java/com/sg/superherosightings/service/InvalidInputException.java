/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

/**
 *
 * @author Buddy
 */
public class InvalidInputException extends Exception{
    
    public InvalidInputException(String msg){
        
        super(msg);
    }
    
    public InvalidInputException(String msg, Throwable cause){
        super(msg, cause);
    }
}
