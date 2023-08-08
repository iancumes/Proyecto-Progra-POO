import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Personaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personaje extends Actor
{
    private int y;
    private int x;
    /**
     * Act - do whatever the Personaje wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    int y=getY();
    if (Greenfoot.isKeyDown("right"))
    move(1);
    if (Greenfoot.isKeyDown("left"))
    move(-1);
    if (Greenfoot.isKeyDown("up"))
    setLocation(getX(),(getY()-1));
    if (Greenfoot.isKeyDown("down"))
    setLocation(getX(),(getY()+1));
    if(isTouching(Muro.class))
    setLocation(x, y);
    else{
    x = getX(); 
    y = getY(); 
       }
    }
}

