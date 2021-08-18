package br.com.i7solution.vtex.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import br.com.i7solution.vtex.apivtex.CatalogClient;
import br.com.i7solution.vtex.apivtex.InventoryClient;
import br.com.i7solution.vtex.apivtex.PriceClient;
import br.com.i7solution.vtex.apivtex.dtos.SkuPriceDTO;
import br.com.i7solution.vtex.clients.EstoqueClient;
import br.com.i7solution.vtex.clients.PedidoClient;
import br.com.i7solution.vtex.clients.ProdutoClient;
import br.com.i7solution.vtex.clients.TabelaPrecoClient;
import br.com.i7solution.vtex.apivtex.dtos.AdressDTO;
import br.com.i7solution.vtex.apivtex.dtos.BalanceDTO;
import br.com.i7solution.vtex.apivtex.dtos.ClientProfileDataDTO;
import br.com.i7solution.vtex.apivtex.dtos.OrderDTO;
import br.com.i7solution.vtex.apivtex.dtos.ShippingDataDTO;
import br.com.i7solution.vtex.clients.dtos.ClienteDTO;
import br.com.i7solution.vtex.clients.dtos.EnderecoDTO;
import br.com.i7solution.vtex.clients.dtos.ItemPedidoDTO;
import br.com.i7solution.vtex.clients.dtos.PedidoDTO;
import br.com.i7solution.vtex.apivtex.dtos.SkuDTO;
import br.com.i7solution.vtex.apivtex.dtos.InventoryDTO;

@Service
public class VtexService {

	@Autowired
	private PriceClient precosVtex;
	@Autowired
	private CatalogClient produtosVtex;
	@Autowired
	private EstoqueClient estoqueWinthor;
	@Autowired
	private ProdutoClient produtoWinthor;
	@Autowired
	private TabelaPrecoClient precosWinthor;
	@Autowired
	private PedidoClient pedidoWinthor;
	@Autowired
	private InventoryClient estoqueVtex;

	@Async(value = "taskAtualizacoes")
	@Scheduled(fixedRate = 3600000, initialDelay = 10000) // 1 em 1 hora
	public void atualizarPrecos() {
		var precosW = precosWinthor.getPrecosWinthor();
		if (precosW.size() > 0) {
			for (int i = 0; i <= precosW.size(); i++) {
				var precoY = new SkuPriceDTO();
				precoY.setCostPrice(precosW.get(i).getPrecoVenda());
				precoY.setListPrice(precosW.get(i).getPrecoVenda());

				precosVtex.putPrecoPorSku(precosW.get(i).getIdProduto(), precoY);
			}
		}
	}

	@Async(value = "taskAtualizacoes")
	@Scheduled(fixedRate = 3600000, initialDelay = 10000) // de 1 em 1 hora
	public void atualizarProdutos() {
		var prodsW = produtoWinthor.getProdutos();
		if (prodsW.size() > 0) {
			for (int i = 0; i <= prodsW.size(); i++) {
				var prodY = new SkuDTO();

				prodY.setId(prodsW.get(i).getId());
				prodY.setProductName(prodsW.get(i).getDescricao());
				prodY.setEan(prodsW.get(i).getCodigoDeBarras().toString());
				prodY.setProductId(prodsW.get(i).getId());
				prodY.setDetailUrl("");
				prodY.setModalType(null);
				prodY.setIsKit(false);
				prodY.setIsActive(true);
				prodY.setCategories(prodsW.get(i).getCategoria());
				prodY.setIsInventoried(true);

				produtosVtex.postSku(prodY);
			}
		}
	}

	@Async(value = "taskAtualizacoes")
	@Scheduled(fixedRate = 10800000, initialDelay = 10000) // 3 em 3 horas
	public void atualizarEstoque() {
		var prodsW = estoqueWinthor.getEstoque();
		if (prodsW.size() > 0) {
			for (int i = 0; i <= prodsW.size(); i++) {
				var prodY = new BalanceDTO();
				var prodId = new InventoryDTO();
				prodId.setSkuId(prodsW.get(i).getIdProduto());
				prodY.setTotalQuantity(prodsW.get(i).getQuantidadeDisponivel());
				prodY.setReservedQuantity(prodsW.get(i).getQuantidadeReservada());
				prodY.setWarehouseId(prodsW.get(i).getIdFilial());
				prodY.setHasUnlimitedQuantity(false);

			}

		}

	}
    /*
	public void ped_yami_winthor(OrderDTO pedVtex) throws Exception {
		var pedWinthor = new PedidoDTO();
		String pontoErro = "";

		try {
			pontoErro = "dados cabeçalho";

			Date dtInclusao = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(pedVtex.getCreationDate() + " UTC");
			String dataString = new SimpleDateFormat("dd/MM/yyyy").format(dtInclusao);
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);

			var clienteVtex = new ClientProfileDataDTO();
			
			var clienteWinthor = new ClienteDTO();
			clienteWinthor.setCpfCnpj(clienteVtex.getDocument());
			clienteWinthor.setEmail(clienteVtex.getEmail());
			clienteWinthor.setNome(clienteVtex.getFirstName());
			clienteWinthor.setTelefoneFixo(clienteVtex.getPhone());

			var enderecoVtex = new AdressDTO();
			
			var enderecoWinthor = new EnderecoDTO();
			
			enderecoWinthor.setBairro(enderecoVtex.getNeighborhood());
			enderecoWinthor.setCep(enderecoVtex.getPostalCode());
			enderecoWinthor.setComplemento(enderecoVtex.getComplement());
			enderecoWinthor.setMunicipio(enderecoVtex.getCity());
			enderecoWinthor.setUf(enderecoVtex.getState());
			enderecoWinthor.setPais(enderecoVtex.getCountry());
			enderecoWinthor.setNumero(enderecoVtex.getNumber());
			var listEnd = new EnderecoDTO[1];
			listEnd[0] = enderecoWinthor;

			clienteWinthor.setEndereco[listEnd];

			pedWinthor.setId(pedVtex.getId().toString());
			pedWinthor.setFilial("1");
			pedWinthor.setCliente(clienteWinthor);
			pedWinthor.setValorTotal(pedVtex.getValue());
			pedWinthor.setPosicao("P");
//            pedWinthor.setDataCancelamento(null);
//            pedWinthor.setDataFaturamento(null);
//            pedWinthor.setDataBloqueio(null);
//            pedWinthor.setDataEntrega(null);
			pedWinthor.setId(pedVtex.getOrderId());
			pedWinthor.setIdPedidoCliente(pedVtex.getOrderId());
//			pedWinthor.setQuantidadeItens[pedVtex.getItensCount()];

//            pedWinthor.setUsuario();
//            pedWinthor.setCobranca();
//            pedWinthor.setFormaDePagamento();

//            pedWinthor.setValorFrete();
//            pedWinthor.setValorOutrasDespesas();
//            pedWinthor.setTipoFrete();

			// pedWinthor.setErro(false);

			var itensVtex = pedVtex.getItems();
			var listItens = new ItemPedidoDTO[pedVtex.getItems()];
			for (var i = 0; i < pedVtex.; i++) {
				var prodW = produtoWinthor.getProdutoPorId(itensVtex[i].getProductId().toString());

				var item = new ItemPedidoDTO();
				item.setIdProduto(prodW.getId());
				item.setCodigoDeBarras(prodW.getCodigoDeBarras().longValue());
				item.setPosicao("P");
				item.setFilialRetira(itensVtex[i]);
				item.setPreco(itensVtex[i].getSellingPrice());
				item.setValorDesconto(0.0);
				item.setQtde(itensVtex[i].);

				listItens[i] = item;
			}

			pedWinthor.setItens(listItens);

			pedidoWinthor.postPedido(pedWinthor);
         
		} catch (Exception e) {
			//log.error("Ped_mag_winthor: " + pontoErro + " -> msg original: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}*/
}
	


