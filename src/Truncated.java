/**
 * Builds a new text block that truncates the input block to a specified width
 * 
 * @author Lydia Ye
 * @version September 2023
 */
public class Truncated  implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The block we are truncating.
   */
  TextBlock block;

  /**
   * The width of the truncated block;
   */
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new text block with the specified width.
   */
  public Truncated(TextBlock _block, int _width){
    this.block = _block;
    this.width = _width;
  } // Truncated(TextBlock , int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the truncated block.
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
    // truncated width
    if (w == this.width) {
      return this.block.row(i);
    } else if (w > this.width) {
      return this.block.row(i).substring(0, this.width);
    } else {
      int spaceLength = this.width - w;
      String extraSpace = TBUtils.spaces(spaceLength);
      return this.block.row(i) + extraSpace;
    } // if
  } // row(int)

  /**
   * Determine how many rows are in the truncated block.
   */
  public int height() {
    return this.block.height();
  } // height()

  /**
   * Determine how many columns are in the truncated block.
   */
  public int width() {
    return this.width;
  } // width()

} // class Truncated 
