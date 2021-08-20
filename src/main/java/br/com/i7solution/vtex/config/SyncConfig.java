package br.com.i7solution.vtex.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@Log4j2
public class SyncConfig {

	@Bean(name = "taskAtualizacoes")
	public Executor taskAtualizacoes() {
		log.debug("Criando executor de tarefas");
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(4);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(100);
		executor.setAllowCoreThreadTimeOut(false);
		executor.setThreadNamePrefix("AtualizacaoThread-");
		executor.initialize();
		return executor;
	}

	@Bean(name = "taskPedidos")
	public Executor taskPedidos() {
		log.debug("Criando executor de tarefas");
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(4);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(100);
		executor.setAllowCoreThreadTimeOut(false);
		executor.setThreadNamePrefix("PedidoThread-");
		executor.initialize();
		return executor;
	}

}
