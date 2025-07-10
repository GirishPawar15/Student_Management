package model;

public class Student {
     int Ro_No;
     String Name;
     String Add;
     String Mo_No;
     String E_Mail;
     String Std;
     double Preveous_Year_marks;

     
     public Student(int ro_No2, String name2, String add2, String mo_No2, String e_Mail2, String std2,
 			double preveous_Year_marks2) {
 	this.Ro_No = ro_No2;
 	this.Name = name2;
 	this.Add = add2;
 	this.Mo_No = mo_No2;
 	this.E_Mail = e_Mail2;
 	this.Std = std2;
 	this.Preveous_Year_marks = preveous_Year_marks2;
 }
      
    
    @Override
    public String toString() {
        return Ro_No + " | " + Name + " | " + Add + " | " + Mo_No + " | " + E_Mail + " | " + Std + " | " + Preveous_Year_marks;
    }
}
