package unam.mx.SGPF.model;

public class ObjetoSP {
	private Accion acc;
	private UsuarioFuncional UF;
	private GrupoDato GD;
	private ProcesoFuncional PF;
	public Accion getAcc() {
		return acc;
	}
	public void setAcc(Accion acc) {
		this.acc = acc;
	}
	public UsuarioFuncional getUF() {
		return UF;
	}
	public void setUF(UsuarioFuncional uF) {
		UF = uF;
	}
	public GrupoDato getGD() {
		return GD;
	}
	public void setGD(GrupoDato gD) {
		GD = gD;
	}
	public ProcesoFuncional getPF() {
		return PF;
	}
	public void setPF(ProcesoFuncional pF) {
		PF = pF;
	}
	
	
}
