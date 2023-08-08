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
    int contador;
    /**
     * Act - do whatever the Personaje wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int y=getY();
        Actor estrella;
        estrella= getOneIntersectingObject(Estrella.class);
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
        
           if (estrella != null){
            contador++;
            getWorld().removeObject(estrella);
            actualizarEtiqueta();
        }
        if (contador >= 3){
        ((Mundo)this.getWorld()).cambiarNivel(1);    
        }
        
    }
    private void actualizarEtiqueta(){
        GreenfootImage texto = new GreenfootImage("Estrellas: " + contador, 30, Color.BLACK, null);
        ((Mundo)this.getWorld()).etiquetaEstrellas = texto;
        getWorld().showText("", 300, 300);
        getWorld().showText("Estrellas: " + contador, 200,50);

    }
    }


