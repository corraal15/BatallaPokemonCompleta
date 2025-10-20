import com.sun.source.util.SourcePositions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*Datos que necesitamos de cada pokemon:
Para cada pokemon, tenéis que definir:

Su nombre
La vida
Los MP
El daño de su ataque normal
Su defensa
El nombre de su ataque especial
El daño de su ataque especial
El consumo de puntos de su ataque especial
Por ejemplo:


String pokemon1 = "Pikachu";
int vida1 = 120;
int mp1 = 50;
int danhoGolpe1 = 10;
int defensa1 = 5;
String golpeEspecial = "Impactrueno";
int danhoEspecial = 40;
int mpGolpeEspecial = 15;
Batalla
Tenéis que simular una pelea entre los dos pokemon hasta que uno gana - un bucle While hasta que uno de los dos tiene 0 o menos vida. En cada ejecución del bucle:

Imprimís el estado de ambos Pokemon
Imprimís a qué pokemon le toca atacar
Le pedís al usuario que diga qué hacer, si el ataque especial o el ataque normal
Si hace el ataque normal, le hace daño al otro Pokemon por valor de (ataque - defensa)
Si hace el ataque especial, ocurre lo mismo que con el normal, salvo que el ataque hace más daño. PERO, si no tiene suficientes MP para ejecutar el ataque, pierde el turno.
Imprimís el efecto del ataque ...(pokemon1 + " le hace " + danho + " puntos de daño a " + pokemon2)... */
        //Datos
        boolean partida=true;
        boolean turno1=true;


        //pokemon1
        String pokemon1 = "Pikachu";
        int vida1 = 120;
        int mp1 = 60;
        int danhoGolpe1 = 10;
        int defensa1 = 5;
        String golpeEspecial = "Impactrueno";
        int danhoEspecial = 40;
        int mpGolpeEspecial = 20;


        //pokemon2
        String pokemon2 = "Ferraligatr";
        int vida2 = 140;
        int mp2 = 60;
        int danhoGolpe2 = 10;
        int defensa2 = 10;
        String golpeEspecial2 = "Colmillo hielo";
        int danhoEspecial2 = 40;
        int mpGolpeEspecial2 = 20;

        //objetos
        int pocionesPequenas=3;
        int pocionesGrandes=2;
        int pocionesPequenas2=3;
        int pocionesGrandes2=2;

        //Estatus inicial
        System.out.println("========== POKEMON 1 ==========");
        System.out.println(pokemon1);
        System.out.println("Vida=" + vida1);
        System.out.println("MP=" + mp1);
        System.out.println("Danho Golpe=" + danhoGolpe1);
        System.out.println("Defensa=" + defensa1);
        System.out.println("GolpeEspecial=" + golpeEspecial);
        System.out.println("DanhoEspecial=" + danhoEspecial);
        System.out.println("MPGolpeEspecial=" + mpGolpeEspecial);
        System.out.println("===============================");
        System.out.println("========== POKEMON 2 =========");
        System.out.println(pokemon2);
        System.out.println("Vida=" + vida2);
        System.out.println("MP=" + mp2);
        System.out.println("Danho Golpe=" + danhoGolpe2);
        System.out.println("Defensa=" + defensa2);
        System.out.println("GolpeEspecial=" + golpeEspecial);
        System.out.println("DanhoEspecial=" + danhoEspecial);
        System.out.println("MPGolpeEspecial=" + mpGolpeEspecial);
        System.out.println("==============================");

        //Inicio Partida
        //Encuentro
        System.out.println("\nTu Pikachu se encuentra con un Ferraligatr salvaje, ¿Que decides hacer?");
        System.out.println("1. Luchar");
        System.out.println("2. Huir");
        Scanner sc = new Scanner(System.in);
        String decision1 = sc.nextLine();
        if (decision1.equals("1")) {
            while (partida) {

                //Mostrar Datos Batalla
                System.out.println("========== POKEMON 1 ==========");
                System.out.println(pokemon1);
                System.out.println("Vida=" + vida1);
                System.out.println("MP=" + mp1);
                System.out.println("Defensa=" + defensa1);
                System.out.println("===============================");
                System.out.println("========== POKEMON 2 ==========");
                System.out.println(pokemon2);
                System.out.println("Vida=" + vida2);
                System.out.println("MP=" + mp2);
                System.out.println("Defensa=" + defensa2);
                System.out.println("===============================");

                if (turno1) {
                    System.out.println("===============================");
                    System.out.println("Es el turno de: "+pokemon1);
                    System.out.println("===============================");
                    //Primera decisión
                    System.out.println("¿Que decides hacer?");
                    System.out.println("1. Ataques");
                    System.out.println("2. Objetos");
                    System.out.println("3. Pokemons");
                    System.out.println("4. Huir");
                    String decision2 = sc.nextLine();

                    if (decision2.equals("1")) {
                        String respuesta= ataques1();
                        if (respuesta.equals("1")) {
                            int dano=(danhoGolpe1+defensa2);
                            if (dano==0){
                                dano=1;
                            }
                            vida2 = vida2 -dano;
                            System.out.println(pokemon1+" le hace "+danhoGolpe1+" puntos de daño a "+pokemon2);
                            System.out.println("Ahora "+pokemon2+" tiene "+vida2+" puntos de vida");
                        }
                        else if (respuesta.equals("2")) {
                            if (mp1 > mpGolpeEspecial) {
                                int dano=(danhoEspecial+defensa2);
                                if (dano==0){
                                    dano=1;
                                }
                                vida2 = vida2 -dano;
                                mp1 = mp1 - mpGolpeEspecial;
                                turno1 = false;
                                System.out.println(pokemon1+" le hace "+danhoEspecial+" puntos de daño a "+pokemon2);
                                System.out.println("Ahora "+pokemon2+" tiene "+vida2+" puntos de vida");
                            }
                            else{
                                System.out.println("No tienes suficientes MP");
                                turno1=false;
                            }
                        }
                    } else if (decision2.equals("2")) {
                        System.out.println("========== Objetos ==========");
                        System.out.println("1. Poción pequeña (20 hp)");
                        System.out.println("Tienes: " + pocionesPequenas);
                        System.out.println("2. Poción Grande (50 hp)");
                        System.out.println("Tienes: " + pocionesGrandes);
                        System.out.println("===============================");
                        String objetosSelect=sc.nextLine();
                        if (objetosSelect.equals("1")){
                            if (pocionesPequenas>0) {
                                pocionesPequenas = pocionesPequenas - 1;
                                vida1=vida1+20;
                            }
                            else {
                                System.out.println("No te quedan");
                            }
                            turno1=false;
                        }
                        else if (objetosSelect.equals("2")){
                            if (pocionesGrandes>0) {
                                pocionesGrandes = pocionesGrandes - 1;
                                vida1=vida1+50;
                            }
                            else{
                                System.out.println("No te quedan.");
                            }
                            turno1=false;
                        }
                    } else if (decision2.equals("3")) {
                        System.out.println("========== Pokemons ==========");
                        System.out.println("No tienes más pokemons.");
                        System.out.println("===============================");
                    } else if (decision2.equals("4")) {
                        System.out.println("Huyes sin problemas.");
                        partida = false;
                    }
                    if (vida1 <= 0 || vida2 <= 0) {
                        partida = false;
                        if (vida1==0){
                            System.out.println("Pikachu ha sido derrotado!");
                        }
                        else if (vida2==0){
                            System.out.println("Ferraligatr ha sido derrotado!");
                        }
                    }
                }
                else {
                    System.out.println("===============================");
                    System.out.println("Es el turno de: "+pokemon2);
                    System.out.println("===============================");
                    //Primera decisión
                    System.out.println("¿Que decides hacer?");
                    System.out.println("1. Ataques");
                    System.out.println("2. Objetos");
                    System.out.println("3. Pokemons");
                    System.out.println("4. Huir");
                    String decision2 = sc.nextLine();

                    if (decision2.equals("1")) {
                        String respuesta= ataques2();
                        if (respuesta.equals("1")) {
                            int dano=(danhoGolpe2+defensa1);
                            if (dano==0){
                                dano=1;
                            }
                            vida1 = vida1 -dano;
                            turno1=true;
                            System.out.println(pokemon2+" le hace "+danhoGolpe2+" puntos de daño a "+pokemon1);
                            System.out.println("Ahora "+pokemon1+" tiene "+vida1+" puntos de vida");
                        }
                        else if (respuesta.equals("2")) {
                            if (mp2 > mpGolpeEspecial2) {
                                int dano=(danhoEspecial2+defensa1);
                                if (dano==0){
                                    dano=1;
                                }
                                vida1 = vida1 -dano;
                                mp2 = mp2 - mpGolpeEspecial2;
                                turno1 = true;
                                System.out.println(pokemon2+" le hace "+danhoEspecial2+" puntos de daño a "+pokemon1);
                                System.out.println("Ahora "+pokemon1+" tiene "+vida1+" puntos de vida");
                            }
                            else{
                                System.out.println("No tienes suficientes MP");
                                turno1=true;
                            }
                        }
                    } else if (decision2.equals("2")) {
                        System.out.println("========== Objetos ==========");
                        System.out.println("1. Poción pequeña (20 hp)");
                        System.out.println("Tienes: " + pocionesPequenas2);
                        System.out.println("2. Poción Grande (50 hp)");
                        System.out.println("Tienes: " + pocionesGrandes2);
                        System.out.println("===============================");
                        String objetosSelect=sc.nextLine();
                        if (objetosSelect.equals("1")){
                            if (pocionesPequenas2>0) {
                                pocionesPequenas2 = pocionesPequenas2 - 1;
                                vida2=vida2+20;
                            }
                            else {
                                System.out.println("No te quedan");
                            }
                            turno1=true;
                        }
                        else if (objetosSelect.equals("2")){
                            if (pocionesGrandes2>0) {
                                pocionesGrandes2 = pocionesGrandes2 - 1;
                                vida2=vida2+50;
                            }
                            else {
                                System.out.println("No te quedan");
                            }
                            turno1=false;
                        }
                    } else if (decision2.equals("3")) {
                        System.out.println("========== Pokemons 2==========");
                        System.out.println("No tienes más pokemons.");
                        System.out.println("===============================");
                    } else if (decision2.equals("4")) {
                        System.out.println("Huyes sin problemas.");
                        partida = false;
                    }
                    if (vida1 <= 0 || vida2 <= 0) {
                        partida = false;
                        if (vida1==0){
                            System.out.println("Pikachu ha sido derrotado!");
                        }
                        else if (vida2==0){
                            System.out.println("Ferraligatr ha sido derrotado!");
                        }
                    }
                }
            }
        }
        else{
            System.out.println("Huyes sin problemas.");
        }
        System.out.println("======= Fin de la batalla =======");

    }

    public static String ataques1() {
        Scanner sc = new Scanner(System.in);
        String golpeEspecial = "Impactrueno";
        System.out.println("========== Ataques ==========");
        System.out.println("1. Arañazo");
        System.out.println("2. "+ golpeEspecial);
        System.out.println("===============================");
        System.out.println("¿Que ataque quieres que tu pokemon utilice?");
        String ataqueElegido = sc.nextLine();
        return  ataqueElegido;
    }
    public static String ataques2() {
        Scanner sc = new Scanner(System.in);
        String golpeEspecial = "Colmillo hielo";
        System.out.println("========== Ataques ==========");
        System.out.println("1. Arañazo");
        System.out.println("2. "+ golpeEspecial);
        System.out.println("===============================");
        System.out.println("¿Que ataque quieres que tu pokemon utilice?");
        String ataqueElegido = sc.nextLine();
        return  ataqueElegido;
    }
}