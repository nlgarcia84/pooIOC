package principal;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.Scanner;

import universitat.Campus;
import universitat.Universitat;

/**
 *
 * @author fgarin
 */
public class Application {
    private final static Scanner DADES = new Scanner(System.in);

    private static Universitat[] universitats = new Universitat[10];
    private static int pUniversitat = 0; // Primera posició buida del vector universitats
    private static Universitat universitatActual = null;

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;

        do {
            System.out.println("\nMenú principal. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió d'universitats");
            System.out.println("\n2. Gestió de campus");
            System.out.println("\n3. Gestió d'aules estàndard");
            System.out.println("\n4. Gestió d'aules d'informàtica");
            System.out.println("\n5. Gestió de laboratoris");
            System.out.println("\n");

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuUniversitats();
                    break;
                case 2:
                    if (universitatActual != null) {
                        menuCampus();
                    } else {
                        System.out.println(
                                "\nPrimer s'ha de seleccionar la universitat al menú 1. Gestió d'universitats.");
                    }
                    break;
                case 3:
                    if (universitatActual != null) {
                        menuAulesEstandard();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el campus al menú 2. Gestió de campus.");
                    }
                    break;
                case 4:
                    if (universitatActual != null) {
                        menuAulesInformatica();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el campus al menú 2. Gestió de campus.");
                    }
                    break;
                case 5:
                    if (universitatActual != null) {
                        menuLaboratoris();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el campus al menú 2. Gestió de campus.");
                    }
                    break;
                default:
                    System.out
                            .println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuUniversitats() {
        int opcio;

        do {
            int indexSel;
            System.out.println("\nMenú d'universitats. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. Llistar");
            System.out.println("\n");

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1: // Afegir nova universitat
                    Universitat novaUniversitat = Universitat.addUniversitat();

                    indexSel = selectUniversitat(novaUniversitat);

                    if (indexSel == -1) { // verifiquem si existeix, en cas contrari l'afegim a l'array universitats i
                                          // incrementem +1 el comptdor pUniversitat
                        universitats[pUniversitat] = novaUniversitat;
                        pUniversitat++;
                    } else {
                        System.out.println("\nLa universitat ja existeix");
                    }
                    break;
                case 2: // Seleccionar universitat existent
                    indexSel = selectUniversitat(null);

                    if (indexSel >= 0) { // verifiquem si existeix, si existeix accedim sino li diem que no hi és
                        universitatActual = universitats[indexSel];
                    } else {
                        System.out.println("\nNo existeix aquesta universitat");
                    }
                    break;
                case 3: // Modifica universitat. Primer verifiquem si existeix, si existeix procedim
                        // sino li diem que no hi és
                    indexSel = selectUniversitat(null);

                    if (indexSel >= 0) {
                        universitats[indexSel].updateUniversitat();
                    } else {
                        System.out.println("\nNo existeix aquesta universitat");
                    }
                    break;
                case 4: // Llistem l'array d'universitats
                    for (int i = 0; i < pUniversitat; i++) {
                        universitats[i].showUniversitat();
                    }
                    break;
                default: // La opció escollida es incorrecte
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     * TODO
     * 
     * Nom del mètode: menuCampus
     * 
     * Heu de desenvolupar el menu Campus amb les opcions que podeu veure.
     * Nota: penseu que quan arribem aquí, l'atribut universitatActual no és null.
     * 
     * Opció 0. Sortir --> Surt del menú i retorna al menú principal.
     * Opció 1. Alta --> Crea una Campus del campus actual. Noteu que Universitat
     * sap crear Campus.
     * Opció 2. Modificar --> Permet modificar una Campus del campus actual.
     * (per comprovar l'existència d'una campus tenim un mètode en la classe
     * Universitat que ens ajuda).
     * Opció 3. Llista Campus --> Imprimeix les dades dels campus del campus actual.
     * 
     * A més, heu de fer una estructura iterativa per tornar a mostrar el menú
     * sempre que no es premi l'opció 0 de sortida.
     *
     * Recomanacions:
     * - estructura de control switch-case per bifurcar les opcions.
     * - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el
     * missatge.
     * "S'ha de seleccionar una opció correcta del menú."
     * - definiu una variable opcio de tipus enter.
     */
    public static void menuCampus() {
        int opcio;

        do {
            int indexSel;
            System.out.println("\nMenú de campus. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar");

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1: // Afegir nou campus
                    Application.universitatActual.addCampus();
                    break;
                case 2: // Verifiquem si existeix el campus que es vol modificar, si no existeix li
                        // avisem a l'usuari
                    indexSel = Application.universitatActual.selectCampus(null);
                    if (indexSel >= 0) {
                        Campus campusActual = Application.universitatActual.getCampus(indexSel);
                        campusActual.updateCampus();
                    } else {
                        System.out.println("\nNo existeix aquest campus");
                    }
                    break;
                case 3: // llistem l'array de campus
                    Application.universitatActual.showCampus();
                    break;
                default: // La opció escollida es incorrecte
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     * TODO
     * 
     * Nom del mètode: menu Aules Estàndard
     * 
     * Heu de desenvolupar el menuAulesEstandard amb les opcions que podeu veure.
     * Nota: penseu que quan arribem aquí, l'atribut universitatActual no és null
     * 
     * Opció 0. Sortir --> Surt del menú i retorna al menú principal
     * Opció 1. Alta --> Crea Aula estàndard del campus actual afegint-lo a un
     * Campus.
     * Penseu que Universitat sap afegir Aules estàndard a una Campus seleccionat.
     * Opció 2. Modificar --> Permet modificar AulaEstàndard del campus actual.
     * Penseu que tots els
     * AulesEstandard d'un campus pertanyen a una Campus d'aquest campus i que
     * Universitat sap modificar AulaEstàndard que pertany a una dels seu Campus.
     * Opció 3. Llista AulesEstandard --> Imprimeix les dades de tots els
     * AulesEstandard del campus actual.
     * 
     * A més, heu de fer una estructura iterativa per tornar a mostrar el menú
     * sempre que no es premi l'opció 0 de sortida
     *
     * Recomanacions:
     * - estructura de control switch-case per bifurcar les opcions
     * - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el
     * missatge "S'ha de seleccionar una opció correcta del menú."
     * - definiu una variable opcio de tipus enter
     */
    public static void menuAulesEstandard() {
        int opcio;

        do {
            int indexSel;
            System.out.println("\nMenú Aules Estàndard. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llista AulesEstandard");

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1: // Afegim nova aula estandard, el mètode ja fa les comprobacions pertinents
                    Application.universitatActual.addAulaEstandardCampus();
                    break;
                case 2: // Actualitzem aula estandard existent, el mètode ja fa les comprobacions
                        // pertinents
                    Application.universitatActual.updateAulaEstandardCampus();
                    break;
                case 3: // Llistem les aules estandards de l'array
                    indexSel = Application.universitatActual.selectCampus(null);
                    if (indexSel >= 0) {
                        Campus campusActual = Application.universitatActual.getCampus(indexSel);
                        campusActual.showAulesEstandards();
                    }
                    break;
                default: // La opció escollida es incorrecte
                    System.out.println("S'ha de seleccionar una opció correcta del menú.");
                    break;
            }

        } while (opcio != 0);
    }

    /*
     * TODO
     * 
     * Nom del mètode: menuAulesInformatica
     * 
     * Heu de desenvolupar el menuAulesInformatica amb les opcions que podeu veure.
     * Nota: penseu que quan arribem aquí, l'atribut universitatActual no és null
     * 
     * Opció 0. Sortir --> Surt del menú i retorna al menú principal
     * Opció 1. Alta --> Crea una AulaInformatica del campus actual afegint-la a un
     * Campus.
     * Penseu que Universitat sap afegir una AulaInformatica a un Campus
     * seleccionat.
     * Opció 2. Modificar --> Permet modificar una AulaInformatica del campus
     * actual. Penseu que totes les
     * AulesInformatica d'un campus pertanyen a una Campus d'aquest Campus i que
     * Universitat sap modificar una AulaInformatica que pertany a una de les seves
     * Campus.
     * Opció 3. Llista AulesInformatica --> Imprimeix les dades de tots/es
     * AulesInformatica del campus actual.
     * A més, heu de fer una estructura iterativa per tornar a mostrar el menú
     * sempre que no es premi l'opció 0 de sortida
     * 
     * Recomanacions:
     * - estructura de control switch-case per bifurcar les opcions
     * - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el
     * missatge "S'ha de seleccionar una opció correcta del menú."
     * - definiu una variable opcio de tipus enter
     */
    public static void menuAulesInformatica() {
        int opcio;

        do {
            int indexSel;
            System.out.println("\nMenú Aules Informàtica. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llista Aules Informàtica");

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1: // Afegim nova aula d'informàtica, el mètode ja fa les comprobacions pertinents
                    Application.universitatActual.addAulaInformaticaCampus();
                    break;
                case 2: // Actualitzem l'aula d'informàtica existent, el mètode ja fa les comprobacions
                        // pertinents
                    Application.universitatActual.updateAulaInformaticaCampus();
                    break;
                case 3: // Llistem les aules d'informàtica de l'array
                    indexSel = Application.universitatActual.selectCampus(null);
                    if (indexSel >= 0) {
                        Campus campusActual = Application.universitatActual.getCampus(indexSel);
                        campusActual.showAulesInformatica();
                    }
                    break;
                default: // La opció escollida es incorrecte
                    System.out.println("S'ha de seleccionar una opció correcta del menú.");
                    break;
            }

        } while (opcio != 0);
    }
    /*
     * TODO
     * 
     * Nom del mètode: menuLaboratoris
     * 
     * Heu de desenvolupar el menuLaboratoris amb les opcions que podeu veure.
     * Nota: penseu que quan arribem aquí, l'atribut universitatActual no és null
     * 
     * Opció 0. Sortir --> Surt del menú i retorna al menú principal
     * Opció 1. Alta --> Crea una Apartament del campus actual afegint-la a una
     * Campus.
     * Penseu que Universitat sap afegir un Apartament a una Campus seleccionat.
     * Opció 2. Modificar --> Permet modificar un Apartament del campus actual.
     * Penseu que totes els
     * Laboratoris d'un campus pertanyen a una Campus d'aquest Campus i que
     * Universitat sap modificar una Apartament que pertany a una dels seus Campus.
     * Opció 3. Llista Laboratoris --> Imprimeix les dades de tots els Laboratoris
     * del campus actual.
     * 
     * A més, heu de fer una estructura iterativa per tornar a mostrar el menú
     * sempre que no es premi l'opció 0 de sortida
     * 
     * Recomanacions:
     * - estructura de control switch-case per bifurcar les opcions
     * - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el
     * missatge "S'ha de seleccionar una opció correcta del menú."
     * - definiu una variable opcio de tipus enter
     */

    public static void menuLaboratoris() {
        int opcio;

        do {
            int indexSel;
            System.out.println("\nMenú Laboratoris. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llista Laboratoris");

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1: // Afegim nou laboratori, el mètode ja fa les comprobacions pertinents
                    Application.universitatActual.addLaboratoriCampus();
                    break;
                case 2: // Actualitzem el laboratori existent, el mètode ja fa les comprobacions
                        // pertinents
                    Application.universitatActual.updateLaboratoriCampus();
                    break;
                case 3: // Llistem els laboratoris de l'array
                    indexSel = Application.universitatActual.selectCampus(null);
                    if (indexSel >= 0) {
                        Campus campusActual = Application.universitatActual.getCampus(indexSel);
                        campusActual.showLaboratoris();
                    }
                    break;
                default: // La opció escollida es incorrecte
                    System.out.println("S'ha de seleccionar una opció correcta del menú.");
                    break;
            }

        } while (opcio != 0);
    }

    public static Integer selectUniversitat(Universitat Universitat) {
        String nom;

        if (Universitat == null) {
            System.out.println("\nNom de la universitat:");
            nom = DADES.nextLine();
        } else {
            nom = Universitat.getNomUniversitat();
        }

        for (int i = 0; i < pUniversitat; i++) {
            if (universitats[i].getNomUniversitat().equals(nom)) {
                return i;
            }
        }

        return -1;
    }
}
