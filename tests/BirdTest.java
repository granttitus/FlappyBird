/**
 * 
 * Author: xdvrx1
 * License: MIT
 * 
 */

import org.junit.*;

public class BirdTest {
    Bird bird;
    
    @Before
    public void setUp() throws Exception {
        bird = new Bird();
    }
    
    @Test
    public void assertBirdNotNull() {
        Assert.assertNotNull(bird);
    }
    
    @Test
    public void assertBirdObjectPublicMembers() {
        Assert.assertEquals(100, bird.x);
        Assert.assertEquals(150, bird.y);
        Assert.assertEquals(45, bird.width);
        Assert.assertEquals(32, bird.height);
    }
    
    @Test
    public void assertBirdObjectStateInsideVoid() {
        bird.update();
        Assert.assertNotEquals(0, bird.yvel);
    }
    
    @Test
    public void assertRenderObjectNotNull() {
        Render r = bird.getRender();
        Assert.assertNotNull(r);
    }
    
    @After
    public void tearDown() throws Exception {
        bird = null;
    }
    
}
