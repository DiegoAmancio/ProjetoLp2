package midias;

import Enums.Plataformas;
import pacotePrincipal.Item;

public class JogoEletronico extends Item{
	private Plataformas plataforma;	
	
	public JogoEletronico(String nome, int preco, String plataforma) {
		super(nome, preco);
		verificaPlataforma(plataforma);
	}
	
	public void verificaPlataforma(String plataforma){
		switch(plataforma.trim().toUpperCase()){
			case "PC":
				this.plataforma = Plataformas.PC;
				break;
			case "MAC":
				this.plataforma = Plataformas.MAC;
				break;
			case "PS3":
				this.plataforma = Plataformas.PS3;
				break;
			case "PS4":
				this.plataforma = Plataformas.PS4;
				break;
			case "XBOX 360":
				this.plataforma = Plataformas.XBOX360;
				break;
			case "XBOX ONE":
				this.plataforma = Plataformas.XBOX_ONE;
				break;
			case "NINTENDO 3DS":
				this.plataforma = Plataformas.NINTENDO_3DS;
				break;
			case "OUTRO":
				this.plataforma = Plataformas.OUTRO;
				break;							
			default:
				throw new IllegalArgumentException();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogoEletronico other = (JogoEletronico) obj;
		if (plataforma == null) {
			if (other.plataforma != null)
				return false;
		} else if (!plataforma.equals(other.plataforma))
			return false;
		return true;
	}
	
	

}
