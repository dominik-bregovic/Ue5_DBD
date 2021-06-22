import java.util.ArrayList;

public class TestDB {

    public static void main(String[] args) {
        Team  real_madrid = new Team("Real Madrid", new ArrayList<>());
        Team  barcelona = new Team("Barcelona", new ArrayList<>());
        Team  manchester_city = new Team("Manchester City", new ArrayList<>());

        Player player1 = new Player("Harry Potter", 45, real_madrid);
        Player player2 = new Player("Arnold Schwarzneger", 20, barcelona);
        Player player3 = new Player("Free Willi", 70, manchester_city);

        real_madrid.addPlayer(player1);
        barcelona.addPlayer(player2);
        manchester_city.addPlayer(player3);

        Trainer trainer1 = new Trainer("Jürgen Klopp", barcelona);
        Trainer trainer2 = new Trainer("Calvin Klein", manchester_city);
        Trainer trainer3 = new Trainer("Gusto", real_madrid);

        HibernateSupport.beginTransaction();
        real_madrid.saveToDB();
        barcelona.saveToDB();
        manchester_city.saveToDB();
        //problem with this method
        HibernateSupport.commitTransaction();

        HibernateSupport.beginTransaction();
        player1.saveToDB();
        player2.saveToDB();
        player3.saveToDB();
        HibernateSupport.commitTransaction();

        HibernateSupport.beginTransaction();
        trainer1.saveToDB();
        trainer2.saveToDB();
        trainer3.saveToDB();
        HibernateSupport.commitTransaction();

    }
}
