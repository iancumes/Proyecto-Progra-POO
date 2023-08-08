import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends Actor
{
    int contador;
    /**
     * Act - do whatever the Menu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Menu(int cont)
    {
        contador=cont;
        cont=1;
        
        if (cont==1){
            this.setImage("Play.png");
    }
}
public void act(){
   if(Greenfoot.mouseClicked(this)&&contador==1){
       ((Mundo)this.getWorld()).cambiarNivel(0);
   }
}
}

