import com.sparta.springbatch.domain.product.repository.ProductRepository;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class MyBatchConfig {

	private final JobLauncher jobLauncher;
	private final JobRepository jobRepository;
	private final PlatformTransactionManager platformTransactionManager;
	private final ProductRepository productRepository;

	public MyBatchConfig(JobLauncher jobLauncher, JobRepository jobRepository,
		PlatformTransactionManager platformTransactionManager, ProductRepository productRepository) {
		this.jobLauncher = jobLauncher;
		this.jobRepository = jobRepository;
		this.platformTransactionManager = platformTransactionManager;
		this.productRepository = productRepository;
	}

	@Bean
	public JobLauncher jobLauncher() {
		return jobLauncher;
	}

	@Bean
	public JobRepository jobRepository() {
		return jobRepository;
	}

	@Bean
	public PlatformTransactionManager platformTransactionManager() {
		return platformTransactionManager;
	}

	@Bean
	public ProductRepository productRepository() {
		return productRepository;
	}
}
