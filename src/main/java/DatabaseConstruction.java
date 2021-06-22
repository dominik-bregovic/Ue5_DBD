import org.hibernate.HibernateException;

public class DatabaseConstruction {

    public static void main(String[] args) {
        //creating schema and Tables
        try {
            HibernateSupport support = new HibernateSupport();
        }catch(HibernateException e){
            e.printStackTrace();
            System.err.println("\nNot alble to create all tables\n");
        }
    }
}
