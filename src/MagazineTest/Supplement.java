/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MagazineTest;

/**
 *
 * @author Ky.Nguyen
 */
public class Supplement {
    private String name;
    private double weeklyCost;
    
    public Supplement(String name, double weeklyCost){
        this.name = name;
        this.weeklyCost = weeklyCost;
    }
    public Supplement(){
        this.name = "";
        this.weeklyCost = 0;
    }
    public String getName(){
        return this.name;
    }
    public double getWeeklyCost(){
        return this.weeklyCost;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setWeeklyCost(double weeklyCost){
        this.weeklyCost = weeklyCost;
    }
}