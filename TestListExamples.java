import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;

class AChecker implements StringChecker{
  public boolean checkString(String s){
    for(int i = 0; i < s.length() - 1; i++){
      if(s.substring(i, i+1).equals("a") || s.substring(i, i+1).equals("A")){
        return true;
      }
    }
  }
  return false;
}
public class TestListExamples {
  // Write your grading tests here!


  //Tests of static List<String> filter(List<String> s, StringChecker sc)
  @Test
  public void testFilterReturn(){
    ArrayList<String> list1 = new ArrayList<String>();
    list1.add("A");
    list1.add("B");
    list1.add("C");
    list1.add("D");
    list1.add("E");
    list1.add("F");

    ArrayList<String> expected = new ArrayList<String>();
    expected.add("A");
    assertEquals(expected, filter(list1, AChecker));
  }
  //Tests of static List<String> merge(List<String> list1, List<String> list2)
  @Test
  public void testMergeReturn(){
    ArrayList<String> list1 = new ArrayList<String>();
    ArrayList<String> list2 = new ArrayList<String>();
    list1.add("B");
    list1.add("F");
    list1.add("H");

    list2.add("C");
    list2.add("D");
    list2.add("K");

    ArrayList<String> expected = new ArrayList<String>();
    expected.add("B"); expected.add("C"); expected.add("D"); expected.add("D"); expected.add("F"); expected.add("H");expected.add("K");
    assertEquals(expected, merge(list1, list2));
  }
}
