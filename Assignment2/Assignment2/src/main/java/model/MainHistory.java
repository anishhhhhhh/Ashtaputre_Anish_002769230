/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class MainHistory {    
    
    private ArrayList<MainModel> history;
//    Arraylist hospitalArray = new ArrayList();
    
    public MainHistory() {
        this.history = new ArrayList<MainModel>();
    }
 
    public ArrayList<MainModel> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<MainModel> history) {
        this.history = history;
    }
    public MainModel addNewCity(){
        
        MainModel newMainModel = new MainModel();
        history.add(newMainModel);
        return newMainModel;
        
        
    }
    public MainModel addNewPerson(){
        
        MainModel newMainModel = new MainModel();
        history.add(newMainModel);
        return newMainModel;
        
        
    }
    public MainModel addNewSession(){
        MainModel mainModel = new MainModel();
        history.add(mainModel);
        return mainModel;
    }
//   public void removeSession(MainModel mainmod){
//       history.remove(mainmod);
//        
//    }
    public void deleteEmployee(MainModel mainmod){
       history.remove(mainmod);
        
    }
    
}
