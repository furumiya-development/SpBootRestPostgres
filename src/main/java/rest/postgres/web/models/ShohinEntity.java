package rest.postgres.web.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ShohinData", schema="public", catalog="SpringBootPostgres")
public class ShohinEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NumId", columnDefinition = "int", nullable = false)
	private Integer _NumId;

	@Column(name = "ShohinNum", columnDefinition = "smallint", nullable = false)
	private Short _ShohinCode;

	@Column(name = "ShohinName", columnDefinition = "char(50)", length = 50)
	private String _ShohinName;

	@Column(name = "EditDate", columnDefinition = "decimal(8, 0)", precision = 8, scale = 0, nullable = false)
	private BigDecimal _EditDate;

	@Column(name = "EditTime", columnDefinition = "decimal(6, 0)", precision = 6, scale = 0, nullable = false)
	private BigDecimal _EditTime;

	@Column(name = "Note", columnDefinition = "varchar(255)", length = 50)
	private String _Note;

	public ShohinEntity() {
		super();
	}

	public ShohinEntity(Short Code, String Name, BigDecimal Date, BigDecimal Time, String Note) {
		super();
		_ShohinCode = Code;
		_ShohinName = Name;
		_EditDate = Date;
		_EditTime = Time;
		this._Note = Note;
	}

	public Integer getNumId() {
		return _NumId;
	}
	public void setNumId(Integer value) {
		_NumId = value;
	}

	public Short getShohinCode() {
		return _ShohinCode;
	}
	public void setShohinCode(Short value) {
		_ShohinCode = value;
	}

	public String getShohinName() {
		return _ShohinName;
	}
	public void setShohinName(String value) {
		_ShohinName = value;
	}

	public BigDecimal getEditDate() {
		return _EditDate;
	}
	public void setEditDate(BigDecimal value) {
		_EditDate = value;
	}

	public BigDecimal getEditTime() {
		return _EditTime;
	}
	public void setEditTime(BigDecimal value) {
		_EditTime = value;
	}

	public String getNote() {
		return _Note;
	}
	public void setNote(String value) {
		_Note = value;
	}
}