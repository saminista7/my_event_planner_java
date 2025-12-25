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
class Dec {
     private int Decoratpor_ID,Price,Deco_Expense;
    private String Name,PhoneNo; 
    
    public Dec(int Decoratpor_ID, String Name, String PhoneNo,int Price,int Deco_Expense)
    {
    
    
        this.Decoratpor_ID=Decoratpor_ID;
        this.Name=Name;
        this.Price=Price;
        this.Deco_Expense=Deco_Expense;
       this.PhoneNo=PhoneNo;
    }
        
       
     public int getDecoratpor_ID()
        {
        return Decoratpor_ID;
        
        }
     public String getName()
     {
     
         return Name;
     
     }
     
     public int getPrice()
        {
        return Price;
        
        }
     
     public int getDeco_Expense()
        {
        return Deco_Expense;
        
        }
     
     public String getPhoneNo()
     {
     
         return PhoneNo;
     
     }
    
}


