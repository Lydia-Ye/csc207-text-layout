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
   * A test of centered text line
   */
  @Test
  void centeredTest1() throws Exception {
    TextBlock block_hello = new TextLine("Hello");
    TextBlock centered_hello1 = new Centered(block_hello, 9);
    assertEquals(centered_hello1.row(0), "  Hello  ");
    assertEquals(centered_hello1.width(), 9);

    TextBlock centered_hello2 = new Centered(block_hello, 3);
    assertEquals(centered_hello2.row(0), "ell");
    assertEquals(centered_hello2.width(), 3);
  } // centeredTest1()

  /**
   * A test of centered boxed blocks
   */
  @Test
  void centeredTest2() throws Exception {
    TextBlock block_hello = new TextLine("Hello");

    // Centered boxed text block
    TextBlock boxed_hello = new BoxedBlock(block_hello);
    TextBlock centered_bhello = new Centered(boxed_hello, 11);

    assertEquals(centered_bhello.row(0), "  +-----+  ");
    assertEquals(centered_bhello.row(1), "  |Hello|  ");
    assertEquals(centered_bhello.row(2), "  +-----+  ");
    assertEquals(centered_bhello.width(), 11);

    // Boxed centered text blocks
    TextBlock centered_hello = new Centered(block_hello, 3);
    TextBlock bcentered_hello = new BoxedBlock(centered_hello);
    assertEquals(bcentered_hello.row(0), "+---+");
    assertEquals(bcentered_hello.row(1), "|ell|");
    assertEquals(bcentered_hello.row(2), "+---+");
    assertEquals(bcentered_hello.width(), 5);

    TextBlock block_gb = new TextLine("Goodbye");
    TextBlock centered_gb = new Centered(block_gb, 12);
    TextBlock bcentered_gb = new BoxedBlock(centered_gb);
    assertEquals(bcentered_gb.row(0), "+------------+");
    assertEquals(bcentered_gb.row(1), "|  Goodbye   |");
    assertEquals(bcentered_gb.row(2), "+------------+");
    assertEquals(bcentered_gb.width(), 14);
  } // centeredTest2()


  /**
   * A test of right justified text line
   */
  @Test
  void rightJustifiedTest1() throws Exception {
    TextBlock block_hello = new TextLine("Hello");
    TextBlock rj_hello = new RightJustified(block_hello, 9);
    assertEquals(rj_hello.row(0), "    Hello");
    assertEquals(rj_hello.width(), 9);
  } // rightJustifiedTest1() 

  /**
   * A test of right justified boxed blocks
   */
  @Test
  void rightJustifiedTest2() throws Exception {
    TextBlock block_hello = new TextLine("Hello");
    TextBlock rj_hello = new RightJustified(block_hello, 9);
    TextBlock brj_hello = new BoxedBlock(rj_hello);

    assertEquals(brj_hello.width(), 11);
    assertEquals(brj_hello.row(0), "+---------+");
    assertEquals(brj_hello.row(1), "|    Hello|");
    assertEquals(brj_hello.row(2), "+---------+");
  } // rightJustifiedTest2() 

  /**
   * A test of spaced blocks
   */
  @Test
  void addSpaceTest() throws Exception {
    TextBlock block_hello = new TextLine("Hello");

    // Spaced text line
    TextBlock add_space_to_hello = new AddSpaces(block_hello);
    assertEquals(add_space_to_hello.row(0), "H e l l o");
    assertEquals(add_space_to_hello.width(), 9);

    // Boxed spaced block
    TextBlock boxed_spaced_hello = new BoxedBlock(add_space_to_hello);
    assertEquals(boxed_spaced_hello.row(0), "+---------+");
    assertEquals(boxed_spaced_hello.row(1), "|H e l l o|");
    assertEquals(boxed_spaced_hello.row(2), "+---------+");
    assertEquals(boxed_spaced_hello.width(), 11);
  } // addSpaceTest()

  /**
   * A test of horizontally flipped blocks
   */
  @Test
  void hFlippedTest() throws Exception {
    TextBlock block_hello = new TextLine("Hello");
    TextBlock hflipped_hello = new HorizontallyFlipped(block_hello);
    assertEquals(hflipped_hello.row(0), "olleH");
    assertEquals(hflipped_hello.width(), block_hello.width());
  } // hFlippedTest()

  /**
   * A test of vertically flipped block
   */
  @Test
  void vFlippedTest() throws Exception {
    TextBlock block_hello = new TextLine("Hello");
    TextBlock block_gb = new TextLine("Goodbye");
    TextBlock vcompose_hello_gb = new VComposition(block_hello, block_gb);
    TextBlock vflipped_hello_gb = new VerticallyFlipped(vcompose_hello_gb);
    assertEquals(vflipped_hello_gb.row(0), "Goodbye");
    assertEquals(vflipped_hello_gb.row(1), "Hello  ");
    assertEquals(vflipped_hello_gb.width(), vcompose_hello_gb.width());
    assertEquals(vflipped_hello_gb.height(), vcompose_hello_gb.height());
  } // vFlippedTest()
} // class TestSampleMethods