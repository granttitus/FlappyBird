/**
 * 
 * Author: xdvrx1
 * License: MIT
 * 
 */

import org.junit.*;

public class PipeTest {
    Pipe southPipe;
    Pipe northPipe;
    
    @Before
    public void setUp() throws Exception {
        southPipe = new Pipe("south");
        northPipe = new Pipe("north");
    }
    
    @Test
    public void assertSouthPipe() {
        Assert.assertEquals("south", southPipe.orientation);   
    }
    
    @Test
    public void assertNorthPipe() {
        Assert.assertEquals("north", northPipe.orientation);   
    }
    
    @Test
    public void assertMethodResetMembersState() {
        southPipe.reset();
        //southPipe.width is 66 in the constructor
        Assert.assertEquals(66, southPipe.width);
        
        //southPipe.height is 400 in the constructor
        Assert.assertEquals(400, southPipe.height);
    }
    
    @Test
    public void assertMethodUpdateMemberState() {
        southPipe.update();
        //southPipe.x = APP.WIDTH + 2 - 3 = 499
        Assert.assertEquals(499, southPipe.x);     
    }
    
    @Test
    public void assertMethodBooleanCollides() {  
        //for south   
        Assert.assertTrue(southPipe.collides(400, 10, 400, 10));   
        //for north
        Assert.assertTrue(northPipe.collides(400, 10, 400, 10));
        
    }
    
    @Test
    public void assertMethodGetRender() {   
        Render r = southPipe.getRender();  
        Assert.assertNotNull(r);
        
        Render r2 = northPipe.getRender();
        Assert.assertNotNull(r2);
    }
    
    @After
    public void tearDown() throws Exception { 
        southPipe = null;
        northPipe = null;
    }
    
}