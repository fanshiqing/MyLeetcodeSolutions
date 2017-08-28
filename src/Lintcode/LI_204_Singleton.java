package Lintcode;

/**
 * Created by sqfan on 8/28/17.
 */
public class LI_204_Singleton {
  private static LI_204_Singleton instance = new LI_204_Singleton();

  private LI_204_Singleton() {
    // init
  }

  /**
   * @return: The same instance of this class every time
   */
  public static LI_204_Singleton getInstance() {
    return instance;
  }
}
