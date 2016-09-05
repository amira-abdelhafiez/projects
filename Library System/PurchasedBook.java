package librarysystem;
public class PurchasedBook extends Book {
    private double Price;
    private int NumberOfCopies;
    public PurchasedBook(){}
    public PurchasedBook(String BookId ,String BookName ,Author BookAuthor,int YearOfPub,int NumberOfCopies,double Price){
        super(BookId ,BookName ,BookAuthor,YearOfPub,NumberOfCopies);
        this.Price = Price;
    }
    public void setPrice(double Price){
        this.Price = Price;
    }
    public double getPrice(){
        return Price;
    }
    public void setNumberOfCopies(int NumberOfCopies){
        this.NumberOfCopies = NumberOfCopies;
    }
    public double getNumberOfCopies(){
        return NumberOfCopies;
    }
   
    public void decrementNumberOfCopies(){
        NumberOfCopies--;
    }
    public void incrementNumberOfCopies(int value){
        NumberOfCopies+=(value);
    }
    public void updateBookDetails(Book book){
        super.setTitle(book.getTitle()); 
        super.setISBN(book.getISBN());
        super.setBookAuthor(book.getBookAuthor());
        super.setYearOfPub(book.getYearOfPub());
    }
    public String toString(){
        return super.toString() + "Price : " + Price + "\n" ;
    }
}
