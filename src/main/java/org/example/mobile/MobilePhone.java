package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> contacts;

    // Constructor: Sadece telefon numarası alır ve boş bir liste oluşturur
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contacts = new ArrayList<>(); // ArrayList örneğiyle başlat
    }

    // Constructor: Telefon numarası ve başlangıç rehberini alır
    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.contacts = new ArrayList<>(contacts); // Verilen listeyle başlat
    }

    // Getterlar
    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return contacts;
    }

    // Metodlar
    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false; // Zaten listede
        }
        contacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            return false; // Eski kişi bulunamadı
        }
        contacts.set(foundPosition, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            return false; // Kişi bulunamadı
        }
        contacts.remove(foundPosition);
        return true;
    }

    public int findContact(Contact contact) {
        return contacts.indexOf(contact); // indexOf kullanımı
    }

    public int findContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                return i; // İsme göre indeks
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return contacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact contact : contacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
