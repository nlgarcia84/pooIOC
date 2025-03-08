/*
 * Classe que defineix un Laboratori d'una universitat.
 * Es defineix pel seu codi, numeroLaboratori, cost per dia i la seva capacitat en nombre de persones.
 */
package universitat;

import java.util.Scanner;

/**
 *
 * @author fgarin
 */
public class Laboratori {
    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private int numeroLaboratori;
    private double costPerDia;
    private int capacitat;

    /*
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: Laboratori
     *
     * Paràmetres: valors per tots els atributs de la classe.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
    public Laboratori(String codi, int numeroLaboratori, double costPerDia, int capacitat) {
        this.codi = codi;
        this.numeroLaboratori = numeroLaboratori;
        this.costPerDia = costPerDia;
        this.capacitat = capacitat;
    }

    /*
     * TODO Heu d'implementar tots els mètodes accessors possibles.
     */
    public String getCodi() {
        return codi;
    }

    public int getNumeroLaboratori() {
        return numeroLaboratori;
    }

    public double getCostPerDia() {
        return costPerDia;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public void setNumeroLaboratori(int numeroLaboratori) {
        this.numeroLaboratori = numeroLaboratori;
    }

    public void setCostPerDia(double costPerDia) {
        this.costPerDia = costPerDia;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    /*
     * TODO
     *
     * Nom del mètode: addLaboratori
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar les dades per consola per crear un Laboratori.
     * Les dades a demanar són les que necessita
     * el constructor.
     * 
     * Retorn: Objecte Laboratori creat.
     */
    public static Laboratori addLaboratori() {
        String codiNouLaboratori;
        int numeroNouLaboratori, capacitatNouLaboratori;
        double costNouLaboratori;
        System.out.println("Introdueixi el codi del laboratori");
        codiNouLaboratori = DADES.next();
        DADES.nextLine();
        System.out.println("Introdueixi el numero de laboratori");
        numeroNouLaboratori = DADES.nextInt();
        DADES.nextLine();
        System.out.println("Introdueixi el cost per dia");
        costNouLaboratori = DADES.nextDouble();
        DADES.nextLine();
        System.out.println("Introdueixi la capacitat del laboratori");
        capacitatNouLaboratori = DADES.nextInt();
        DADES.nextLine();
        return new Laboratori(codiNouLaboratori, numeroNouLaboratori, costNouLaboratori, capacitatNouLaboratori);
    }

    /*
     * TODO
     *
     * Nom del mètode: updateLaboratori
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades del Laboratori i
     * modificar els
     * atributs corresponents d'aquest Laboratori.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de
     * modificar-los.
     *
     * Retorn: cap
     */

    public void updateLaboratori() {
        String codiLaboratoriCanvi;
        int numeroLaboratoriCanvi, capacitatLaboratoriCanvi;
        double costLaboratoriCanvi;
        System.out.println("Codi actual: " + getCodi());
        System.out.println("Introdueixi el nou codi");
        codiLaboratoriCanvi = DADES.next();
        DADES.nextLine();
        setCodi(codiLaboratoriCanvi);
        System.out.println("Número de laboratori actual: " + getNumeroLaboratori());
        System.out.println("Introdueixi el nou número de laboratori");
        numeroLaboratoriCanvi = DADES.nextInt();
        setNumeroLaboratori(numeroLaboratoriCanvi);
        System.out.println("Cost per dia actual: " + getCostPerDia());
        System.out.println("Introdueix el nou cost per dia");
        costLaboratoriCanvi = DADES.nextDouble();
        DADES.nextLine();
        setCostPerDia(costLaboratoriCanvi);
        System.out.println("Capacitat actual: " + getCapacitat());
        System.out.println("Introdueix nova capacitat");
        capacitatLaboratoriCanvi = DADES.nextInt();
        DADES.nextLine();
        setCapacitat(capacitatLaboratoriCanvi);
    }

    /*
     * TODO
     *
     * Nom del mètode: showLaboratori
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Mètode per mostrar les dades del Laboratori actual i el cost del seu
     * manteniment.
     * 
     * Retorn: cap
     */
    public void showLaboratori() {
        System.out.println("Les dades actuals del laboratori son les segënts:");
        System.out.println("Codi del laboratori: " + getCodi());
        System.out.println("Número del laboratori: " + getNumeroLaboratori());
        System.out.println("Cost de manteniment: " + costManteniment());
        System.out.println("Capacitat del laboratori: " + getCapacitat());
        ;
    }
    /*
     * TODO
     *
     * Nom del mètode: costManteniment
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Mètode que retornarà el cost del manteniment del Laboratori actual.
     * - El cost del manteniment per dia és un 35% del cost per dia del laboratori +
     * un 10% de la seva capacitat
     *
     * Retorn: Cost de manteniment del laboratori actual (double).
     */

    public double costManteniment() {
        double costManteniment = getCostPerDia() * 0.35;
        double costMantenimentRounded = Math.round(costManteniment * 100.0) / 100.0;
        return costMantenimentRounded;
    }
}
