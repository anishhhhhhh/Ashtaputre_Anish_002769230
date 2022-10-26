/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Anish
 */
public class EmployeeDetailsHistory {
    
    private ArrayList<EmployeeDetails> tableData;
    
    //constructer(this method will always be called when called EmployeeDetailsHistory)
    public EmployeeDetailsHistory(){
        this.tableData = new ArrayList<EmployeeDetails>();
    }

    public ArrayList<EmployeeDetails> getTableData() {
        return tableData;
    }

    public void setTableData(ArrayList<EmployeeDetails> tableData) {
        this.tableData = tableData;
    }
    
    //adds new employee detail ie.row
    public EmployeeDetails addData(){
        EmployeeDetails newEmployee = new EmployeeDetails();
        tableData.add(newEmployee);
        return newEmployee;
    }
}
