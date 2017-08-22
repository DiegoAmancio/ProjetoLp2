package usuario;

import java.util.Comparator;

public class UsuarioNomeComparator implements Comparator<Usuario>{

	@Override
	public int compare(Usuario o1, Usuario o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}
