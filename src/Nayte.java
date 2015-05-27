import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* Näytettä mallintava luokka
*/
public class Nayte {

    /*******************
    * JÄSENMUUTTUJAT
    ********************/

    /**
    * Näytteen yksilöivä id.
    */
    private int nayteid;

    /**
    * Näytteenotin, jolla näyte on otettu.
    */
    private String naytteenotin;

    /**
    * Vesisyvyys, jolta näyte on otettu.
    */
    private double naytesyvyys;

    /**
    * Näytteen sijainnin id.
    */
    private int sijaintiid;

    /**
    * Näytteenottajan henkilötunnus.
    */
    private String naytothetu;

    /**
    * Näytteenoton ajankohta.
    */
    private Date ajankohta;

    /*****************
    * KONSTRUKTORIT
    ******************/

    /**
    * Konstruktori, joka luo näytteen.
    */
    public Nayte(int nayteid, String naytteenotin, double naytesyvyys, int sijaintiid, String naytothetu, String ajankohta) {
        this.nayteid = nayteid;
        this.naytteenotin = naytteenotin;
        this.naytesyvyys = naytesyvyys;
        this.sijaintiid = sijaintiid;
        this.naytothetu = naytothetu;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        try {
            Date aika = format.parse(ajankohta);
            this.ajankohta = aika;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
    * Konstruktori, joka luo näytteen ja lisää sen tietokantaan.
    */
    public Nayte(int nayteid, String naytteenotin, double naytesyvyys, int sijaintiid, String naytothetu, String ajankohta, Connection con) {
        this(nayteid, naytteenotin, naytesyvyys, sijaintiid, naytothetu, ajankohta);
        try {
            Statement st = null;
            st = con.createStatement();
            String query = "INSERT INTO nayte (nayteid, naytteenotin, naytesyvyys, sijaintiid, naytothetu, ajankohta) VALUES ("
                     +this.nayteid+","
                     +"\'"+this.naytteenotin+"\',"
                     +this.naytesyvyys+","
                     +this.sijaintiid+","
                     +"\'"+this.naytothetu+"\',"
                     +"\'"+ajankohta+"\');";
            st.execute(query);
            st.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /*******************
    * FUNKTIOT
    ********************/

    /**
	* Getters - palauttavat näytteen jäsenmuuttujien arvot.
	*/
    public int getNayteid()         { return this.nayteid;      }
    public String getNaytteenotin() { return this.naytteenotin; }
    public double getNaytesyvyys()  { return this.naytesyvyys;  }
    public int getSijaintiid()      { return this.sijaintiid;   }
    public String getNaytothetu()   { return this.naytothetu;   }
    public Date getAjankohta()      { return this.ajankohta;    }

    /********************
    * PROSEDUURIT
    *********************/
}
