/**
 * Classe que defineix un campus. Es defineix pel seu nom,
 * la seva ubicació, un array d'aules estàndard,
 * un array d'aules d'informàtica i un array de laboratoris.
 */

package universitat;

import java.util.Scanner;

/**
 *
 * @author fgarin
 */
public class Campus {
    private final static Scanner DADES = new Scanner(System.in);

    private String nomCampus;
    private String ubicacio;

    private AulaEstandard[] aulesEstandard = new AulaEstandard[100];
    private int pAulesEstandard = 0; // Primera posició buida de l'array d'aules estàndard
    private AulaInformatica[] aulesInformatica = new AulaInformatica[100];
    private int pAulesInformatica = 0; // Primera posició buida de l'array d'aules d'informàtica
    private Laboratori[] laboratoris = new Laboratori[100];
    private int pLaboratoris = 0; // Primera posició buida de l'array de laboratoris

    /**
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: Campus
     *
     * Paràmetres: valors per tots els atributs de la classe, menys els arrays
     *
     * Accions:
     * - Assignar als atributs els valors passats com a paràmetres.
     */

    public Campus(String nomCampus, String ubicacio) {
        this.nomCampus = nomCampus;
        this.ubicacio = ubicacio;
    }

    /**
     * TODO Heu d'implementar tots els mètodes accessors possibles.
     */
    public String getNomCampus() {
        return nomCampus;
    }

    public String getUbicacio() {
        return ubicacio;
    }

    public void setNomCampus(String nomCampus) {
        this.nomCampus = nomCampus;
    }

    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }

    /**
     * TODO
     *
     * Nom del mètode: addCampus
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar a l'usuari les dades per consola per crear un nou campus
     * Les dades a demanar són les que necessita el constructor.
     *
     * Retorn: Objecte Campus creat.
     */
    public static Campus addCampus() {
        String nomCam, ubicacioCam;
        System.out.println("Introdueixi el nom del campus");
        nomCam = DADES.nextLine();
        System.out.println("Introdueixi la ubicació del campus");
        ubicacioCam = DADES.nextLine();
        return new Campus(nomCam, ubicacioCam);
    }

    /*
     * TODO
     *
     * Nom del mètode: updateCampus
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades del campus i
     * modificar els atributs corresponents d'aquest. Els únics
     * atributs que modificarem són els que hem inicialitzat en el constructor
     * amb els paràmetres passats.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de
     * modificar-los.
     *
     * Retorn: cap
     */

    public void updateCampus() {
        String nomCam, ubicacioCam;
        System.out.println("Nom del campus actual: " + getNomCampus());
        System.out.println("Introdueixi el nom del nou campus");
        nomCam = DADES.nextLine();
        setNomCampus(nomCam);
        System.out.println("Ubicació actual del campus: " + getUbicacio());
        System.out.println("Introdueixi la nova ubicació del campus");
        ubicacioCam = DADES.nextLine();
        setUbicacio(ubicacioCam);
    }
    /*
     * TODO
     *
     * Nom del mètode: costManteniment
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Calcular el cost de manteniment del campus a partir dels costos
     * de manteniment de les aules i laboratoris del campus.
     *
     * Retorn: cost de manteniment total del campus.
     */

    public double costManteniment() {
        AulaEstandard aulaStandard = new AulaEstandard(nomCampus, pAulesEstandard, pAulesInformatica);
        AulaInformatica aulaInformatica = new AulaInformatica(nomCampus, pLaboratoris, pAulesInformatica,
                pAulesEstandard);
        Laboratori laboratori = new Laboratori(nomCampus, pLaboratoris, pAulesEstandard, pAulesInformatica);
        double costMantenimentTotal = aulaStandard.costManteniment() + aulaInformatica.costManteniment()
                + laboratori.costManteniment();
        return costMantenimentTotal;
    }

    /*
     * TODO
     *
     * Nom del mètode: showCampus
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Mètode per mostrar les dades del campus i el seu cost de manteniment.
     *
     * Retorn: cap
     */
    public void showCampus() {
        System.out.println("Nom del campus: " + getNomCampus());
        System.out.println("Ubicació: " + getUbicacio());
        System.out.println("Cost total de manteniment: " + costManteniment());
    }

    /**
     * AulaEstandard
     *
     * TODO
     *
     * Nom del mètode: addAulaEstandard
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Afegeix una nova aula estàndard a l'array d'aulesEstandard
     * del campus actual si aquest/a no existeix.
     * Per afegir-lo heu de fer servir el mètode de la classe AulaEstandard
     * escaient i per comprovar la seva existència el mètode d'aquesta classe
     * que ens ajuda en aquesta tasca.
     * - Actualitza la posició de l'array de aulesEstandard si s'afegeix.
     * - Mostra el missatge "L'aula estàndard ja existeix" si
     * no s'ha afegit.
     *
     * Retorn: cap
     */

    public void addAulaEstandard() {
        AulaEstandard novaAulaEstandard = AulaEstandard.addAulaEstandard();
        String codiNovaAulaEstandard = novaAulaEstandard.getCodi();
        int comprobacioExisteix = selectAulaEstandard(codiNovaAulaEstandard);
        if (comprobacioExisteix == -1) {
            aulesEstandard[pAulesEstandard] = novaAulaEstandard;
            pAulesEstandard++;
        } else {
            System.out.println("L'aula estàndard ja existeix");
        }
    }

    /**
     *
     * Nom del mètode: selectAulaEstandard
     *
     * Paràmetres: codi de l'aula estàndard
     *
     * Accions:
     * - Mètode que selecciona una aula estàndard de l'array de aulesEstandard del
     * campus actual
     * a partir del seu codi.
     *
     * Retorn: posició de l'aula estàndard seleccionada a l'array de aulesEstandard
     * del campus actual.
     * Si l'aula estàndard no existeix retorna -1.
     */
    public int selectAulaEstandard(String codi) {
        if (codi == null) {
            System.out.println("\nCodi de l'aula estàndard:");
            codi = DADES.nextLine();
        }

        for (int i = 0; i < pAulesEstandard; i++) {
            if (aulesEstandard[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * AulaInformatica
     *
     * TODO
     *
     * Nom del mètode: addAulaInformatica
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Afegeix una nova aulaInformatica a l'array de aulesInformatica
     * del campus actual si aquesta no existeix.
     * Per afegir-la heu de fer servir el mètode de la classe AulaInformatica
     * escaient i per comprovar la seva existència el mètode d'aquesta classe
     * que ens ajuda en aquesta tasca.
     * - Actualitza la posició de l'array de aulesInformatica si s'afegeix.
     * - Mostra el missatge "L'aula d'informàtica ja existeix" si
     * no s'ha afegit.
     *
     * Retorn: cap
     */

    public void addAulaInformatica() {
        AulaInformatica novAulaInformatica = AulaInformatica.addAulaInformatica();
        String codiNovaAulaInformatica = novAulaInformatica.getCodi();
        int comprobacioExisteix = selectAulaInformatica(codiNovaAulaInformatica);
        if (comprobacioExisteix == -1) {
            aulesInformatica[pAulesInformatica] = novAulaInformatica;
            pAulesInformatica++;
        } else {
            System.out.println("L'aula d'informàtica ja existeix");
        }
    }

    /**
     *
     * Nom del mètode: selectAulaInformatica
     * 
     * Paràmetres: codi de l'aulaInformatica
     *
     * Accions:
     * - Mètode que selecciona una aulaInformatica de l'array de aulesInformatica
     * del campus actual
     * a partir del seu codi.
     *
     * Retorn: posició de la aulaInformatica seleccionada a l'array de
     * aulesInformatica del campus actual.
     * Si l'aula d'informàtica no existeix retorna -1.
     */
    public int selectAulaInformatica(String codi) {
        if (codi == null) {
            System.out.println("\nCodi de l'aula d'informàtica:");
            codi = DADES.nextLine();
        }

        for (int i = 0; i < pAulesInformatica; i++) {
            if (aulesInformatica[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Laboratori
     *
     * TODO
     *
     * Nom del mètode: addLaboratori
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Afegeix un nou laboratori a l'array de laboratoris
     * del campus actual si aquest no existeix.
     * Per afegir-lo heu de fer servir el mètode de la classe Laboratori
     * escaient i per comprovar la seva existència el mètode d'aquesta classe
     * que ens ajuda en aquesta tasca.
     * - Actualitza la posició de l'array de laboratoris si s'afegeix.
     * - Mostra el missatge "El laboratori ja existeix" si
     * no s'ha afegit.
     *
     * Retorn: cap
     */

    public void addLaboratori() {
        Laboratori nouLaboratori = Laboratori.addLaboratori();
        String codiNouLaboratori = nouLaboratori.getCodi();
        int comprobacioExisteix = selectLaboratori(codiNouLaboratori);
        if (comprobacioExisteix == -1) {
            laboratoris[pLaboratoris] = nouLaboratori;
            pLaboratoris++;
        } else {
            System.out.println("El laboratori ja existeix");
        }
    }

    /**
     *
     * Nom del mètode: selectLaboratori
     * 
     * Paràmetres: codi del laboratori
     *
     * Accions:
     * - Mètode que selecciona un laboratori de l'array de laboratoris del campus
     * actual
     * a partir del seu codi.
     *
     * Retorn: posició de la laboratori seleccionada a l'array d'laboratoris del
     * campus actual.
     * Si el laboratori no existeix retorna -1.
     */

    public int selectLaboratori(String codi) {
        if (codi == null) {
            System.out.println("\nCodi del laboratori:");
            codi = DADES.nextLine();
        }

        for (int i = 0; i < pLaboratoris; i++) {
            if (laboratoris[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }
}