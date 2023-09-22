import java.io.PrintWriter;

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

    // Truncate text blocks
    TextBlock truncated_hello = new Truncated(block_hello, 10);
    TBUtils.print(pen, truncated_hello);
    TextBlock truncated_gb = new Truncated(block_gb, 5);
    TBUtils.print(pen, truncated_gb);    
    
    // Truncate boxed blocks
    TextBlock truncated_bhello = new Truncated(boxed_hello, 4);
    TBUtils.print(pen, truncated_bhello);
    TextBlock truncated_bgb = new Truncated(boxed_gb, 10);
    TBUtils.print(pen, truncated_bgb);    

   // Centered text blocks
    TextBlock centered_hello = new Centered(block_hello, 9);
    TBUtils.print(pen, centered_hello);
    TextBlock centered_gb = new Centered(block_gb, 9);
    TBUtils.print(pen, centered_gb);    
    
   // Boxed centered text blocks
    TextBlock bcentered_hello = new BoxedBlock(centered_hello);
    TBUtils.print(pen, bcentered_hello);
    TextBlock bcentered_gb = new BoxedBlock(centered_gb);
    TBUtils.print(pen, bcentered_gb);     

    // Right-justified text blocks
    TextBlock rj_hello = new RightJustified(block_hello, 9);
    TBUtils.print(pen, rj_hello);
    TextBlock rj_gb = new RightJustified(block_gb, 9);
    TBUtils.print(pen, rj_gb);   
    
    // Boxed right-justified text blocks
    TextBlock brj_hello = new BoxedBlock(rj_hello);
    TBUtils.print(pen, brj_hello);
    TextBlock brj_gb = new BoxedBlock(rj_gb);
    TBUtils.print(pen, brj_gb);  

    // Horrizontally flipped block
    TextBlock hflipped_hello = new HorizontallyFlipped(block_hello);
    TBUtils.print(pen, hflipped_hello);

    // Horrizontally flipped block
    TextBlock vflipped_hello_gb = new VerticallyFlipped(vcompose_hello_gb);
    TBUtils.print(pen, vflipped_hello_gb);

    TextBlock add_space_to_hello = new AddSpaces(block_hello);
    TBUtils.print(pen, add_space_to_hello);

    TextBlock a = block_hello;
    TextBlock b = block_hello;
    pen.println(block_hello);
    pen.println(a);
    pen.println(b);
    pen.println(block_gb);

    pen.println(TBUtils.eqv(a,boxed_gb));

    pen.close();
  } // main(String[])

} // class TBExpt
