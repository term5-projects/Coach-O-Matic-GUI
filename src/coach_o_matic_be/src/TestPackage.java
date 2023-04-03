import javax.swing.text.PlainDocument;

import coach_o_matic_be.*;

public class TestPackage {
  public static void  main(String[] args){
    SoccerPlayer player = new SoccerPlayer();
    player.setName("Michael McCarthy");
    System.out.println("Package test");
    System.out.println(player.getName());
  }
}
