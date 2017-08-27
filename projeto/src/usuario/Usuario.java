package usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bluRay.BluRaySerie;
import emprestismo.Emprestimo;
import emprestismo.EmprestimoComparator;
import enums.CartaoFidelidade;

import enums.Emprestado;
import item.Item;

/**
 * representacao de um usuario
 * 
 * 
 * Laboratorio de Programacao 2 - projeto
 * 
 * @author Diego Amancio - 116210716
 */
public class Usuario {
	private String nome;
	private String telefone;
	private String email;
	private Map<String, Item> itens;
	private List<Emprestimo> emprestou;
	private List<Emprestimo> pegouEmprestado;
	private double reputacao;
	private CartaoFidelidade cartao;

	/**
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param email
	 *            email do usuario
	 */
	public Usuario(String nome, String telefone, String email) {

		validaUsuarioAtributo(nome, "Nome");
		validaUsuarioAtributo(telefone, "Telefone");
		validaUsuarioAtributo(email, "Email");

		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.itens = new HashMap<String, Item>();
		emprestou = new ArrayList<Emprestimo>();
		pegouEmprestado = new ArrayList<Emprestimo>();
		this.reputacao = 0;
		this.cartao = CartaoFidelidade.FREE_RIDER;
	}

	public void abaixaReputacao(double preco, int diasAtrasados) {

		double diminuir = (preco * (diasAtrasados * 0.01));
		setReputacao(this.reputacao - diminuir);
		calcularTipoCartao();

	}
	public void adicionarBluRay(String nomeItem, int duracao) {
		Item item = getItem(nomeItem);
		if (item instanceof BluRaySerie) {
			BluRaySerie bluRaySerie = (BluRaySerie) item;
			bluRaySerie.adicionaEpisodio(duracao);
		} else {
			throw new IllegalArgumentException("Esse item nao se trata de uma Serie");
		}
	}
	/**
	 * verifica se um item esta emprestado
	 * 
	 * @param item
	 *            item a ser verificado
	 */
	public void taEmprestado(String item) {
		if (getItem(item).getEmprestado() == Emprestado.EMPRESTADO) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}
	}

	public void adicionaItem(String nomeItem, Item item) {
		if (!(itens.containsKey(nomeItem))) {
			sobeReputacao(item.getPreco(), "");
			itens.put(nomeItem, item);

		}
		calcularTipoCartao();
	}

	/**
	 * atualiza o preco do item
	 * 
	 * @param nomeItem
	 *            nome do item
	 * @param atributo
	 *            atributo do item
	 * @param valor
	 *            valor do item
	 */
	public void atualizarItem(String nomeItem, String atributo, String valor) {
		if (itens.containsKey(nomeItem)) {
			switch (atributo.trim().toUpperCase()) {

			case "PRECO":
				double novoValor = Double.parseDouble(valor);
				itens.get(nomeItem).setPreco(novoValor);
				break;
			case "NOME":
				Item item = itens.get(nomeItem);
				itens.remove(nomeItem);
				itens.put(valor, item);
				itens.get(valor).setNome(valor);
				break;
			default:
				throw new IllegalArgumentException();
			}
		} else {
			throw new NullPointerException("Item nao encontrado");
		}
	}

	public void calcularTipoCartao() {

		if (this.reputacao >= 0 && this.reputacao <= 100) {
			setCartao(CartaoFidelidade.NOOB);
		} else if (this.reputacao > 100) {
			setCartao(CartaoFidelidade.BOM_AMIGO);
		} else if (this.reputacao < 0) {
			setCartao(CartaoFidelidade.CALOTEIRO);
		} else {
			setCartao(CartaoFidelidade.FREE_RIDER);
		}
	}

	public void empresta(Emprestimo novoEmprestimo, String nomeItem) {
		emprestou.add(novoEmprestimo);
		sobeReputacao(getItem(nomeItem).getPreco(), "Emprestou");
		itens.get(nomeItem).setEmprestado(Emprestado.EMPRESTADO);
	}

	/**
	 * verifica se o emprestimo existe
	 * 
	 * @param nomeItem
	 *            nome do item
	 * @param nomeRequerente
	 *            nome do usuario que pegou o item emprestado
	 * @throws NullPointerException
	 *             joga um nullpointerException falando que o emprestimo não foi
	 *             encontrado
	 * @return o emprestimo
	 */
	public Emprestimo existeEmprestimo(String nomeItem, String nomeRequerente) {

		for (Emprestimo emprestimo : emprestou) {
			if (emprestimo.getItemEmprestado().equals(nomeItem)
					&& emprestimo.getNomeRequerente().equals(nomeRequerente)) {
				return emprestimo;
			}
		}

		throw new NullPointerException("Emprestimo nao encontrado");

	}

	/**
	 * verifica se o item existe
	 * 
	 * @param nomeItem
	 *            nome do item
	 */
	public void existeItem(String nomeItem) {
		if (!itens.containsKey(nomeItem)) {
			throw new NullPointerException("Item nao encontrado");
		}
	}

	/**
	 * fecha um emprestimo
	 * 
	 * @param dataEntrega
	 *            dataq de entrega do item
	 * @param emprestimo
	 *            emrpestimo no qual esta sendo fechado
	 */
	public void fechandoEmprestimo(String dataEntrega, Emprestimo emprestimo) {
		for (int i = 0; i < emprestou.size(); i++) {
			Emprestimo emprestimoLista = emprestou.get(i);
			if (emprestimoLista.equals(emprestimo)) {
				emprestimoLista.fechandoEmprestimo(dataEntrega);

			}
		}
	}

	/**
	 * Retorna o preco do item
	 * 
	 * @param nomeItem nome do item
	 * @param atributo atributo do item
	 * @return retorna o item em txt
	 */
	public String getInfoItem(String nomeItem, String atributo) {
		if (itens.containsKey(nomeItem)) {
			switch (atributo.trim().toUpperCase()) {
			case "PRECO":
				return Double.toString(itens.get(nomeItem).getPreco());
			case "NOME":
				return itens.get(nomeItem).getNome();
			default:
				throw new IllegalArgumentException();
			}
		} else {
			throw new IllegalArgumentException("Item nao encontrado");
		}
	}

	/**
	 * reune informações dos emprestimos em que o usuario emprestou um item
	 * 
	 * @return uma lista dos emprestimos no qual este usuario participou como
	 *         requirinte do item
	 */
	public String listarItensEmprestados() {
		String saida = "Emprestimos: ";
		Collections.sort(emprestou, new EmprestimoComparator());
		if (emprestou.size() > 0) {
			for (int i = 0; i < emprestou.size(); i++) {
				saida += emprestou.get(i).toString();
			}
			return saida;
		} else {
			return ("Nenhum item emprestado");
		}
	}

	/**
	 * reune informações dos emrpestimos em que o usuario pegou emprestado um
	 * item
	 * 
	 * @return uma lista dos emprestimos no qual este usuario participou como
	 *         requirinte do item
	 */
	public String listarItensPegouEmprestado() {
		String saida = "Emprestimos pegos: ";
		Collections.sort(emprestou, new EmprestimoComparator());
		if (pegouEmprestado.size() > 0) {
			for (int i = 0; i < pegouEmprestado.size(); i++) {
				saida += pegouEmprestado.get(i).toString();
			}
			return saida;
		} else {
			return ("Nenhum item pego emprestado");
		}
	}

	public void pegaEmprestado(Emprestimo novoEmprestimo, String nomeItem) {
		pegouEmprestado.add(novoEmprestimo);
	}

	/**
	 * remove um item
	 * 
	 * @param nomeItem
	 *            nome do item a ser removido
	 */
	public void removerItem(String nomeItem) {
		if (itens.containsKey(nomeItem)) {
			itens.remove(nomeItem);
		} else {
			throw new NullPointerException("Item nao encontrado");
		}
	}

	/**
	 * sobe a reputacao de usuarios
	 * 
	 * @param preco
	 *            valor do item
	 * @param situacao
	 *            verifica se ele emprestou ou esta pegando emprestado
	 */
	public void sobeReputacao(double preco, String situacao) {
		double valor = 0;
		if (situacao.equals("Emprestou")) {
			valor = this.reputacao + (preco * 0.1);
		} else {
			valor = this.reputacao + (preco * 0.05);
		}
		setReputacao(valor);
		calcularTipoCartao();

	}

	/**
	 * valida os atributos nos quais o usuario vai ser criado
	 * 
	 * @param atributo
	 *            atribuo testado
	 * @param qualAtributo
	 *            representação em texto de qual tipo(nome, telefone e etc) e o
	 *            atributo a ser testado
	 */
	public void validaUsuarioAtributo(String atributo, String qualAtributo) {
		if (atributo == null) {
			throw new NullPointerException(qualAtributo + "invalido,nulo");
		}
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException(qualAtributo + "invalido,vazio");
		}
	}

	/**
	 * compara um usuario com este.
	 * 
	 * @param usuario
	 *            usuario a ser comparado
	 * @return se o usuario e igual ao dono deste metodo.
	 */
	public boolean equals(Usuario usuario) {
		boolean saida = false;
		if (usuario.getNome().equals(this.nome)) {
			if (usuario.getTelefone().equals(this.telefone)) {
				saida = true;
			}
		}
		return saida;
	}

	public String getDetalhes(String nomeItem) {
		if (itens.containsKey(nomeItem)) {
			return itens.get(nomeItem).toString();
		}
		throw new NullPointerException("Item nao encontrado");
	}

	public Item getItem(String itemEmprestado) {
		return itens.get(itemEmprestado);
	}

	public CartaoFidelidade getCartao() {
		return cartao;
	}

	public double getReputacao() {
		return reputacao;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getCartaoTxt() {
		return cartao.getMensagem();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setReputacao(double reputacao) {
		this.reputacao = reputacao;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCartao(CartaoFidelidade cartao) {
		this.cartao = cartao;
	}

	/**
	 * representacao de um usuario
	 */
	@Override
	public String toString() {
		return nome + ", " + email + ", " + telefone;
	}

}
