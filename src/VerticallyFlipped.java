/**
 * Rearrange the input text block vertically.
 * 
 * @author Lydia Ye
 * @version September 2023
 */
public class VerticallyFlipped  implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The block we are flipping.
   */
  TextBlock block;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Flip the input block vertically.
   */
  public VerticallyFlipped(TextBlock _block){
    this.block = _block;
  } // VerticallyFlipped(TextBlock , int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the VerticallyFlipped block.
   * 
   * @pre 0 <= i < this.block.height
   * @exception Exception if i is greater than the height of block
   */
  public String row(int i) throws Exception {
    int h = this.block.height();
    if (i > h - 1) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid
    return this.block.row((h - 1) -i);
  } // row(int)

  /**
   * Determine how many rows are in the VerticallyFlipped block.
   */
  public int height() {
    return this.block.height();
  } // height()

  /**
   * Determine how many columns are in the VerticallyFlipped block.
   */
  public int width() {
    return this.block.width();
  } // width()

} // class VerticallyFlipped