import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int time;
    /**
     * Constructor for objects of class MyWorld.
     * 
     * @param there are no parameters
     * @return there is nothing to be returned
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        time = 2000;
        showTime();
        prepare();
    }
    
    
    /*
     * Act method It cycles through the time in the game
     * 
     * @param there are no parameters
     * @return there is nothing to be returned
     */
    public void act()
    {
        time--;
        showText("Time: " + time, 700, 25);
    }
    
    
    /**
     * countTime It counts the time in the game
     * 
     * @param there are no parameters
     * @return there is nothing to be returned
     */
    private void countTime()
    {
        time++;
        showTime();
        if(time == 0)
        {
            showEndMessage();
            Greenfoot.stop();
        }
    }
    
    
    /*
     * showTime it displays the time in the game
     * 
     * @param there are no parameters
     * @return there is nothing to be returned
     */
    private void showTime()
    {
        showText("Time: " + time, 700, 25);
    }
    
    
    /*
     * showEndMessage At the end of the game it displays that your'e time is up
     * 
     * @param there are no parameters
     * @return there is nothing to be returned 
     */
    private void showEndMessage()
    {
        showText("Time is up", 390, 150);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     * 
     * @param there are no parameters
     * @return there is nothing returned
     */
    private void prepare()
    {
        platform platform = new platform();
        addObject(platform,82,218);
        platform platform2 = new platform();
        addObject(platform2,157,225);
        platform2.setLocation(151,218);
        platform platform3 = new platform();
        addObject(platform3,767,233);
        platform platform4 = new platform();
        addObject(platform4,844,239);
        platform4.setLocation(833,232);
        platform platform5 = new platform();
        addObject(platform5,439,138);
        platform platform6 = new platform();
        addObject(platform6,517,144);
        platform platform7 = new platform();
        addObject(platform7,301,269);
        platform platform8 = new platform();
        addObject(platform8,381,276);
        platform7.setLocation(262,130);
        platform6.setLocation(599,164);
        platform5.setLocation(534,164);
        platform8.setLocation(359,246);
        platform7.setLocation(273,107);
        platform8.setLocation(355,246);
        removeObject(platform7);
        platform4.setLocation(832,233);
        platform platform9 = new platform();
        addObject(platform9,50,672);
        platform platform10 = new platform();
        addObject(platform10,124,677);
        platform10.setLocation(116,671);
        platform10.setLocation(115,672);
        platform platform11 = new platform();
        addObject(platform11,99,462);
        platform platform12 = new platform();
        addObject(platform12,482,603);
        platform platform13 = new platform();
        addObject(platform13,558,609);
        platform13.setLocation(548,603);
        platform8.setLocation(333,301);
        platform6.setLocation(530,397);
        platform platform14 = new platform();
        addObject(platform14,752,486);
        platform platform15 = new platform();
        addObject(platform15,817,491);
        platform15.setLocation(813,486);
        platform6.setLocation(312,472);
        platform platform16 = new platform();
        addObject(platform16,385,481);
        platform16.setLocation(377,472);
        platform8.setLocation(330,276);
        platform platform17 = new platform();
        addObject(platform17,721,704);
        platform platform18 = new platform();
        addObject(platform18,795,711);
        platform18.setLocation(788,705);
        platform6.setLocation(293,499);
        platform16.setLocation(358,499);
        platform platform19 = new platform();
        addObject(platform19,507,413);
        platform19.setLocation(579,372);
        platform13.setLocation(614,713);
        platform12.setLocation(406,668);
        platform13.setLocation(558,726);
        platform platform20 = new platform();
        addObject(platform20,272,678);
        removeObject(platform10);
        platform20.setLocation(148,672);
        platform12.setLocation(356,665);
        platform16.setLocation(342,425);
        platform8.setLocation(330,269);
        platform6.setLocation(274,545);
        platform16.setLocation(414,474);
        platform19.setLocation(618,370);
        platform15.setLocation(895,487);
        platform14.setLocation(755,529);
        platform18.setLocation(878,669);
        removeObject(platform13);
        removeObject(platform12);
        platform16.setLocation(375,415);
        platform19.setLocation(649,431);
        platform15.setLocation(918,370);
        platform4.setLocation(929,223);
        removeObject(platform3);
        platform4.setLocation(810,245);
        platform19.setLocation(685,415);
        platform14.setLocation(684,582);
        platform17.setLocation(714,707);
        platform18.setLocation(869,669);
        Character character = new Character();
        addObject(character,95,192);
        platform14.setLocation(623,579);
        Player player = new Player();
        addObject(player,858,639);
        platform18.setLocation(905,673);
        player.setLocation(905,638);
        platform18.setLocation(922,673);
        player.setLocation(918,641);
    }
}
