

import javax.persistence.*;
import java.util.List;

@Entity
public class Team implements ISaveAndDelete{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id", length = 11, nullable = false)
    private int teamId;
    @Column(length = 40)
    private String name;
    @OneToMany
    private List<Player> playerList;
    @OneToOne(cascade = {CascadeType.ALL})
    private Trainer trainer;


    public Team(){

    }

    public Team(String name, List<Player> p){
        this.name = name;
        this.playerList = p;
    }


    public int getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void addPlayer(Player player){
        playerList.add(player);
    }

    @Override
    public boolean saveToDB() {
       if (this.playerList != null){
           for (Player p : this.playerList) {
               p.saveToDB();
           }
       }
       if (HibernateSupport.commit(false)){
           return false;
       }
       return true;
    }

    @Override
    public void deleteFromDB() {
        if (this.playerList != null)
            for (Player p : this.playerList)
                p.deleteFromDB();
        HibernateSupport.deleteObject(this);
    }
}
