package br.com.i7solution.vtex.services;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.i7solution.vtex.apivtex.CatalogClient;
import br.com.i7solution.vtex.apivtex.PriceClient;
import br.com.i7solution.vtex.apivtex.dtos.SkuPriceDTO;
import br.com.i7solution.vtex.clients.EstoqueClient;
import br.com.i7solution.vtex.clients.ProdutoClient;
import br.com.i7solution.vtex.clients.TabelaPrecoClient;
import br.com.i7solution.vtex.apivtex.dtos.SkuDTO;
import br.com.i7solution.vtex.tools.Ferramentas;
import br.com.i7solution.vtex.apivtex.dtos.InventoryDTO;
import br.com.i7solution.vtex.apivtex.dtos.OrderDTO;
import br.com.i7solution.vtex.apivtex.dtos.ProductDTO;
import br.com.i7solution.vtex.apivtex.dtos.SellersDTO;
import br.com.i7solution.vtex.clients.dtos.ItemPedidoDTO;
import br.com.i7solution.vtex.clients.dtos.PedidoDTO;

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

	// ------Métodos agendados-----------------
	// @Async(value = "taskAtualizacoes")
	// @Scheduled(fixedRate = 1800000, initialDelay = 10000) // de 30 em 30 mins
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

	// @Async(value = "taskAtualizacoes")
	// @Scheduled(fixedRate = 1800000, initialDelay = 10000) // de 30 em 30 mins
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

	public void atualizarEstoque() {
		var prodsW = estoqueWinthor.getEstoque();
		if (prodsW.size() > 0) {
			for (int i = 0; i <= prodsW.size(); i++) {
				var prodY = new InventoryDTO();
				prodY.setSkuId(prodsW.get(i).getIdProduto());
				prodY.setTotalQuantity(prodsW.get(i).getQuantidadeDisponivel());
				prodY.setReservedQuantity(prodsW.get(i).getQuantidadeReservada());
				prodY.setWarehouseId(prodsW.get(i).getIdFilial());

			}

		}

	}

}
