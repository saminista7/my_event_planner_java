/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.event.planner;

/**
 *
 * @author User
 */
public class User_photographer {
    private int Photographer_ID,Price,Photo_expense;
    private String Name,Phone; 
    
    public User_photographer(int Photographer_ID, String Name, int Price,int Photo_expense,String Phone)
    {
    
    
        this.Photographer_ID=Photographer_ID;
        this.Name=Name;
        this.Price=Price;
        this.Photo_expense=Photo_expense;
       this.Phone=Phone;
    }
        
       
     public int getPhotographer_ID()
        {
        return Photographer_ID;
        
        }
     public String getName()
     {
     
         return Name;
     
     }
     
     public int getPrice()
        {
        return Price;
        
        }
     
     public int getPhoto_expense()
        {
        return Photo_expense;
        
        }
     
     public String getPhone()
     {
     
         return Phone;
     
     }
    
}
