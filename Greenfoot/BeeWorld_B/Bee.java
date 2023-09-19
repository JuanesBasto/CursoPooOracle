import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bee extends Actor
{
    private GreenfootImage[] images = new GreenfootImage[4];
    private int currentImage;

    boolean isTurning;
    private int score;
    private int lives;
    
    /**
     * Act - do whatever the Bee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        animateBee();
        handleMovement();
        turnAtEdge();
        catchFly();
        caughtBySpider();
    }//End method act
    
    private void animateBee(){
        if(currentImage == 3){
            currentImage = 0;
        }else{
            currentImage++;
        }//endif
        setImage(images[currentImage]);
    }
    
    public Bee(){
        int i=0;
        while(i<4){
            images[i]= new GreenfootImage("bee" + (i+1) +".png");
            i++;
        }
        currentImage = 0;
        setImage(images[currentImage]);
        score = 0;
        lives = 3;
        isTurning=false;
    }
    
    private void handleMovement(){
        move(1);
        if(Greenfoot.isKeyDown("left")){
            turn(-2);
            isTurning = true;
            //setImage(imageLeft);
        }else if (Greenfoot.isKeyDown("right")){
            turn(2);
            isTurning = true;
            //setImage(imageRight);
        }else{
            isTurning = false;
        }//endif
    }//end method move
    
    private void turnAtEdge(){
        if(atRightEdge()){
            setLocation(6, getY());
        }
        else if(atBottomEdge()){
                setLocation(getX(), 6);
        }
        else if(atLeftEdge()){
                setLocation(getWorld().getWidth()-20, getY());
        }
        else if(atTopEdge()){
                setLocation(getX(), getWorld().getHeight()-20);
        }//endif
    }
    
    /**
     * devuelve al actor al punto inicial si está al borde final de la parte inferior
     */
    private boolean atBottomEdge()
    {
        if(getY() >getWorld().getHeight()-20)
            return true;
        else
        return false;
    }

    /**
     * devuelve al actor al punto inicial si está al borde superior de la parte inferior
     */
    private boolean atTopEdge()
    {
        if(getY() <6)
            return true;
        else
        return false;
    }
    
    /**
     * devuelve al actor al punto inicial si está al borde final del lado derecho
     */
    private boolean atRightEdge()
    {
        if(getX() >getWorld().getWidth()-20)
            return true;
        else
        return false;
    }
    
    /**
     * devuelve al actor al punto inicial si está al borde final del lado izquierdo
     */
    private boolean atLeftEdge()
    {
        if(getX() <6)
            return true;
        else
        return false;
    }
    
    /**
     * retira las moscas que toque la abeja 
     */
    private void caughtBySpider(){
        if (isTouching(Spider.class)){
            setLocation(20,20);
            lives--;
            if(lives<0){
                endGame();
            }
        }//endif
    }
    
    private void endGame(){
        Greenfoot.stop();
    }
    
    /**
     * retira las moscas que toque la abeja 
     */
    private void catchFly(){
        if (isTouching(Fly.class)){
            removeTouching(Fly.class);
            //Greenfoot.playSound("slurp.wav");
            updateScore();
            getWorld().addObject(new Fly(2,90), Greenfoot.getRandomNumber(getWorld().getWidth()), 
                                           Greenfoot.getRandomNumber(getWorld().getHeight()));
        }//endif
    }
    
    private void updateScore(){
        BeeWorld myworld = (BeeWorld) getWorld();
        myworld.updateScore();
    }//endmethod score
}
