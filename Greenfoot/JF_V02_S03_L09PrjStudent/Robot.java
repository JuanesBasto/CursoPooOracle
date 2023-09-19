import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends Actor
{
    private GreenfootImage robotimage1;
    private GreenfootImage robotimage2;
    private int lives;
    private int score;
    private int pizzaEaten;
    private GreenfootImage gameover;
    int timer;
    private final int MAXTIMER=1000;

    
    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        robotMovement();
        detectWallCollision();
        detectBlockCollision();
        detectHome();
        eatPizza();
        showStatus();
        updateTimer();
    }

    public Robot(){
        robotimage1= new GreenfootImage("man01.png");
        robotimage2= new GreenfootImage("man02.png");
        gameover= new GreenfootImage("gameover.png");
        lives = 3;
        score = 0;
        pizzaEaten = 0;
        
        timer=MAXTIMER;
        timer+= 200;
    }
    
    public void updateTimer(){
        timer--;
        if (timer==0){
            removeLife();
            resetTimer();
        }
        getWorld().showText("Tiempo : " + timer, 70, 580);
    }
    
    public void resetTimer(){
        timer=MAXTIMER;
    }
    
    public void resetPosition(){
        setLocation(48, 50);
    }
    
    public void  animate(){
        if(getImage()==robotimage1){
            setImage(robotimage2);
        }else{
            setImage(robotimage1);
        }
        
    }
    
    public void robotMovement(){
        int y=getY();
        if (Greenfoot.isKeyDown("left")){
            move(-2);
            animate();
        }else if (Greenfoot.isKeyDown("right")){
            move(2);
            animate();
        }
        
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(),(getY()-2));
            animate();
        }else if(Greenfoot.isKeyDown("down")){
            setLocation(getX(),(getY()+2));
            animate();
        }
    }
    
     public void detectWallCollision(){
         if (isTouching(Wall.class)){
             removeLife();
             Greenfoot.playSound("hurt.wav");
             removeLife();
            }
         
     }
     
      public void detectBlockCollision(){
         if (isTouching(Block.class)){
             removeLife();
             Greenfoot.playSound("hurt.wav");
             removeLife();
         }
     }
     
     public void detectHome(){
         if (isTouching(Home.class)){
             if(pizzaEaten==5){
               resetPosition();
               resetTimer();
             Greenfoot.playSound("yipee.wav"); 
             pizzaEaten = 0;
             increasedScore();
             
             RobotWorld myworld = (RobotWorld)getWorld();
             myworld.increaseLevel();
             }
         }
     }
     
     public void eatPizza(){
         if (isTouching(Pizza.class)){
            removeTouching(Pizza.class);
            pizzaEaten++;
            Greenfoot.playSound("eat.wav");
            timer+=200;
        }//endif
     }
     
    public void removeLife(){
        lives--;
        resetPosition();
        testEndGame();
    }
    
    public void testEndGame(){
        if(lives<=0){
            setImage(gameover);
            Greenfoot.stop();
        }
    }
    
    public void increasedScore(){
        score++;
    }
    
    public void showStatus(){
        getWorld().showText("Score : " + score, 60, 525);
        getWorld().showText("Lives : " + lives, 60, 550);
    }
}
