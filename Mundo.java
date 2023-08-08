import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Mundo extends World
{
    GreenfootImage fondo;
    Personaje personaje;
    Menu playbutton;
    Villano villano;
    Estrella estrellas[] = new Estrella[4];
    public GreenfootImage etiquetaEstrellas;
    GreenfootImage victoria;
    GreenfootImage derrota;
    GreenfootImage instrucciones;
    private GreenfootSound musicafondo;
    /**
     * Constructor for objects of class Mundo.
     * 
     */
    public Mundo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 640, 1); 
        personaje = new Personaje();
        fondo = new GreenfootImage("FondoJuego.jpg");
        playbutton= new Menu(1);
        villano = new Villano();
        victoria = new GreenfootImage("Ganaste.png");
        derrota = new GreenfootImage("Perdiste.png");
        instrucciones= new GreenfootImage("Instrucciones.png");
        musicafondo = new GreenfootSound("Musica.mp3");

        for(int i=0 ; i<4 ; i++){
            estrellas[i] = new Estrella();
        }   
        etiquetaEstrellas = new GreenfootImage("", 30, Color.BLACK, null);
        cambiarNivel(3);
    }
    public void niveluno(){
        this.setBackground(fondo);
        DibujarLaberinto(LabUno());
        addObject(personaje,500,230);
        addObject(villano,580,270);
        addObject(estrellas[1],250,150);
        addObject(estrellas[2],410,370);
        addObject(estrellas[3],500,360);
        Musica();
    }
    public void victoria(){
        this.setBackground(victoria);
        Greenfoot.stop();
    }
    public void derrota(){
        this.setBackground(derrota);
        Greenfoot.stop();
    }
    public void remove()
    {
        int aux;
        aux=getObjects(null).size();
        Actor a;
        for(int f=0;f<aux;f++){
            a = (Actor) getObjects(null).get(0);
            removeObject(a);  
        }
    }
    public void Instrucciones(){
        this.setBackground(instrucciones);
        addObject(playbutton, 300, 250);
        
    }
    private void Musica(){
      musicafondo.playLoop();  
    }
    private int[][] LabUno(){
        int laberinto[][]={
                        
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1},
            {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
            {1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

        
        };
        return laberinto;
        
    }
    private void generarLab(){
        int limite= 20;
        int laberinto[][]={
        /*i*/    
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1},
            {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
            {1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        
        };
        for (int j = 0; j < limite; j++) {
            for (int i = 0; i < limite; i++) {
                if (laberinto[i][j]==1){
                    Muro muro = new Muro();
                    addObject(muro,(j*30),(i*32));
                }
            }
        }
    }
    public void DibujarLaberinto(int[][] laberinto){
        int limite= 20;
        for (int j = 0; j < limite; j++) {
            for (int i = 0; i < limite; i++) {
                if (laberinto[i][j]==1){
                    Muro muro = new Muro();
                    addObject(muro,(j*30),(i*32));
                }
            }
        }
    }
    public void cambiarNivel(int x){
        switch(x){
            case 0: remove();
                    niveluno();
                    break;
            case 1: remove();
                    victoria();
                    break;
            case 2: remove();
                    derrota();
                    break;
            case 3: remove();
                    Instrucciones();
                    break;
        }
    }
    }
    
    

