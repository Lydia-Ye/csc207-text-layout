/**
 * Builds a new text block that centers the block within the specified width
 * 
 * @author Lydia Ye
 * @version September 2023
 */
public class Centered  implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The block we are truncating.
   */
  TextBlock block;

  /**
   * The width of the Centered block;
   */
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new text block with the specified width.
   */
  public Centered(TextBlock _block, int _width){
    this.block = _block;
    this.width = _width;
  } // Centered(TextBlock , int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the Centered block.
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
      return this.block.row(i).substring(cutoff / 2, this.width + (cutoff / 2));
    } else {
      int spaceLength = this.width - w;
      String lSpace = TBUtils.spaces(spaceLength / 2);
      String rSpace = TBUtils.spaces(this.width - w - spaceLength / 2 );
      return lSpace + this.block.row(i) + rSpace;
    } // if
  } // row(int)

  /**
   * Determine how many rows are in the Centered block.
   */
  public int height() {
    return this.block.height();
  } // height()

  /**
   * Determine how many columns are in the Centered block.
   */
  public int width() {
    return this.width;
  } // width()

} // class Centered
