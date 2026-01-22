package treinando.rpg;

public class ClasseLadino extends Jogador {

    public ClasseLadino(String nome, int nivel, int idade, double altura, double peso, String linhagem, String antecedente, FichaGeral ficha){
        super(nome, nivel, idade, altura, peso, linhagem, antecedente, ficha);
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
    public void diminuirHP(int dano) {
    int saldoVida = this.hpAtual - dano;
    
    int limiteMorte = -(this.hpMaximo / 2);
    
    if (saldoVida < limiteMorte) {
        this.hpAtual = 0;
        this.estaMorto = true;
        System.out.println("☠️ DANO MASSIVO! " + this.nome + " morreu instantaneamente.");
    }
    
    else if (saldoVida <= 0) {
        this.hpAtual = 0;
        System.out.println("⚠️ " + this.nome + " caiu inconsciente (0 HP)!");
    }
    
    else {
        this.hpAtual = saldoVida;
        System.out.println(this.nome + " tomou " + dano + " de dano. HP: " + hpAtual);
    }
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

    }
}
