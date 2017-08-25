package item;

import java.util.Comparator;

import usuario.Usuario;

public class ReputacaoComparatorInverso implements Comparator<Usuario> {
	@Override
	public int compare(Usuario o1, Usuario o2) {
		double reputacao1 = o1.getReputacao();
		double reputacao2 = o2.getReputacao();

		if (reputacao1 < reputacao2) {
			return -1;
		} else if (reputacao1 > reputacao2) {
			return 1;
		}
		return 0;
	}
}
