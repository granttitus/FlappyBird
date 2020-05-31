/**
 * 
 * Author: xdvrx1
 * License: MIT
 * 
 */

import java.io.IOException;
import java.awt.Image;

import org.junit.*;

public class UtilTest {
    
    @Test
    public void assertLoadImageMethodPathShouldBeNull() {        
        //should be null
        Assert.assertNull(Util.loadImage("/fake"));                
    }
    
    @Test
    public void assertLoadImageMethodPathShouldNotBeNull() {        
        //should not be null
        Assert.assertNotNull(Util.loadImage("lib/bird.png"));
        Assert.assertNotNull(Util.loadImage("lib/background.png"));
        Assert.assertNotNull(Util.loadImage("lib/foreground.png"));
        Assert.assertNotNull(Util.loadImage("lib/pipe-north.png"));
        Assert.assertNotNull(Util.loadImage("lib/pipe-south.png"));        
    }
    
    @Test(expected = IOException.class)
    public void loadImageMethodMustThrowAnException() throws IOException {
        
        //the given directory is fake, so it should
        //explicitly throw the IOException
        Image image = Util.loadImage("/fake");
        if (image == null) {
            throw new IOException("ioe");   
        }       
    }
    
    @Test
    public void loadImageMethodMustNoTThrowAnException() throws IOException {
        
        //this time the image can be found
        Image image = Util.loadImage("lib/bird.png");
        
        //this if will simply be ignored
        if (image == null) {
            Assert.fail("this line should not be reached: " +
                        "this if statement will simply be ignored.");
            
            throw new IOException("ioe");   
            
        }       
    }    
    
}