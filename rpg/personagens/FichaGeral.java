
package rpg.personagens;
public class FichaGeral {
    protected int forca;
    protected int destreza;
    protected int constituicao;
    protected int inteligencia;
    protected int sabedoria;
    protected int carisma;

    public FichaGeral(int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma){
        this.forca = forca;
        this.destreza = destreza;
        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
    }
    
    public int getModificador(int atributo) {
    return (atributo - 10) / 2;
    }

    public void setForca(int forca){
        this.forca = forca;
    }
    
    public int getForca(){
        return this.forca;
    }
    
    public void setDestreza(int destreza){
        this.destreza = destreza;
    }
    
    public int getDestreza(){
        return this.destreza;
    }
    
    public void setConstituicao(int constituicao){
        this.constituicao = constituicao;
    }
    
    public int getConstituicao(){
        return this.constituicao;
    }
    
    public void setInteligencia(int inteligencia){
        this.inteligencia = inteligencia;
    }
    
    public int getInteligencia(){
        return this.inteligencia;
    }
    
    public void setSabedoria(int sabedoria){
        this.sabedoria = sabedoria;
    }
    
    public int getSabedoria(){
        return this.sabedoria;
    }
    
    public void setCarisma(int carisma){
        this.carisma = carisma;
    }
    
    public int getCarisma(){
        return this.carisma;
    }
}
