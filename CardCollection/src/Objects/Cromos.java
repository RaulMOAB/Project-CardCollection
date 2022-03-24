/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Raul
 */
public class Cromos {

    private String description;
    private int numCard;

    public Cromos(String description, int numCard) {
        this.description = description;
        this.numCard = numCard;
    }

    public Cromos(int numCard) {
        this.numCard = numCard;
        this.description = "Sin Descripción";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws DescriptionException {
        do {
            if (description.length() >= 3) {
                this.description = description;
            } else {
                throw new  DescriptionException("La descripción debe contener 3 o más carácteres"); 
            }
        } while (description.length() < 3);

    }

    public int getNumCard() {
        return numCard;
    }

    public void setNumCard(int numCard) {
        this.numCard = numCard;
    }

    @Override
    public String toString() {
        return  "Nombre : " + description + ", numero: " + numCard ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Cromos)) {
            return false;
        }
        final Cromos other = (Cromos) obj;
        if (this.numCard != other.numCard) {
            return false;
        }
        return true;
    }

}
