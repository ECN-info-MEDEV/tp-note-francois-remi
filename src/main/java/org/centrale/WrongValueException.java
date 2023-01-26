/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package org.centrale;

/**
 *
 * @author inky19
 */
public class WrongValueException extends Exception {

    public WrongValueException(int value){
        super("Invalid value (" + value + ") !");
    }
}
