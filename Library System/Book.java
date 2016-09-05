package librarysystem;
public class Book {
    private String ISBN , Title ;
    private  Author BookAuthor ;
    private int NumberOfCopies;
    private int YearOfPub ;
    private Boolean Status;
    public Book(){} // default
    public Book(String ISBN ,String Title ,Author BookAuthor,int YearOfPub,int NumberOfCopies)
    {
        this.ISBN = ISBN;
        this.Title = Title ;
        this.BookAuthor = BookAuthor;
        this.YearOfPub = YearOfPub;
        this.NumberOfCopies = NumberOfCopies;
    }
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }
    public String getISBN(){
        return ISBN;
    }
    
    public void setBookAuthor(Author BookAuthor){
        this.BookAuthor =  BookAuthor;
    }
    public Author getBookAuthor(){
        return BookAuthor;
    }
    
    public void setTitle(String Title){
        this.Title = Title;
    }
    public String getTitle(){
        return Title;
    }
    
    public void setYearOfPub(int YearOfPub){
        this.YearOfPub = YearOfPub;
    }
    public int getYearOfPub(){
        return YearOfPub;
    }
    
    public void setStatus(boolean value){
        Status = value;
    }
    public boolean getStatus(){
        return Status;
    }
    public void decrementNumberOfCopies() {
        NumberOfCopies--;
    }
    public void incrementNumberOfCopies(int value) {
        NumberOfCopies+=value;
    }
    @Override
    public boolean equals(Object object){ //override .equals method
        if(object instanceof Book && ((Book)object).getISBN().compareTo(this.ISBN)==0 ) {
            return true;
        }
        else 
            return false;
    }
    public void updateBookDetails(Book book){
        this.Title = book.Title;
        this.ISBN = book.ISBN;
        this.BookAuthor = book.BookAuthor;
        this.YearOfPub = book.YearOfPub;
    }
    @Override
    public String toString(){
        return "BookId : " + ISBN + "\n" + "Title : " + Title+ "\n" + "BookAuthor : " + BookAuthor.toString() + "\n" + "YearOfPub : " + YearOfPub + "\n" + "NumberOfCopies : " + NumberOfCopies;
    }
}
