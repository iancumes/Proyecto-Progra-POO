import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Villano here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Villano extends Actor {
    private double velocidad = 1.2; 
    private int x;
    private int y;
    public void act() {
        seguirPersonaje();
        verificarColisionConPersonaje();
    }
    
    private void seguirPersonaje() {
        
        World mundo = getWorld();
        
        
        Personaje personaje = (Personaje) mundo.getObjects(Personaje.class).get(0);
        
        
        int dx = personaje.getX() - getX();
        int dy = personaje.getY() - getY();
        
        
        double distancia = Math.sqrt(dx * dx + dy * dy);
        
        
        int desplazamientoX = (int) (dx * velocidad / distancia);
        int desplazamientoY = (int) (dy * velocidad / distancia);
        
        
        setLocation(getX() + desplazamientoX, getY() + desplazamientoY);
        
    }
    private void verificarColisionConPersonaje(){
        World mundo = getWorld();
        Personaje personaje = (Personaje) mundo.getObjects(Personaje.class).get(0);
        if (isTouching(Personaje.class)) {
            ((Mundo)this.getWorld()).cambiarNivel(2);
    }
    }
}
