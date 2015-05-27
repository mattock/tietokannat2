# tietokannat2

Tietokannat II-kurssin harjoitustyö

# Vaatimukset

Ohjelman käyttöön tarvitaan vähintäänkin

* Java-kääntäjä
* PostgreSQL
* PostgreSQL:n JDBC-ajuri

Ohjelman käyttö on helpointi *NIX-alustalla, vaikka sen epäilemättä saisi 
toimimaan myös esim. Windowsissa.

# Hakemistot

* db: tietokantadumpit ja raakadata (CSV-tiedostot)
* dokumentit: harjoitustyöhön liittyvät dokumentit
* src: harjoitustyön lähdekoodi

# Käyttö

Ennen ohjelman ajamista pitää luoda sopivat käyttäjät ja 
tietokannat postgresql:ään. Tämä onnistuu createuser, createdb ja 
psql-komennoilla jotakuinkin näin:

  $ sudo -s
  $ su - postgres
  $ createuser johndoe
  $ createdb -O johndoe tietokannat2b
  $ psql tietokannat2b < sql/tietokannat2.sql

Koodin voi kääntää ja heti perään ajaa komennolla

  $ ./main.sh

Ohjelman luomat uudet rivit voi poistaa psql:llä seuraavasti

  DELETE FROM jarvi WHERE nimi = 'Saimaa';
  DELETE FROM nayte WHERE nayteid = '6'; 
  DELETE FROM sijainti WHERE sijaintiid=6;
  DELETE FROM vesinayte WHERE nayteid = 6;
