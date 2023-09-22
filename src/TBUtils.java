import java.io.PrintWriter;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @author Lydia Ye
 * @version September 2023
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program operates.
   */
  static String lotsOfSpaces = "  ";


  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

  /**
   * equal returns true if two input text blocks contain the same lines, 
   * otherwise return false.
   */
  static boolean equal(TextBlock t1, TextBlock t2) throws Exception {
    if (t1.height() != t2.height()){
      return false;
    } // if t1 and t2 doon't have same row numbers

    for (int i = 0; i < t1.height(); i++) {
      // if two rows are not equal
      if (t1.row(i) != t2.row(i)) 
        return false;
    } // for every row i of t1 and t2

    return true;
  } // equal(TextBlock, TextBlock)

  /**
   * eqv returns true if the two input text blocks were build in the same way,
   * otherwise false.
   */
  static boolean eqv(TextBlock t1, TextBlock t2) {
    if (t1.getClass() == t2.getClass())
      return true;
    else
      return false;
  } // eqv(TextBlock, TextBlock)

  /**
   * eq returns true if the two input text blocks occupy the same memory location,
   * otherwise false.
   */
  static boolean eq(TextBlock t1, TextBlock t2) {
    // check if t1 and t2 have the same address
   return (t1 == t2);
  } // eq(TextBlock, TextBlock)




} // class TBUtils
