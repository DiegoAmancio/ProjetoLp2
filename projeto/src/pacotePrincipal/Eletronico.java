package pacotePrincipal;

import Enums.Plataforma;

public class Eletronico extends Item{
	
	private Plataforma plataforma;

	public Eletronico(String nome, double preco, String plataforma) {
		super(nome, preco);
		setPlataforma(plataforma);
	}
	
	public Plataforma getPlataforma() {
		return plataforma;
	}

	private void setPlataforma(String valor) {
		boolean valido = false;
		for (Plataforma plataforma : Plataforma.values()) {
			if (valor.equals(plataforma.getValor())) {
				this.plataforma = plataforma;
				valido = true;
				break;
			}
		}
		if (!valido) {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			if (obj instanceof Eletronico) {
				if (((Eletronico) obj).getPlataforma().equals(plataforma)) {
					return true;
				}
			}
		}
		return false;
	}

}
