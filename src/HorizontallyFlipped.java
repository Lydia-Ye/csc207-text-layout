/**
 * Rearrange the input text block horizontally.
 * 
 * @author Lydia Ye
 * @version September 2023
 */
public class HorizontallyFlipped  implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The block we are truncating.
   */
  TextBlock block;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new text block with the specified width.
   */
  public HorizontallyFlipped(TextBlock _block){
    this.block = _block;
  } // HorizontallyFlipped(TextBlock , int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the HorizontallyFlipped block.
   * 
   * @pre 0 <= i < this.block.height
   * @exception Exception if i is greater than the height of block
   */
  public String row(int i) throws Exception {
    if (i > this.block.height()) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    String reversed = "";
    for (int j = 0; j < this.block.width(); j++) {
      reversed = this.block.row(i).charAt(j) + reversed;
    } // for

    return reversed;
  } // row(int)

  /**
   * Determine how many rows are in the HorizontallyFlipped block.
   */
  public int height() {
    return this.block.height();
  } // height()

  /**
   * Determine how many columns are in the HorizontallyFlipped block.
   */
  public int width() {
    return this.block.width();
  } // width()

} // class HorizontallyFlipped