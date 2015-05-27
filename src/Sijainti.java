import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
* Näytteen sijaintia järvessä mallintava luokka.
*/
public class Sijainti {

    /*******************
    * JÄSENMUUTTUJAT
    ********************/

    /**
    * Näytteen sijainnin id.
    */
    private int sijaintiid;

    /**
    * Näytteenottopisteen pohjoiskoordinaatti (YKJ).
    */
    private int pohjoiskoordinaatti;

    /**
    * Näytteenottopisteen itäkoordinaatti (YKJ).
    */
    private int itakoordinaatti;

    /**
    * Järven tunnusnumero.
    */
    private int jarvitunnus;

    /******************
    * KONSTRUKTORIT
    *******************/

    /**
    * Konstruktori, joka luo sijainnin.
    */
    public Sijainti(int sijaintiid, int pohjoiskoordinaatti, int itakoordinaatti, int jarvitunnus) {
        this.sijaintiid = sijaintiid;
        this.pohjoiskoordinaatti = pohjoiskoordinaatti;
        this.itakoordinaatti = itakoordinaatti;
        this.jarvitunnus = jarvitunnus; 
    }

    /**
    * Konstruktori, joka luo sijainnin ja lisää sen tietokantaan.
    */
    public Sijainti(int sijaintiid, int pohjoiskoordinaatti, int itakoordinaatti, int jarvitunnus, Connection con) {
        this(sijaintiid, pohjoiskoordinaatti, itakoordinaatti, jarvitunnus);

        try {
            Statement st = null;
            st = con.createStatement();
            String query = "INSERT INTO sijainti (sijaintiid, pohjoiskoordinaatti, itakoordinaatti, jarvitunnus) VALUES ("
                     +this.sijaintiid+","
                     +this.pohjoiskoordinaatti+","
                     +this.itakoordinaatti+","
                     +this.jarvitunnus+");";
            st.execute(query);
            st.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /******************
    * FUNKTIOT
    *******************/

    /**
    * Getters - palauttavat sijainnin jäsenmuuttujien arvot.
    */
    public int getSijaintiid()          { return this.sijaintiid;          }
    public int getPohjoiskoordinaatti() { return this.pohjoiskoordinaatti; }
    public int getItakoordinaatti()     { return this.itakoordinaatti;     }
    public int getJarvitunnus()         { return this.jarvitunnus;         }

    /*******************
    * PROSEDUURIT
    ********************/

}
