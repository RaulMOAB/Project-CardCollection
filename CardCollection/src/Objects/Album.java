/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.util.ArrayList;

/**
 *
 * @author Raul
 */
public class Album {//clase DAO

    private ArrayList<Cromos> cromos_tengo = new ArrayList<>();
    private int max_num;
    private ArrayList<Cromos> cromos_repes = new ArrayList<>();

    public Album() {
        this.cromos_tengo = new ArrayList<Cromos>();
        this.cromos_repes = new ArrayList<>();
        this.max_num = 150;//numero de cartas 
    }

    public ArrayList<Cromos> getCromos_tengo() {
        return cromos_tengo;
    }

    public boolean AddCard(Cromos c) {//No consigo mostrar cuando se añade a las cartas repetidas
        try {
            if (c.getNumCard() < max_num && (c.getDescription().length() >= 3)) {
                if (CheckCard(c)) {
                    return cromos_repes.add(c);
                }else{
                     return cromos_tengo.add(c);
                }
            } else {
                throw new NumberOutofAlbumEx("El número debe ser inferior al máximo de cromos");
            }
        } catch (NumberOutofAlbumEx e) {
            System.out.println(e.getMessage());
        }

return false;
    }

    public boolean deleteCard(Cromos c) {// review
        try {
                 cromos_tengo.remove(c);
                    return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void changeCard(Cromos new_card, Cromos old_card) {

        if ((cromos_repes.contains(old_card)) && (!cromos_tengo.contains(new_card))) {
            cromos_repes.remove(old_card);
            cromos_tengo.add(new_card);
        }
    }

    public void displayCardAlbum() {
        System.out.println("Lista de cromos");
        for (Cromos cards : cromos_tengo) {
            System.out.println(cards.toString());
        }
    }

    public void displayRepeatedCardAlbum() {
        System.out.println("Lista de cromos repetidos");
        for (Cromos cromos : cromos_repes) {
            System.out.println(cromos.toString());
        }
    }

    private boolean CheckCard(Cromos c) {
        for (int i = 0; i < cromos_tengo.size(); i++) {
            if (cromos_tengo.get(i).equals(c)) {
                return true;
            }
        }
        return false;
    }
}
