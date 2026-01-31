package rpg.personagens;

public abstract class Jogador {
    protected String nome;
    protected int nivel;
    protected int idade;
    protected double altura;
    protected double peso;
    protected String linhagem;
    protected String antecedente;
    protected FichaGeral ficha;
    protected String armadura;
    protected boolean estaMorto = false;
    protected int dadosDeVidaTotais;
    protected int dadosDeVidaAtuais; 
    protected int hpMaximo;
    protected int hpAtual;

    public Jogador(String nome, int nivel, int idade, double altura, double peso, String linhagem, String antecedente, FichaGeral ficha, String armadura){
        this.nome = nome;
        this.nivel = nivel;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.linhagem = linhagem;
        this.antecedente = antecedente;
        this.ficha = ficha;
        this.armadura = armadura;
        this.dadosDeVidaTotais = this.nivel;
        this.dadosDeVidaAtuais = this.dadosDeVidaTotais;
    }

    public Jogador(String nome2, int nivel2, int idade2, double altura2, double peso2, String linhagem2,
            String antecedente2, FichaGeral ficha2) {
        //TODO Auto-generated constructor stub
    }

    public boolean isMorto() {
        return this.estaMorto;
    }

    public void realizarDescansoLongo(){
        System.out.println(this.nome + " vai descansar...");
        this.hpAtual = this.hpMaximo;
        
        this.dadosDeVidaAtuais += Math.max(1, this.dadosDeVidaTotais / 2);
        
        if (this.dadosDeVidaAtuais > this.dadosDeVidaTotais) {
            this.dadosDeVidaAtuais = this.dadosDeVidaTotais;
        }

        System.out.println("HP Total restaurado. Dados de Vida: " + dadosDeVidaAtuais + "/" + dadosDeVidaTotais);
    }

    public void calcularCA() {
        int modDex = ficha.getModificador(ficha.getDestreza());
        int caFinal = 10 + modDex;
        String armaduraAtual = (this.armadura == null) ? "nenhuma" : this.armadura.toLowerCase();

    switch (armaduraAtual) {
        case "acolchoada":
        case "couro":
            caFinal = 11 + modDex;
            break;
        case "couro batido":
            caFinal = 12 + modDex;
            break;
        case "gibão de peles":
            caFinal = 12 + Math.min(modDex, 2);
            break;
        case "camisão de malha":
            caFinal = 13 + Math.min(modDex, 2);
            break;
        case "brunea":
        case "peitoral":
            caFinal = 14 + Math.min(modDex, 2);
            break;
        case "meia armadura":
            caFinal = 15 + Math.min(modDex, 2);
            break;
        case "cota de anéis":
            caFinal = 14;
            break;
        case "cota de malha":
            caFinal = 16;
            break;
        case "cota de talas":
            caFinal = 17;
            break;
        case "placas":
            caFinal = 18;
            break;
        case "nenhuma":
        default:
            caFinal = 10 + modDex;
            break;
        }
    System.out.println("Classe de Armadura (CA): " + caFinal);
    }

    public void diminuirHP(int dano) {
    int saldoVida = this.hpAtual - dano;
    
    int limiteMorte = -(this.hpMaximo / 2);
    
    if (saldoVida < limiteMorte) {
        this.hpAtual = 0;
        this.estaMorto = true;
        System.out.println(this.nome + " morreu instantaneamente.");
    }
    
    else if (saldoVida <= 0) {
        this.hpAtual = 0;
        System.out.println(this.nome + " caiu inconsciente (0 HP)!");
    }
    
    else {
        this.hpAtual = saldoVida;
        System.out.println(this.nome + " tomou " + dano + " de dano. HP: " + hpAtual);
        }
    }

    public void recuperarHP(int cura){   
        if(this.hpAtual <= this.hpMaximo){
            this.hpAtual += cura;
        }
        
        if (this.hpAtual > this.hpMaximo) {
            this.hpAtual = this.hpMaximo;
        }
        System.out.println(hpAtual);
    }

    public abstract void exibirStatus();

    public abstract void calcularHP();

    public abstract void descansoCurto();
}
