package Jogos;

import Enums.Plataforma;
import Item.Item;

public class JogoEletronico extends Item{
	private Plataforma plataforma;	
	
	public JogoEletronico(String nome, double preco, String plataforma) {
		super(nome, preco);
		verificaPlataforma(plataforma);
	}
	
	public void verificaPlataforma(String plataforma){
		switch(plataforma.trim().toUpperCase()){
			case "PC":
				this.plataforma = Plataforma.PC;
				break;
			case "MAC":
				this.plataforma = Plataforma.MAC;
				break;
			case "PS3":
				this.plataforma = Plataforma.PS3;
				break;
			case "PS4":
				this.plataforma = Plataforma.PS4;
				break;
			case "XBOX_360":
				this.plataforma = Plataforma.XBOX360;
				break;
			case "XBOX_ONE":
				this.plataforma = Plataforma.XBOX_ONE;
				break;
			case "NINTENDO_3DS":
				this.plataforma = Plataforma.NINTENDO_3DS;
				break;
			case "OUTRO":
				this.plataforma = Plataforma.OUTRO;
				break;							
			default:
				throw new IllegalArgumentException();
		}
	}
	
	
	
	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}
	
	@Override
	public String getInfoItem(String atributo) {
		String info = super.getInfoItem(atributo);
		switch (atributo) {
		case "Plataforma":
			info += this.getPlataforma();
			return info;
		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogoEletronico other = (JogoEletronico) obj;
		if (plataforma != other.plataforma)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JOGO ELETRONICO: " + super.toString() + ", " + getPlataforma().getValor();
	}
	
	
	

}
