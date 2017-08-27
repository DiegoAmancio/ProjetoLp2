package usuario;

import java.util.Comparator;

/**
 * representa um comparador de usuarios usando o parametro Reputação;
 * @author Diego Amancio - 116210716
 *
 */
public class UsuarioReputacaoComparator implements Comparator<Usuario> {
	/**
	 * compara os usuarios atraves de sua reputação
	 */
	@Override
	public int compare(Usuario o1, Usuario o2) {
		double reputacao1 = o1.getReputacao();
		double reputacao2 = o2.getReputacao();

		if (reputacao1 < reputacao2) {
			return 1;
		} else if (reputacao1 > reputacao2) {
			return -1;
		}
		return 0;
	}

}
