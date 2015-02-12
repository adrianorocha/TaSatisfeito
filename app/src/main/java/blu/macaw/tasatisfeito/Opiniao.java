package blu.macaw.tasatisfeito;

/**
 * Created by Adriano on 07/02/2015.
 */
public class Opiniao {
    int codigo;
    int prefixoLinha;
    String dataOpiniao;
    String horaOpiniao;
    String nomeUsuario;
    boolean statusOpiniao;
    char textoOpiniao;

    public Opiniao() {
    }

    public Opiniao(int codigo, int prefixoLinha,String dataOpiniao, String horaOpiniao, String nomeUsuario, boolean statusOpiniao, char textoOpiniao) {
        super();
        this.codigo = codigo;
        this.prefixoLinha = prefixoLinha;
        this.dataOpiniao = dataOpiniao;
        this.horaOpiniao = horaOpiniao;
        this.nomeUsuario = nomeUsuario;
        this.statusOpiniao = statusOpiniao;
        this.textoOpiniao = textoOpiniao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrefixoLinha() {
        return prefixoLinha;
    }

    public void setPrefixoLinha(int prefixoLinha) {
        this.prefixoLinha = prefixoLinha;
    }

    public String getDataOpiniao() {
        return dataOpiniao;
    }

    public void setDataOpiniao(String dataOpiniao) {
        this.dataOpiniao = dataOpiniao;
    }

    public String getHoraOpiniao() {
        return horaOpiniao;
    }

    public void setHoraOpiniao(String horaOpiniao) {
        this.horaOpiniao = horaOpiniao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public boolean isStatusOpiniao() {
        return statusOpiniao;
    }

    public void setStatusOpiniao(boolean statusOpiniao) {
        this.statusOpiniao = statusOpiniao;
    }

    public char getTextoOpiniao() {
        return textoOpiniao;
    }

    public void setTextoOpiniao(char textoOpiniao) {
        this.textoOpiniao = textoOpiniao;
    }

    @Override
    public String toString() {
        return nomeUsuario;
    }
}
