
package connect4;

/**
 *
 * @author Amira Mahmoud
 */
public class Player {
    private String Name;
    private int score;
    
    Player(){
        
    }
    Player(String Name , int score){
        this.Name = Name;
        this.score = score;
    }

    public void setName(String Name){
        this.Name = Name;
        this.score = 0;
    }
    
    public String getName()
    {
        return this.Name;
    }
    
    public void setScore(int score){
        this.score = score;
    }
    
    public int getScore(){
        return this.score;
    }
    
    public void increaseScore(){
        this.score++;
    }
    
    public String ToString(){
        return "Player " + this.Name + " : " + this.score ;
    }
}
