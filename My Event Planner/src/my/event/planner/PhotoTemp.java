/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.event.planner;

/**
 *
 * @author USER
 */
public class PhotoTemp extends Items{
    private int experience;
    
    public PhotoTemp() {
        
    }

    public PhotoTemp(int ID, String Name, int price) {
        super(ID, Name, price);
    }
    

    
    public PhotoTemp(int ID, String Name, int price, int experience) {
        super(ID, Name, price);
        this.experience= experience;
        
    }

    

    /**
     * @return the experience
     */
    public int getExperience() {
        return experience;
    }

    /**
     * @param experience the experience to set
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    
    
    
}
