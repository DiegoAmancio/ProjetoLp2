package pacotePrincipal;

import java.io.IOException;


import dados.GravaDados;
import dados.RecuperarDados;
import usuario.UsuarioController;

/**
 * representa a facade para acesso ao sistema
 * 
 * @author Diego Amancio - 11621016
 *
 */
public class Facade {
	/**
	 * 
	 */
	
	UsuarioController controllerUsuario;
	

	/**
	 * constroi a facade
	 * @throws IOException
	 */
	public Facade() throws IOException {
		controllerUsuario = new UsuarioController();
		iniciarSistema();
	}

	/**
	 * Inicia o sistema. O parametro true � usado para que n�o haja sobrescrita do
	 * arquivo
	 * @throws IOException 
	 */

	public void iniciarSistema() throws IOException {
		RecuperarDados recupera = new RecuperarDados();
		recupera.getDados();
	}

	public void fecharSistema() throws IOException {
		GravaDados.salvaDados();
	}

	/**
	 * passa as informações para o usuario controller para o cadastro do usuario
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param email
	 *            email do usuario
	 */
	public void cadastrarUsuario(String nome, String telefone, String email) {
		controllerUsuario.cadastrarUsuario(nome, telefone, email);
	}

	/**
	 * pede ao controller Usuario a informação do usuario
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param atributo
	 *            atributo do usuario
	 * @return a informação do usuario
	 */
	public String getInfoUsuario(String nome, String telefone, String atributo) {
		return controllerUsuario.getInfoUsuario(nome, telefone, atributo);
	}

	/**
	 * pede ao controller Usuario para remover o usuario com as informações
	 * repasadas
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 */
	public void removerUsuario(String nome, String telefone) {
		controllerUsuario.removerUsuario(nome, telefone);
	}

	/**
	 * pede ao usuario controller para atualizar a informação especificada do
	 * usuario
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param atributo
	 *            atributo do usuario a ser modificado
	 * @param valor
	 *            nova informacao para o atributo do usuario
	 */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		controllerUsuario.atualizarUsuario(nome, telefone, atributo, valor);
	}

	/**
	 * pede ao usuario controller para pegar a informação requisitada do item de
	 * um usuario
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param atributo
	 *            atributo do item a ser visto
	 * @param nomeItem
	 *            nome do item
	 * @return a informação do item no qual foi requisitada.
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		return controllerUsuario.getInfoItem(nome, telefone, nomeItem, atributo);
	}

	/**
	 * 
	 * pede ao usuario controller para cadastrar um jogo Eletronico
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preço do item
	 * @param plataforma
	 *            plataforma do item
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		controllerUsuario.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	/**
	 * pede ao usuario controller para cadastrar um jogo de tabuleiro
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preço do item
	 */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		controllerUsuario.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		controllerUsuario.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);

	}

	/**
	 * pede ao usuario controller para cadastrar um filme
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preço do item
	 * @param duracao
	 *            duração do item
	 * @param classificacao
	 *            classificação do item
	 * @param genero
	 *            genero do item
	 * @param anoLancamento
	 *            ano de lançamento do item
	 */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		controllerUsuario.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao,
				anoLancamento);
	}

	/**
	 * pede ao usuario controller para cadastra um show
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preço do item
	 * @param duracao
	 *            duração do item
	 * @param classificacao
	 *            classificação do item
	 * @param artista
	 *            nome do artista
	 * @param numeroFaixas
	 *            numero de faixas do show
	 */
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		controllerUsuario.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, numeroFaixas, artista,
				classificacao);
	}

	/**
	 * pede ao usuario controller para cadastra uma serie
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preço do item
	 * @param descricao
	 *            descrição do item
	 * @param duracao
	 *            duração do item
	 * @param classificacao
	 *            classificação do item
	 * @param genero
	 *            genero do item
	 * @param numeroDaTemporada
	 *            numero da temporada da serie
	 */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int numeroDaTemporada) {
		controllerUsuario.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao,
				genero, numeroDaTemporada);
	}

	public void adicionarBluRay(String nome, String telefone, String nomeBlueRayTemporada, int duracao) {
		controllerUsuario.adicionarBluRay(nome, telefone, nomeBlueRayTemporada, duracao);
	}

	/**
	 * pede ao usuario controller para remover um item do sistema e do usuario
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item a ser removido
	 */
	public void removerItem(String nome, String telefone, String nomeItem) {
		controllerUsuario.removerItem(nome, telefone, nomeItem);
	}

	/**
	 * pede ao usuario controller para atualizar informações de um item
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param atributo
	 *            atributo do item
	 * @param valor
	 *            nova informação
	 */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		controllerUsuario.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}

	/**
	 * pede ao usuario controller para listar os itens ordenados pelo nome
	 * 
	 * @return retorna uma lista de itens ordenados eusando como referencial o nome
	 *         do item;
	 */
	public String listarItensOrdenadosPorNome() {
		return controllerUsuario.listarItensOrdenadosPorNome();
	}

	/**
	 * pede ao usuario controller para listar os itens ordenados pelo valor
	 * 
	 * @return retorna uma lista de itens ordenados eusando como referencial o valor
	 *         do item;
	 */
	public String listarItensOrdenadosPorValor() {
		return controllerUsuario.listarItensOrdenadosPorValor();
	}

	/**
	 * pede ao usuario controller para pesquisar detalhes especificos de um item;
	 * 
	 * @param nome
	 *            nome do usuario dono do item
	 * @param telefone
	 *            telefone do usuario dono do item
	 * @param nomeItem
	 *            nome do item a ser pesquisado
	 * @return retorna informações sobre o item procurado
	 */
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		return controllerUsuario.pesquisarDetalhesItem(nome, telefone, nomeItem);
	}

	/**
	 * pede ao usuario controller para:
	 * 
	 * Registra emprestimos, passos: Primeiro, checa se o usuario tem determinado
	 * item para emprestar, se sim, verifica o status do item (se esta emprestado ou
	 * nao), se nao estiver emprestado, realiza emprestimo.
	 * 
	 * @param nomeDono
	 *            nome do dono do item a ser emprestado
	 * @param telefoneDono
	 *            telefone do dono do item a ser emprestado
	 * @param nomeRequerente
	 *            nome do usuario que esta requisitando o item
	 * @param telefoneRequerente
	 *            telefone do usuario que esta requisitando o item
	 * @param itemEmprestado
	 *            nome do item a ser emprestado
	 * @param dataEmprestimo
	 *            inicio do emprestimo
	 * @param periodo
	 *            periodo limite que o usuario pode ficar com o item
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String itemEmprestado, String dataEmprestimo, int periodo) {
		controllerUsuario.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente,
				itemEmprestado, dataEmprestimo, periodo);
	}

	/**
	 * pede ao usuario controller para: Devolve item e muda o status do item para
	 * NAO EMPRESTADO.
	 * 
	 * @param nomeDono
	 *            nome do dono do item
	 * @param telefoneDono
	 *            telefone do dono do item
	 * @param nomeRequerente
	 *            nome do usuario que esta devolvendo o item emprestado
	 * @param telefoneRequerente
	 *            telefone do usuario que esta devolvendo o item
	 * @param nomeItem
	 *            nome do item que foi emprestado
	 * @param dataEmprestimo
	 *            data em que o item foi emprestado.
	 * @param dataDevolucao
	 *            data de entrega do item
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		controllerUsuario.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
				dataEmprestimo, dataDevolucao);
	}

	/**
	 * pede ao usuario controller para listar os itens que o usuario emprestou
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @return a informação sobre os itens que o usuario em questao emprestou;
	 * 
	 */
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		return controllerUsuario.listarEmprestimosUsuarioEmprestando(nome, telefone);
	}

	/**
	 * pede ao usuario controller para listar os itens que o usuario pegou
	 * emprestado
	 * 
	 *
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @return a informação sobre os itens que o usuario em questao pegou
	 *         emprestado;
	 */
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		return controllerUsuario.listarEmprestimosUsuarioPegandoEmprestado(nome, telefone);
	}

	/**
	 * pede ao usuario controller para listar o historicos de emprestimos envolvidos
	 * com este item.
	 * 
	 * @param nomeItem
	 *            nome do item
	 * @return uma lista dos emprestimos associados a este item.
	 */
	public String listarEmprestimosItem(String nomeItem) {
		return controllerUsuario.listarEmprestimosItem(nomeItem);
	}

	/**
	 * pede ao usuario controller para listar os itens não emprestados no sistema
	 * 
	 * @return lista os objetos não emprestados no sistema
	 */
	public String listarItensNaoEmprestados() {
		return controllerUsuario.listarItensNaoEmprestados();
	}

	/**
	 * pede ao usuario controller para listar os itens emprestados no sistema
	 * 
	 * @return lista os objetos emprestados no sistema
	 */
	public String listarItensEmprestados() {
		return controllerUsuario.listarItensEmprestados();
	}

	/**
	 * pede ao usuario controller para listar os itens mais emprestados no sistema
	 * 
	 * @return lista em ordem decrescente o item que foi mais emprestado ao que foi
	 *         menos intervalo [0,9].
	 */
	public String listarTop10Itens() {
		return controllerUsuario.listarTop10Itens();
	}

	/**
	 * pede ao usuario controller para listar os caloteiros.
	 * 
	 * @return uma lista cntendo os inadiplentes do sistema
	 */
	public String listarCaloteiros() {
		return controllerUsuario.listarCaloteiros();
	}

	/**
	 * pede ao usuario controller para listar o top 10 dos usuarios com as piores
	 * reputações.
	 * 
	 * @return uma lista ordenada do usuario que tem a pior reputação ate o que
	 *         tem a maior reputação em um intervalo de 0 a 9 fechado.
	 */
	public String listarTop10PioresUsuarios() {
		return controllerUsuario.listarTop10PioresUsuarios();
	}

	/**
	 * pede ao usuario controller para listar o top 10 dos usuarios com melhores
	 * reputações.
	 * 
	 * @return uma lista ordenada do usuario que tem melhor reputação ate o que
	 *         tem a menor reputação em um intervalo de 0 a 9 fechado.
	 */
	public String listarTop10MelhoresUsuarios() {
		return controllerUsuario.top10MelhoresUsuarios();
	}

}
