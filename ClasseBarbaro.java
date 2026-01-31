package treinando.rpg;

public class ClasseBarbaro extends Jogador {
    private int furiasMaximas;   
    private int furiasRestantes; 
    private boolean emFuria;     
    private int danoFuria;
    public ClasseBarbaro(String nome, int nivel, int idade, double altura, double peso, String linhagem, String antecedente, FichaGeral ficha, String armadura){
        super(nome, nivel, idade, altura, peso, linhagem, antecedente, ficha, armadura);
        this.furiasMaximas = 2; 
        this.furiasRestantes = this.furiasMaximas;
        this.danoFuria = 2;
        this.emFuria = false;
    }

    @Override
    public void calcularHP(){
        int modCon = ficha.getModificador(ficha.getConstituicao());
        hpMaximo = 12 + modCon;
        for(int i = 1; i<nivel; i++){
            hpMaximo +=(7 + modCon);}
            this.hpAtual = this.hpMaximo;
        System.out.println("O hp de " + this.nome + " eh esse aqui: " + this.hpAtual);
        }
    
    @Override
    public void diminuirHP(int dano) {
        int danoFinal = dano;

        if (this.emFuria) {
        danoFinal = dano / 2;
        System.out.println("Fúria reduziu o dano de " + dano + " para " + danoFinal);
        }
    super.diminuirHP(danoFinal); 
    }

    @Override
    public void recuperarHP(int cura){
        if(this.hpAtual <= this.hpMaximo){
            this.hpAtual += cura;
        }
        if (this.hpAtual > this.hpMaximo) {
            this.hpAtual = this.hpMaximo;
        }
        
        System.out.println(hpAtual);
    }
    
    @Override
    public void exibirStatus(){
        System.out.println("Exibindo dados de "+this.nome);
        System.out.println(this.idade);
        System.out.println(this.altura); 
        System.out.println(this.peso); 
        System.out.println(this.linhagem); 
        System.out.println(this.antecedente);
    }

    @Override
    public void descansoCurto(){
        if (this.hpAtual < (this.hpMaximo / 2) && this.dadosDeVidaAtuais > 0) {
            // Rola o dado (d12 para barbaro) + CON
            int cura = 7 + ficha.getModificador(ficha.getConstituicao()); 
            this.recuperarHP(cura);
            this.dadosDeVidaAtuais--;
            System.out.println("-> Gastou 1 Dado de Vida para se curar.");
        }
    }
    @Override
    public void realizarDescansoLongo(){
        super.realizarDescansoLongo();
        this.furiasRestantes = this.furiasMaximas;
        this.emFuria = false;
        System.out.println("Todas as habilidades do Bárbaro recarregadas!");
    }

    @Override
    public void calcularCA() {
        if(this.armadura == null || this.armadura.equalsIgnoreCase("nenhuma")) {
            int modDex = ficha.getModificador(ficha.getDestreza());
            int modCon = ficha.getModificador(ficha.getConstituicao());
            int caBarbaro = 10 + modDex + modCon;

            System.out.println("CA de Bárbaro (Sem Armadura): " + caBarbaro);
        }else{
            super.calcularCA();
        }
    }
    
    public void ativarFuria(){
        if (this.emFuria) {
        System.out.println("Você já está em fúria!");
        return;
        }
        if (this.furiasRestantes <= 0) {
        System.out.println("Precisa de um descanso longo.");
        return;
        }
        this.furiasRestantes--;
        this.emFuria = true;

    System.out.println("Fúria Ativada");
    System.out.println("Fúrias restantes: " + this.furiasRestantes);
    }

    public void acabarFuria() {
        if (this.emFuria) {
        this.emFuria = false;
        System.out.println("Sua fúria passou.");
        }
    }




    
}
