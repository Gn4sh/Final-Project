import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    private int jumpHeight = 10;
    private int walkSpeed = 5;
    private double fallSpeed = 0.4;
    
    
    
    private boolean inTheAir = false;
    private double deltaX = 0;
    private double deltaY = 0;
    private int groundHeight = getImage().getHeight()/2;
    private int sideWidth = getImage().getWidth()/2;
    private World myWorld;
    int worldHeight;
    int worldWidth;
    
    
    /*
     * addedToWorld It adds the height and the width of the world and myWorld to the world
     * 
     * @param 
     * @return there is nothing to be returned
     */
    public void addedToWorld(World myWorld)
    {
        this.myWorld = myWorld;
        this.worldHeight = myWorld.getHeight();
        this.worldWidth = myWorld.getWidth();
    }
    
    /**
     * Act method It calls the animation method and the move method. 
     *
     * @param there are no parameters
     * @return there is nothing to be returned
     */
    public void act() 
    {
        // Add your action code here.
        if(inTheAir)
        {
            fall();
        }
        else
        {
            getCommand();
        }
        move();
        Animation();
    }
    
    
    /*
     * Animation It sets the location of the player to move five pixels from getting push by character
     * 
     * @param there are no parameters
     * @return there is nothing to be returned
     */
    private void Animation()
    {
        Actor player = getOneIntersectingObject(Player.class);
        if( player != null )
        {
            player.setLocation(player.getX() + 5, player.getY() );
        }
    }
    
    
    /*
     * Run Sets the running speed of the character
     * 
     * @param (String direction) it is the way the character is going
     * @return there is nothing to be returned
     */
    private void run (String direction)
    {
        if(direction.equals("left"))
        {
            deltaX = walkSpeed*-1;
        }
        else  
        {
            deltaX = walkSpeed;
        }
    }
    
    
    /*
     * Stop
     * 
     * @param there are no parameters
     * @return there is nothing to be returned
     */
    private void stop()
    {
        deltaX = 0;
    }
    
    
    /*
     * Jump makes the character jump a certain amount in height
     * 
     * there are no paramaters
     * there is nothing to be returned
     */
    private void jump()
    {
        deltaY += jumpHeight;
        inTheAir = true;
    }
    
    
    /*
     * Fall It slows the Character when falling in the game
     * 
     * @param there are no parameters
     * @return there is nothing to be returned
     */
    private void fall()
    {
        deltaY -= fallSpeed;
    }
    
    
    /*
     * Move The character that is on the platform in the game can jumo to the other platforms. the platform below the character moves 5 pixels down, platform abaove moves 5 pixels up, platform to the right the character can move 5 pixels to the right
     * of the platform at the width of 5 pixels, platform left the chracter can move to the left of the platform at the width of 5 pixels. It also sets the location of X and Y.
     * 
     * @param there are no parameters
     * @return there is nothing to be returned
     */
    private void move()
    {
        double newX = getX() + deltaX;
        double newY = getY() - deltaY;
        
        Actor platformBelow = getOneObjectAtOffset(0, groundHeight + 5, platform.class);
        Actor platformAbove = getOneObjectAtOffset(0,-(groundHeight + 5), platform.class);
        Actor platformToRight = getOneObjectAtOffset(sideWidth+5, 0, platform.class);
        Actor platformToLeft = getOneObjectAtOffset(-(sideWidth+5), 0, platform.class);
        if(platformBelow !=null)
        {
            if(deltaY < 0)
            {
                deltaY = 0;
                inTheAir = false;
                GreenfootImage platformImage = platformBelow.getImage();
                int topOfPlatform = platformBelow.getY() - platformImage.getHeight()/2;
                newY = topOfPlatform - groundHeight;
            }
        }
        else if(getY() >= worldHeight - groundHeight)
        {
            if(deltaY < 0)
            {
                deltaY = 0;
                inTheAir = false;
                newY = worldHeight - groundHeight;
            }
        }
        else
        {
            inTheAir = true;
        }
        
        
        
        if(platformAbove !=null)
        {
            if(deltaY >0)
            {
                deltaY = 0;
                
                GreenfootImage platformImage = platformAbove.getImage();
                int bottomOfPlatform = platformAbove.getY() + platformImage.getHeight()/2;
                newY = bottomOfPlatform + groundHeight;
            }
        }
        
        
        if(getX() <= sideWidth)
        {
            deltaX = Math.abs(deltaX);
        }
        
        if(getX() >= worldWidth - sideWidth)
        {
             deltaX = Math.abs(deltaX) * -1;
        }
        
        if(platformToRight !=null)
        {
            deltaX = Math.abs(deltaX) * -1;
        }
        
        if(platformToLeft !=null)
        {
            deltaX = Math.abs(deltaX);
        }
        setLocation((int)newX,(int)newY);
    }
    
    
    /*
     * getCommand It lets you press the keys to control the character the direction you want the chracter to go
     * 
     * @param there are no parameters
     * @return there is nothing to be returned
     */
    private void getCommand()
    {
        if(Greenfoot.isKeyDown("left") )
        {
            run("left");
        }
        else if(Greenfoot.isKeyDown("right") )
        {
            run("right");
        }
        else 
        {
            stop();
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            jump();
        }
    }
}
    
