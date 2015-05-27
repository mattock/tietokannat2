import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
* Järveä mallintava luokka
*/
public class Jarvi {

	/**************************
	* JÄSENMUUTTUJAT
	***************************/

	/**
	* Järven yksilöivä tunnusnumero.
	*/
    private int jarvitunnus;

	/**
	* Järven nimi.
	*/
    private String nimi;

    /**
    * Järven tyyppi
    */
    private String jarvityyppi;

	/**
	* Järven vedenpinnan tason korkeus merenpinnasta metreinä.
	*/
    private double korkeustaso;

	/**
	* Järven tilavuus.
	*/
    private int tilavuus;

	/**
	* Järven pinta-ala.
	*/
    private int pintaala;

	/**
	* Järven keskisyvyys.
	*/
    private double keskisyvyys;


	/************************
	* KONSTRUKTORIT
	*************************/

	/**
	* Konstruktori, joka luo järven.
	*/
    public Jarvi(int jarvitunnus, String nimi, String jarvityyppi, double korkeustaso, int tilavuus, int pintaala, double keskisyvyys) {
        this.jarvitunnus = jarvitunnus;
        this.nimi = nimi;
        this.jarvityyppi = jarvityyppi;
        this.korkeustaso = korkeustaso;
        this.tilavuus = tilavuus;
        this.pintaala = pintaala;
        this.keskisyvyys = keskisyvyys;
    }

	/**
	* Konstruktori, joka luo järven ja lisää sen tietokantaan.
	*/
    public Jarvi(int jarvitunnus, String nimi, String jarvityyppi, double korkeustaso, int tilavuus, int pintaala, double keskisyvyys, Connection con) {
        this(jarvitunnus, nimi, jarvityyppi, korkeustaso, tilavuus, pintaala, keskisyvyys);

        try {
            Statement st = null;
            st = con.createStatement();
            String query = "INSERT INTO jarvi (jarvitunnus, nimi, jarvityyppi, korkeustaso, tilavuus, pintaala, keskisyvyys) VALUES ("
                     +this.jarvitunnus+","
                     +"\'"+this.nimi+"\',"
                     +"\'"+this.jarvityyppi+"\',"
                     +this.korkeustaso+","
                     +this.tilavuus+","
                     +this.pintaala+","
                     +this.keskisyvyys+");";
            st.execute(query);
            st.close();

            } catch (SQLException e) {
                System.out.println(e);
            } 
    }

	/**************************
	* FUNKTIOT
	***************************/

	/**
	* Getters - palauttavat järven jäsenmuuttujien arvot.
	*/
    public int getJarvitunnus()    { return this.jarvitunnus; }
    public String getNimi()        { return this.nimi;        }
    public double getKorkeustaso() { return this.korkeustaso; }
    public int getTilavuus()       { return this.tilavuus;    }
    public int getPintaala()       { return this.pintaala;    }
    public double getKeskisyvyys() { return this.keskisyvyys; }

	/**************************
	* PROSEDUURIT
	***************************/

    

}
