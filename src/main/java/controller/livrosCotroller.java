package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Carrinho;
import model.Carrinhos;
import model.Livro;
import model.Livros;
import model.Pedido;
import model.Pedidos;

 
@RestController
@RequestMapping("/v1")
public class livrosCotroller {
	
	Livros livros;
	Carrinho carrinho;
	Carrinhos carrinhos;
	Pedido pedido;
	Pedidos pedidos;

	ArrayList<Carrinho> listaCarrinhos;
	ArrayList<Livro> listaLivros;
	ArrayList<Pedido> listaPedidos;
	
	public livrosCotroller() {
		
		livros = new Livros();
		listaLivros = livros.getListaLivro();
		carrinho = new Carrinho();
		carrinhos = new Carrinhos();
		pedido = new Pedido();
		pedidos = new Pedidos();
		
		listaCarrinhos = carrinhos.getListaCarrinho();
		listaPedidos = pedidos.getListaPedido();
		
        Livro c1 = new Livro(1, "percy jackson", "rick r", "12323123", 30 , new ArrayList<String>());
		Livro c2 = new Livro(2, "harry potter 1", "jk r", "22455123", 35 , new ArrayList<String>());
		Livro c3 = new Livro(3, "harry potter 2", "jk r", "32455124", 35 , new ArrayList<String>());
		Livro c4 = new Livro(4, "senhor do aneis", "tokien", "40101010", 40 , new ArrayList<String>());
		
		listaLivros.add(c1);
		listaLivros.add(c2);
		listaLivros.add(c3);
		listaLivros.add(c4);


	}
	
	//METODO GET PARA BUSCAR LIVROS COM E SEM FILTROS
	@RequestMapping(value = "/public/livros", method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> pesquisaLivrosNome(@RequestParam(defaultValue="", value="nome") String nome,
		  												@RequestParam(defaultValue="", value="autor") String autor,
		  												@RequestParam(defaultValue="", value="isbn") String isbn) {
		
		if(!(listaLivros.isEmpty()) && nome.isEmpty() && autor.isEmpty() && isbn.isEmpty()) {
			return new ResponseEntity<List<Livro>>(listaLivros, HttpStatus.OK);
		}else {
			List<Livro> list = new ArrayList<Livro>();
			for (Livro livro : listaLivros) {
				if((!nome.isEmpty() && livro.getNome().equals(nome))
					  || (!autor.isEmpty() && livro.getAutor().equals(autor))
					  || (!isbn.isEmpty() && livro.getIsbn().equals(isbn))) {
				  
					list.add(livro);
				}
			}
			return new ResponseEntity<List<Livro>>(list, HttpStatus.OK);
		}
		
	}
	
	//METODO POST PARA CADASTRAR LIVROS
	@RequestMapping(value = "/private/livros", method = RequestMethod.POST)
	public String postarComentarioLivro(@RequestParam(defaultValue="", value="nome") String nome,
												@RequestParam(defaultValue="", value="autor") String autor,
												@RequestParam(defaultValue="", value="isbn") String isbn,
												@RequestParam(defaultValue="", value="preco") float preco) {

		if(!nome.isEmpty() && !autor.isEmpty() && !isbn.isEmpty()) {
			Livro novoLivro = new Livro(listaLivros.size()+1, nome, autor, isbn, preco , new ArrayList<String>());
			listaLivros.add(novoLivro);
			return "Adicionado o Livro: "+ novoLivro.toString();
		}  
		return "Erro! Adicione todos os campos: Nome, Autor, ISBN e Preço.";
		  
	}
	
	//METODO POST PARA POSTAR COMENTARIOS EM LIVROS CADASTRADOS
	@RequestMapping(value = "/public/livros/{id}/comentario", method = RequestMethod.POST)
	public String postarComentarioLivro(@PathVariable(value="id") long id, @RequestParam(defaultValue="", value="comentario") String comentario) {

		  for (Livro livro : listaLivros) {
			  if(livro.getId() == id) {
				  livro.getComentario().add(comentario);
				  return "Adicionado o comentario: "+ comentario;
			  }
		  }  
		  return "Comentario Inválido";
		  
	}
	
	//METODO GET PARA EXIBIR ITENS NO CARRINHO
	@RequestMapping(value = "/public/livros/carrinho/{session_id}", method = RequestMethod.GET)
	public ResponseEntity<Carrinho> pesquisaLivrosNome(@PathVariable(value="session_id") String idCarrinho) {
	  
		for (Carrinho car : listaCarrinhos) {
			if(car.getId() == Long.parseLong(idCarrinho)) {
				return new ResponseEntity<Carrinho>(car, HttpStatus.OK);
			}
		}
	  
		return null;
	}
	
	//METODO POST PARA ADICINAR ITENS(LIVROS) NO CARRINHO DE COMPRAS
	@RequestMapping(value = "/public/livros/{id}/carrinho/{session_id}", method = RequestMethod.POST)
	public String adicionarItemCarrinho(@PathVariable(value="session_id") long idCarrinho, @PathVariable(value="id") long idLivro) {
		
		if(listaCarrinhos != null && listaCarrinhos.isEmpty()) {
			for (Livro livro : listaLivros) {
				
				if(livro.getId() == idLivro) {
					carrinho = new Carrinho(idCarrinho,new ArrayList<Livro>(),0); 
					carrinho.getItems().add(livro);
					carrinho.setTotalCarrinho(livro.getPreco());
					listaCarrinhos.add(carrinho);
					return "Carrinho criado! Item Adicionado!";
				}
			}
			
		}else {
			
			for (Carrinho car : listaCarrinhos) {
				if(car.getId() == idCarrinho) {
					for (Livro livro : listaLivros) {
						if(livro.getId() == idLivro) {
							car.getItems().add(livro);
							car.setTotalCarrinho(carrinho.getTotalCarrinho()+livro.getPreco());
							return "Item Adicionado";	
						} 
					}
				}
			}
			
		}
		
		return "Item inválido";
	}
	
	//METODO POST PARA DELETAR ITENS(LIVROS) NO CARRINHO DE COMPRAS
	@RequestMapping(value = "/public/livros/{id}/carrinho/{session_id}", method = RequestMethod.DELETE)
	public String deleteItemCarrinho(@PathVariable("session_id") long idCarrinho, @PathVariable("id") long idLivro) {
		if(listaCarrinhos != null && listaCarrinhos.isEmpty()) {
			for (Carrinho car : listaCarrinhos) {
				if(car.getId() == idCarrinho) {
						car.getItems().remove((int) idCarrinho);
						return "Item: " + idLivro + "Deletado!";
				}
			}
		}
		return "Item não encontrado!";	
	}
	
	//POST	/v1/public/pedidos/{session_id}
	//METODO POST PARA ADICINAR ITENS(LIVROS) NO CARRINHO DE COMPRAS
	@RequestMapping(value = "/public/livros/pedidos/{session_id}", method = RequestMethod.POST)
	public String realizarPedido(@PathVariable(value="session_id") long idCarrinho) {
		if(listaCarrinhos != null && listaCarrinhos.isEmpty()) {
			for (Carrinho car : listaCarrinhos) {
				if(car.getId() == idCarrinho) {
					Pedido novoPedido;
					
					if(listaPedidos.isEmpty()) {
						novoPedido = new Pedido(1,car,car.getTotalCarrinho(),"Pedido Computado!");
					}else {
						novoPedido = new Pedido(listaCarrinhos.size()+1,car,car.getTotalCarrinho(),"Pedido Computado!");
					}
					listaPedidos.add(novoPedido);
					return "Pedido Realizado!";
				}
			}
		}
		return "Erro! Adicione Itens ao Carrinho";
	}
	
	
	
}