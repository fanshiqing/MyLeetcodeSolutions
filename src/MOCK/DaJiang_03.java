package MOCK;

import java.util.Scanner;

/**
 * 大疆测试题03.小车碰撞问题。17-09-08
 */
public class DaJiang_03 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      int len = in.nextInt();
      int pa = in.nextInt(); // power of a
      int la = in.nextInt(); // location of a
      int da = in.nextInt(); // direction of a, -1: left, 1: right

      int pb = in.nextInt();
      int lb = in.nextInt();
      int db = in.nextInt();
      int result = run(len, pa, la, da, pb, lb, db);
      System.out.println(result);
    }
  }

  /**
   *
   * @param len 轨道长度
   * @param pa 车A能量
   * @param la 车A初始位置
   * @param da 车A运行方向
   * @param pb 车B能量
   * @param lb 车B位置
   * @param db 车B运行方向
   * @return
   */
  public static int run(int len, int pa, int la, int da, int pb, int lb, int db) {
    if (la > lb) { // 保证A小车总是在左边，便于判断
      return run(len, pb, lb, db, pa, la, da);
    }
    int count = 0;

    if (da == 1 && db == -1) { // a --> <---b
      if (lb - la - 1 >= pa + pb) { // 不会碰撞
        return count;
      } else {
        if (pa < pb && la + pa < lb - pa) { // A先停下，等待B向左碰撞
          return run(len, 0, la + pa, -1, pb - pa, lb - pa, -1);
        } else if (pa > pb && lb - pb > la + pb) { // B先停下，等待A向右碰撞
          return run(len, pa - pb, la + pb, 1, 0, lb - pb, 1);
        } else { // A,B碰撞并反向运行
          int tmp = (lb - la - 1) / 2;
          if ((lb - la - 1) % 2 == 0) {
            return run(len, pa - tmp, la + tmp,-1, pb - tmp, lb - tmp, 1);
          } else {
            // 中间奇数格，A,B能量损耗怎么算是关键：A,B算碰撞位置左右各半格的位置，能量比偶数情况各减1
            return run(len, pa - tmp - 1, la + tmp, -1, pb - tmp - 1, lb - tmp, 1);
          }
        }
      }
    } else if (da == 1 && db == 1) { // a--> b-->
      if (pa <= pb) { // 不会碰撞
        if (pb > len - lb - 1) count ++; // b out
        if (pa > len - la - 1) count ++; // a out
      } else {
        if (pb > len - lb - 1) {
          count ++; // b out
          if (pa > len - la - 1) // a out
            count ++;
        } else { // b先停下（走了pb），之后A推着B向右走
          int paLeft = pa - (lb - la - 1 + pb); // power of a left before meet with b
          if (paLeft > 0) {
            if (paLeft > 2 * (len - (lb + pb) - 1)) { // A， B一起走，两倍power
              count ++; // b out
              if (paLeft > 2 * (len - (lb + pb) - 1) + 1) {
                count ++; // a out, 注意最后一格A只需要1个power
              }
            }
          }
        }
      }
    } else if (da == -1 && db == -1) { // <-- a <---b
      if (pb <= pa) { // 不会碰撞
        if (pa > la) count ++; // a out
        if (pb > lb) count ++; // b out
      } else {
        if (pa > la) {
          count++; // a out
          if (pb > lb) // b out
            count++;
        } else { // a 先停下（走了pa之后，之后B可能推着A向左走
          int pbLeft = pb - (lb - la - 1 + pa);
          if (pbLeft > 0) {
            if (pbLeft > 2 * (la - pa)) {
              count ++; // a out
              if (pbLeft > 2 * (la - pa) + 1)
                count ++; // b out;注意最后一格B只需要1个power
            }
          }
        }
      }
    } else { // <--a  b-->,不会碰撞
      if (pa > la) count++; // a out
      if (pb > len - lb - 1) count++; // b out
    }
    return count;
  }
}
