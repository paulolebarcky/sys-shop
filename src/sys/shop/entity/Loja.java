package sys.shop.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Representa a entidade relacionada a loja.
 * 
 * @author paulo
 * @since 2012-09-09
 */
@Entity
@Table(name = "loj_loja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LojLoja.findAll", query = "SELECT l FROM LojLoja l"),
    @NamedQuery(name = "LojLoja.findByLojId", query = "SELECT l FROM LojLoja l WHERE l.lojId = :lojId"),
    @NamedQuery(name = "LojLoja.findByLojNome", query = "SELECT l FROM LojLoja l WHERE l.lojNome = :lojNome"),
    @NamedQuery(name = "LojLoja.findByLojTelefone", query = "SELECT l FROM LojLoja l WHERE l.lojTelefone = :lojTelefone"),
    @NamedQuery(name = "LojLoja.findByLojEndereco", query = "SELECT l FROM LojLoja l WHERE l.lojEndereco = :lojEndereco"),
    @NamedQuery(name = "LojLoja.findByLojCnpj", query = "SELECT l FROM LojLoja l WHERE l.lojCnpj = :lojCnpj"),
    @NamedQuery(name = "LojLoja.findByLojStatus", query = "SELECT l FROM LojLoja l WHERE l.lojStatus = :lojStatus"),
    @NamedQuery(name = "LojLoja.findByLojCelular", query = "SELECT l FROM LojLoja l WHERE l.lojCelular = :lojCelular"),
    @NamedQuery(name = "LojLoja.findByLojDtcadastro", query = "SELECT l FROM LojLoja l WHERE l.lojDtcadastro = :lojDtcadastro"),
    @NamedQuery(name = "LojLoja.findByLojDescricao", query = "SELECT l FROM LojLoja l WHERE l.lojDescricao = :lojDescricao")})
public class Loja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "loj_id")
    private Integer lojId;
    @Column(name = "loj_nome")
    private String lojNome;
    @Column(name = "loj_telefone")
    private String lojTelefone;
    @Column(name = "loj_endereco")
    private String lojEndereco;
    @Column(name = "loj_cnpj")
    private String lojCnpj;
    @Column(name = "loj_status")
    private Character lojStatus;
    @Column(name = "loj_celular")
    private String lojCelular;
    @Column(name = "loj_dtcadastro")
    @Temporal(TemporalType.DATE)
    private Date lojDtcadastro;
    @Column(name = "loj_descricao")
    private String lojDescricao;

    public Loja() {
    }

    public Loja(Integer lojId) {
        this.lojId = lojId;
    }

    public Integer getLojId() {
        return lojId;
    }

    public void setLojId(Integer lojId) {
        this.lojId = lojId;
    }

    public String getLojNome() {
        return lojNome;
    }

    public void setLojNome(String lojNome) {
        this.lojNome = lojNome;
    }

    public String getLojTelefone() {
        return lojTelefone;
    }

    public void setLojTelefone(String lojTelefone) {
        this.lojTelefone = lojTelefone;
    }

    public String getLojEndereco() {
        return lojEndereco;
    }

    public void setLojEndereco(String lojEndereco) {
        this.lojEndereco = lojEndereco;
    }

    public String getLojCnpj() {
        return lojCnpj;
    }

    public void setLojCnpj(String lojCnpj) {
        this.lojCnpj = lojCnpj;
    }

    public Character getLojStatus() {
        return lojStatus;
    }

    public void setLojStatus(Character lojStatus) {
        this.lojStatus = lojStatus;
    }

    public String getLojCelular() {
        return lojCelular;
    }

    public void setLojCelular(String lojCelular) {
        this.lojCelular = lojCelular;
    }

    public Date getLojDtcadastro() {
        return lojDtcadastro;
    }

    public void setLojDtcadastro(Date lojDtcadastro) {
        this.lojDtcadastro = lojDtcadastro;
    }

    public String getLojDescricao() {
        return lojDescricao;
    }

    public void setLojDescricao(String lojDescricao) {
        this.lojDescricao = lojDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lojId != null ? lojId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loja)) {
            return false;
        }
        Loja other = (Loja) object;
        if ((this.lojId == null && other.lojId != null) || (this.lojId != null && !this.lojId.equals(other.lojId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sys.shop.entity.LojLoja[ lojId=" + lojId + " ]";
    }
    
}
