

import javax.persistence.*;


@Entity
public class Player implements ISaveAndDelete{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id", length = 11, nullable = false, unique = true)
    private int playerId;
    @Column(length = 40)
    private String name;
    @Column(length = 3)
    private int age;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Team team;

    public Player(){

    }
    public Player(String name, int age, Team team){
        this.name = name;
        this.age = age;
        this.team = team;
    }


    public int getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean saveToDB() {
        if (HibernateSupport.commit(this)){
            return false;
        }
        return false;
    }

    @Override
    public void deleteFromDB() {
        HibernateSupport.deleteObject(this);
    }
}
