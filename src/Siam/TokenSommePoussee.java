package Siam;

public class TokenSommePoussee {

    private int somme;
    private boolean peutEtreNull;

    public TokenSommePoussee(){
        somme = 0;
        peutEtreNull = false;
    }

    public TokenSommePoussee(int somme, boolean peutEtreNull){
        this.somme = somme;
        this.peutEtreNull = peutEtreNull;
    }

    public boolean isPeutEtreNull() {
        return peutEtreNull;
    }

    public int getSomme() {
        return somme;
    }

    public void addSomme(int a){
        somme += a;
    }

    public void setSomme(int somme) {
        this.somme = somme;
    }

    public void setPeutEtreNull(boolean peutEtreNull) {
        this.peutEtreNull = peutEtreNull;
    }
}