import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tryhard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tryhard extends Actor
{
    GreenfootImage [] images = new GreenfootImage[4];
    GreenfootImage [] imagesleft = new GreenfootImage[4];
    SimpleTimer animTimer = new SimpleTimer();
    String facing = "right";
    public Tryhard(){
        for(int i = 0; i < images.length; i++){
            images[i] = new GreenfootImage("images/player2_idle/tile00" + i + ".png");
            images[i].scale(100, 100);
        } 
        
        for(int i = 0; i < imagesleft.length; i++){
            imagesleft[i] = new GreenfootImage("images/player2_idle/tile00" + i + ".png");
            imagesleft[i].mirrorHorizontally();
            imagesleft[i].scale(100, 100);
        }
        setImage(images[0]);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("d")){
            move(10);
            facing = "right";
        }
        if(Greenfoot.isKeyDown("a")){
            move(-10);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY() - 10);
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + 10);
        }
        
        animate();
    }
    
    int i = 0;
    public void animate(){
        
        if(animTimer.millisElapsed() > 100){
            if(facing.equals("right")){
                setImage(images[i]);
                i = (i + 1) % images.length;
            }
            else
            {
                setImage(imagesleft[i]);
                i = (i + 1) % imagesleft.length;
            }
            animTimer.mark();
        }
        
        
    }
}