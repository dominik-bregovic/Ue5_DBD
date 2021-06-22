import org.hibernate.HibernateException;

import java.util.ArrayList;

public class TestDB {

    public static void main(String[] args) {

        Team barcelona = new Team("FC Barcelona", new ArrayList<>());
        Team city = new Team("Manchester City", new ArrayList<>());
        Team real = new Team("Real Madrid", new ArrayList<>());
        Team liverpool = new Team("FC Liverpool", new ArrayList<>());

        Player player1 = new Player("Toni Kroos", 31, real);
        Player player2 = new Player("Marcelo", 33, real);
        Player player3 = new Player("Mohamed Salah", 29, liverpool);
        Player player4 = new Player("Sadio Mane", 29, liverpool);
        Player player5 = new Player("Lionel Messi", 33, barcelona);
        Player player6 = new Player("Sergio Aguero", 33, city);

        real.addPlayer(player1);
        real.addPlayer(player2);
        liverpool.addPlayer(player3);
        liverpool.addPlayer(player4);
        barcelona.addPlayer(player5);
        city.addPlayer(player6);

        Trainer trainer1 = new Trainer("Ronald Koeman", barcelona);
        Trainer trainer2 = new Trainer("Pep Guardiola", city);
        Trainer trainer3 = new Trainer("Zinedine Zidane", real);
        Trainer trainer4 = new Trainer("Jürgen Klopp", liverpool);

        barcelona.setTrainer(trainer1);
        city.setTrainer(trainer2);
        real.setTrainer(trainer3);
        liverpool.setTrainer(trainer4);

        try {
            HibernateSupport.beginTransaction();
            barcelona.saveToDB();
            city.saveToDB();
            real.saveToDB();
            liverpool.saveToDB();
            HibernateSupport.commitTransaction();

            HibernateSupport.beginTransaction();
            player1.saveToDB();
            player2.saveToDB();
            player3.saveToDB();
            player4.saveToDB();
            player5.saveToDB();
            player6.saveToDB();
            HibernateSupport.commitTransaction();

            HibernateSupport.beginTransaction();
            trainer1.saveToDB();
            trainer2.saveToDB();
            trainer3.saveToDB();
            trainer3.saveToDB();
            HibernateSupport.commitTransaction();

        }catch(HibernateException e){
            e.printStackTrace();
            System.err.println("\nNot able to fill all tables with values!\n");
        }
    }
}
