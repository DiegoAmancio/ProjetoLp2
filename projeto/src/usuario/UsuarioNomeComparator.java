package usuario;

import java.util.Comparator;
/**
 * representa um comparador de usuarios usando o parametro nome
 * @author Diego Amancio - 116210716
 *
 */
public class UsuarioNomeComparator implements Comparator<Usuario>{
	/**
	 * compara os usuarios atraves do nome
	 */
	@Override
	public int compare(Usuario o1, Usuario o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}
