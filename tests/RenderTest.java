/**
 * 
 * Author: xdvrx1
 * License: MIT
 * 
 */

import org.junit.*;

public class RenderTest {
    
    @Test
    public void testTheConstructor() {
        //with the plain constructor
        Render r = new Render();
        Assert.assertEquals(0, r.x);
        
        //with the constructor accepting image path
        //the image is null 
        Render r2 = new Render(1, 1, "/fake-dir");
        Assert.assertNull(r2.image);
        
        //the real directory
        Render r3 = new Render(0, 0, "lib/bird.png");
        Assert.assertNotNull(r3);
    }
    
}