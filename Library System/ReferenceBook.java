package librarysystem;
public class ReferenceBook extends Book{
    private int Fine;
    public ReferenceBook(){}
    public ReferenceBook(String ISBN ,String Title ,Author BookAuthor,int YearOfPub ,int NumberOfCopies,int Fine)
    {
        super(ISBN ,Title ,BookAuthor,YearOfPub,NumberOfCopies);
        this.Fine = Fine;
    }
    public void setFine(int Fine){
        this.Fine = Fine;
    }
    public int getFine(){
        return Fine;
    }
 
    @Override
    public void updateBookDetails(Book book){
        super.setTitle(book.getTitle()); 
        this.setISBN(book.getISBN());
        this.setBookAuthor(book.getBookAuthor());
        this.setYearOfPub(book.getYearOfPub());
    }
    public String toString(){
        return super.toString()+"\n"+"Fine : "+Fine;
    }
}
