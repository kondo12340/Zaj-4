public class Student {
    private String imie;
    private String nazwisko;
    private int wiek;
    private String dataUrodzenia;

    public Student(String imie, String nazwisko, int wiek, String dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getImie() {
        return imie;
    }

    public String ToString() {
        
        return imie + "; " + nazwisko + "; " + wiek + "; " + dataUrodzenia;
    }

    public static Student Parse(String line) {
        String[] parts = line.split("; ");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Nieprawidłowa linia: " + line);
        }
        String imie = parts[0];
        String nazwisko = parts[1];
        int wiek = Integer.parseInt(parts[2]);
        String dataUrodzenia = parts[3];
        return new Student(imie, nazwisko, wiek, dataUrodzenia);
    }
}
