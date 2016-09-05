/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package librarygui;

import java.util.ArrayList;

/**
 *
 * @author ADMEN
 */
public class LibraryGUI {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Book>bookList;
    public static ArrayList<User>userList; 
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame1().setVisible(true);
            }
        });
        
        // TODO code application logic here
    }
    public void addStudent(String name,String ID,String r,int s ,String phone){
        userList.add(new Student(ID,name," ",phone,r,s));
    }
    public boolean searchMember(String ID){
        for (User s : userList){
            if(s.getUserId().equals(ID)) {
                return true;
            }
        }
        return false;
    }
    
    public void deleteMember(String ID){
        for(User s : userList){
            if(s.getUserId().equals(ID))
            {
                userList.remove(s);
                break;
            }
        }
    }
    public String viewStudentDetails(String ID){
        String r= new String();
        for(User s : userList){
            if(s.getUserId().equals(ID)){
                r=s.toString();
                break;
            }
        }
        return r;
    }
    public void addStaffMember(String name,String ID,String phone,String degree){
        userList.add(new Faculty(ID,name," ",phone,degree));
    }
    public LibraryGUI() {
    }
}
