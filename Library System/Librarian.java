package librarysystem;

import java.util.ArrayList;
import java.util.List;

public class Librarian implements Person{
    private String LibrarianId,LibrarianName,LibrarianPassword;
    private int wage;
    public Librarian(){}
    public Librarian(String LibrarianId,String LibrarianName,String LibrarianPassword)
    {
        this.LibrarianId = LibrarianId;
        this.LibrarianName = LibrarianName;
        this.LibrarianPassword = LibrarianPassword;
    }
    public void setLibrarianId(String LibrarianId){
        this.LibrarianId = LibrarianId;
    }
    public String getLibrarianId(){
        return  LibrarianId;
    }
    public void setLibrarianName(String LibrarianName){
        this.LibrarianName = LibrarianName;
    }
    public String LibrarianName(){
        return LibrarianName;
    }
    public void setLibrarianPassword(String LibrarianPassword){
        this.LibrarianPassword = LibrarianPassword;
    }
    public String getLibrarianPassword(){
        return LibrarianPassword;
    }
    
    @Override
    public String toString(){
        return "LibrarianId : " + LibrarianId + "\n" + "LibrarianName : " + LibrarianName + "\n" + "LibrarianPassword : " + LibrarianPassword;   
    }

    @Override
    public int Salary() {
        return wage;
    }
}
