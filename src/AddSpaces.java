/**
 * Builds a new text block that add spaces between each character in the text 
 * block.
 * 
 * @author Lydia Ye
 * @version September 2023
 */
public class AddSpaces  implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The block we are truncating.
   */
  TextBlock block;

  /**
   * The width of the AddSpaces block;
   */
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new text block with the specified width.
   */
  public AddSpaces(TextBlock _block) {
    this.block = _block;
  } // AddSpaces(TextBlock , int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the AddSpaces block.
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

    String spaced = "";

    for (int j = 0; j < w - 1; j++) {
      spaced = spaced + this.block.row(i).charAt(j) + " ";
    } // for

    spaced = spaced + this.block.row(i).charAt(w - 1);

    return spaced;
  } // row(int)

  /**
   * Determine how many rows are in the AddSpaces block.
   */
  public int height() {
    return this.block.height();
  } // height()

  /**
   * Determine how many columns are in the AddSpaces block.
   */
  public int width() {
    return this.block.width()*2 - 1;
  } // width()

} // class AddSpaces