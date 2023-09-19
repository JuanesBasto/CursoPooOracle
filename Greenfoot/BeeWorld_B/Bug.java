import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bug extends Actor
{
    /**
     * Act - do whatever the Bug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * turnAtEdge - gira al actor 180 grados si está al borde del mundo
       */
    
    public void act()
    {
        // Add your action code here.
    }
    
    /**
     * turnAtEdge - gira al actor 180 grados si está al borde del mundo
     */
    public void turnAtEdge()
    {
        if (isAtEdge())
        {
            turn(180);
        }
    }
}
