import java.io.PrintWriter;
import org.w3c.dom.Text;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    TextBlock block1 = new TextLine("This is a test.");
    TBUtils.print(pen,block1);

    // Create a block to use
    TextBlock block_hello = new TextLine("Hello");
    TextBlock block_gb = new TextLine("Goodbye");
    // Print out the block
    TBUtils.print(pen, block_hello);

    // Create and print a boxed block
    TextBlock boxed_hello = new BoxedBlock(block_hello);
    TBUtils.print(pen, boxed_hello);

    // Create and print a boxed boxed block
    TextBlock bboxed_hello = new BoxedBlock(boxed_hello);
    TBUtils.print(pen, bboxed_hello);

    // Create and print a boxed empty block
    TextBlock empty_line = new TextLine("");
    TextBlock boxed_empty_line = new BoxedBlock(empty_line);
    TBUtils.print(pen, boxed_empty_line);

    // Create and print text blocks using VComposition and HComposition
    TextBlock vcompose_hello_gb = new VComposition(block_hello, block_gb);
    TextBlock boxed_vcomposed_blocks = new BoxedBlock(vcompose_hello_gb);
    TBUtils.print(pen, boxed_vcomposed_blocks);

    TextBlock boxed_gb = new BoxedBlock(block_gb);
    TextBlock vcompose_boxed_blocks = new VComposition(boxed_hello, boxed_gb);
    TBUtils.print(pen, vcompose_boxed_blocks);

    TextBlock hcompose_bhello_gb = new HComposition(boxed_hello, block_gb);
    TBUtils.print(pen, hcompose_bhello_gb);

    TextBlock hcompose_hello_bgb = new HComposition(block_gb, boxed_hello);
    TBUtils.print(pen, hcompose_hello_bgb);

    pen.close();
  } // main(String[])

} // class TBExpt
