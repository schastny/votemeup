package up.modell;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.expressions.ExpressionBuilder;

import up.voteme.domain.Category;
import junit.framework.TestCase;

public class SimpleJunitTestClass extends TestCase {

	private EntityManagerFactory entityManagerFactory;
	
	@Override
	protected void setUp() throws Exception {
		// like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
		// 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
		entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate" );
	}

	@Override
	protected void tearDown() throws Exception {
		entityManagerFactory.close();
	}
	
	public void testBasicUsage() {
				System.out.println("run as Junit test - testBasicUsage() started...");
				
				// create a couple of categories...
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				entityManager.getTransaction().begin();
				entityManager.persist( new Category( "Transport") );
				entityManager.persist( new Category( "Zdravoohranenie") );
				entityManager.persist( new Category( "Health Care") );
				entityManager.persist( new Category( "Emergency forces") );
				entityManager.getTransaction().commit();
				entityManager.close();

				// now lets pull categories from the database and list them
				entityManager = entityManagerFactory.createEntityManager();
				entityManager.getTransaction().begin();
				
				//uncomment if do not  easylink
		       // List<Category> result = entityManager.createQuery( "from Category", Category.class ).getResultList();
				
				List<Category> result =  entityManager.createQuery( "SELECT c FROM Category c ORDER BY c.categName" ).getResultList();
		        
		        for ( Category categ : result ) {
					System.out.println( categ );
				}
		        entityManager.getTransaction().commit();
		        entityManager.close();
	}

}
