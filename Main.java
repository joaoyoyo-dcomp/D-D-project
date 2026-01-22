package treinando.rpg;

public class Main {
    public static void main(String[] args) {
        FichaGeral fichaUtral = new FichaGeral(20, 14, 18, 17, 13, 10);
        ClasseBarbaro Utral = new ClasseBarbaro("Utral", 20, 40, 2.10, 100, "golias", "soldado", fichaUtral, "gibão de peles");
        Utral.calcularArmadura();
        /* 
        FichaGeral fichaJoao = new FichaGeral(4, 0, 14, -1, 0, 2);
        ClasseGuerreiro Joao = new ClasseGuerreiro("Joseph Joestar", 3, 25, 1.90, 78, "humano", "soldado", fichaJoao, "Defesa");
        Joao.exibirStatus();
        Joao.calcularHP();
        Joao.diminuirHP(27);
        Joao.recuperarHP(26);
        Joao.recuperarHP(26);
        Joao.diminuirHP(20);
        Joao.retomarFolego();
        Joao.retomarFolego();
        Joao.retomarFolego();
        Joao.surtoDeAcao();
        Joao.descansoCurto();
        */
    }
}
