package sys.shop.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
    @NamedQuery(name = "Loja.findAll", query = "SELECT l FROM Loja l"),
    @NamedQuery(name = "Loja.findByLojId", query = "SELECT l FROM Loja l WHERE l.lojId = :lojId"),
    @NamedQuery(name = "Loja.findByLojNome", query = "SELECT l FROM Loja l WHERE l.lojNome = :lojNome"),
    @NamedQuery(name = "Loja.findByLojTelefone", query = "SELECT l FROM Loja l WHERE l.lojTelefone = :lojTelefone"),
    @NamedQuery(name = "Loja.findByLojEndereco", query = "SELECT l FROM Loja l WHERE l.lojEndereco = :lojEndereco"),
    @NamedQuery(name = "Loja.findByLojCnpj", query = "SELECT l FROM Loja l WHERE l.lojCnpj = :lojCnpj"),
    @NamedQuery(name = "Loja.findByLojStatus", query = "SELECT l FROM Loja l WHERE l.lojStatus = :lojStatus"),
    @NamedQuery(name = "Loja.findByLojCelular", query = "SELECT l FROM Loja l WHERE l.lojCelular = :lojCelular"),
    @NamedQuery(name = "Loja.findByLojDtcadastro", query = "SELECT l FROM Loja l WHERE l.lojDtcadastro = :lojDtcadastro"),
    @NamedQuery(name = "Loja.findByLojDescricao", query = "SELECT l FROM Loja l WHERE l.lojDescricao = :lojDescricao")})
public class Loja implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final Character LOJ_STATUS_ATIVA = '1';
    public static final Character LOJ_STATUS_INATIVA = '0';
    
    @Id
    @SequenceGenerator(name = "loja", sequenceName = "s_loja", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loja" )
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
    
    @Column(name = "loj_end_num")
    private Integer lojEndNum;
    
    @Column(name = "loj_bairro")
    private String lojBairro;
    
    @Column(name = "loj_cep")
    private String lojCep;
    
    @Column(name = "cid_id")
    private Integer cidId;

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
        return lojStatus == null || lojStatus == 0 ? LOJ_STATUS_INATIVA : LOJ_STATUS_ATIVA;
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
    
    public Integer getLojEndNum() {
        return lojEndNum;
    }

    public void setLojEndNum(Integer lojEndNum) {
        this.lojEndNum = lojEndNum;
    }

    public String getLojBairro() {
        return lojBairro;
    }

    public void setLojBairro(String lojBairro) {
        this.lojBairro = lojBairro;
    }

    public String getLojCep() {
        return lojCep;
    }

    public void setLojCep(String lojCep) {
        this.lojCep = lojCep;
    }

    public Integer getCidId() {
        return cidId;
    }

    public void setCidId(Integer cidId) {
        this.cidId = cidId;
    }
    
    public boolean isAtiva() {
        return lojStatus == null || lojStatus == 0 ? false : true;
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
        return "sys.shop.entity.Loja[ lojId=" + lojId + " ]";
    }
    
}
