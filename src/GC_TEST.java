/**
 * Created by sqfan on 8/23/17.
 * 测试：一个对象被赋值为null以后不一定被标记为可回收对象
 */
class FinalizedEscapeTestCase {
  public static FinalizedEscapeTestCase caseForEscape = null;

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("哈哈，我已逃逸！");
    caseForEscape = this;
  }
}
public class GC_TEST {
  public static void main(String[] args) throws InterruptedException {

    System.out.println(FinalizedEscapeTestCase.caseForEscape);

    FinalizedEscapeTestCase.caseForEscape = new FinalizedEscapeTestCase();

    System.out.println(FinalizedEscapeTestCase.caseForEscape);

    FinalizedEscapeTestCase.caseForEscape = null;

    System.gc();

    Thread.sleep(100);

    System.out.println(FinalizedEscapeTestCase.caseForEscape);
  }
}
