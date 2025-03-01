/*
 * Classe que defineix una aula estàndard d'una universitat. 
 * Es defineixen pel seu codi, número d'aula i el seu cost per dia.
 */
package universitat;

import java.util.Scanner;

/**
 *
 * @author fgarin
 */
public class AulaEstandard {
    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private int numeroAula;
    private double costPerDia;

    /*
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: AulaEstandard
     * 
     * Paràmetres: valors per tots els atributs de la classe.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */

    public AulaEstandard(String codi, int numeroAula, double costPerDia) {
        this.codi = codi;
        this.numeroAula = numeroAula;
        this.costPerDia = costPerDia;
    }

    /*
     * TODO Heu d'implementar tots els mètodes accessors possibles.
     */
    public String getCodi() {
        return codi;
    }

    public int getNumeroAula() {
        return numeroAula;
    }

    public double getCostPerDia() {
        return costPerDia;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public void setNumeroAula(int numeroAula) {
        this.numeroAula = numeroAula;
    }

    public void setCostPerDia(double costPerDia) {
        this.costPerDia = costPerDia;
    }

    /*
     * TODO
     *
     * Nom del mètode: addAulaEstandard
     *
     * Accions:
     * - Demanar a l'usuari les dades per consola per crear una nova
     * AulaEstandard. Les dades a demanar són les que necessita
     * el constructor.
     *
     * Retorn: Objecte AulaEstandard creat.
     */

    public static AulaEstandard addAulaEstandard() {
        String codi;
        int numeroAula;
        double costPerDia;
        System.out.println("Introdueixi el codi de l'aula");
        codi = DADES.next();
        DADES.nextLine();
        System.out.println("Introdueixi el número de l'aula");
        numeroAula = DADES.nextInt();
        DADES.nextLine();
        System.out.println("Introdueixi el cost per dia");
        costPerDia = DADES.nextDouble();
        DADES.nextLine();
        return new AulaEstandard(codi, numeroAula, costPerDia);
    }

    /*
     * TODO
     *
     * Nom del mètode: updateAulaEstandard
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades de l'aula actual i
     * modificar els atributs corresponents d'aquesta aula.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de
     * modificar-los.
     * 
     * Retorn: cap
     */
    public void updateAulaEstandard() {
        System.out.println("Codi actual: " + getCodi());
        System.out.println("Introdueixi el nou codi");
        codi = DADES.next();
        DADES.nextLine();
        setCodi(codi);
        System.out.println("Número d'aula actual: " + getNumeroAula());
        System.out.println("Introdueixi el nou número d'aula");
        numeroAula = DADES.nextInt();
        DADES.nextLine();
        setNumeroAula(numeroAula);
        System.out.println("Cost per dia actual: " + getCostPerDia());
        System.out.println("Introdueixi el nou cost per dia");
        costPerDia = DADES.nextDouble();
        DADES.nextLine();
        setCostPerDia(costPerDia);
    }

    /*
     * TODO
     *
     * Nom del mètode: showAulaEstandard
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Mètode per mostrar les dades de l'aula actual i el seu cost de manteniment.
     * 
     * Retorn: cap
     */
    public void showAulaEstandard() {
        System.out.println("Les dades actuals de l'aula son les següents:");
        System.out.println("Codi de l'aula: " + getCodi());
        System.out.println("Número de l'aula: " + getNumeroAula());
        System.out.println("Cost de manteniment: " + costManteniment());
    }

    /*
     * TODO
     *
     * Nom del mètode: costManteniment
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Mètode que calcula el cost de manteniment del AulaEstandard actual
     * a partir del seu cost per dia (inclou manteniment, neteja...)
     * El cost de manteniment per dia és un 20% del cost per dia de l'aula
     * 
     * Retorn: cost de manteniment de l'aula (double).
     */
    public double costManteniment() {
        double costManteniment = getCostPerDia() * 0.20;
        return costManteniment;
    }
}