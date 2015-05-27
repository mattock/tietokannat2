import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
* Vedestä otettua näytettä mallintava luokka.
*/
public class Vesinayte {

    /*********************
    * JÄSENMUUTTUJAT
    **********************/

    /**
    * Vesinäytteen id.
    */
    private int nayteid;

    /**
    * Vesinäytteen lämpötila.
    */
    private double lampotila;

    /**
    * Vesinäytteen sähkönjohtavuus.
    */
    private double sahkonjohtavuus;

    /**
    * Vesinäytteen pH.
    */
    private double ph;

    /**
    * Vesinäytteen kokonaisfosforipitoisuus.
    */
    private int kokonaisfosfori;

    /**
    * Vesinäytteen kokonaistyppipitoisuus.
    */
    private int kokonaistyppi;

    /**
    * Vesinäytteen hapenkyllästysaste.
    */
    private int hapenkyllastysaste;

    /**
    * Vesinäytteen alkaliniteetti.
    */
    private double alkaliniteetti;

    /**
    * Vesinäytteen klorofyllipitoisuus.
    */
    private double klorofylli;

    /************************
    * KONSTRUKTORIT
    *************************/

    /**
    * Konstruktori, joka luo vesinäytteen.
    */
    public Vesinayte(int nayteid, double lampotila, double sahkonjohtavuus, double ph, int kokonaisfosfori, int kokonaistyppi, int hapenkyllastysaste, double alkaliniteetti, double klorofylli) {
        this.nayteid = nayteid;
        this.lampotila = lampotila;
        this.sahkonjohtavuus = sahkonjohtavuus;
        this.ph = ph;
        this.kokonaisfosfori = kokonaisfosfori;
        this.kokonaistyppi = kokonaistyppi;
        this.alkaliniteetti = alkaliniteetti;
        this.klorofylli = klorofylli;
    }

    /**
    * Konstruktori, joka luo vesinäytteen ja lisää sen tietokantaan.
    */
    public Vesinayte(int nayteid, double lampotila, double sahkonjohtavuus, double ph, int kokonaisfosfori, int kokonaistyppi, int hapenkyllastysaste, double alkaliniteetti, double klorofylli, Connection con) {

        this(nayteid, lampotila, sahkonjohtavuus, ph, kokonaisfosfori, kokonaistyppi, hapenkyllastysaste, alkaliniteetti, klorofylli);

        try {
            Statement st = null;
            st = con.createStatement();
            String query = "INSERT INTO vesinayte (nayteid, lampotila, sahkonjohtavuus, ph, kokonaisfosfori, kokonaistyppi, hapenkyllastysaste, alkaliniteetti, klorofylli) VALUES ("
                     +this.nayteid+","
                     +this.lampotila+","
                     +this.sahkonjohtavuus+","
                     +this.ph+","
                     +this.kokonaisfosfori+","
                     +this.kokonaistyppi+","
                     +this.hapenkyllastysaste+","
                     +this.alkaliniteetti+","
                     +this.klorofylli+");";
            st.execute(query);
            st.close();

            } catch (SQLException e) {
                System.out.println(e);
            }
   }


    /*********************
    * FUNKTIOT
    **********************/

    /**
    *  Getters - Palauttavat vesinäytteen jäsenmuuttujien arvot. 
    */
    public int getNayteid()            { return this.nayteid;            }
    public double getLampotila()       { return this.lampotila;          }
    public double getSahkonjohtavuus() { return this.sahkonjohtavuus;    }
    public double getPh()              { return this.ph;                 }
    public int getKokonaisfosfori()    { return this.kokonaisfosfori;    }
    public int getKokonaistyppi()      { return this.kokonaistyppi;      }
    public int getHapenkyllastysaste() { return this.hapenkyllastysaste; }
    public double getAlkaliniteetti()  { return this.alkaliniteetti;     }
    public double getKlorofylli()      { return this.klorofylli;         }

    /*******************
    * PROSEDUURIT
    ********************/

	/**
	* Poista vesinäyte tietokannasta.
	*/
    public void poista(Connection con) {
        try {
            Statement st = null;
            st = con.createStatement();
            String query = "DELETE FROM vesinayte WHERE nayteid = "+this.nayteid+";";
            st.execute(query);
            st.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
