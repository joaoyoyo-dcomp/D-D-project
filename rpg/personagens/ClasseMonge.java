package rpg.personagens;

public class ClasseMonge extends Jogador {

    public ClasseMonge(String nome, int nivel, int idade, double altura, double peso, String linhagem, String antecedente, FichaGeral ficha){
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
    @Override
    public void calcularCA() {
        if(this.armadura == null || this.armadura.equalsIgnoreCase("nenhuma")) {
            int modDex = ficha.getModificador(ficha.getDestreza());
            int modSab = ficha.getModificador(ficha.getSabedoria());
            int caMonge = 10 + modDex + modSab;

            System.out.println("CA de Bárbaro (Sem Armadura): " + caMonge);
        }else{
            super.calcularCA();
        }
    }
}

