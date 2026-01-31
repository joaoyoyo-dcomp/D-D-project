package treinando.rpg;

public class ClasseGuerreiro extends Jogador {
    private boolean secondWindDisponivel;
    private boolean actionSurgeDisponivel;
    private String estiloDeLuta;
    public ClasseGuerreiro(String nome, int nivel, int idade, double altura, double peso, String linhagem, String antecedente, FichaGeral ficha, String estiloDeLuta){
        super(nome, nivel, idade, altura, peso, linhagem, antecedente, ficha);
        this.secondWindDisponivel = true;
        this.actionSurgeDisponivel = true;
        this.estiloDeLuta = estiloDeLuta;
        aplicarBonusEstilo();
    }

    @Override
    public void calcularHP(){
        int modCon = ficha.getModificador(ficha.getConstituicao());
        hpMaximo = 10 + modCon;
        for(int i = 1; i<nivel; i++){
            hpMaximo +=(6 + modCon);}
            this.hpAtual = this.hpMaximo;
        System.out.println("O hp de " + this.nome + " eh esse aqui: " + this.hpAtual);
        }

    @Override
    public void exibirStatus(){
        System.out.println("Exibindo dados de "+this.nome);
        System.out.println(this.idade);
        System.out.println(this.altura); 
        System.out.println(this.peso); 
        System.out.println(this.linhagem); 
        System.out.println(this.antecedente);
        System.out.println("Surto de ação: " + this.actionSurgeDisponivel);
        System.out.println("Retomar o fôlego: "+ this.secondWindDisponivel);
    }

    @Override
    public void realizarDescansoLongo(){
        super.realizarDescansoLongo();
        this.secondWindDisponivel = true;
        this.actionSurgeDisponivel = true;
        System.out.println("Todas as habilidades do Guerreiro recarregadas!");
    }

    @Override
    public void descansoCurto(){
        if(!this.actionSurgeDisponivel){
            this.actionSurgeDisponivel = true;
            System.out.println("Surto de ação disponível novamente");
        }
        if(!this.secondWindDisponivel){
            this.secondWindDisponivel = true;
            System.out.println("Retomar o fôlego disponível novamente");
        }
        
        if (this.hpAtual < (this.hpMaximo / 2) && this.dadosDeVidaAtuais > 0) {
            // Rola o dado (d10 para guerreiro) + CON
            int cura = 6 + ficha.getModificador(ficha.getConstituicao()); 
            this.recuperarHP(cura);
            this.dadosDeVidaAtuais--;
            System.out.println("-> Gastou 1 Dado de Vida para se curar.");
        }
    }

    public void aplicarBonusEstilo(){
        if(this.estiloDeLuta.equals("Arquearia")){
            System.out.println("Seu estilo de luta é arquearia");
        }
        if(this.estiloDeLuta.equals("Combate com armas grandes")){
            System.out.println("Seu estilo de luta é combate com armas grandes");
        }
        if(this.estiloDeLuta.equals("Combate com duas armas")){
            System.out.println("Seu estilo de luta é combate com duas armas");
        }
        if(this.estiloDeLuta.equals("Defesa")){
            System.out.println("Seu estilo de luta é defesa");
        }
        if(this.estiloDeLuta.equals("Duelismo")){
            System.out.println("Seu estilo de luta é duelismo");
        }
        if(this.estiloDeLuta.equals("Proteção")){
            System.out.println("Seu estilo de luta é proteção");   
        }
    }

    public void retomarFolego(){
        if(!secondWindDisponivel){
            System.out.println("Essa habilidade já foi usada");
            return;
        }
        int cura = 6 + this.nivel;
        this.recuperarHP(cura);
            secondWindDisponivel = false;
    }
    
    public void surtoDeAcao(){
        if(!actionSurgeDisponivel){
            System.out.println("Essa habilidade já foi usada");
            return;
        }
        System.out.println("Você possui uma ação extra");
        actionSurgeDisponivel = false;
    }

}
