/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardcollection;

import Objects.Album;
import Objects.Cromos;
import Utilities.Menu;
import Utilities.Option;
import java.util.Scanner;

/**
 *
 * @author Raul
 */
public class CardCollection {

    private Album dragon_ball;
    private Menu main_menu;

    public static void main(String[] args) {
        CardCollection app = new CardCollection();
        app.runApp();
    }

    private void runApp() {
        dragon_ball = new Album();
        main_menu = new Menu("Coleccion de cromos Dragon Ball");
        addOptions();
        testCards();
        int option;
        do {
            main_menu.displayMenu();
            option = main_menu.choose();

            switch (option) {
                case 1:
                    addCardToCollection();
                    break;
                case 2:
                    deleteCardToCollection();
                    break;
                case 3:
                    changeCards();
                    break;
                case 4:
                    displayCards();
                    break;
                case 5:
                    displayRepeatCards();
                    break;
                case 0:
                    System.out.println("Cerrando app");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (option != 0);

    }

    private void displayCards() {
        dragon_ball.displayCardAlbum();
    }

    private void addOptions() {
        main_menu.add(new Option("Salir"));
        main_menu.add(new Option("◦ Añadir cromo."));
        main_menu.add(new Option("◦ Borrar cromo."));
        main_menu.add(new Option("◦ Cambiar cromo."));
        main_menu.add(new Option("◦ Mostrar cromos que tengo."));
        main_menu.add(new Option("◦ Mostrar cromos repetidos."));
    }

    /**
     * Carga algunos cromos de prueba
     */
    private void testCards() {
        dragon_ball.AddCard(new Cromos(27));
        dragon_ball.AddCard(new Cromos(50));
        dragon_ball.AddCard(new Cromos(38));
        dragon_ball.AddCard(new Cromos(27));
        dragon_ball.AddCard(new Cromos(38));
    }

    private void addCardToCollection() {
        int num_card = askIntData("Introduce el numero de la carta a añadir");
        Cromos new_card = new Cromos(num_card);
        if (dragon_ball.AddCard(new_card)) {

            System.out.println("Cromo " + new_card.toString() + " añadido correctamente");
        } else {
            System.out.println("Numero de cromo invalido");
        }

    }

    private int askIntData(String phrase) {
        Scanner sc = new Scanner(System.in);
        System.out.println(phrase);
        int option = sc.nextInt();
        return option;
    }

    private void deleteCardToCollection() {
        int num_card = askIntData("Introduce el numero de la carta a eliminar de la colección");
        Cromos cardToDelete = new Cromos(num_card);
        dragon_ball.deleteCard(cardToDelete);
        if (dragon_ball.deleteCard(cardToDelete)) {
            System.out.println("Carta " + cardToDelete.toString() + "  eliminada con éxito");
        } else {
            System.out.println("El número de carta no existre en la colección");
        }
    }

    private void displayRepeatCards() {
        dragon_ball.displayRepeatedCardAlbum();
    }

    private void changeCards() {
        int numNewcard = askIntData("Introduce el numero de la carta a conseguir");
        Cromos new_card = new Cromos(numNewcard);
        int numOldCard = askIntData("Introduce el numero de la carta a cambiar");
        Cromos swap_card = new Cromos(numOldCard);

        dragon_ball.changeCard(new_card, swap_card);
    }

}
