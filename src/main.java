import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
* Tietokantayhteyttä mallintava luokka.
*/
public class main {

    /*********************
    * JÄSENMUUTTUJAT
    **********************/

    /**
    * Yhteys tietokantaan.
    */
    private static Connection con;

    /*********************
    * KONSTRUKTORIT
    **********************/

    /*********************
    * FUNKTIOT
    **********************/

    /**
    * Palauttaa parametrina annetusta järvestä näytteitä ottaneet henkilöt.
    * AE: Tietokantayhteys alustettu.
    */
    public static String getJarviNayttott (String jarvinimi) {
        String naytteenottajat = new String();
        try {
            Statement st = con.createStatement();
            String query1 = "SELECT DISTINCT sn.henkilotunnus, sn.nimi, sn.sertifikaattinumero"
                            + " FROM sertifioitunaytteenottaja AS sn, nayte AS n, sijainti AS si, jarvi AS j"
                            + " WHERE sn.henkilotunnus = n.naytothetu"
                            + " AND n.sijaintiid = si.sijaintiid"
                            + " AND si.jarvitunnus=j.jarvitunnus"
                            + " AND j.nimi=\'"+jarvinimi+"\';";
            ResultSet rs = st.executeQuery(query1);
            while (rs.next()) {
                naytteenottajat = naytteenottajat + "    "+rs.getString("henkilotunnus") + "    " + rs.getString("nimi") + "\n";
            }
            rs.close();
            st.close();            
        } catch(Exception e) {
            System.out.println("Failed to query database: " + e);
        }
        return naytteenottajat;
    }

    /**
    * Etsitään järvet, joista ei ole otettu näytettä.
    * AE: Tietokantayhteys alustettu.
    */
    public static String getNaytteettomatJarvet () {
        String jarvet = new String();
        try {
            Statement st = con.createStatement();
            String query = "SELECT DISTINCT jarvitunnus, nimi"
                            + " FROM jarvi"
                            + " WHERE jarvitunnus NOT IN("
                            + " SELECT jarvitunnus"
                            + " FROM sijainti"
                            + " WHERE jarvitunnus IS NOT NULL)";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                jarvet = jarvet + "    "+rs.getString("jarvitunnus") + "    " + rs.getString("nimi") + "\n";
            }
            rs.close();
            st.close();
        } catch(Exception e) {
            System.out.println("Failed to query database: " + e);
        }
        return jarvet;
    }

    /** Palauttaa järvet, joista on otettu vähintään yksi vesinäyte, jonka kokonaisfosforipitoisuus on
    *   suurempi kuin parametrina annettu arvo.
    * AE: Tietokantayhteys alustettu.
    */
    public static String getFosforiJarvi (int fosforipitoisuus) {
        String jarvet = new String();
        try{
            Statement st = con.createStatement();
            String query = "SELECT DISTINCT j.jarvitunnus, j.nimi"
                            + " FROM jarvi AS j, sijainti AS s, nayte AS n, vesinayte AS v"
                            + " WHERE j.jarvitunnus=s.jarvitunnus"
                            + " AND s.sijaintiid=n.sijaintiid"
                            + " AND v.nayteid=n.nayteid"
                            + " AND v.kokonaisfosfori>30";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                jarvet = jarvet + "    "+rs.getString("jarvitunnus") + "    " + rs.getString("nimi") + "\n";
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Failed to query database: " + e);
        }
        return jarvet;
    }

    /*********************
    * PROSEDUURIT
    **********************/

    /**
    * Alustaa tietokantayhteyden.
    */
    public static void alustaYhteys() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql:tietokannat2b";
            String user = "user";
            String password = "password";
            
            con = DriverManager.getConnection(url, user, password);
        } catch(Exception e) {
            System.out.println("Failed to connect to database: " + e);
        }
    }

    /**
    * Sulkee tietokantayhteyden.
    * AE: Tietokantayhteys alustettu.
    */
    public static void suljeYhteys() {
        try {
            con.close();
        } catch(Exception e) {
            System.out.println("Failed to close the connection: " + e);
        }
    }

    /*******************
    * TESTIMETODI
    ********************/

    /**
    * Testaa luokan metodeita.
    */    
    public static void main(String[] args) {
        main.alustaYhteys();
        System.out.println("Yhteys avattu!");

        System.out.println("\nNäytteenottajat, jotka ovat ottaneet näytteitä Kakskerran järvestä:\n\n    Henkilötunnus  Nimi\n");
        System.out.println(main.getJarviNayttott(new String("Kakskerranjärvi")));

        System.out.println("\nLisätään Saimaa-järviolio\n");
        Jarvi saimaa = new Jarvi(41121001, "Saimaa", "Suuret vähähumuksiset järvet" , 75.5, 14822200, 137703, 10.8, con);

        System.out.println("\nJärvet, joista ei ole otettu näytettä:\n");
        System.out.println("    Järvitunnus  Nimi\n");
        System.out.println(main.getNaytteettomatJarvet());

        System.out.println("Lisätään Näyte järveen Saimaa\n");
        Nayte nayte = new Nayte(6, "Pullonäytteenotin", 8.2, 6, "181168-891S", "2014-08-18", con);

        System.out.println("Lisätään SijaintiID\n");
        Sijainti sijainti = new Sijainti(6, 6784115, 3581077, 41121001, con);

        System.out.println("Lisätään Vesinäyte\n");
        Vesinayte vesinayte = new Vesinayte(6, 20.7, 6.8, 7.4, 10, 370, 99, -1, -1, con);

        System.out.println("\nJärvet, joista ei ole otettu näytettä:\n");
        System.out.println("    Järvitunnus  Nimi\n");
        System.out.println(main.getNaytteettomatJarvet());

        System.out.println("\nJärvet, joista on otettu vähintään yksi vesinäyte, jonka fosforipitoisuus on yli 30 mikrogrammaa litrassa:\n");
        System.out.println("    Järvitunnus  Nimi\n");
        System.out.println(main.getFosforiJarvi(30));

        System.out.println("Poistetaan Vesinäyte\n");
        vesinayte.poista(con);

        main.suljeYhteys();
        System.out.println("Yhteys suljettu");
    }
}
