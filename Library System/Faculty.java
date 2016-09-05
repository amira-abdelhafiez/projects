package librarysystem;

public class Faculty extends User{
    private String Degree;
    private int CurrentFine;
    public Faculty(String UserId,String Name,String Address,String PhoneNum,String Degree)
    {
        super(UserId, Name,Address,PhoneNum);
        this.Degree = Degree;
        CurrentFine =0 ;
    }
    public void setDegree(String Degree){
        this.Degree = Degree;
    }
    public String getDegree(){
        return Degree;
    }
    public void addBook(Book book){
        itemsBorrowed[numOfBooksborrowed] = book;
        numOfBooksborrowed++;
    }
    public Book [] getBooksBorrowed()
    {
        return itemsBorrowed;
    }
    /**
     *
     * @param book
     */
    @Override
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
    
    @Override
    public int payFine(int days) {
        CurrentFine+=10*days;
        return 10*days;
    }

    @Override
    public void bookPurchase(Book book) {
        booksList.add(book);
    }
    public void updateDetails(String Degree){
        this.Degree= Degree;
    }
    @Override
    public String toString()
    {
        String FacultyDetails =  "UserType : Faculty" + super.toString()  + "Degree : " +Degree + "\n" + "CurrentFine : " + CurrentFine ; 
        return FacultyDetails;
    } 

    
}
