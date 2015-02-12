package blu.macaw.tasatisfeito;

/**
 * Created by Adriano on 07/02/2015.
 */
public class Onibus {
    private String codigoLinha;
    private String letreiroIda;
    private String letreiroVolta;
    private int prefixoLinha;
    private int tipo;

    public Onibus() {
    }

    public Onibus(String codigoLinha,String letreiroIda,String letreiroVolta,int prefixoLinha,int tipo) {
        super();
        this.codigoLinha = codigoLinha;
        this.letreiroIda = letreiroIda;
        this.letreiroVolta = letreiroVolta;
        this.prefixoLinha = prefixoLinha;
        this.tipo = tipo;
    }

    public String getCodigoLinha() {
        return codigoLinha;
    }

    public void setCodigoLinha(String codigoLinha) {
        this.codigoLinha = codigoLinha;
    }

    public String getLetreiroIda() {
        return letreiroIda;
    }

    public void setLetreiroIda(String letreiroIda) {
        this.letreiroIda = letreiroIda;
    }

    public String getLetreiroVolta() {
        return letreiroVolta;
    }

    public void setLetreiroVolta(String letreiroVolta) {
        this.letreiroVolta = letreiroVolta;
    }

    public int getPrefixoLinha() {
        return prefixoLinha;
    }

    public void setPrefixoLinha(int prefixoLinha) {
        this.prefixoLinha = prefixoLinha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return codigoLinha;
    }
}
