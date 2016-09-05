package librarysystem;

public class Student extends User {
    private String regNumber;
    private int Term,CurrentFine;
    public Student(){}
    public Student(String UserId,String Name,String Address,String PhoneNum,String regNumber,int Term)
    {
        super(UserId,Name,Address,PhoneNum);
        this.regNumber = regNumber;
        CurrentFine = 0;
        this.Term = Term;
    }
    public void setRegNumber(String regNumber){
        this.regNumber = regNumber;
    }
    public String getRegNumber(){
        return regNumber;
    }
    public void setTerm(int Term){
        this.Term = Term;
    }
    public int getTerm(){
        return Term;
    }
    public void addBook(Book book){
        itemsBorrowed[numOfBooksborrowed] = book;
        numOfBooksborrowed++;
    }
    public Book [] getBooksBorrowed()
    {
        return itemsBorrowed;
    }
    public void returnBooks(Book book){
        Book [] Temp;
        Temp = new Book[numOfBooksborrowed];
        int counter = 0;
        for(int i=0;i<numOfBooksborrowed;i++){
            if(book.equals(itemsBorrowed[i]))
                continue;
            else
            {
                Temp[counter] = itemsBorrowed[i];
                counter++;
            }   
        }
        numOfBooksborrowed = counter;
        for(int i=0;i<numOfBooksborrowed;i++)
            itemsBorrowed[i] = Temp[i];
    }
    public int payFine(int days){
        int ans = days*100;
        CurrentFine+=ans;
        return ans;
    }
    public void updateDetails(int Term){
        this.Term = Term;
    }
    /**
     *
     * @param book
     */
    @Override
    public void bookPurchase(Book book){
        booksList.add(book);
    }
    @Override
    public String toString()
    {
        String StudentDetails =  "UserType : Student" + super.toString() + "Reg# : " + regNumber + "Term : " + Term + "CurrentFine : " + CurrentFine;
        return StudentDetails;
    }   
}
