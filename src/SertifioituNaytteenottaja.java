/**
* Sertifioitua näytteenottajaa mallintava luokka.
*/
public class SertifioituNaytteenottaja {

    /********************
    * JÄSENMUUTTUJAT
    *********************/

    /**
    * Näytteenottajan henkilötunnus.
    */
    private String hetu;

    /**
    * Näytteenottajan etu- ja sukunimi.
    */
    private String nimi;

    /**
    * Näytteenottajan sertifikaatin numero.
    */
    private int sertifikaattinumero;

    /*******************
    * KONSTRUKTORIT
    ********************/

    /**
    * Konstruktori, joka luo näytteenottajan.
    */
    public SertifioituNaytteenottaja(String hetu, String nimi, int sertifikaattinumero) {
        this.hetu = hetu;
        this.nimi = nimi;
        this.sertifikaattinumero = sertifikaattinumero;
    }

    /*******************
    * FUNKTIOT
    ********************/

    /** 
    * Getters - palauttavat sertifioidun näytteenottajan jäsenmuuttujien arvot. 
    */
    public String getHetu()             { return this.hetu;                }
    public String getNimi()             { return this.nimi;                }
    public int getSertifikaattinumero() { return this.sertifikaattinumero; }

    /*******************
    * PROSEDUURIT
    ********************/
}
