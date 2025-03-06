/*
 * Classe que defineix una universitat, que es defineix pel seu nom,
 * la seva ubicació i un array de campus.
 */

package universitat;

import java.util.Scanner;

/**
 *
 * @author fgarin
 */
public class Universitat {
    private final static Scanner DADES = new Scanner(System.in);

    private String nomUniversitat;
    private String ubicacioSeu;
    private Campus[] campus = new Campus[5];
    private int pCampus = 0; // Primera posició buida de l'array de campus

    /*
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: Universitat
     *
     * Paràmetres: valors per tots els atributs de la classe menys els arrays.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */

    public Universitat(String nomUniversitat, String ubicacioSeu) {

        this.nomUniversitat = nomUniversitat;
        this.ubicacioSeu = ubicacioSeu;
    }

    /**
     * TODO Heu d'implementar tots els mètodes accessors possibles.
     */
    public String getNomUniversitat() {
        return nomUniversitat;
    }

    public String getUbicacioSeu() {
        return ubicacioSeu;
    }

    /**
     * @param
     * @return Campus
     */
    public Campus getCampus(int index) {
        return this.campus[index];
    }

    public void setNomUniversitat(String nomUniversitat) {
        this.nomUniversitat = nomUniversitat;
    }

    public void setUbicacioSeu(String ubicacioSeu) {
        this.ubicacioSeu = ubicacioSeu;
    }

    /**
     * TODO
     *
     * Nom del mètode: addUniversitat
     *
     * Paràmetres: cap
     * 
     * Accions:
     * - Demanar a l'usuari les dades per consola per crear una nova universitat.
     * Les dades a demanar són les que necessita el constructor.
     * 
     * Retorn: Objecte Universitat creat.
     */
    public static Universitat addUniversitat() {
        String nomNovaUniversitat, ubicacioNovaUniversitat;
        System.out.println("Introdueixi el nom de la universitat");
        nomNovaUniversitat = DADES.nextLine();
        System.out.println("Introdueixi la ubicació de la universitat");
        ubicacioNovaUniversitat = DADES.nextLine();
        return new Universitat(nomNovaUniversitat, ubicacioNovaUniversitat);
    }

    /**
     * TODO
     *
     * Nom del mètode: updateUniversitat
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades de la universitat i
     * modificar els atributs corresponents d'aquesta universitat.
     * Els únics atributs que modificarem
     * són els que hem inicialitzat en el constructor amb els paràmetres passats.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de
     * modificar-los.
     * 
     * Retorn: cap
     */

    public void updateUniversitat() {
        String nomUniversitatCanvi, ubicacioUniversitatCanvi;
        System.out.println("Nom de la Universitat actual: " + getNomUniversitat());
        System.out.println("Introdueixi el nom de la nova Universitat");
        nomUniversitatCanvi = DADES.nextLine();
        setNomUniversitat(nomUniversitatCanvi);
        System.out.println("Introdueixi la seva ubicació");
        ubicacioUniversitatCanvi = DADES.nextLine();
        setUbicacioSeu(ubicacioUniversitatCanvi);
    }

    /**
     * TODO
     *
     * Nom del mètode: costManteniment
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Calcular cost de manteniment dels campus de la universitat a partir dels
     * costos de manteniment
     * de tots els campus de la universitat.
     * 
     * Retorn: Cost de manteniment total de la universitat (double).
     */

    public double costManteniment() {
        double costMantenimentUniversitat = 0.0;
        for (int i = 0; i < pCampus; i++) {
            Campus campusObjecte = campus[i];
            if (campusObjecte != null) {
                costMantenimentUniversitat += campusObjecte.costManteniment();
            }
        }
        return costMantenimentUniversitat;
    }

    /**
     * TODO
     *
     * Nom del mètode: showUniversitat
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Mètode per imprimir les dades de la universitat actual i el cost del seu
     * manteniment.
     * 
     * Retorn: cap
     */
    public void showUniversitat() {
        System.out.println("Nom de la universitat: " + getNomUniversitat());
        System.out.println("Ubicació: " + getUbicacioSeu());
        System.out.println("Cost del seu manteniment: " + costManteniment());
    }

    /**
     * Campus
     * 
     * TODO
     *
     * Nom del mètode: addCampus
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Afegeix un nou campus a l'array de campus de la universitat
     * si aquest no existeix.
     * Per afegir-lo heu de fer servir el mètode de la classe Campus escaient
     * i per comprovar la seva existència el mètode d'aquesta classe que ens
     * ajuda en aquesta tasca.
     * - Actualitza la posició de l'array de campus si s'afegeix el campus.
     * - Mostra el missatge "El campus ja existeix" si no s'ha afegit.
     * 
     * Retorn: cap
     */
    public void addCampus() {
        Campus nouCampus = Campus.addCampus();
        String nomNouCampus = nouCampus.getNomCampus();
        int comprobacioExisteix = selectCampus(nomNouCampus);
        if (comprobacioExisteix == -1) {
            campus[pCampus] = nouCampus;
            pCampus++;
        } else {
            System.out.println("El campus ja existeix");
        }
    }

    /**
     *
     * Nom del mètode: selectCampus
     *
     * Paràmetres: cap
     * 
     * Accions:
     * - Seleciona un campus de l'array de campus de la universitat
     * a partir del seu nom.
     * 
     * Retorn: La posició del campus seleccionat o -1 si no existeix.
     */
    public int selectCampus(String nom) {
        if (nom == null) {
            System.out.println("\nNom del campus:");
            nom = DADES.nextLine();
        }

        for (int i = 0; i < pCampus; i++) {
            if (campus[i].getNomCampus().equals(nom)) {
                return i;
            }
        }

        return -1;
    }

    public void addAulaEstandardCampus() {

        int index = selectCampus(null);

        if (index != -1) {
            campus[index].addAulaEstandard();
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }

    // Métode per llistar l'array campus
    public void showCampus() {
        for (int i = 0; i < pCampus; i++) {
            campus[i].showCampus();
        }
    }

    public void updateAulaEstandardCampus() {
        int indexCampus = selectCampus(null);

        if (indexCampus != -1) {
            int indexAulaEstandard = campus[indexCampus].selectAulaEstandard(null);

            if (indexAulaEstandard != -1) {
                campus[indexCampus].getAulesEstandard()[indexAulaEstandard].updateAulaEstandard();
            } else {
                System.out.println("\nL'aula estàndard no existeix");
            }
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }

    public void addAulaInformaticaCampus() {
        int index = selectCampus(null);

        if (index != -1) {
            campus[index].addAulaInformatica();
        } else {
            System.out.println("\nLEl campus no existeix");
        }
    }

    public void updateAulaInformaticaCampus() {
        int indexCampus = selectCampus(null);

        if (indexCampus != -1) {
            int indexAulaInformatica = campus[indexCampus].selectAulaInformatica(null);

            if (indexAulaInformatica != -1) {
                campus[indexCampus].getAulesInformatica()[indexAulaInformatica].updateAulaInformatica();
            } else {
                System.out.println("\nL'aula d'informàtica no existeix");
            }
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }

    public void addLaboratoriCampus() {
        int index = selectCampus(null);

        if (index != -1) {
            campus[index].addLaboratori();
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }

    public void updateLaboratoriCampus() {
        int indexCampus = selectCampus(null);

        if (indexCampus != -1) {
            int indexLaboratori = campus[indexCampus].selectLaboratori(null);

            if (indexLaboratori != -1) {
                campus[indexCampus].getLaboratoris()[indexLaboratori].updateLaboratori();
            } else {
                System.out.println("\nEl laboratori no existeix");
            }
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }
}
