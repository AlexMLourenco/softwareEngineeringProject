/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esp11.app;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author manuel
 */
@Entity
public class alarm {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String co;
    private String hr;

    private String fighter;
    
    public alarm(){
        
    }
    public alarm(String fighter){
        this.fighter = fighter;
        this.co = "false";
        this.hr = "false";
        
    }
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }
    
    public void setCo(String co){
        this.co = co;
    }
    public String getCo(){
        return co;
    }
    public void setFighter(String fighter){
        this.fighter = fighter;
    }
    public String getFighter(){
        return fighter;
    }
    public void setHr(String hr){
        this.hr = hr;
    }
    public String getHr(){
        return hr;
    }
    
}