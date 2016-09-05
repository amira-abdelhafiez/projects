package librarysystem;

import java.util.ArrayList;
import java.util.List;

public  abstract class User {
    private String UserId,Name,Address,PhoneNum;
    private int CuurentFine;
    private Date date ;
    List<Book> booksList = new ArrayList<>();
    protected int numOfBooksborrowed ;
    final static int itemsBorrowed_SIZE = 10;
    protected Book [] itemsBorrowed;
    public User(){}
    public User (String UserId,String Name,String Address,String PhoneNum){
        this.UserId = UserId;
        this.Name = Name ;
        this.Address = Address;
        this.PhoneNum = PhoneNum;
        booksList = new ArrayList<>();
        numOfBooksborrowed = 0;
        itemsBorrowed = new Book[itemsBorrowed_SIZE];
    }
    public void setUserId(String UserId){
        this.UserId = UserId;
    }
    public String getUserId(){
        return UserId;
    } 
    public void setName(String Name){
        this.Name = Name;
    }
    public String getName(){
        return Name;
    }
    public void setAddress(String Address){
        this.Address = Address;
    }
    public String getAddress(){
        return Address;
    }
    public void setPhoneNum(String PhoneNum){
        this.PhoneNum = PhoneNum;
    }
    public String getPhoneNum(){
        return PhoneNum;
    }
    public void AddFine(int value){
        CuurentFine+=(value);
    }
    public boolean equals(Object object){ //override .equals method
        if(object instanceof User && ((User)object).getUserId().compareTo(this.UserId)==0)
            return true;
        else 
            return false;
    }
    public void addItem(Book book){
        itemsBorrowed[numOfBooksborrowed] = book;
        numOfBooksborrowed++;
    }
    
    public abstract void returnBooks(Book book);
    public abstract int payFine(int day);
    
    public void updateDetails(User user){
        this.Address = user.Address;
        this.PhoneNum = user.PhoneNum;
    }
    public  abstract void bookPurchase(Book book);
    @Override
    public String toString()
    {
        String UserDetails = "UserId : " + UserId + "\n" + "Address : " + Address + "\n" + "PhoneNum : " + PhoneNum +"\n";
        return UserDetails;
    }
}
