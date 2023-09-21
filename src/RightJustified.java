/**
 * Builds a new text block that right-justifies the input block within a 
 * specified width
 * 
 * @author Lydia Ye
 * @version September 2023
 */
public class RightJustified  implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The block we are right-justifying.
   */
  TextBlock block;

  /**
   * The width of the right justified block.
   */
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new right justified text block with the specified width.
   */
  public RightJustified(TextBlock _block, int _width){
    this.block = _block;
    this.width = _width;
  } // RightJustified(TextBlock , int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the RightJustified block.
   * 
   * @pre 0 <= i < this.block.height
   * @exception Exception if i is greater than the height of block
   */
  public String row(int i) throws Exception {
    // The width of input block
    int w = this.block.width();
    
    if (i > this.block.height()) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    // Check if the width of input block is less, equal or greater the the 
    // Centered width
    if (w == this.width) {
      return this.block.row(i);
    } else if (w > this.width) {
      int cutoff = w - this.width;
      return this.block.row(i).substring(cutoff, this.width);
    } else {
      int spaceLength = this.width - w;
      String lSpace = TBUtils.spaces(spaceLength);
      return lSpace + this.block.row(i);
    } // if
  } // row(int)

  /**
   * Determine how many rows are in the RightJustified block.
   */
  public int height() {
    return this.block.height();
  } // height()

  /**
   * Determine how many columns are in the RightJustified block.
   */
  public int width() {
    return this.width;
  } // width()

} // class RightJustified 
