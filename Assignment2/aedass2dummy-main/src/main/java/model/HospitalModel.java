package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rosha
 */
public class HospitalModel {
    private String Name;
      private int EmployeeID;
      private int Age;    //2
      private String Gender;
      private String HospitalName;
      private long HospitalContact;
      private String HospitalAddress;
      private String Start_date;
      private String Level;
      private String City;
      private String Team_Info;
      private String Position_title;
      private Long Cell_phone_number;  //2
      private String Email_address;
      private String Photo;
//      private MainHospital HospitalName;
//      MainHospital mainH = new MainHospital();
//      public void addNewHospital(MainHospital HospitalName){
//          this.HospitalName = HospitalName;
//      }
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }
    public void setHospitalName(String HospitalName) {
        
        this.HospitalName = HospitalName;
    }
    public String getHospitalName() {
        return HospitalName;
    }
    public void setHospitalContact(long HospitalContact) {
        
        this.HospitalContact = HospitalContact;
    }
    public long getHospitalContact() {
        return HospitalContact;
    }
    public void setHospitalAddress(String HospitalAddress) {
        
        this.HospitalAddress = HospitalAddress;
    }
    public String getHospitalAddress() {
        return HospitalAddress;
    }
    public void setCity(String City) {
        this.City = City;
    }
    public String getCity() {
        return City;
    }
    public String getStart_date() {
        return Start_date;
    }

    public void setStart_date(String Start_date) {
        this.Start_date = Start_date;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String Level) {
        this.Level = Level;
    }

    public String getTeam_Info() {
        return Team_Info;
    }

    public void setTeam_Info(String Team_Info) {
        this.Team_Info = Team_Info;
    }

    
    public void setPhoto(String Photo) {
            this.Photo = Photo;
    }
    public String getPhoto() {
        return Photo;
    }
    public String getPosition_title() {
        return Position_title;
    }

    public void setPosition_title(String Position_title) {
        this.Position_title = Position_title;
    }

    public Long getCell_phone_number() {
        return Cell_phone_number;
    }

    public void setCell_phone_number(Long Cell_phone_number) {
        this.Cell_phone_number = Cell_phone_number;
    }

    public String getEmail_address() {
        return Email_address;
    }

    public void setEmail_address(String Email_address) {
        this.Email_address = Email_address;
    }
      
    @Override
    public String toString(){
        return Start_date;
        
    }

    
}
