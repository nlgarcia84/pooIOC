/*
 * Classe que defineix una aula d'informàtica d'una universitat. 
 * Es defineix pel seu codi, número d'aula, el seu cost per dia i el tamany de l'aula en metres quadrats.
 */
package universitat;

import java.util.Scanner;

/**
 *
 * @author fgarin
 */
public class AulaInformatica {
    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private int numeroAula;
    private double costPerDia;
    private double areaEnMetresQuadrats;

    /*
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: AulaInformatica
     *
     * Paràmetres: valors per tots els atributs de la classe.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
    public AulaInformatica(String codi, int numeroAula, double costPerDia, double areaEnMetresQuadrats) {
        this.codi = codi;
        this.numeroAula = numeroAula;
        this.costPerDia = costPerDia;
        this.areaEnMetresQuadrats = areaEnMetresQuadrats;
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

    public double getAreaEnMetresQuadrats() {
        return areaEnMetresQuadrats;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public void setNumeroAula(int numeroAula) {
        this.numeroAula = numeroAula;
    }

    public void setCostPerDia(double cosPerDia) {
        this.costPerDia = cosPerDia;
    }

    public void setAreaEnMetresQuadrats(double areaEnMetresQuadrats) {
        this.areaEnMetresQuadrats = areaEnMetresQuadrats;
    }

    /*
     * TODO
     *
     * Nom del mètode: addAulaInformatica
     *
     * Paràmetres: cap
     * 
     * Accions:
     * - Demanar a l'usuari les dades per consola per crear una nova aula de
     * informatica. Les dades a
     * demanar són les que necessita el constructor.
     *
     * Retorn: Objecte AulaInformatica creat.
     */

    public static AulaInformatica addAulaInformatica() {
        String codiAulaInformaticaNova;
        int numeroAulaInformaticaNova;
        double costAulaInformaticaNova;
        double areaAulaInformaticaNova;
        System.out.println("Introdueixi el codi de l'aula");
        codiAulaInformaticaNova = DADES.next();
        DADES.nextLine();
        System.out.println("Introdueix el número de l'aula");
        numeroAulaInformaticaNova = DADES.nextInt();
        DADES.nextLine();
        System.out.println("Introdueix el cost per dia");
        costAulaInformaticaNova = DADES.nextDouble();
        DADES.nextLine();
        System.out.println("Introdueix el tamany en metres quadrats");
        areaAulaInformaticaNova = DADES.nextDouble();
        DADES.nextLine();
        return new AulaInformatica(codiAulaInformaticaNova, numeroAulaInformaticaNova, costAulaInformaticaNova,
                areaAulaInformaticaNova);
    }

    /*
     * TODO
     *
     * Nom del mètode: updateAulaInformatica
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades de l'aula de informatica
     * i modificar els
     * atributs corresponents d'aquesta aula.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de
     * modificar-los.
     *
     * Retorn: cap
     */

    public void updateAulaInformatica() {
        String codiAI;
        int numAI;
        double costAI;
        double areaAI;
        System.out.println("Codi actual: " + getCodi());
        System.out.println("Introdueixi el nou codi");
        codiAI = DADES.next();
        DADES.nextLine();
        setCodi(codiAI);
        System.out.println("Número d'aula actual: " + getNumeroAula());
        System.out.println("Introdueixi el nou número d'aula");
        numAI = DADES.nextInt();
        setNumeroAula(numAI);
        DADES.nextLine();
        System.out.println("Cost per dia actual: " + getCostPerDia());
        System.out.println("Introdueixi el nou cost per dia");
        costAI = DADES.nextDouble();
        setCostPerDia(costAI);
        DADES.nextLine();
        System.out.println("Metres quadrats actuals: " + getAreaEnMetresQuadrats());
        System.out.println("Introdueix els nous metres quadrats");
        areaAI = DADES.nextDouble();
        setAreaEnMetresQuadrats(areaAI);
    }

    /*
     * TODO
     *
     * Nom del mètode: showAulaInformatica
     * 
     * Accions:
     * - Mètode per imprimir les dades de l'aula de informatica i el seu cost de
     * manteniment.
     *
     * Retorn: cap
     */
    public void showAulaInformatica() {
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
     * - Mètode que retornarà el cost de manteniment de l'aula actual.
     * - El cost de manteniment per dia és un 30% del cost per dia de l'aula + un 5%
     * de la seva àrea
     *
     * Retorn: cost de manteniment de l'aula (double).
     */
    public double costManteniment() {
        double costManteniment = getCostPerDia() * 0.05;
        return costManteniment;
    }

}
