/**
 * Created by sqfan on 8/25/17.
 * JAVA反射 - 性能测试demo
 */
class A {
  public void doSomeThing() {
    // okay actually I just do nothing ~.~
  }
}
public class Reflection_Perf_Test {
  public static void main(String[] args) throws Exception
  {
    doRegular();
    doReflection();
  }

  public static void doRegular() throws Exception
  {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++)
    {
      A a = new A();
      a.doSomeThing();
    }
    System.out.println(System.currentTimeMillis() - start);
  }

  public static void doReflection() throws Exception
  {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++)
    {
      A a = (A) Class.forName("A").newInstance();
      a.doSomeThing();
    }
    System.out.println(System.currentTimeMillis() - start);
  }
}
