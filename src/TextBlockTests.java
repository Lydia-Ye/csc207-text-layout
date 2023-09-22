import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Tests of the Text Blocks.
 * 
 * @author Samuel A. Rebelsky
 * @author Lydia Ye
 */
public class TextBlockTests {
  
  /**
   * A test of Truncated text line
   */
  @Test
  void truncatedTest1() throws Exception {
    TextBlock block_hello = new TextLine("Hello");
    TextBlock block_gb = new TextLine("Goodbye");
    TextBlock truncated_hello = new Truncated(block_hello, 10);
    TextBlock truncated_gb = new Truncated(block_gb, 5);
    assertEquals(truncated_hello.row(0), "Hello     ");
    assertEquals(truncated_gb.row(0), "Goodb");
  } // sampleSuccessfulTest()

  /**
   * A test of Truncated boxed blocks
   */
  @Test
  void truncatedTest2() throws Exception {
    TextBlock block_hello = new TextLine("Hello");
    TextBlock boxed_hello = new BoxedBlock(block_hello);
    TextBlock truncated_bhello = new Truncated(boxed_hello, 4);

    assertEquals(truncated_bhello.row(0), "+---");
    assertEquals(truncated_bhello.row(1), "|Hel");
    assertEquals(truncated_bhello.row(2), "+---");
    assertEquals(truncated_bhello.width(), 4);
  } // sampleSuccessfulTest()

  /**
   * A test of centered blocks
   */
  @Test
  void centeredTest() throws Exception {
    TextBlock block_hello = new TextLine("Hello");
    TextBlock centered_hello1 = new Centered(block_hello, 9);
    assertEquals(centered_hello1.row(0), "  Hello  ");
    assertEquals(centered_hello1.width(), 9);

    TextBlock centered_hello2 = new Centered(block_hello, 3);
    assertEquals(centered_hello2.row(0), "ell");
    assertEquals(centered_hello2.width(), 3);
  } // sampleSuccessfulTest()


  /**
   * A test of right justified block
   */
  @Test
  void rightJustifiedTest() throws Exception {
    TextBlock block_hello = new TextLine("Hello");
    TextBlock rj_hello1 = new RightJustified(block_hello, 9);
    assertEquals(rj_hello1.row(0), "    Hello");
    assertEquals(rj_hello1.width(), 9);
  } // sampleSuccessfulTest()

} // class TestSampleMethods