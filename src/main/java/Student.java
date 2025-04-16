/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

public class Student {
    private String imie;
    private int wiek;

    public Student(String imie, int wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }

    public String ToString() {
        return imie + ";" + wiek;
    }

    public static Student Parse(String str) {
        String[] data = str.split(";");
        if(data.length != 2) return null;
        return new Student(data[0], Integer.parseInt(data[1]));
    }
}

class Main {

  public static void main(String[] args) {

    System.out.print("Podaj imię nowego studenta: ");
    Scanner sc=new Scanner(System.in);
    String imie=sc.nextLine();
    System.out.print("Podaj wiek nowego studenta: ");
    int wiek=sc.nextInt();

    Student nowystudent = new Student(imie, wiek);


    try {
      Service s = new Service();

    s.addStudent(nowystudent);

      var students = s.getStudents();
      for(Student current : students) {
        System.out.println(current.ToString());
      }
    } catch (IOException e) {

    }
  }
}